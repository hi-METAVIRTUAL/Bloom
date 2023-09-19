package com.metavirtual.bloom.user.model.dao;


import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

   String selectUserByNickname(String nickname);
   int insertUser(UserDTO user);
   int insertMember(MemberDTO member);

   String idDupCheck(String userId);

   int findUserById(String userId);

   /*   AuthDetails findUserById(String username);*/

}
