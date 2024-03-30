package com.example.triviet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  RequestFilter requestFilter;

  @Autowired
  public SecurityConfig(RequestFilter requestFilter) {
    this.requestFilter = requestFilter;
  }

  /**
   * configures Spring Security to disable CSRF and CORS protection defines authorization rules for
   * different URL patterns sets session management to be stateless, adds a custom filter to the
   * security filter chain.
   *
   * @param http http to filter
   * @return the http
   * @throws Exception throws exception when create session fail
   */
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.cors(AbstractHttpConfigurer::disable)
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(
            request ->
                request
                    .requestMatchers("/swagger-ui/**")
                    .permitAll()
                    .requestMatchers("/api/admin/**")
                    .hasRole("ADMIN")
                    .requestMatchers("/api/user/**")
                    .hasRole("USER")
                    .requestMatchers("/api/accountant/**")
                    .hasRole("ACCOUNTANT")
                    .requestMatchers("/api/academic-staff/**")
                    .hasRole("ACADEMIC_STAFF")
                    .anyRequest()
                    .authenticated())
        .sessionManagement(
            session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }
}
