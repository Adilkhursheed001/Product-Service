package com.E_commerceBackend.E_commerceBackend.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
//import org.springframework.security.oauth2.jwt.ReactiveJwtDecoders;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.oauth2.jwt.JwtDecoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                .authorizeHttpRequests((authorize) -> authorize
      //                  .requestMatchers("/product/").hasAuthority("ADMIN")
//                                .requestMatchers("/search").permitAll()
                        .anyRequest().authenticated()

                )
                .cors().disable()
                .csrf().disable()
               .oauth2ResourceServer((oauth2) -> oauth2
                        .jwt(Customizer.withDefaults()));
//                        .oauth2ResourceServer(oauth2 -> oauth2
//                                .jwt(jwt -> jwt
//                                        .jwtAuthenticationConverter(new CustomJwtAuthenticationConverter())
//                                )
//                        );



        return http.build();
    }


}
