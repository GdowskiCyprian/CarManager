package com.engineer.carmanager.repositories;

import com.engineer.carmanager.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
