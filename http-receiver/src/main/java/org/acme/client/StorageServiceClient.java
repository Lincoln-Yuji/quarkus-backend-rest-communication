package org.acme.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@RegisterRestClient(configKey = "storage-service")
@Path("/activation")
public interface StorageServiceClient {
    
    @POST
    @Transactional
    @Path("/{name}/{age}")
    public void activateClient(@PathParam("name") String name, @PathParam("age") int age);

}
