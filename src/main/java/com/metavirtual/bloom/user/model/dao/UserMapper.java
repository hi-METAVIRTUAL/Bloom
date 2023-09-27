package com.metavirtual.bloom.user.model.dao;


import com.metavirtual.bloom.booking.model.dto.BookingDTO;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.DataFileDTO;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.TherapistDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

   String selectUserByNickname(String nickname);
   int insertUser(UserDTO user);
   int insertMember(MemberDTO member);

   int idDupCheck(String userId) throws Exception;

   UserDTO findUserById(String userId);

   int nicknameDupCheck(String nickname);

    int insertTherapist(TherapistDTO therapist);

   int updateDataFile(DataFileDTO dataFile);


   int uploadDataFile(DataFileDTO dataFile);

   List<BookingDTO> bookingStatus(String userId);

   String findDetails(String name, String email);

   int emailDupCheck(String email);

   String findUserDetails(String userId, String email);

   void changePwd(UserDTO user);

   /*   AuthDetails findUserById(String username);*/

}
