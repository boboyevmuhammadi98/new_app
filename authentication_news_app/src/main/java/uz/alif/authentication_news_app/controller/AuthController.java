package uz.alif.authentication_news_app.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.alif.authentication_news_app.dtos.ApiResponse;
import uz.alif.authentication_news_app.dtos.ApiResponseWithToken;
import uz.alif.authentication_news_app.dtos.RegisterUserDto;
import uz.alif.authentication_news_app.servce.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterUserDto registerUserDto) {
        ApiResponse register = authService.register(registerUserDto);
        return ResponseEntity.status(register.getCode()).body(register);
    }

    @PostMapping("/verifyUser")
    public ResponseEntity<?> verifyUser(@RequestParam() String phoneNumber, @RequestParam String code) {
        ApiResponseWithToken verifyUser = authService.verifyUser(phoneNumber, code);
        return ResponseEntity.status(verifyUser.getCode()).body(verifyUser);
    }

    @PostMapping("/resendCode")
    public ResponseEntity<?> resendCode(@RequestParam String phoneNumber) {
        ApiResponse register = authService.resendCode(phoneNumber);
        return ResponseEntity.status(register.getCode()).body(register);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String phoneNumber, @RequestParam String password) {
        ApiResponseWithToken login = authService.login(phoneNumber, password);
        return ResponseEntity.status(login.getCode()).body(login);
    }
}
