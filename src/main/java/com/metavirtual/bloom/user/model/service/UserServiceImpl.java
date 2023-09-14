package com.metavirtual.bloom.user.model.service;

import com.metavirtual.bloom.user.model.dao.UserDAO;
import com.metavirtual.bloom.user.model.dto.AuthorityDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
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

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        UserDTO user = userDAO.findUserById(userId);

        if(user==null) {
            user = new UserDTO();
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        return null;

        if(user.getMemberRoleList() != null) {
            List<UserRoleDTO> roleList = user.getMemberRoleList();

            for(int i = 0; i < roleList.size(); i++) {

                AuthorityDTO authority = roleList.get(i).getAuthority();
                authorities.add(new SimpleGrantedAuthority(authority.getName()));
            }
        }

        UserImpl newUser = new UserImpl( user.getUserId(), user.getPassword(), authorities);                                                                                                                         .getId(), member.getPwd(), authorities);
        newUser.setDetails(user);
    }
}
