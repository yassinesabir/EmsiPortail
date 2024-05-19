package ma.exemple.emsiCasablanca03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 1. Authentication

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("yassine")
                        .password("admin1")
                        .roles("ADMIN")
                        .build();
        UserDetails user1 =
                User.withDefaultPasswordEncoder()
                        .username("hasnaa")
                        .password("admin2")
                        .roles("ADMIN")
                        .build();
        UserDetails user2 =
                User.withDefaultPasswordEncoder()
                        .username("aya")
                        .password("akil123")
                        .roles("Student")
                        .build();

        return new InMemoryUserDetailsManager(user, user1, user2);
    }

    // 2. Authorizarion

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "home", "/login", "/style.css", "/images/login_image.png", "/images/logo.png", "/images/404.png").permitAll()
                        .requestMatchers("/StudentsChannel").hasRole("Student")
                        .requestMatchers("/TeachersChannel").hasRole("Teacher")
                        .anyRequest().authenticated()

                )
                .formLogin(form -> form.loginPage("/login").permitAll()
                )
                .logout(LogoutConfigurer::permitAll);
        return http.build();
    }
}
