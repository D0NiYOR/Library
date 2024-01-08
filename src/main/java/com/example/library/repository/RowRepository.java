package com.example.library.repository;

import com.example.library.model.RowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RowRepository extends JpaRepository<RowEntity, UUID> {
    List<RowEntity> findAllByShelfId(UUID shelfId);
}
