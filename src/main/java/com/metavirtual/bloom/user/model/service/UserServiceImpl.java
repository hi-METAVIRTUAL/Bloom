
package com.metavirtual.bloom.user.model.service;


import com.metavirtual.bloom.booking.model.dto.BookingDTO;
import com.metavirtual.bloom.common.exception.member.UserRegistException;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.DataFileDTO;
import com.metavirtual.bloom.user.model.dao.UserMapper;
import com.metavirtual.bloom.user.model.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.context.Context;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.TemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.lang.String.valueOf;
import static java.lang.System.out;
import static javax.swing.text.html.parser.DTDConstants.NUMBERS;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    HttpServletResponse response;
    private final PasswordEncoder passwordEncoder;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;
    private static final String senderEmail = "metavirtual.bloom@gmail.com";
    private static int number;


    private static final String CAPITAL_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String SYMBOLS = "!@$%&*";
    private static final String ALLOWED_CHARACTERS = CAPITAL_LETTERS + LOWERCASE_LETTERS + SYMBOLS;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, PasswordEncoder passwordEncoder, JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
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
        log.info(valueOf(user));
        /* 사용자가 입력한 아이디로 조회가 안될 경우 NPE(NullPointerException) 방지를 위해 빈 MemberDTO 객체를 생성 */
        if (user == null) {
//            throw new UsernameNotFoundException("존재하는 정보가 없습니다");
            user = new UserDTO();
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (user.getUnregistDate() != null) {
            return null;
        }
        if (user.getAuthorityCode() != 1 || user.getAuthorityCode() != 2 || user.getAuthorityCode() != 3) {

            out.println("unregistData = " + user.getUnregistDate());
            out.println("RegistData = " + user.getRegistDate());
            int authorityCode = user.getAuthorityCode();

            authorities.add(new SimpleGrantedAuthority(valueOf(authorityCode)));
        }

        UserImpl userImpl = new UserImpl(user.getUserId(), user.getPwd(), authorities);
        userImpl.setDetails(user);
        log.info(userId);
        return userImpl;
    }


    @Transactional
    public int idDupCheck(String userId) throws Exception {
        out.println(userId);
        return userMapper.idDupCheck(userId);
    }

    @Transactional
    public int nicknameDupCheck(String nickname) {
        out.println(nickname);
        return userMapper.nicknameDupCheck(nickname);

    }


    @Transactional
    public void registUser(UserDTO user, MemberDTO member) throws UserRegistException {

        out.println("[UserService] 들어옴");
        out.println("[UserService] Insert User : " + user);
        out.println("[UserService] Insert Member : " + member);

        int result1 = userMapper.insertUser(user);
        int result2 = userMapper.insertMember(member);

        out.println("[UserService] Insert result1 : " + ((result1 > 0) ? "일반 회원가입 성공" : "일반 회원가입 실패"));
        out.println("[UserService] Insert result2 : " + ((result2 > 0) ? "일반 member 회원가입 성공" : "일반 member 회원가입 실패"));


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

        out.println("[UserService] 들어옴");
        out.println("[UserService] Insert User : " + user);
        out.println("[UserService] Insert Therapist : " + therapist);
        out.println("[UserService] Insert dataFile : " + therapistFiles);


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


    public List<BookingDTO> bookingStatus(String userId) {

        log.info("userId : " + userId);


        return userMapper.bookingStatus(userId);
    }


    public int emailDupCheck(String email) {

        log.info(email);

        return userMapper.emailDupCheck(email);
    }


    public static String generateRandomString(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder randomString = new StringBuilder();

        // Ensure at least one capital letter
        randomString.append(CAPITAL_LETTERS.charAt(random.nextInt(CAPITAL_LETTERS.length())));

        // Ensure at least one symbol
        randomString.append(SYMBOLS.charAt(random.nextInt(SYMBOLS.length())));

        // Ensure at least one number
        int randomNumber = random.nextInt(NUMBERS);
        randomString.append(randomNumber);

        // Fill the rest of the string with a random selection of allowed characters
        for (int i = 3; i < length; i++) {
            randomString.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        }

        return randomString.toString();
    }

    public MimeMessage sendNewPwdToEmail(String userId, String email, String name) {
        String temporaryPwd = generateRandomString(10);
        out.println(temporaryPwd);

        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom(senderEmail);
            helper.setTo(email);
            helper.setSubject("임시 비밀번호 이메일 전송");

            // Create a context to hold variables to be replaced in the template
            Context context = new Context();
            context.setVariable("content", temporaryPwd);
            context.setVariable("name", String.valueOf(name));


            // Process the HTML template with Thymeleaf
            String htmlContent = templateEngine.process("/user/sendNewPwdToEmail", context);

            // Set the email content as HTML
            helper.setText(htmlContent, true);

            // 임시 비밀번호 변경
            out.println(temporaryPwd);

            UserDTO user = new UserDTO();
            user.setPwd(passwordEncoder.encode(temporaryPwd));
            user.setUserId(userId);
            user.setEmail(email);

            userMapper.changePwd(user);


        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return message;
    }


    public String setNewPwd(String userId, String email) {

        String name = userMapper.findUserDetails(userId, email);

        if (name != null) {
            MimeMessage message = sendNewPwdToEmail(userId, email, name);
            javaMailSender.send(message);
            return name;
        } else {
            return "이메일 또는 아이디가 존재하지 않습니다.";
        }
    }

}

