package com.hwan.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostsController {

    @GetMapping("/posts")
    public String write() {
        return "/posts/writeForm";
    }
}
