package com.hwan.board.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false, length = 30, unique = true)
    private String nickname;

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();
}
