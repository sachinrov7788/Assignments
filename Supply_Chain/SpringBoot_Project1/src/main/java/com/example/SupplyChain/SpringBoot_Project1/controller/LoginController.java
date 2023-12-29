package com.example.SupplyChain.SpringBoot_Project1.controller;

import com.example.SupplyChain.SpringBoot_Project1.service.impl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService service;

    @PostMapping("/{username}/{pwd}")
    String login(@PathVariable String username, @PathVariable String pwd ){
        return service.generateToken(username,pwd);
    }

    @GetMapping("/verify/{name}")
    public String getMethodName(HttpServletRequest request, @PathVariable String name) {
        return service.validateToken(request.getHeader("Authorization").split(" ",2)[1],name);
    }

}
