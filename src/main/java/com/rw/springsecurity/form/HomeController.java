package com.rw.springsecurity.form;

import com.rw.springsecurity.vo.Account;
import com.rw.springsecurity.vo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    AccountRepository repository;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/Profile")
    public String  profile(Model model){

        OAuth2AuthenticationToken authentication = (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        String authorizedClientRegistrationId = authentication.getAuthorizedClientRegistrationId();
        model.addAttribute("authorizedClientRegistrationId", authorizedClientRegistrationId);

        String name="";
        // model에 간단한 principal 정보와 DB에 저장된 계정 정보 전달
        if ( authorizedClientRegistrationId.equals("facebook")){
            DefaultOAuth2User facebookUser = (DefaultOAuth2User)authentication.getPrincipal();
            name = facebookUser.getName();
        } else if ( authorizedClientRegistrationId.equals("google")){
            DefaultOidcUser googleUser = (DefaultOidcUser)authentication.getPrincipal();
            name =googleUser.getName();
        } else if ( authorizedClientRegistrationId.equals("kakao")){
            DefaultOAuth2User kakaoUser = (DefaultOAuth2User)authentication.getPrincipal();
            name = kakaoUser.getName();
        } else if ( authorizedClientRegistrationId.equals("naver")){
            DefaultOAuth2User naverUser = (DefaultOAuth2User)authentication.getPrincipal();
            name = naverUser.getName();
        }
        Account account =repository.findByPrincipal(name);
        model.addAttribute("account", account);

        return "profile";
    }

    @GetMapping("/Members")
    public String  members(Model model){
        // Account 리스트 전달
        Iterable<Account> accounts = repository.findAll();
        model.addAttribute("accounts", accounts);
        return "members";
    }
}
