package com.hwan.board.service;

import com.hwan.board.domain.Post;
import com.hwan.board.domain.Role;
import com.hwan.board.domain.User;
import com.hwan.board.dto.PostDto;
import com.hwan.board.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PostServiceTest {

    @Autowired
    PostService postService;

    @Autowired
    UserRepository userRepository;

    @Transactional
    @Test
    public void 게시글_저장 () {
        //given
        User user = User.builder()
                .username("test")
                .email("test@test")
                .password("1234")
                .nickname("testNickname")
                .role(Role.USER)
                .build();

        userRepository.save(user);

        PostDto postDto = new PostDto();
        postDto.setTitle("testTile");
        postDto.setContent("testContent");

        //when
        postService.save(user,postDto);

        //then
        List<Post> posts = postService.findAll();
        int lastIndex = posts.size() - 1;
        Post savedPost = posts.get(lastIndex);

        assertThat(savedPost.getTitle()).isEqualTo(postDto.getTitle());
        assertThat(savedPost.getPostContent()).isEqualTo(postDto.getContent());
        assertThat(savedPost.getUser()).isEqualTo(user);

        //처음 게시글 저장 시 조회수는 0으로 자동 초기화
        assertThat(savedPost.getViewCount()).isEqualTo(0);
    }
}