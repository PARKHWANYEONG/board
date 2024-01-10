package com.hwan.board.controller;

import com.hwan.board.config.auth.PrincipalDetails;
import com.hwan.board.domain.User;
import com.hwan.board.dto.PostDto;
import com.hwan.board.dto.ResponseDto;
import com.hwan.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;

    @GetMapping("/post")
    public String write() {
        return "/post/writeForm";
    }

    @ResponseBody
    @PostMapping("/post")
    public ResponseDto<Integer> save(@RequestBody PostDto postDto , @AuthenticationPrincipal PrincipalDetails principal) {
        postService.save(principal.getUser(),postDto);
        return new ResponseDto<>(HttpStatus.OK, 1);
    }
}
