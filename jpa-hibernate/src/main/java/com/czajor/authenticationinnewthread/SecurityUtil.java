package com.czajor.authenticationinnewthread;

import java.util.Set;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class SecurityUtil {

  public static void setContextAuthentication(Authentication authentication) {
    SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
    securityContext.setAuthentication(authentication);
    SecurityContextHolder.setContext(securityContext);
  }

  public static Authentication user() {
    final User user = new User("joe", "password", Set.of(
        new Role("ROLE_USER"),
        new Role("ROLE_ADMIN")));

    return new UsernamePasswordAuthenticationToken(
        user,
        null,
        user.getAuthorities()
    );
  }

  static class Role implements GrantedAuthority {
    private String role;

    public Role(String role) {
      this.role = role;
    }

    @Override
    public String getAuthority() {
      return role;
    }
  }

}
