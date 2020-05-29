package com.developervisits.remember.me;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user@neric.org")
                .password(passwordEncoder().encode("123456"))
                .roles("USER")
            .and()
                .withUser("admin@neric.org")
                    .password(passwordEncoder().encode("123456"))
                    .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
        .authorizeRequests().antMatchers("/login").permitAll()
            .antMatchers("/admin/**").hasRole("ADMIN")
        .and()
            .formLogin().loginPage("/login") // cutom login page. 
            .usernameParameter("email")
            .passwordParameter("password")
            .loginProcessingUrl("/login")  // this should be public too(which we did) as user's request would reach here then authentication will happen. 
            .defaultSuccessUrl("/loginSuccess") // this has to be done since you have two different role so we need to identify whether user role or admin role and based on that redirection should happen.
        .and()
            .logout()
                .logoutUrl("/logout") // logout should be common for both role so dont add /admin/logout  
                 .invalidateHttpSession(true)
            .permitAll()
        .and()
            .csrf()
                .disable()
        //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
       ;
    }
}
