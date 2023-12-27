package com.hwan.board.domain;

import jakarta.persistence.*;

@Entity
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(length = 300, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String postContent;

    @Column(columnDefinition = "integer default 0")
    private int viewCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
