package com.example.library.repository;

import com.example.library.model.TakeAwayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TakeAwayRepository extends JpaRepository<TakeAwayEntity, UUID> {


}
