package uz.alif.authentication_news_app.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.alif.authentication_news_app.dtos.ApiResponse;
import uz.alif.authentication_news_app.dtos.UserDto;
import uz.alif.authentication_news_app.servce.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PreAuthorize("hasAuthority('ADD_USER')")
    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody UserDto userDto) {
        ApiResponse add = userService.add(userDto);
        return ResponseEntity.status(add.getCode()).body(add);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        ApiResponse add = userService.logout();
        return ResponseEntity.status(add.getCode()).body(add);
    }



}
