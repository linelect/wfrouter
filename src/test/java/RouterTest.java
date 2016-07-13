import org.junit.Test;
import testclasses.MyArticleIndex;

import static org.junit.Assert.*;

/**
 * Created by linelect on 12.07.2016.
 */
public class RouterTest {

    @Test
    public void testRoute() throws Exception {
        Router router = new Router()
                .GET("/articles", MyArticleIndex.class);

        Routed routed = router.route(HTTPMetods.GET, "/articles/123");
        System.out.println(routed);
    }
}