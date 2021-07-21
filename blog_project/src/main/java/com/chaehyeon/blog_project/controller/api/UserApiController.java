package com.chaehyeon.blog_project.controller.api;

import com.chaehyeon.blog_project.dto.ResponseDto;
import com.chaehyeon.blog_project.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user) {
        System.out.println("UserApiController: save호출됨");
        return new ResponseDto<Integer>(HttpStatus.OK, 1);
    }
}
