package com.metavirtual.bloom.configuration;

import com.metavirtual.bloom.user.model.dto.UserImpl;
import com.metavirtual.bloom.user.model.service.UserService;
import com.metavirtual.bloom.user.model.service.UserServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {


    UserServiceImpl userService;

    @GetMapping("/index")
    public void gomain() {
    }

    @GetMapping("/")
    public String defaultLocation() {

        return "index";
    }
/*
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.isAuthenticated()) {

            String userId = ((UserImpl) authentication.getPrincipal()).getUserId();

            char BookingReservation = userService.bookingStatus(userId);


        }



        String userId = principal.getName();

        return "index";*/





    @GetMapping("review")
    public String review() {
        return "reviewboard/reviewmain";
    }
}
