package uz.alif.authentication_news_app.servce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.alif.authentication_news_app.dtos.ApiResponse;
import uz.alif.authentication_news_app.dtos.RoleDto;
import uz.alif.authentication_news_app.entity.Role;
import uz.alif.authentication_news_app.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public ApiResponse add(RoleDto roleDto) {
        if (roleRepository.existsByName(roleDto.getName()))
            return new ApiResponse("role name already exists", false, 409, null);
        Role save = roleRepository.save(new Role(roleDto.getName(), roleDto.getDescription(), roleDto.getPermissions()));
        return new ApiResponse("created", true, 201, save);
    }

}
