package com.eden33.jersey.client;

import com.eden33.jersey.dto.Request;
import com.eden33.jersey.dto.Response;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.glassfish.jersey.apache.connector.ApacheClientProperties;
import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;

/**
 *
 * @author edi
 */
public class ClientApp {
    
    public static void main(String[] args) {
        
        // use ApacheConnetorProvider as client transport connector --------------------------
        // see 5.5. Client Transport Connectors in jersey documentation
        // https://jersey.java.net/nonav/documentation/latest/user-guide.html#d0e4781
        ClientConfig clientConf = new ClientConfig();
            
        PoolingClientConnectionManager connManager = new PoolingClientConnectionManager();
        connManager.setMaxTotal(1);
        connManager.setDefaultMaxPerRoute(1);

        clientConf.property(ApacheClientProperties.CONNECTION_MANAGER, connManager);

        ApacheConnectorProvider connector = new ApacheConnectorProvider();
        clientConf.connectorProvider(connector);

        Client client = ClientBuilder.newClient(clientConf);
        Request req = new Request();
        req.setFoo("ApacheConnetorProvider as transport connector set");
        
        String restURI = "http://localhost:8080/jersey-service";
        Response resp = client
                            .target(restURI)
                            .request()
                            .post(Entity.entity(req, MediaType.APPLICATION_XML), 
                                    Response.class);
        
        System.out.println("Service response: " + resp.getBar());
        
        client = ClientBuilder.newClient();
        req.setFoo("Using default connector implementation");
        
        resp = client
                .target(restURI)
                .request()
                .post(Entity.entity(req, MediaType.APPLICATION_XML), 
                    Response.class);
        
        System.out.println("Service response: " + resp.getBar());
                
    }
}
