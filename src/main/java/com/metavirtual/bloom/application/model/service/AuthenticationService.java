/*
package com.metavirtual.bloom.application.model.service;

import com.metavirtual.bloom.application.model.dto.AuthDetails;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import com.metavirtual.bloom.user.model.service.UserService;
import com.metavirtual.bloom.user.model.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    public final UserServiceImpl userServiceImpl;

    @Autowired
    public AuthenticationService(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthDetails auth = userServiceImpl.findUserId(username);
        if(Objects.isNull(auth)) {
            throw new UsernameNotFoundException("회원 정보가 없습니다.");
        }

        return auth;
    }
}
*/
