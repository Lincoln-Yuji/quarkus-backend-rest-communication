package org.acme.rest;

import org.acme.db.model.Client;
import org.acme.db.repository.ClientRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

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
    public void activateClient(@PathParam("name") String name, @PathParam("age") int age) {
        log.info("START ::: Client Activation");

        Client newClient = new Client();
        newClient.name = name;
        newClient.age = age;
        clientRepository.persist(newClient);

        log.info("END ::: Client Activation");
    }
}
