package com.example.impl;

import com.example.common.Response;
import com.example.common.ResponseCode;
import com.example.exception.ServiceException;
import com.example.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Component
public class TokenServiceImpl implements TokenService {

    @Autowired
    RedisTemplate redisTemplate;


    @Override
    public Response createToken() {
        String token = UUID.randomUUID().toString().replace("-", "");
        redisTemplate.opsForValue().set(token, token);
        Response response = new Response(0, token, null);
        return response;

    }

    @Override
    public Response checkToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter("token");
            if (StringUtils.isEmpty(token)) {
                throw new ServiceException(ResponseCode.ILLEGAL_ARGUMENT.getCode().toString(),
                        ResponseCode.ILLEGAL_ARGUMENT.getMsg());
            }
        }
        if (!redisTemplate.hasKey(token)) {
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getCode().toString(), ResponseCode.REPETITIVE_OPERATION.getMsg());

        }
        Boolean a = redisTemplate.delete(token);
        if (!a) {
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getCode().toString(), ResponseCode.REPETITIVE_OPERATION.getMsg());
        }
        return new Response(0, "校验成功", null);
    }
}
