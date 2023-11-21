package uz.alif.authentication_news_app.servce;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.alif.authentication_news_app.dtos.ApiResponse;
import uz.alif.authentication_news_app.dtos.UserDto;
import uz.alif.authentication_news_app.entity.TokenBlockList;
import uz.alif.authentication_news_app.entity.UserForNewsApp;
import uz.alif.authentication_news_app.exception.NewsAppResourceNotFoundException;
import uz.alif.authentication_news_app.repository.RoleRepository;
import uz.alif.authentication_news_app.repository.TokenBlockListRepository;
import uz.alif.authentication_news_app.repository.UserRepository;
import uz.alif.authentication_news_app.security.JwtService;

@Service
public class UserService {

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenBlockListRepository tokenBlockListRepository;

    @Autowired
    JwtService jwtService;

    public ApiResponse add(UserDto userDto) {

        UserForNewsApp user = new UserForNewsApp();
        user.setFullName(userDto.getFullName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(roleRepository.findById(userDto.getRoleId()).orElseThrow(() -> new NewsAppResourceNotFoundException("role not found")));
        user.setEnabled(true);
        UserForNewsApp save = userRepository.save(user);
        return new ApiResponse("created", true, 201, save);
    }

    public ApiResponse logout() {
        String authorization = httpServletRequest.getHeader("Authorization");
        if (authorization != null && authorization.startsWith("Bearer")) {
            authorization = authorization.substring(7);
            SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
            tokenBlockListRepository.save(new TokenBlockList(null, authorization, jwtService.extractExpiration(authorization)));
            return new ApiResponse("logged out", true, 200, null);
        }
        return new ApiResponse("something want wrong", false, 400, null);
    }
}
