package com.chaehyeon.blog_project.controller.api;

import com.chaehyeon.blog_project.dto.ResponseDto;
import com.chaehyeon.blog_project.model.RoleType;
import com.chaehyeon.blog_project.model.User;
import com.chaehyeon.blog_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;


    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user) { // username, password, email
        System.out.println("UserApiController: save호출됨");
        // 실제로 DB에 insert하고 아래에서 return 이 되면 됨.
        user.setRole(RoleType.USER);
        userService.회원가입(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    //    전통적인 로그인방법
    @PostMapping("/api/user/login")
    public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) {
        System.out.println("UserApiController: login호출됨");
        User principal = userService.로그인(user); // principal (접근주체)
        if (principal != null) {
            session.setAttribute("principal", principal);
        }
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }


//    //    스프링 시큐리티 로그인방법
//    @PostMapping("/api/login")
//    public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) {
//        System.out.println("UserApiController: login호출됨");
//        User principal = userService.로그인(user); // principal (접근주체)
//        if (principal != null) {
//            session.setAttribute("principal", principal);
//        }
//        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//    }
}
