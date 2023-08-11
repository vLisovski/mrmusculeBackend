package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.authservices.AuthOrRegisterService;
import com.lisovski.mrmuscule.dtos.AuthOrRegisterResponseDto;
import com.lisovski.mrmuscule.dtos.AuthRequestDto;
import com.lisovski.mrmuscule.dtos.RegisterRequestDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@AllArgsConstructor
@Validated
public class AuthController {
    private final AuthOrRegisterService authOrRegisterService;

    @PostMapping("/register")
    public AuthOrRegisterResponseDto register(@Valid @RequestBody RegisterRequestDto registerRequestDto) {
        return authOrRegisterService.register(registerRequestDto);
    }

    @PostMapping("/authenticate")
    public AuthOrRegisterResponseDto authenticate(@Valid @RequestBody AuthRequestDto authRequestDto) {
        return authOrRegisterService.authenticate(authRequestDto);
    }
}
