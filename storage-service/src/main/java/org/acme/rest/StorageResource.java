package org.acme.rest;

import org.acme.db.model.Client;
import org.acme.db.repository.ClientRepository;
import org.acme.entities.DataPayload;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/activation")
public class StorageResource {
    
    @Inject
    ClientRepository clientRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void activateClient(DataPayload payload) {
        Client newClient = new Client();
        newClient.data = payload.data;
        clientRepository.persist(newClient);
    }
}
