package uz.alif.authentication_news_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.alif.authentication_news_app.entity.Post;
import uz.alif.authentication_news_app.entity.Role;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
}