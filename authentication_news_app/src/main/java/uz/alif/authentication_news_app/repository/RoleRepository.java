package uz.alif.authentication_news_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.alif.authentication_news_app.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);

    boolean existsByName(String name);

}