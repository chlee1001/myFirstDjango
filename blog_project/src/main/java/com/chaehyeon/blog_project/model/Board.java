package com.chaehyeon.blog_project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴
@Entity // Board 클래스가 MySQL에 테이블이 생성이 된다.
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob // 대용량 데이터
    private String content; // 섬머노트 라이브러리 <html>태그가 섞여서 디자인이 됨.

    @ColumnDefault("0")
    private int count; // 조회수

    @ManyToOne(fetch = FetchType.EAGER) // Many = Board, One = User ==> 한명의 유저는 여러개의 보드를 쓸 수 있다.
    @JoinColumn(name = "userId")
    private User user; // DB는 object를 저장할 수 없어서 Foreign key를 사용하지만, 자바는 오브젝트를 저장할 수 있다.

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // 하나의 게시물은 여러개의 답변을 가질 수 있다.
    // mappedBy 연관관계의 주인이 아니다. (FK가 아니다) DB에 컬럼 생성X
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;
}
