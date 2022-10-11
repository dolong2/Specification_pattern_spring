package com.practice.specificationPattern.domain.posting.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostingUpdateReqDto {
    private String title;
    private String content;
}
