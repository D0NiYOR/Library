package com.example.library.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TakeAwayResponseDto {
    private UUID userId;
    private UUID bookId;
    private LocalDateTime returnDate;
    private UUID id;
}
