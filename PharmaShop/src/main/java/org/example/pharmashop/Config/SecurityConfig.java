package org.example.pharmashop.Config;


import org.example.pharmashop.Service.Impl.UserServiceImpl;
import org.example.pharmashop.Service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userService()).passwordEncoder(passwordEncoder());

        http.exceptionHandling(
                exception -> exception.accessDeniedPage("/forbidden")
        );

        http.authorizeRequests(
                authorize -> authorize
                        .requestMatchers("/sign-in", "/entering", "/sign-up", "/registration").anonymous()
                        .requestMatchers("/sign-out", "/change-password", "/save-password").authenticated()
                        .requestMatchers("/profile").authenticated()
                        .requestMatchers("/css/**", "/js/**").permitAll()
                        .requestMatchers("/users").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/posts").hasAuthority("ROLE_MANAGER")
                        .anyRequest().permitAll()
        ).formLogin(
                login -> login
                        .loginProcessingUrl("/entering")
                        .defaultSuccessUrl("/profile")
                        .loginPage("/sign-in")
                        .failureUrl("/sign-in?error")
                        .usernameParameter("user_email")
                        .passwordParameter("user_password")
        ).logout(
                logout -> logout
                        .logoutSuccessUrl("/sign-in?logout")
                        .logoutUrl("/sign-out")
        ).csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
