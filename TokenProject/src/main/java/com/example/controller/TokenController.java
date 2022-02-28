package com.example.controller;

import com.example.common.Response;
import com.example.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @GetMapping
    public Response token(){
        return tokenService.createToken();

    }

    @PostMapping("/checktoken")
    public Response checktoken(HttpServletRequest request){
        return tokenService.checkToken(request);
    }
}
