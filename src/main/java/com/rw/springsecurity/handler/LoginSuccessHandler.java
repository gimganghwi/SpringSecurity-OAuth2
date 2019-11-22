package com.rw.springsecurity.handler;

import com.rw.springsecurity.vo.Account;
import com.rw.springsecurity.vo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    AccountRepository repository;

    public LoginSuccessHandler(String defaultTargetUrl){
        setDefaultTargetUrl(defaultTargetUrl);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        String principal="";
        String name ="";
        Date date = new Date();

        OAuth2AuthenticationToken authenticationToken = (OAuth2AuthenticationToken)authentication;
        String authorizedClientRegistrationId = authenticationToken.getAuthorizedClientRegistrationId();
        if ( authorizedClientRegistrationId.equals("facebook")){
            DefaultOAuth2User facebookUser = (DefaultOAuth2User)authentication.getPrincipal();
            principal = facebookUser.getName();
            name = facebookUser.getAttributes().get("name").toString();
        } else if ( authorizedClientRegistrationId.equals(("google"))){
            DefaultOidcUser googleUser = (DefaultOidcUser)authentication.getPrincipal();
            principal = googleUser.getName();
            name = googleUser.getAttributes().get("name").toString();
        } else if ( authorizedClientRegistrationId.equals("kakao")){
            DefaultOAuth2User kakaoUser = (DefaultOAuth2User)authentication.getPrincipal();
            principal = kakaoUser.getName();
            LinkedHashMap properties = (LinkedHashMap) kakaoUser.getAttributes().get("properties");
            name = properties.get("nickname").toString();
        } else if ( authorizedClientRegistrationId.equals("naver")){
            DefaultOAuth2User naverUser = (DefaultOAuth2User)authentication.getPrincipal();
            principal = naverUser.getName();
            name = naverUser.getAttributes().get("name").toString();
        }

        // 첫 번째 로그인인지 확인
        if ( repository.findByPrincipal(principal) == null ){
            // 새로운 계정 삽입
            repository.save( new Account(principal, name, date));
        }

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
