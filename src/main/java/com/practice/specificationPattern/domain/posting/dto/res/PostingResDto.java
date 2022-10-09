package com.practice.specificationPattern.domain.posting.dto.res;

import com.practice.specificationPattern.domain.posting.Posting;
import lombok.Builder;

@Builder
public class PostingResDto {
    private String title;
    private String content;
    private String member;

    public PostingResDto(Posting posting){
        title = posting.getTitle();
        content = posting.getMember();
        member = posting.getMember();
    }
}
