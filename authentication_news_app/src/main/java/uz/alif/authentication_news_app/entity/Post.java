package uz.alif.authentication_news_app.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.alif.authentication_news_app.entity.template.AbstractEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Post extends AbstractEntity {
    @Column(nullable = false)
    private String name;
    @Column(columnDefinition = "text")
    private String title;
}
