package com.engineer.carmanager.repositories;

import com.engineer.carmanager.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
