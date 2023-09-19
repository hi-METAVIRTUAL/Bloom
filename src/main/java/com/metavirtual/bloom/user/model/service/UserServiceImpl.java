
package com.metavirtual.bloom.user.model.service;


import com.metavirtual.bloom.common.exception.member.UserRegistException;
import com.metavirtual.bloom.user.model.dao.UserMapper;
import com.metavirtual.bloom.user.model.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl<AuthDetails> implements UserService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    /*private final PasswordEncoder passwordEncoder;*/

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(
            /*PasswordEncoder passwordEncoder,*/
            UserMapper userMapper) {
//this.passwordEncoder = passwordEncoder;

        this.userMapper = userMapper;
    }

/*    @Override
    public boolean selectUserById(String username) {

        String result = userMapper.selectUserById(username);

        return result != null ? true : false;
    }*/

/*    @Override
    public boolean selectUserByNickname(String nickname) {
        String result = userMapper.selectUserByNickname(nickname);

        return result != null ? true : false;
    }*/


    @Override
    @Transactional
    public void registUser(UserDTO user, MemberDTO member) throws UserRegistException {

        log.info("[UserService] Insert User : " + user);
        int result1 = userMapper.insertUser(user);
        int result2 = userMapper.insertMember(member);


        log.info("[UserService] Insert result : " + ((result1 > 0 && result2 > 0) ? "회원가입 성공" : "회원가입 실패"));


        if (!(result1 > 0 && result2 > 0)) {
            throw new UserRegistException("회원 가입에 실패하였습니다.");
        }
    }

    /*public AuthDetails findUserId(String username) {
        return null;
    }*/


    
    public boolean idDupCheck(String userId){
        String result = userMapper.idDupCheck(userId);
        return result != null? true : false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
