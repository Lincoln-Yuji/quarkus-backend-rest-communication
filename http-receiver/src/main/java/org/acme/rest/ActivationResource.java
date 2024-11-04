package org.acme.rest;

import org.acme.client.StorageServiceClient;
import org.acme.entities.DataPayload;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/activation")
public class ActivationResource {
    
    @Inject
    @RestClient
    StorageServiceClient storageServiceClient;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response activateClient(DataPayload payload) {
        storageServiceClient.activateClient(payload);
        return Response.ok(true).build();
    }
}
