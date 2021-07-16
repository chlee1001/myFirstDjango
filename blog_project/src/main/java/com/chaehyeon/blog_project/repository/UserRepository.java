package com.chaehyeon.blog_project.repository;

import com.chaehyeon.blog_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// 자동으로 bean등록이 된다. --> @Repository 생략가능
public interface UserRepository extends JpaRepository<User, Integer> {

}
