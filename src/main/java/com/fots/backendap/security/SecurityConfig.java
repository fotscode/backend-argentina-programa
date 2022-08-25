package com.fots.backendap.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.fots.backendap.filter.CustomAuthenticationFilter;
import com.fots.backendap.filter.CustomAuthorizationFilter;

import lombok.RequiredArgsConstructor;

/**
 * SecurityConfig
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  private final UserDetailsService userDetailsService;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
    customAuthenticationFilter.setFilterProcessesUrl("/api/login");
    http.csrf().disable();
    http.cors().configurationSource(corsConfigurationSource());
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/login/**").permitAll();
    http.authorizeRequests()
        .antMatchers(HttpMethod.GET, "/project/**", "/skill/**", "/experience/**", "/education/**",
            "/profile/**", "/api/login/**")
        .permitAll();
    http.authorizeRequests()
        .antMatchers(HttpMethod.POST, "/project/**", "/skill/**", "/experience/**", "/education/**",
            "/profile/**")
        .hasAnyAuthority("ROLE_USER");
    http.authorizeRequests()
        .antMatchers(HttpMethod.DELETE, "/project/**", "/skill/**", "/experience/**", "/education/**", "/profile/**")
        .hasAnyAuthority("ROLE_USER");
    http.authorizeRequests()
        .antMatchers(HttpMethod.PUT, "/project/**", "/skill/**", "/experience/**", "/education/**", "/profile/**")
        .hasAnyAuthority("ROLE_USER");
    http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/user/**", "/api/token/refresh/**").hasAnyAuthority("ROLE_USER");
    http.authorizeRequests().anyRequest().authenticated();
    http.addFilter(customAuthenticationFilter);
    http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
    //corsConfiguration.setAllowedOrigins(Arrays.asList("*", "https://frontend-argentina-progr-4954e.web.app"));
    //corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS", "PATCH"));
    //corsConfiguration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers", "Access-Control-Allow-Origin",
    //    "Access-Control-Request-Method", "Access-Control-Request-Headers", "Origin", "X-Requested-With", "X-Auth-Token",
    //    "Cache-Control", "Content-Type", "Accept"));
    corsConfiguration.setAllowCredentials(true);
    corsConfiguration.setExposedHeaders(Arrays.asList("*"));
    corsConfiguration.setAllowedOriginPatterns(Arrays.asList("*"));
    corsConfiguration.addAllowedMethod(HttpMethod.DELETE);
    corsConfiguration.addAllowedMethod(HttpMethod.PUT);
    source.registerCorsConfiguration("/**", corsConfiguration);
    return source;
  }

}
