package uz.alif.authentication_news_app.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDto {
    @NotBlank
    private String name;
    @NotBlank
    private String title;
}
