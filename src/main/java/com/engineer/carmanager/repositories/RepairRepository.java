package com.engineer.carmanager.repositories;

import com.engineer.carmanager.models.Repair;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairRepository extends JpaRepository<Repair, Long> {
}
