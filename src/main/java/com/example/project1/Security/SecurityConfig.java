package com.example.project1.Security;

import com.example.project1.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Autowired
    private MyUserDetailsService myUserDetailsService;


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authz) ->

                authz.
                        requestMatchers("/admin/**").permitAll()
//                        .requestMatchers("country/**").permitAll()
                        .anyRequest().authenticated()
                )
                .logout((logout) -> logout.logoutSuccessUrl("/home").permitAll())
                .formLogin(form -> form
                        .loginPage("/sign-in")
                        .permitAll()
                        .defaultSuccessUrl("/sign-in?success=true")
                        .failureForwardUrl("/error?success=fail")
                        .permitAll()
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .loginProcessingUrl("/j_spring_security_check")
                );

        return http.build();
    }



    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails userDetails = User.builder()
                .username("user")
                .password(passwordEncoder().encode("password"))
//                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }


    // config authentication managerment

    @Bean
    public AuthenticationManager authenticationManager ( ){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(myUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return  new ProviderManager(authenticationProvider);

    }


}
