package com.chaehyeon.blog_project.test;

import com.chaehyeon.blog_project.model.RoleType;
import com.chaehyeon.blog_project.model.User;
import com.chaehyeon.blog_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

// html파일이 아니라 data를 리턴해주는 controller
@RestController
public class DummyControllerTest {

    @Autowired // 의존성주입(DI)
    private UserRepository userRepository;

    // email, password
    @Transactional // 함수 종료 시 자동 commit됨
    @PutMapping("/dummy/user/{id}")
    public User upadteUser(@PathVariable int id, @RequestBody User requestUser) { // Json 데이터를 요청 => Java Object(MessageConverter의 Jackson라이브러리로) 변환해서 받음

        User user = userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("수정에 실패하였습니다.");
        });
        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());

        return null;
    }


    // http://localhost:8000/blog/dummy/users
    @GetMapping("/dummy/users")
    public List<User> list() {
        return userRepository.findAll();
    }

    // 한 페이지당 2건에 데이터를 리턴받아 볼 예정
    // http://localhost:8000/blog/dummy/user
    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<User> pagingUser = userRepository.findAll(pageable);
        List<User> users = pagingUser.getContent();
        return users;
    }


    // {id} 주소로 파라미터를 전달 받을 수 있음.
    // http://localhost:8000/blog/dummy/user/3
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id) {
        // user/4를 찾을때 내가 데이터베이스에서 못찾게 되면 user가 null이 됨
        // 그럼 return null이 리턴되는데.. 그럼 프로그램에 문제가 된다.
        // 그래서 findById의 반환값은 Optional로 User객체를 감싸서 반환해준다.
        // null인지 아닌지 판단해서 사용해라

        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 없습니다. id: " + id);
            }
        });
        // 요청: 웹브라우저
        // user 객체 = 자바 오브젝트
        // 변환 (웹브라우저가 이해할 수 있는 데이터) --> json
        // 스프링부트 = MessageConverter라는 얘가 응답시에 자동작동
        // 만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson라이브러리를 호출해서
        // user오브젝트를 json으로 변환해서 브라우저에게 던져준다.
        return user;
    }

    // http://localhost:8000/blog/dummy/join (요청)
    // http의 body에 username, password, email 데이터를 가지고 (요청)
    @PostMapping("/dummy/join")
//    public String join(String username, String password, String email) { // key=value (규칙)
//        System.out.println("username:" + username);
//        System.out.println("password: " + password);
//        System.out.println("email: " + email);
//        return "회원가입이 완료되었습니다.";
//    }

    public String join(User user) {
        System.out.println("id:" + user.getId());
        System.out.println("username:" + user.getUsername());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());
        System.out.println("role: " + user.getRole());
        System.out.println("createDate: " + user.getCreateDate());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}
