package com.example.SupplyChain.SpringBoot_Project1.controller;

import javax.naming.NameNotFoundException;

import com.example.SupplyChain.SpringBoot_Project1.service.impl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.NoHandlerFoundException;


import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/{username}/{pwd}")
    String login(@PathVariable String username, @PathVariable String pwd ){
        return loginService.generateToken(username);
    }

    @GetMapping("/validate/{username}")
    public String validate(@PathVariable String username,HttpServletRequest request) {
        return loginService.validateToken(username,request);
    }

    @ExceptionHandler(value=RuntimeException.class)
    public ResponseEntity<?> runTimeException(){
        return new ResponseEntity<>("Bad Request",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value=IllegalArgumentException.class)
    public ResponseEntity<?> illegalArgumentException(){
        return new ResponseEntity<>("Illegal Argument",HttpStatus.BAD_REQUEST);
    }
}