package com.chaehyeon.blog_project.test;

import org.springframework.web.bind.annotation.*;

// 사용자가 요청 --> 응답(HTML파일)
// @Controller

// 사용자가 요청 --> 응답(Data)
@RestController
public class HttpControllerTest {

    private static final String TAG = "HttpControllerTest:";

    @GetMapping("http/lombok")
    public String lombokTest() {
        Member m = Member.builder().username("chae").password("1234").email("test@naver.com").build();
        System.out.println(TAG + "getter: " + m.getUsername());
        m.setUsername("cos");
        System.out.println(TAG + "setter: " + m.getUsername());
        return "loombok test 완료";
    }


    // 인터넷 브라우저 요청은 무조건 get요청밖에 할 수 없다
    // http://localhost:8080/http/get (select)
    @GetMapping("/http/get")
    public String getTest(Member m) {
        return "get 요청: " + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail();
    }

    // http://localhost:8080/http/post (insert)
    @PostMapping("/http/post") // text/plain, application/json
    public String postTest(@RequestBody Member m) { // MessageConverter(스프링부트)
        return "post 요청: " + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail();
    }

    // http://localhost:8080/http/put (update)
    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m) {
        return "put 요청" + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail();
    }

    // http://localhost:8080/http/delete (delete)
    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }
}
