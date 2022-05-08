package es.cuatrogatos.solax.boundary;

import es.cuatrogatos.solax.entity.Result;
import es.cuatrogatos.solax.entity.SolaxCloudResponse;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.client.JerseyInvocation;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class SolaxClient {
    private URI interfaceAddress;
    private String token;
    private String sn;

    private long cachedTttl=5*60*1000;


    private SolaxCloudResponse cachedResponse;
    private long lastUpdatedCached;

    private JerseyClient client;

    public SolaxClient(String interfaceAddress,String token,String sn) throws MalformedURLException {
        this.interfaceAddress= URI.create(interfaceAddress);
        this.setToken(token);
        this.setSn(sn);
        client=JerseyClientBuilder.createClient();
        client.register(SolaxCloudResponse.class);
        client.register(Result.class);
    }


    public SolaxClient(String interfaceAddress,String token,String sn,long cachedTttl) throws MalformedURLException {
        this.interfaceAddress= URI.create(interfaceAddress);
        this.setToken(token);
        this.setSn(sn);
        this.cachedTttl=cachedTttl;
        client=JerseyClientBuilder.createClient();
        client.register(SolaxCloudResponse.class);
        client.register(Result.class);
    }


    public SolaxCloudResponse queryEndpoint() throws ExecutionException, InterruptedException {
        // logger.info("retrieveCachedSummary");
        if(cachedResponse==null || lastUpdatedCached+cachedTttl<=new Date().getTime()){
            JerseyInvocation request=client.target(this.interfaceAddress).path("getRealtimeInfo.do")
                    .queryParam("tokenId",this.getToken())
                    .queryParam("sn",this.getSn())
                    .request().accept("application/json;charset=ISO-8859-1")
                    .buildGet();
            Response response=request.invoke();
            SolaxCloudResponse sResponse=response.readEntity(SolaxCloudResponse.class);
            validateResponse(sResponse);
            cachedResponse=sResponse;
            lastUpdatedCached=new Date().getTime();

        }
        return cachedResponse;
    }


    private void validateResponse(SolaxCloudResponse solaxCloudResponse){
        if(!solaxCloudResponse.isSuccess()){
            throw new BadRequestException(solaxCloudResponse.getException());
        }
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSn() {
        return sn;
    }

    public void setCachedTttl(long cachedTttl){
        this.cachedTttl=cachedTttl;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }
}
