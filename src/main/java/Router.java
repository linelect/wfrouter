import java.util.*;

public class Router {
    private final HashMap<HTTPMetods, Map<String, Object>> routingMap = new HashMap<HTTPMetods, Map<String, Object>>();

    private void addRouting(HTTPMetods method, String path, Object object) {
        if (routingMap.containsKey(method)) {
            Map<String, Object> innerMap = routingMap.get(method);
            innerMap.put(path, object);
        } else {
            Map<String, Object> innerMap = new HashMap<String, Object>();
            innerMap.put(path, object);
            routingMap.put(method, innerMap);
        }
    }

    public Router GET(String path, Object object) {
        addRouting(HTTPMetods.GET, path, object);
        return this;
    }

    public Router POST(String path, Object object) {
        addRouting(HTTPMetods.POST, path, object);
        return this;
    }

    public Routed route(HTTPMetods method, String path) {
        return new Routed(routingMap.get(method).get(path), getParametersFromPath(path));
    }


    private List<String> getParametersFromPath(String path) {
        if (path.length() > 0) {
            String paramsString = path.substring(path.indexOf("?"));
            if (paramsString.substring(paramsString.length() - 2, paramsString.length() - 1).equals("/"))
                paramsString = paramsString.substring(0, paramsString.length() - 2);
            return Arrays.asList(paramsString.split("&"));
        } else {
            return new ArrayList<String>();
        }
    }
}
