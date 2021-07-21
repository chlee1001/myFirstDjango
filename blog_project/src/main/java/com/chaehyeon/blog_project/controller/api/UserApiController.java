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
}
