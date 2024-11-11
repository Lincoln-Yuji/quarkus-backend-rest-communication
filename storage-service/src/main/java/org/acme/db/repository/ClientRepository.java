package org.acme.db.repository;

import org.acme.db.model.Client;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.Dependent;

@Dependent
public class ClientRepository implements PanacheRepository<Client> {
    
}
