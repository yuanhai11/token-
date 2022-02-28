package com.example.service;

import com.example.common.Response;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface TokenService {
    public Response createToken();
    public Response checkToken(HttpServletRequest request);
}
