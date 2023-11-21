package uz.alif.authentication_news_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.alif.authentication_news_app.entity.template.AbstractEntity;
import uz.alif.authentication_news_app.enums.Permission;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class UserForNewsApp extends AbstractEntity implements UserDetails {

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private boolean isAccountNonExpired = true;

    @Column(nullable = false)
    private boolean isAccountNonLocked = true;

    @Column(nullable = false)
    private boolean isCredentialsNonExpired = true;

    @Column(nullable = false)
    private boolean isEnabled = false;

    @JsonIgnore
    private String verificationCode;

    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Permission permission : role.getPermissions()) {
            authorities.add((GrantedAuthority) permission::name);
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.phoneNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }
}
