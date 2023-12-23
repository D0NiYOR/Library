package com.example.library.controller;

import com.example.library.model.request.AuthDto;
import com.example.library.model.request.BronDto;
import com.example.library.model.request.TakeAwayDto;
import com.example.library.model.response.TakeAwayResponseDto;
import com.example.library.service.BronService;
import com.example.library.service.TakeAwayService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.rowset.BaseRowSet;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
@SecurityRequirement(name = "Bearer Authentication")
public class UserController {
    private final BronService bronService;
    private  final TakeAwayService takeAwayService;
    @PermitAll
    @PostMapping("/bron")
    private  String bron(@Valid @RequestBody BronDto dto){
        return bronService.bron(dto);
    }
    @PermitAll
    @PostMapping("/take-away")
    private TakeAwayResponseDto takeAway(@Valid @RequestBody TakeAwayDto dto){
        return takeAwayService.takeAway(dto);
    }

}
