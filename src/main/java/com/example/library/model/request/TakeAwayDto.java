package com.example.library.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TakeAwayDto {
    private UUID userId;
    private UUID bookId;
    private LocalDateTime returnDate;
}
