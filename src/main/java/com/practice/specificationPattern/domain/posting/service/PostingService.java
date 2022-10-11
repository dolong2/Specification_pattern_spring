package com.practice.specificationPattern.domain.posting.service;

import com.practice.specificationPattern.domain.posting.Posting;
import com.practice.specificationPattern.domain.posting.dto.req.PostingReqDto;
import com.practice.specificationPattern.domain.posting.dto.req.PostingUpdateReqDto;
import com.practice.specificationPattern.domain.posting.dto.res.PostingListResDto;
import com.practice.specificationPattern.domain.posting.dto.res.PostingResDto;
import com.practice.specificationPattern.domain.posting.repository.PostingRepository;
import com.practice.specificationPattern.global.spec.Specification;
import com.practice.specificationPattern.global.spec.custom.PostingMemberSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostingService {
    private final PostingRepository postingRepository;

    @Transactional
    public void write(PostingReqDto postingReqDto){
        Posting posting = postingReqDto.toEntity();
        postingRepository.save(posting);
    }

    @Transactional(readOnly = true)
    public PostingResDto getOnePosting(Long positingId){
        Posting posting = postingRepository.findById(positingId).orElseThrow(() -> new RuntimeException());
        return PostingResDto.builder()
                .title(posting.getTitle())
                .content(posting.getContent())
                .member(posting.getMember())
                .build();
    }

    @Transactional(readOnly = true)
    public PostingListResDto getAllPosting(){
        List<Posting> all = postingRepository.findAll();
        List<PostingResDto> list = new ArrayList<>();
        all.forEach(it -> {
            list.add(
                    PostingResDto.builder()
                            .title(it.getTitle())
                            .content(it.getContent())
                            .member(it.getMember())
                            .build()
            );
        });
        return PostingListResDto.builder()
                .list(list)
                .build();
    }

    @Transactional(readOnly = true)
    public PostingListResDto getAllMyPosting(String member){
        List<Posting> all = postingRepository.findAll();
        Specification specification = new PostingMemberSpecification(member);
        List<PostingResDto> list = all.stream().filter(it -> specification.isSatisfiedBy(it)).map(PostingResDto::new).collect(Collectors.toList());
        PostingListResDto result = new PostingListResDto(list);
        return result;
    }

    @Transactional
    public void updatePosting(Long postingId, PostingUpdateReqDto postingUpdateReqDto, String member){
        Posting posting = postingRepository.findById(postingId)
                .orElseThrow(() -> new RuntimeException());
        Specification specification = new PostingMemberSpecification(member);
        if(!specification.isSatisfiedBy(posting))
            throw new RuntimeException();
        posting.update(postingUpdateReqDto);
    }

    @Transactional
    public void deletePosting(Long postingId, String member){
        Posting posting = postingRepository.findById(postingId)
                .orElseThrow(() -> new RuntimeException());
        Specification specification = new PostingMemberSpecification(member);
        if(!specification.isSatisfiedBy(posting))
            throw new RuntimeException();
        postingRepository.delete(posting);
    }
}
