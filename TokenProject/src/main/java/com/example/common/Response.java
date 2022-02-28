package com.example.common;

import lombok.Data;

@Data
public class Response {
    private int status;
    private String msg;
    private Object data;

    public Response(Integer code, String msg, Object o) {
        this.status = code;
        this.msg = msg;
        this.data = o;
    }
}
