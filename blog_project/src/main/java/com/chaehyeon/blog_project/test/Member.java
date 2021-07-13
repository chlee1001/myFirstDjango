package com.chaehyeon.blog_project.test;

import lombok.*;


@Data // Getter & Setter
//@AllArgsConstructor // 생성자
@NoArgsConstructor
public class Member {
    private int id; // final..불변성 유지
    private String username;
    private String password;
    private String email;

    @Builder
    public Member(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }


}
