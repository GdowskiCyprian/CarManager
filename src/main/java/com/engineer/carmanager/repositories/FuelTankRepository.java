package com.engineer.carmanager.repositories;

import com.engineer.carmanager.models.FuelTank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelTankRepository extends JpaRepository<FuelTank, Long> {
}
