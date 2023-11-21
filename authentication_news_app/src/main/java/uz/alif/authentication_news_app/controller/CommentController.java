package uz.alif.authentication_news_app.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.alif.authentication_news_app.aop.CheckPermission;
import uz.alif.authentication_news_app.dtos.ApiResponse;
import uz.alif.authentication_news_app.dtos.CommentDto;
import uz.alif.authentication_news_app.dtos.PostDto;
import uz.alif.authentication_news_app.entity.Comment;
import uz.alif.authentication_news_app.entity.Post;
import uz.alif.authentication_news_app.servce.CommentService;
import uz.alif.authentication_news_app.servce.PostService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("")
    public ResponseEntity<?> get() {
        return ResponseEntity.status(200).body(commentService.getALl());
    }

    @CheckPermission(permission = "ADD_COMMENT")
    @PostMapping("")
    public ResponseEntity<?> add(@Valid CommentDto commentDto) {
        Comment add = commentService.add(commentDto);
        return ResponseEntity.status(201).body(add);
    }

    @PreAuthorize("hasAuthority('EDIT_COMMENT')")
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @Valid CommentDto commentDto) {
        Comment edit = commentService.edit(id, commentDto);
        return ResponseEntity.status(201).body(edit);
    }

    @PreAuthorize("hasAnyAuthority('DELETE_COMMENT', 'DELETE_MY_COMMENT')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ApiResponse delete = commentService.delete(id);
        return ResponseEntity.status(delete.getCode()).body(delete);
    }

}
