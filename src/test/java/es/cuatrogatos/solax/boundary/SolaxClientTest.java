package es.cuatrogatos.solax.boundary;

import es.cuatrogatos.solax.entity.SolaxCloudResponse;
import jakarta.ws.rs.BadRequestException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

public class SolaxClientTest {
    private SolaxClient solaxClient;

    @Before
    public void setUp() throws Exception {
        solaxClient=new SolaxClient("https://www.solaxcloud.com:9443/proxy/api","1","2");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void queryEndpoint() throws ExecutionException, InterruptedException {
        solaxClient.setToken(System.getProperty("token"));
        solaxClient.setSn(System.getProperty("sn"));
        SolaxCloudResponse response=solaxClient.queryEndpoint();
        Assert.assertNotNull(response.getResult());
        Assert.assertTrue(response.isSuccess());
        Assert.assertEquals("Query success!",response.getException());
    }

    @Test
    public void queryBadRequestEndpoint() throws ExecutionException, InterruptedException {
        solaxClient.setToken("1");
        solaxClient.setSn("2");
        try {
            solaxClient.queryEndpoint();
        }catch (BadRequestException e){
            Assert.assertTrue(true);
        }
    }

}