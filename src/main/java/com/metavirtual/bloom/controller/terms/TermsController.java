package com.metavirtual.bloom.controller.terms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/terms")
public class TermsController {
    @GetMapping("/termsOfService")
    public String termsOfServicePage(){ return "terms/termsOfService"; }
    @GetMapping("/policy")
    public String policyPage(){ return "terms/policy"; }
}
