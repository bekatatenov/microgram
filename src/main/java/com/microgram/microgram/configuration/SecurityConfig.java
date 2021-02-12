package com.microgram.microgram.configuration;

import com.microgram.microgram.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends  WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userService);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        // Правило 1: Всё, что начинается с /subscriptions
        // должно быть доступно только
        // после авторизации пользователя
        http.authorizeRequests()
                .antMatchers("/subs/**")
                .fullyAuthenticated()
                .antMatchers(HttpMethod.POST, "/images/**")
                .fullyAuthenticated()
                .antMatchers(HttpMethod.POST, "/posts/**")
                .fullyAuthenticated()
                .antMatchers(HttpMethod.DELETE, "/posts/**")
                .fullyAuthenticated()
                .antMatchers(HttpMethod.DELETE, "/likes/**")
                .fullyAuthenticated()
                .antMatchers(HttpMethod.POST, "/likes/**")
                .fullyAuthenticated()
                .antMatchers(HttpMethod.DELETE, "/comments/**")
                .fullyAuthenticated()
                .antMatchers(HttpMethod.POST, "/comments/**")
                .fullyAuthenticated();

        // Правило 2: Разрешить всё остальные запросы
        http.authorizeRequests()
                .anyRequest()
                .permitAll();

        // Настраиваем хранение сессий. Не храним сессию.
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Используем авторизацию по механизму Http Basic.
        // Данные пользователя передаются через заголовок запроса
        http.httpBasic();

        // Так как мы авторизуемся через заголовок запроса, то
        // форма входа на сайт и выхода с него нам тоже не нужны.
        http.formLogin().disable().logout().disable();

        // Так как у нас REST сервис, нам не нужна защита от CSRF
        http.csrf().disable();

    }
}
