package com.metavirtual.bloom.configuration;

import com.metavirtual.bloom.application.controller.AuthFailHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private final AuthFailHandler authFailHandler;



    public SecurityConfiguration(AuthFailHandler authFailHandler) {
        this.authFailHandler = authFailHandler;

    }

    /* 비밀번호 암호화에 사용할 객체 BCryptPasswordEncoder bean 등록 */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /* 시큐리티 설정을 무시할 정적 리소스 등록 (resources 안의 static 폴더 내부의 정적 리소스 유형 무시) */
/*    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring().antMatchers("/css/**", "/images/**", "/js/**", "/lib/**");
    }*/


    /* HTTP 요청에 대한 권한 설정 */
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
         http.csrf().disable();

         http.authorizeRequests()
                 .mvcMatchers("/**", "/mail", "/introduction/**", "/terms/**", "/user/category", "/user/registCategory"
                         ,"user/memberRegist","user/findId","user/findPassword","/user/login", "/user/loginfail"
                         ,"user/therapistRegist","user/therapistRegist2", "psychological/match/introduceTherapy"
                         , "psychological/match/therapyList", "/"
                         ,"/user/loginfail", "/user/idDupCheck")
                 .permitAll()
                .antMatchers("/psychological/psychometry/**")
                .hasAnyAuthority("MEMBER")// .denyAll(), rememberMe(), hasIpAddress()
                .antMatchers("/psychological/match/therapyRecommend")
                .hasAnyAuthority("MEMBER")
                .antMatchers("/mypage/adminPage/**")
                .hasAnyAuthority("ADMIN")
                .antMatchers("/mypage/memberPage/**")
                .hasAnyAuthority("MEMBER")
                .antMatchers("/mypage/therapistPage/**")
                .hasAnyAuthority("THERAPIST")
                .antMatchers("/booking/**")
                .hasAnyAuthority("MEMBER")
                .antMatchers("user/memberRegistSuccess").hasAnyAuthority("MEMBER")
                .antMatchers("user/therapistRegistSuccess").hasAnyAuthority("THERAPIST")
                .anyRequest().permitAll()
                 .and()
                .formLogin()
                .loginPage("/user/login")
                .failureHandler(authFailHandler)
                .usernameParameter("username")
                .passwordParameter("password")
                 /*.and()
                 .rememberMe() // 사용자 계정 저장
                 .rememberMeParameter("remember") // default 파라미터는 remember-me
                 .tokenValiditySeconds(604800) // 7일(default 14일)
                 .alwaysRemember(false) // remember-me 기능 항상 실행
                 .userDetailsService(rememberMeService) // 사용자 계정 조회*/
                .and()
                .logout()
                 .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/index")
                .permitAll();
         return http.build();
    }


}        /*        .mvcMatchers("/**","/","/mail", "/introduction/**", "/terms/**", "/user/category", "user/registCategory"
                        ,"user/memberRegist","user/findId","user/findPassword","user/login", "/user/loginfail"
                        ,"user/therapistRegist","user/therapistRegist2", "psychological/match/introduceTherapy"
                        , "psychological/match/therapyList"
                        ,"/user/loginfail", "/user/idDupCheck"
                )*/