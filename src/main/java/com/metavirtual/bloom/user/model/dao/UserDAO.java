package com.metavirtual.bloom.user.model.dao;

import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {

   UserDTO findUserById(String userId);
}
