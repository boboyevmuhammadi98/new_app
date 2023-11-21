package uz.alif.authentication_news_app.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.alif.authentication_news_app.aop.CheckPermission;
import uz.alif.authentication_news_app.dtos.ApiResponse;
import uz.alif.authentication_news_app.dtos.PostDto;
import uz.alif.authentication_news_app.entity.Post;
import uz.alif.authentication_news_app.repository.PostRepository;
import uz.alif.authentication_news_app.servce.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    PostService postService;

    @PreAuthorize("hasAuthority('VIEW_POST')")
    @GetMapping("")
    public ResponseEntity<?> get() {
        return ResponseEntity.status(200).body(postService.getALl(););
    }

    @CheckPermission(permission = "ADD_POST")
    @PostMapping("")
    public ResponseEntity<?> add(@Valid PostDto postDto) {
        Post add = postService.add(postDto);
        return ResponseEntity.status(201).body(add);
    }

    @PreAuthorize("hasAuthority('EDIT_POST')")
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @Valid PostDto postDto) {
        Post add = postService.edit(id, postDto);
        return ResponseEntity.status(201).body(add);
    }

    @PreAuthorize("hasAuthority('DELETE_POST')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ApiResponse delete = postService.delete(id);
        return ResponseEntity.status(delete.getCode()).body(delete);
    }

}
