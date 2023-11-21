package uz.alif.authentication_news_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.alif.authentication_news_app.entity.template.AbstractEntity;
import uz.alif.authentication_news_app.enums.Permission;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Role extends AbstractEntity {
    @Column(nullable = false, unique = true)
    private String name;
    @Column()
    private String description;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Permission> permissions;
}
