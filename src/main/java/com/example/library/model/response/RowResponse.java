package com.example.library.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
///.
public class RowResponse {
    private int number;
    private UUID shelfId;
}
