package com.practice.specificationPattern.domain.posting;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor
public class Posting {
    @Id @GeneratedValue
    private Long id;

    private String title;

    private String content;

    /**
     * 일단 시큐리티하기 귀찮으니까 이렇게 할래
     */
    private String member;
}
