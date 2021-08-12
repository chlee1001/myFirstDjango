package com.chaehyeon.blog_project.config.auth;

import com.chaehyeon.blog_project.model.User;
import com.chaehyeon.blog_project.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailService implements UserDetailsService {

    final UserRepository userRepository;

    public PrincipalDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 스프링이 로그인 요청을 가로챌 때, username, password  변수 2개를 가로채는데
    // password부분 처리는 알아서 함.
    // username이 DB에 있는지만 확인해주면 됨.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal = userRepository.findUsersByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다.: " + username));
        return new PrincipalDetail(principal); // 시큐리티의 세션에 유저정보가 저장됨.
    }
}
