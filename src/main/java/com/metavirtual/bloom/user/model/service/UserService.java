package com.metavirtual.bloom.user.model.service;

import com.metavirtual.bloom.common.exception.member.UserRegistException;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.DataFileDTO;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.TherapistDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/*
package com.metavirtual.bloom.user.model.service;

import org.springframework.security.core.userdetails.UserDetailsService;

/* Spring Security가 제공하는 UserDetailServices를 상속 받아야 한다*/

public interface UserService extends UserDetailsService {


    void registUser(UserDTO user, MemberDTO member) throws UserRegistException;

    void registTherapist(UserDTO user, TherapistDTO therapist, DataFileDTO dataFile, List<MultipartFile> therapistFiles) throws UserRegistException, ModifyInfoException;


}

