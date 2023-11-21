package uz.alif.authentication_news_app.servce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.alif.authentication_news_app.dtos.ApiResponse;
import uz.alif.authentication_news_app.dtos.ApiResponseWithToken;
import uz.alif.authentication_news_app.dtos.RegisterUserDto;
import uz.alif.authentication_news_app.entity.UserForNewsApp;
import uz.alif.authentication_news_app.exception.AppLoginException;
import uz.alif.authentication_news_app.exception.NewsAppResourceNotFoundException;
import uz.alif.authentication_news_app.repository.RoleRepository;
import uz.alif.authentication_news_app.repository.UserRepository;
import uz.alif.authentication_news_app.security.JwtService;
import uz.alif.authentication_news_app.servce.smsServiceApi.SmsApiService;
import uz.alif.authentication_news_app.utils.AppUtils;

@Service
public class AuthService implements UserDetailsService {


    @Lazy
    @Autowired
    PasswordEncoder passwordEncoder;

    @Lazy
    @Autowired
    JwtService jwtService;

    @Autowired
    SmsApiService smsApiService;

    @Lazy
    @Autowired
    AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public AuthService(UserRepository userRepository,
                       RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public ApiResponse register(RegisterUserDto registerUserDto) {
        if (userRepository.existsByPhoneNumber(registerUserDto.getPhoneNumber()))
            return new ApiResponse("phone number aready exists", false, 409, null);
        UserForNewsApp user = new UserForNewsApp();
        user.setFullName(registerUserDto.getFullName());
        user.setPhoneNumber(registerUserDto.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
        user.setRole(roleRepository.findByName("user").orElseThrow(() -> new NewsAppResourceNotFoundException("role name user not found")));
        String code = AppUtils.generateCode();
        smsApiService.sendSms(registerUserDto.getPhoneNumber(), code);
        user.setVerificationCode(code);
        UserForNewsApp save = userRepository.save(user);
        return new ApiResponse("created", true, 201, save);
    }


    public ApiResponseWithToken verifyUser(String phoneNumber, String code) {
        UserForNewsApp user = userRepository.findByPhoneNumber(phoneNumber).orElseThrow(() -> new NewsAppResourceNotFoundException("user not found"));
        if (user.getVerificationCode().equals(code)) {
            user.setVerificationCode(null);
            user.setEnabled(true);
            userRepository.save(user);
            return new ApiResponseWithToken("verified", true, 200, jwtService.generateToken(user.getPhoneNumber()));
        }
        return new ApiResponseWithToken("verification code is incorrect", false, 400, null);
    }

    public ApiResponse resendCode(String phoneNumber) {
        UserForNewsApp user = userRepository.findByPhoneNumber(phoneNumber).orElseThrow(() -> new NewsAppResourceNotFoundException("user not found"));
        String code = AppUtils.generateCode();
        user.setVerificationCode(code);
        smsApiService.sendSms(user.getPhoneNumber(), code);
        userRepository.save(user);
        return new ApiResponse("code sended", true, 200, null);
    }

    public ApiResponseWithToken login(String phoneNumber, String password) {
        try {
            UserForNewsApp principal = (UserForNewsApp) authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(phoneNumber, password)).getPrincipal();
            return new ApiResponseWithToken("success", true, 200, jwtService.generateToken(principal.getPhoneNumber()));
        } catch (Exception e) {
            throw new AppLoginException("username or password is incorrect");
        }
    }


    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        return userRepository.findByPhoneNumber(phoneNumber).orElseThrow(() -> new NewsAppResourceNotFoundException("user not found"));
    }
}
