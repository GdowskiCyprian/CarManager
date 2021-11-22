package com.engineer.carmanager.repositories;

import com.engineer.carmanager.models.RepairShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairShopRepository extends JpaRepository<RepairShop, Long> {
}
