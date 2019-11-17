package jm.fatumepta.springmvc.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;


@Configuration
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        // getting user's authority (role)
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        // putting username (login) into the session
        request.getSession().setAttribute("login", request.getParameter("username"));

        // choosing url to redirect
        String url = roles.contains("ROLE_admin") ? "/admin/users" : "/home";

        response.sendRedirect(url);

    }
}
