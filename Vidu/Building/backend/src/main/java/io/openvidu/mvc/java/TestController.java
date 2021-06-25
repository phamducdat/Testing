package io.openvidu.mvc.java;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/")
    @ResponseBody
    public String getString(){
        System.out.println("Get in");
//        OutPut outPut = new OutPut("Hello");
        return "Hello";
    }

    @GetMapping("/check")
    public ResponseEntity logout(HttpSession httpSession) {
        return ResponseEntity.ok(httpSession.getAttribute("loggedUser"));
    }

    @GetMapping("/test2")
    @ResponseBody
    public String getString2(){
        System.out.println("Get in 2");
//        OutPut outPut = new OutPut("Hello");
        return "Hello2";
    }
}
