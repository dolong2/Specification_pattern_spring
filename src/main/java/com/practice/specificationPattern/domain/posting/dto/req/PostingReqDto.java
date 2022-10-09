package com.practice.specificationPattern.domain.posting.dto.req;

import com.practice.specificationPattern.domain.posting.Posting;

public class PostingReqDto {
    private String title;
    private String content;

    private String member;

    public Posting toEntity(){
        return Posting.builder()
                .title(title)
                .content(content)
                .member(member)
                .build();
    }
}
