package com.engineer.carmanager.repositories;

import com.engineer.carmanager.models.Refuel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefuelRepository extends JpaRepository<Refuel, Long> {
}
