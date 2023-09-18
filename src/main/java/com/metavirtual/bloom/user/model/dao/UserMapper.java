package com.metavirtual.bloom.user.model.dao;

import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.Map;

@Mapper
public interface UserMapper {
   String selectUserById(String userId);
   int insertUser(UserDTO user);
   int insertMember(MemberDTO member);
   UserDTO findUserById(String userId);



}
