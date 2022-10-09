package com.practice.specificationPattern.domain.posting.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@Builder
@AllArgsConstructor
public class PostingListResDto {
    List<PostingResDto> list;
}
