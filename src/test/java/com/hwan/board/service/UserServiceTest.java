package com.hwan.board.service;

import com.hwan.board.domain.User;
import com.hwan.board.dto.UserDto;
import com.hwan.board.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Transactional
    @Test
    public void 회원가입() {
        //given
        String rawPassword = "1234";
        UserDto userDto = new UserDto("userA", rawPassword,"test@test","hello");

        //when
        userService.join(userDto);

        //then
        User savedUser = userRepository.findByUsername("userA").orElse(null);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getUsername()).isEqualTo("userA");
        assertThat(savedUser.getEmail()).isEqualTo("test@test");
        assertThat(savedUser.getNickname()).isEqualTo("hello");
        assertThat(savedUser.getRoleValue()).isEqualTo("ROLE_USER");

        // BCryptPasswordEncoder로 암호화 되었는지 검증
        boolean isPasswordMatch = encoder.matches(rawPassword, savedUser.getPassword());

        assertThat(isPasswordMatch).isTrue();
    }
}