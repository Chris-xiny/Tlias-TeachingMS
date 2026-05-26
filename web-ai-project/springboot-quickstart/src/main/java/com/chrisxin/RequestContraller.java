package com.chrisxin;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestContraller {
    @RequestMapping("/Request")
    public String request(HttpServletRequest request){
        //1.获取请求方式
        String method = request.getMethod();
        System.out.println("RequestMethod="+method);
        //2.请求URL地址
        String requestURL = request.getRequestURL().toString();
        String requestURI = request.getRequestURI();
        System.out.println("URL="+requestURL);
        System.out.println("URI="+requestURI);
        //3.获取请求协议
        String protocol = request.getProtocol();
        System.out.println("protocal="+protocol);
        //4.获取请求参数 - name - age
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("name="+name);
        System.out.println("age="+age);
        //5.获取请求头 - Accept
        String accept = request.getHeader("Accept");
        System.out.println("Accept="+accept);
        return "OK";
    }
}
