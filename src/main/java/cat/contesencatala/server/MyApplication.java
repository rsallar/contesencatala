package cat.contesencatala.server;
import org.glassfish.jersey.server.ResourceConfig;


public class MyApplication extends ResourceConfig {
    public MyApplication() {
        packages("cat.contesencatala.server");
    }
}