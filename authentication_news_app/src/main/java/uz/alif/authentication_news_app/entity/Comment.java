package uz.alif.authentication_news_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.alif.authentication_news_app.entity.template.AbstractEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Comment extends AbstractEntity {
    private String title;
    @ManyToOne(optional = false)
    private Post post;
}
