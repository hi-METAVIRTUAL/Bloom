/*
package com.metavirtual.bloom.user.model.service;

import com.metavirtual.bloom.user.model.dao.UserMapper;
import com.metavirtual.bloom.user.model.dto.AuthorityDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import com.metavirtual.bloom.user.model.dto.UserImpl;
import com.metavirtual.bloom.user.model.dto.UserRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserDTO user = userMapper.findUserById(userId);

        /* 사용자가 입력한 아이디로 조회가 안될 경우 NPE(NullPointerException) 방지를 위해 빈 UserDTO 객체를 생성 */
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
}
*/
