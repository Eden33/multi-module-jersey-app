package com.eden33.jersey.service;

import com.eden33.jersey.dto.Request;
import com.eden33.jersey.dto.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author edi
 */
@Path("/")
public class Service {
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response getIt(Request req) {
        System.out.println("POST incoming");
        Response resp = new Response();
        resp.setBar("POST request received. Foo value was: "+req.getFoo());
        return resp;
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "You have to talk POST";
    }
}
