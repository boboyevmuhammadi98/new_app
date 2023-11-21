package uz.alif.authentication_news_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.alif.authentication_news_app.repository.PostRepository;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    public ResponseEntity<?> getPosts() {
        return ResponseEntity.ok("welcome to home");
    }
}
