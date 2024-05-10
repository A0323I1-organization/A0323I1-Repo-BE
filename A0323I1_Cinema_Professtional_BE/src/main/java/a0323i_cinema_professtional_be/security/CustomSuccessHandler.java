package a0323i_cinema_professtional_be.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
            // TODO Auto-generated method stub

            var authourities = authentication.getAuthorities();
            var roles = authourities.stream().map(r -> r.getAuthority()).findFirst();

            if (roles.orElse("").equals("ADMIN")) {
                response.sendRedirect("/admin-page");
            } else if (roles.orElse("").equals("USER")) {
                response.sendRedirect("/user-page");
            } else {
                response.sendRedirect("/error");
            }
    }
}
