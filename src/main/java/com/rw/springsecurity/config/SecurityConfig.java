package com.rw.springsecurity.config;

import com.rw.springsecurity.handler.LoginSuccessHandler;
import com.rw.springsecurity.vo.CustomAuthorizationRequestResolver;
import com.rw.springsecurity.vo.NaverOAuth2User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web){
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Autowired
    ClientRegistrationRepository clientRegistrationRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/Profile").authenticated()
                .anyRequest().permitAll();
        http.oauth2Login()
                .successHandler(successHandler())
                .authorizationEndpoint()
                    .authorizationRequestResolver(new CustomAuthorizationRequestResolver(
                            clientRegistrationRepository,
                            "/oauth2/authorization"
                    ))
                    .and()
                .userInfoEndpoint()
                    .customUserType(NaverOAuth2User.class, "naver");
                //.loginPage("/login");
    }

    @Bean
    public AuthenticationSuccessHandler successHandler(){
        return new LoginSuccessHandler("/");
    }
}
