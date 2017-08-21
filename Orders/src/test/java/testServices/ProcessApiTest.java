package testServices;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

/**
 * Created by ephrar1 on 8/17/2017.
 */
public class ProcessApiTest extends JerseyTest {
    @Override
    public Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(ProcessApiTest.class);
    }

    @Test
    public void testProcessApi(){
        Response output = target("/Process/Order001").request().get();
        assertEquals("should return status 200", 404, output.getStatus());
    }


}
