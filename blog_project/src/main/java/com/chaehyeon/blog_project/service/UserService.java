package com.chaehyeon.blog_project.service;

import com.chaehyeon.blog_project.model.User;
import com.chaehyeon.blog_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해준다.
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void 회원가입(User user) {
        userRepository.save(user);
    }

    @Transactional(readOnly = true) // Select할 때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료 (정합성 유지)
    public User 로그인(User user) {
        return userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}

// 서비스를 만든 이유
// 트랜잭션 관리하기 위해
// 서비스의 의미 때문에