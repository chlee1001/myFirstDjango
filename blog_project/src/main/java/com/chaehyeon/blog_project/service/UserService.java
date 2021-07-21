package com.chaehyeon.blog_project.service;

import com.chaehyeon.blog_project.model.User;
import com.chaehyeon.blog_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해준다.
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void 회원가입(User user) {
        userRepository.save(user);
    }
}

// 서비스를 만든 이유
// 트랜잭션 관리하기 위해
// 서비스의 의미 때문에