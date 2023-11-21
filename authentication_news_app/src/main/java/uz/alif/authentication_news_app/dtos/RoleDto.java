package uz.alif.authentication_news_app.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.alif.authentication_news_app.enums.Permission;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleDto {


    @NotBlank(message = "rolename cannot be empty")
    @Size(min = 3, max = 50, message = "rolename is between 3 and 50 letters")
    private String name;
    private String description;
    @NotEmpty(message = "permission cannot be empty")
    private Set<Permission> permissions;
}
