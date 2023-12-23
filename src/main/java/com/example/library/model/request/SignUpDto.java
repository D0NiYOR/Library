package com.example.library.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignUpDto {
    private String name;
    @NotBlank(message = "email must not be blank")
    private String email;
    @NotBlank(message = "password must not be blank")
    private String password;
}
