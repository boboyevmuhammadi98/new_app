package uz.alif.authentication_news_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.alif.authentication_news_app.entity.TokenBlockList;

import java.util.Date;

public interface TokenBlockListRepository extends JpaRepository<TokenBlockList, Long> {
    boolean existsByToken(String token);

    void deleteAllByExpireDateIsBefore(Date expireDate);

}