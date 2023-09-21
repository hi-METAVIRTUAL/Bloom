
package com.metavirtual.bloom.user.model.service;


import com.metavirtual.bloom.common.exception.member.UserRegistException;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.DataFileDTO;
import com.metavirtual.bloom.user.model.dao.UserMapper;
import com.metavirtual.bloom.user.model.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public int idDupCheck(String userId) throws Exception {
        System.out.println(userId);
        return userMapper.idDupCheck(userId);
    }

    public int nicknameDupCheck(String nickname) {
        System.out.println(nickname);
        return userMapper.nicknameDupCheck(nickname);

    }

    @Override
    @Transactional
    public void registUser(UserDTO user, MemberDTO member) throws UserRegistException {

        System.out.println("[UserService] 들어옴");
        System.out.println("[UserService] Insert User : " + user);
        System.out.println("[UserService] Insert Member : " + member);

        int result1 = userMapper.insertUser(user);
        int result2 = userMapper.insertMember(member);

        System.out.println("[UserService] Insert result1 : " + ((result1 > 0 ) ? "일반 회원가입 성공" : "일반 회원가입 실패"));
        System.out.println("[UserService] Insert result2 : " + ((result2 > 0) ? "일반 member 회원가입 성공" : "일반 member 회원가입 실패"));


        if (!(result1 > 0 && result2 > 0)) {
            throw new UserRegistException("회원 가입에 실패하였습니다.");
        }
    }

    @Override
    @Transactional
    public void registTherapist(UserDTO user, TherapistDTO therapist, DataFileDTO dataFile) throws UserRegistException, ModifyInfoException {

        System.out.println("[UserService] 들어옴");
        System.out.println("[UserService] Insert User : " + user);

        int userResult = userMapper.insertUser(user);
        int therapistResult = userMapper.insertTherapist(therapist);



        System.out.println("[UserService] Insert userResult : " + ((userResult > 0) ? "상담사 인적사항 회원가입 성공" : "상담사 인적사항 회원가입 실패"));
        if(!(userResult > 0)) {
            throw new UserRegistException("상담사 회원가입에 실패하였습니다");
        }

        System.out.println("[UserService] Insert therapistResult : " + ((therapistResult > 0) ? "상담사 추가 문항 등록 성공" : "상담사 추가 문항 등록 실패"));
        if(!(therapistResult > 0)) {
            throw new UserRegistException("상담사 추가 문항 등록에 실패하였습니다");
        }

        int fileResult;

        if(dataFile.getFileNumber() == 0){
            fileResult = userMapper.uploadDataFIle(dataFile);
        } else {
            fileResult = userMapper.updateDataFile(dataFile);
        }
        if(!(fileResult>0)){
            throw new ModifyInfoException("❌프로필 사진 업로드 실패❌");
        }


    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


}
