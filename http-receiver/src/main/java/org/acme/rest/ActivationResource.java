package org.acme.rest;

import org.acme.client.StorageServiceClient;
import org.acme.entities.DataPayload;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
@Path("/activation")
public class ActivationResource {
    
    @Inject
    @RestClient
    StorageServiceClient storageServiceClient;

    @POST
    @Path("/{name}/{age}")
    public Response activateClient(@PathParam("name") String name, @PathParam("age") int age) {
        
        log.info("START ::: Client Activation");

        Response serviceResponse = storageServiceClient.activateClient(name, age);

        log.info("END ::: Client Activation");
        return serviceResponse;
    }

    @POST
    @Path("/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response activeClientFromJsonBody(DataPayload payload) {

        log.info("START ::: Client Activation");

        Response serviceResponse = storageServiceClient.activateClient(payload.getName(), payload.getAge());

        log.info("END ::: Client Activation");

        return serviceResponse;
    }
}
