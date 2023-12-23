package com.example.library.service;

import com.example.library.model.UserEntity;
import com.example.library.config.jwt.JwtService;
import com.example.library.model.UserRole;
import com.example.library.model.exceptions.DataNotFoundException;
import com.example.library.model.request.AuthDto;
import com.example.library.model.request.SignUpDto;
import com.example.library.model.response.JwtResponse;
import com.example.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    public JwtResponse signIn(AuthDto dto) {
        UserEntity user = userRepository.findByEmail(dto.getEmail()).orElseThrow(() -> new DataNotFoundException("user not found"));
        if (dto.getPassword().equals(user.getPassword())) {
            return new JwtResponse(jwtService.generateToken(user));
        }
        throw new AuthenticationCredentialsNotFoundException("password didn't match");
    }
    public JwtResponse signUp(SignUpDto dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email is already in use");
        }
        UserEntity newUser = new UserEntity();
        newUser.setEmail(dto.getEmail());
        newUser.setPassword(dto.getPassword());
        newUser.setName(dto.getName());
        newUser.setRole(UserRole.USER);
        userRepository.save(newUser);
        return new JwtResponse(jwtService.generateToken(newUser));
    }
}
