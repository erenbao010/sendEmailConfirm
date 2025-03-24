package com.sendEmailSpringBoot.demo.security.config;

import com.sendEmailSpringBoot.demo.appUser.AppUserService;
import com.sendEmailSpringBoot.demo.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig {

    private final AppUserService AppUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(
                    auth -> auth.requestMatchers("/users/**", "/identity/users/**")
                                .permitAll().anyRequest()
                                .authenticated())
            .oauth2Login(oauth2 -> oauth2
                    .loginPage("/login")
                    .defaultSuccessUrl("http://localhost:3000/dashboard", true))
            /* Customizer.withDefaults meaning no conffigurration wwill be applied inside the
             httBasic method in the httpSecutiry object */
            .formLogin(Customizer.withDefaults());
        return http.build();
    }
    //    @Bean
    //    public ClientRegistrationRepository clientRegistrationRepository() {
    //        return new InMemoryClientRegistrationRepository(this
    //        .googleClientRegistration());
    //    }
    //    private ClientRegistration googleClientRegistration() {
    //        return ClientRegistration.withRegistrationId("google")
    //                                 .clientId("google-client-id")
    //                                 .clientSecret("google-client-secret")
    //                                 .clientAuthenticationMethod
    //                                 (ClientAuthenticationMethod
    //                                 .CLIENT_SECRET_BASIC)
    //                                 .authorizationGrantType
    //                                 (AuthorizationGrantType
    //                                 .AUTHORIZATION_CODE)
    //                                 .redirectUri
    //                                 ("{baseUrl}/login/oauth2/code/{registrationId}")
    //                                 .scope("openid", "profile", "email",
    //                                 "address", "phone")
    //                                 .authorizationUri("https://accounts.google.com/o/oauth2/v2/auth")
    //                                 .tokenUri("https://www.googleapis.com/oauth2/v4/token")
    //                                 .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
    //                                 .userNameAttributeName
    //                                 (IdTokenClaimNames.SUB)
    //                                 .jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
    //                                 .clientName("Google")
    //                                 .build();
    //    }

    @Bean
    public AuthenticationManager authenticationManager(PasswordEncoder passwordEncoder,
            UserDetailsService userDetailsService)
    {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(AppUserService);
        return new ProviderManager(provider);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:3000") // React
                        .allowedMethods("GET", "POST", "PUT", "DELETE").allowCredentials(true);
            }
        };
    }
}
