
package com.metavirtual.bloom.user.model.service;


import com.metavirtual.bloom.common.exception.member.UserRegistException;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.DataFileDTO;
import com.metavirtual.bloom.user.model.dao.UserMapper;
import com.metavirtual.bloom.user.model.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired
    public UserServiceImpl(UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

//    @Transactional
//    public int login(UserDTO userDTO) throws UsernameNotFoundException{
//
//        String rawPassword = userDTO.getPwd();
//        String encodedPassword = userMapper.getEncPass(userDTO.getUserId());
//
//        if(!passwordEncoder.matches(rawPassword, encodedPassword)){
//            return 0;
//        }else{
//            userDTO.setPwd(encodedPassword);
//            return userMapper.login(userDTO);
//        }
//    }

    @Override
    public UserDetails loadUserByUsername(@RequestParam("username") String userId) throws UsernameNotFoundException {


        UserDTO user = userMapper.findUserById(userId);
        log.info(String.valueOf(user));
        /* 사용자가 입력한 아이디로 조회가 안될 경우 NPE(NullPointerException) 방지를 위해 빈 MemberDTO 객체를 생성 */
        if (user == null) {
//            throw new UsernameNotFoundException("존재하는 정보가 없습니다");
            user = new UserDTO();
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (user.getAuthorityCode() != 1 || user.getAuthorityCode() != 2) {
            int authorityCode = user.getAuthorityCode();

            authorities.add(new SimpleGrantedAuthority(String.valueOf(authorityCode)));
        }

        UserImpl userImpl = new UserImpl(user.getUserId(), user.getPwd(), authorities);
        userImpl.setDetails(user);
        log.info(userId);
        return userImpl;
    }



    @Transactional
    public int idDupCheck(String userId) throws Exception {
        System.out.println(userId);
        return userMapper.idDupCheck(userId);
    }

    @Transactional
    public int nicknameDupCheck(String nickname) {
        System.out.println(nickname);
        return userMapper.nicknameDupCheck(nickname);

    }


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




/*    @Override
    @Transactional
    public void registTherapist(UserDTO user, TherapistDTO therapist, DataFileDTO dataFile) throws UserRegistException, ModifyInfoException {

        System.out.println("[UserService] 들어옴");
        System.out.println("[UserService] Insert User : " + user);

        int userResult = userMapper.insertUser(user);
        int therapistResult = userMapper.insertTherapist(therapist);

        System.out.println("[UserService] Insert userResult : " + ((userResult > 0) ? "상담사 인적사항 회원가입 성공" : "상담사 인적사항 회원가입 실패"));
        if (!(userResult > 0)) {
            throw new UserRegistException("상담사 회원가입에 실패하였습니다");
        }

        System.out.println("[UserService] Insert therapistResult : " + ((therapistResult > 0) ? "상담사 추가 문항 등록 성공" : "상담사 추가 문항 등록 실패"));
        if (!(therapistResult > 0)) {
            throw new UserRegistException("상담사 추가 문항 등록에 실패하였습니다");
        }

        int fileResult;

        if (dataFile.getFileNumber() == 0) {
            fileResult = userMapper.uploadDataFile(dataFile); // Adjust method name
        } else {
            fileResult = userMapper.updateDataFile(dataFile); // Adjust method name
        }

        if (fileResult <= 0) {
            throw new ModifyInfoException("❌파일 업로드 실패❌");
        }
    }*/



    @Value("${image.image-dir}")
    private String FILE_DIR;

    @Value("${spring.servlet.multipart.location}")
    private String ROOT_LOCATION;

    @Transactional
    public void registTherapist(UserDTO user, TherapistDTO therapist, DataFileDTO dataFile, List<MultipartFile> therapistFiles) throws UserRegistException, ModifyInfoException {

        System.out.println("[UserService] 들어옴");
        System.out.println("[UserService] Insert User : " + user);
        System.out.println("[UserService] Insert Therapist : " + therapist);
        System.out.println("[UserService] Insert dataFile : " + therapistFiles);


        userMapper.insertUser(user);
        userMapper.insertTherapist(therapist);


        for (MultipartFile therapistFile : therapistFiles) {
            if (!therapistFile.isEmpty()) {
                DataFileDTO newDataFile = new DataFileDTO();
                String fileOriginName = therapistFile.getOriginalFilename();
                String ext = fileOriginName.substring(fileOriginName.lastIndexOf("."));
                String fileChangedName = UUID.randomUUID().toString().replaceAll("-", "") + ext;
                long fileSize = therapistFile.getSize();


                newDataFile.setFileOriginName(fileOriginName);
                newDataFile.setFileChangedName(fileChangedName);
                newDataFile.setFileSize(fileSize);
                newDataFile.setFilePath(FILE_DIR); // Set the appropriate file directory
                newDataFile.setUserId(user.getUserId());

                userMapper.uploadDataFile(newDataFile);
            }
        }
    }


}
