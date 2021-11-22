package com.engineer.carmanager.repositories;

import com.engineer.carmanager.models.RepairPart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairPartRepository extends JpaRepository<RepairPart, Long> {
}
