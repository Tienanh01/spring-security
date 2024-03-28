package com.example.project1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/sign-in")
    public String loginPage(){

        return "login";

    }

}
