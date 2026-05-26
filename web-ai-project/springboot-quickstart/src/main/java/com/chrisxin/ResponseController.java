package com.chrisxin;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {
    /*
     *方式一：基于HttpServletResponse 设置响应数据
     */
    @RequestMapping("/Response1")
    public void Response1(HttpServletResponse response) throws IOException {
        //1.设置响应状态码
        response.setStatus(401);
        //2.设置响应头
        response.setHeader("name", "ChrisXin");
        //3.设置响应体
        response.getWriter().write("<h1>hello response<h1>");
    }

    /*
     *方式二：基于ResponseEntity 设置响应数据
     */
    @RequestMapping("Response2")
    public ResponseEntity<String> Response2(){
        return ResponseEntity.status(401).header("name","ChrisXin").body("<h1>hello response<h1>");
    }
}
