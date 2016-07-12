import java.util.List;

public class Routed {
    public final Object object;
    public final List<String> parameters;

    public Routed(Object object, List<String> parameters) {
        this.object = object;
        this.parameters = parameters;
    }
}
