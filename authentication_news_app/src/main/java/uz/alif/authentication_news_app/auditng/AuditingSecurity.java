package uz.alif.authentication_news_app.auditng;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import uz.alif.authentication_news_app.entity.UserForNewsApp;

import java.util.Optional;

public class AuditingSecurity implements AuditorAware<UserForNewsApp> {
    @Override
    public Optional<UserForNewsApp> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !authentication.getPrincipal().equals("anonymousUser")) {
            return Optional.of(((UserForNewsApp) authentication.getPrincipal()));
        }
        return Optional.empty();
    }
}
