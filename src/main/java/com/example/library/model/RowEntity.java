package com.example.library.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RowEntity extends BaseEntity {
    private int number;
    private UUID shelfId;
}
