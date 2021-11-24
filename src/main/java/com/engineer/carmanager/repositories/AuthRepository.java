package com.engineer.carmanager.repositories;

import com.engineer.carmanager.models.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long>{

}
