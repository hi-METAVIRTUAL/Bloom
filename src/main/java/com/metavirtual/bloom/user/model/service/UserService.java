package com.metavirtual.bloom.user.model.service;

import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetailsService;

/*
package com.metavirtual.bloom.user.model.service;

import org.springframework.security.core.userdetails.UserDetailsService;

/* Spring Security가 제공하는 UserDetailServices를 상속 받아야 한다*/
public interface UserService extends UserDetailsService {

    boolean selectUserById(String userId);
}

