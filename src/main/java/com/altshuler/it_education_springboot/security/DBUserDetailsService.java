package com.altshuler.it_education_springboot.security;

import com.altshuler.it_education_springboot.model.AppUser;
import com.altshuler.it_education_springboot.repo.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.method.P;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_USER_NAME;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_USER_PASSWORD;

/*@Component
@RequiredArgsConstructor*/
public class DBUserDetailsService /*implements UserDetailsService*/ {

   /* private final AppUserRepository appUserRepository;*/

    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser == null) {
            throw new UsernameNotFoundException("User does not exists");
        }
        List<SimpleGrantedAuthority> authorities = Collections.singletonList(
                new SimpleGrantedAuthority("ROLE_USER"));
        return new User(appUser.getUsername(), appUser.getPassword(), authorities);
    }*/
}
