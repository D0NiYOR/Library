package com.example.library.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BronEntity extends BaseEntity {
    private UUID userId;
    private UUID bookId;
    private LocalDateTime completionDate = LocalDateTime.now().plus(3, ChronoUnit.DAYS);;

}
