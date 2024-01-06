package com.example.library.repository;

import com.example.library.model.BronEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;
@Repository
public interface BronRepository extends JpaRepository<BronEntity, UUID> {
}
