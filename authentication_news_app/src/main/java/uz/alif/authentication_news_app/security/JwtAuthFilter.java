package uz.alif.authentication_news_app.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.alif.authentication_news_app.repository.TokenBlockListRepository;
import uz.alif.authentication_news_app.servce.AuthService;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthService authService;
    @Autowired
    private TokenBlockListRepository tokenBlockListRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = request.getHeader("Authorization");
            String phoneNumber = null;
            if (token != null && token.startsWith("Bearer ")) {
                token = token.substring(7);
                phoneNumber = jwtService.extractUsername(token);
            }

            if (phoneNumber != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = authService.loadUserByUsername(phoneNumber);
                if (jwtService.validateToken(token, userDetails)) {
                    if (!tokenBlockListRepository.existsByToken(token)) {
                        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authToken);
                    }
                }
            }
        }catch (Exception ignored){

        }
        filterChain.doFilter(request, response);
    }
}
