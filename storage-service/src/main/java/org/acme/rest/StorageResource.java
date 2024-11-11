package org.acme.rest;

import org.acme.db.model.Client;
import org.acme.db.repository.ClientRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
@Path("/activation")
public class StorageResource {
    
    @Inject
    ClientRepository clientRepository;

    @POST
    @Transactional
    @Path("/{name}/{age}")
    public Response activateClient(@PathParam("name") String name, @PathParam("age") int age)
    {
        try {
            Client newClient = new Client();
            newClient.name = name;
            newClient.age = age;
            clientRepository.persist(newClient);   
        } catch (Exception e) {
            log.info("INFO ::: FAILED persistance: " + e.getMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }

        log.info("Client with NAME: " + name + ", AGE: " + age + " saved successfuly");

        return Response.ok(true).build();
    }
}
