package com.metavirtual.bloom.application.model.service;

import com.metavirtual.bloom.user.model.dao.UserMapper;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    public final UserMapper userMapper;

    public AuthenticationService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        log.info("[AuthenticationService] =====================================================");
        log.info("[AuthenticationService] userId : " + userId);

        UserDTO user = userMapper.findUserById(userId);

        log.info("[AuthenticationService] user : " + user);

        if(user == null){
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다");
        }

        return null; /*오류 뜸. userDetails 가 필요한데 UserDTO 라고 */
    }

}
