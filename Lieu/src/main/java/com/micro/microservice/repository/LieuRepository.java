package com.micro.microservice.repository;

import com.micro.microservice.entities.Lieu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LieuRepository extends JpaRepository<Lieu,Long> {
}
