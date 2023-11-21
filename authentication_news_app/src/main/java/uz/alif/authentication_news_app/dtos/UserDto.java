package uz.alif.authentication_news_app.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.alif.authentication_news_app.enums.Permission;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    @NotBlank(message = "fullname cannot be empty")
    @Size(min = 3, max = 100, message = "fullname is between 3 and 100 letters")
    private String fullName;

    @Pattern(regexp = "^[0-9]{12}$", message = "phone is incorrect")
    @NotBlank(message = "phone cannot be empty")
    private String phoneNumber;

    @NotBlank(message = "password cannot be empty")
    @Size(min = 6, message = "password is can be minimum 6 characters")
    private String password;

    @NotNull(message = "role id cannot be empty")
    private Long roleId;

}
