package uz.alif.authentication_news_app.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.alif.authentication_news_app.entity.Role;
import uz.alif.authentication_news_app.repository.RoleRepository;
import uz.alif.authentication_news_app.entity.UserForNewsApp;
import uz.alif.authentication_news_app.enums.Permission;
import uz.alif.authentication_news_app.repository.UserRepository;
import static uz.alif.authentication_news_app.enums.Permission.*;

import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Value(value = "${spring.sql.init.mode}")
    private String sqlInitMode;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (sqlInitMode.equals("always")) {

            Role roleAdmin = new Role();
            roleAdmin.setName("admin");
            roleAdmin.setDescription("hamma ishni qiladi tizimdagi");
            roleAdmin.setPermissions(Set.of(Permission.values()));
            Role savedRoleAdmin = roleRepository.save(roleAdmin);

            Role roleUser = new Role();
            roleUser.setName("user");
            roleUser.setDescription("yangi ro'yxatdan o'tgan user uchun");
            roleUser.setPermissions(Set.of(VIEW_POST, ADD_COMMENT, EDIT_COMMENT, DELETE_MY_COMMENT, VIEW_COMMENT));
            Role savedRoleUser = roleRepository.save(roleUser);

            UserForNewsApp admin = new UserForNewsApp();
            admin.setFullName("Muhammad");
            admin.setPhoneNumber("998901582195");
            admin.setEnabled(true);
            admin.setPassword(passwordEncoder.encode("rootAdmin"));
            admin.setRole(savedRoleAdmin);
            userRepository.save(admin);

            UserForNewsApp user = new UserForNewsApp();
            user.setFullName("Abdulloh");
            user.setPhoneNumber("998901547666");
            user.setEnabled(true);
            user.setPassword(passwordEncoder.encode("rootUser"));
            user.setRole(savedRoleUser);
            userRepository.save(user);
        }
    }
}
