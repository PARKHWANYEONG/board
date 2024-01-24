package com.hwan.board.dto;

import com.hwan.board.domain.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PostDto {

    private String writer;

    private String title;

    private String content;

    private int viewCount;

    public PostDto(Post post) {
        this.writer = post.getUser().getNickname();
        this.title = post.getTitle();
        this.content = post.getPostContent();
        this.viewCount = post.getViewCount();
    }
}
