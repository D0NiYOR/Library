package com.example.library.repository;

import com.example.library.model.ShelfEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ShelfRepository extends JpaRepository<ShelfEntity, UUID> {
    List<ShelfEntity> findAllByFloorId(UUID floorId);
}
