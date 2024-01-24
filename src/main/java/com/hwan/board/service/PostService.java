package com.hwan.board.service;

import com.hwan.board.domain.Post;
import com.hwan.board.domain.User;
import com.hwan.board.dto.PostDto;
import com.hwan.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class PostService {

    private final PostRepository postRepository;

    public void save(User user, PostDto postDto) {
        Post post = Post.builder()
                .title(postDto.getTitle())
                .postContent(postDto.getContent())
                .user(user)
                .build();

        postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Transactional(readOnly = true)
    public PostDto findById(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("postId를 찾을 수 없습니다."));

        return new PostDto(post);
    }
}
