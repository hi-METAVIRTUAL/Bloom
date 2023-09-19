package com.metavirtual.bloom.configuration;

import com.metavirtual.bloom.application.controller.AuthFailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
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



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()

                .mvcMatchers("/**", "/introduction/**", "/terms/**", "/user/category", "user/registCategory"
                        ,"user/memberRegist","user/findId","user/findPassword","user/login"
                        ,"user/therapistRegist","user/therapistRegist2", "psychological/match/introduceTherapy"
                        , "psychological/match/therapyList"
                        ,"/user/loginfail", "/user/idDupCheck"
                )
                .permitAll(); // .denyAll(), rememberMe(), hasIpAddress()
                /*.antMatchers("/employee/list")
                .hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/employee/file")
                .hasAnyAuthority("ADMIN")
                .anyRequest().authenticated(); // .anonymous()*/
//               .and()
//               .csrf().disable();


/*   http.formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/")
                .failureHandler(authFailHandler)
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/")
                .and()
                .sessionManagement()
                .maximumSessions(1)
                .expiredUrl("/")
                .maxSessionsPreventsLogin(true); // false: 이전 사용자의 강제 로그아웃 / true: 신규 사용자의 로그인 실패*/
        return http.build();
    }
}

