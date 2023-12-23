package com.example.library.controller;

import com.example.library.model.request.AuthDto;
import com.example.library.model.request.SignUpDto;
import com.example.library.model.response.JwtResponse;
import com.example.library.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
@SecurityRequirement(name = "Bearer Authentication")
public class AuthController {
    private final UserService userService;
    @PermitAll
    @PostMapping("/sign-in")
    public JwtResponse signIn(@Valid @RequestBody AuthDto dto) {
        return userService.signIn(dto);
    }
    @PermitAll
    @PostMapping("/sign-up")
    public JwtResponse signUp(@Valid @RequestBody SignUpDto dto) {
        return userService.signUp(dto);
    }
}
