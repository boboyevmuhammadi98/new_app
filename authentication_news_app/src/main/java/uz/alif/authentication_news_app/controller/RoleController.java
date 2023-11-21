package uz.alif.authentication_news_app.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.alif.authentication_news_app.dtos.ApiResponse;
import uz.alif.authentication_news_app.dtos.RoleDto;
import uz.alif.authentication_news_app.repository.RoleRepository;
import uz.alif.authentication_news_app.servce.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PreAuthorize("hasAuthority('ADD_ROLE')")
    @PostMapping("")
    public ResponseEntity<?> add(@Valid @RequestBody RoleDto roleDto) {
        ApiResponse add = roleService.add(roleDto);
        return ResponseEntity.status(add.getCode()).body(add);
    }
}
