package uz.alif.authentication_news_app.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import uz.alif.authentication_news_app.entity.UserForNewsApp;

import java.nio.file.AccessDeniedException;

@Component
@Aspect
public class CheckPermissionImpl {
    @Before(value = "@annotation(checkPermission)")
    public void checkUserPermission(CheckPermission checkPermission) throws AccessDeniedException {
        UserForNewsApp user = (UserForNewsApp) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        for (GrantedAuthority authority : user.getAuthorities()) {
            if (authority.getAuthority().equals(checkPermission.permission())) {
                return;
            }
        }
        throw new AccessDeniedException("access denied");
    }

}
