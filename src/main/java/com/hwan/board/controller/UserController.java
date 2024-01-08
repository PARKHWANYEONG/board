package com.hwan.board.controller;

import com.hwan.board.dto.ResponseDto;
import com.hwan.board.dto.UserDto;
import com.hwan.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/auth/join")
    public String join() {
        return "user/joinForm";
    }

    @ResponseBody
    @PostMapping("/auth/join")
    public ResponseDto<Integer> joinProc(@RequestBody UserDto userDto) {
        userService.join(userDto);
        return new ResponseDto<>(HttpStatus.OK, 1);
    }

    @GetMapping("/auth/login")
    public String login() {
        return "user/loginForm";
    }
}
