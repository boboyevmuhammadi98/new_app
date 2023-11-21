package uz.alif.authentication_news_app.auditng;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import uz.alif.authentication_news_app.entity.UserForNewsApp;

@Configuration
@EnableJpaAuditing
public class AuditingConfiguration {
    @Bean
    public AuditorAware<UserForNewsApp> uuidAuditorProvider() {
        return new AuditingSecurity();
    }

}
