
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, UserMapper userMapper){
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public boolean selectUserById(String userId) {

        String result = userMapper.selectUserById(userId);

        return result != null ? true : false;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserDTO user = userMapper.findUserById(userId);

        if(user == null){
            user = new UserDTO();
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        if(user.getUserRoleList() != null) {
            List<UserRoleDTO> roleList = user.getUserRoleList();

            for(int i = 0; i < roleList.size(); i++) {

                AuthorityDTO authority = roleList.get(i).getAuthority();
                authorities.add(new SimpleGrantedAuthority(authority.getAuthorityName()));
            }
        }

        UserImpl userImpl = new UserImpl(user.getUserId(), user.getPwd(), authorities);
        userImpl.setDetails(user);

        return userImpl;
    }


    @Transactional
    public void registUser(UserDTO user, MemberDTO member) throws UserRegistException {

        log.info("[UserService] Insert User : " + user);
        int result1 = userMapper.insertUser(user);
        int result2 = userMapper.insertMember(member);


        log.info("[UserService] Insert result : " + ((result1 > 0 && result2 > 0) ? "회원가입 성공" : "회원가입 실패"));


        if(!(result1 > 0 && result2 > 0)){
            throw new UserRegistException("회원 가입에 실패하였습니다.");
        }
    }

}
