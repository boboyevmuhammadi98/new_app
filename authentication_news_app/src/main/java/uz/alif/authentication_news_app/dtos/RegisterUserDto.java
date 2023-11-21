package uz.alif.authentication_news_app.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RegisterUserDto {
    @NotBlank(message = "fullname cannot be empty")
    @Size(min = 3, max = 100, message = "fullname is between 3 and 100 letters")
    private String fullName;

    @Pattern(regexp = "^[0-9]{12}$", message = "phone is incorrect")
    @NotBlank(message = "phone cannot be empty")
    private String phoneNumber;

    @NotBlank(message = "password cannot be empty")
    @Size(min = 6, message = "password is can be minimum 6 characters")
    private String password;
}
