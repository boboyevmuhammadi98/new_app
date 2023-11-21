package uz.alif.authentication_news_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.alif.authentication_news_app.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}