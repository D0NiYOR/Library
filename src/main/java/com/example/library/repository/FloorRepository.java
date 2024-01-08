package com.example.library.repository;

import com.example.library.model.FloorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FloorRepository extends JpaRepository<FloorEntity, UUID> {
}
