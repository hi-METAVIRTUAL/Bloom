package com.metavirtual.bloom.configuration;

import com.metavirtual.bloom.user.model.service.UserService;
import com.metavirtual.bloom.user.model.service.UserServiceImpl;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {


    UserServiceImpl userService;
    Principal principal;
    @GetMapping("/index")
    public void gomain() {
    }

    @GetMapping("/")
    public String defaultLocation() {


        return "index";
    }


    @GetMapping("review")
    public String review() {
        return "reviewboard/reviewmain";
    }
}
