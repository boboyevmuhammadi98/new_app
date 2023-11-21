package uz.alif.authentication_news_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.alif.authentication_news_app.entity.UserForNewsApp;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserForNewsApp, Long> {
    boolean existsByPhoneNumber(String phoneNumber);
    Optional<UserForNewsApp> findByPhoneNumber(String phoneNumber);
}
