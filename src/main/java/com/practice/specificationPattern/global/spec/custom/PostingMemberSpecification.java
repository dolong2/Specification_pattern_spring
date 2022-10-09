package com.practice.specificationPattern.global.spec.custom;

import com.practice.specificationPattern.domain.posting.Posting;
import com.practice.specificationPattern.global.spec.AbstractSpecification;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PostingMemberSpecification extends AbstractSpecification<Posting> {
    private String member;


    @Override
    public boolean isSatisfiedBy(Posting candidate) {
        return candidate.getMember() == member;
    }
}
