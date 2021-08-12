package com.chaehyeon.blog_project.repository;

import com.chaehyeon.blog_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// 자동으로 bean등록이 된다. --> @Repository 생략가능
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUsersByUsername(String username);

}


//      JPA Naming 전략
//     SELECT * FROM user WHERE username = ?1 AND password = ?2;
//    User findUserByUsernameAndPassword(String username, String password);

//    @Query(value="SELECT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
//    User login(String username, String password);