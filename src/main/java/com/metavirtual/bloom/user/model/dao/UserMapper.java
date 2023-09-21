package com.metavirtual.bloom.user.model.dao;


import com.metavirtual.bloom.myPage.therapistPage.model.dto.DataFileDTO;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.TherapistDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.concurrent.ExecutionException;

@Mapper
public interface UserMapper {

   String selectUserByNickname(String nickname);
   int insertUser(UserDTO user);
   int insertMember(MemberDTO member);

   int idDupCheck(String userId) throws Exception;

   int findUserById(String userId);

   int nicknameDupCheck(String nickname);

    int insertTherapist(TherapistDTO therapist);

   int uploadDataFIle(DataFileDTO dataFile);

   int updateDataFile(DataFileDTO dataFile);

   /*   AuthDetails findUserById(String username);*/

}
