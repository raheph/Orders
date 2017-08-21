package DBConnection;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.model.Items;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.TestProperties;
import org.glassfish.jersey.test.JerseyTest;
import com.services.OrdersApi;
import org.hibernate.SessionFactory;
import org.junit.*;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

/**
 * Created by ephrar1 on 8/15/2017.
 */
public class OrderApiTest extends JerseyTest{

    @Override
    public Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(OrdersApi.class);
    }

    @Test
    public void testOrderwithParam(){
        Response output = target("/Order/Order001").request().get();
        assertEquals("should return status 200", 200, output.getStatus());
    }
}
