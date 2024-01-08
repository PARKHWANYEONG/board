package com.hwan.board.service;

import com.hwan.board.domain.Role;
import com.hwan.board.domain.User;
import com.hwan.board.dto.UserDto;
import com.hwan.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;

    public void join(UserDto userDto) {
        String encodedPassword = encoder.encode(userDto.getPassword());

        User user = User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(encodedPassword)
                .nickname(userDto.getNickname())
                .role(Role.USER)
                .build();

        userRepository.save(user);
    }
}
