package com.practice.specificationPattern.domain.posting.controller;

import com.practice.specificationPattern.domain.posting.dto.req.PostingReqDto;
import com.practice.specificationPattern.domain.posting.dto.req.PostingUpdateReqDto;
import com.practice.specificationPattern.domain.posting.dto.res.PostingListResDto;
import com.practice.specificationPattern.domain.posting.dto.res.PostingResDto;
import com.practice.specificationPattern.domain.posting.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posting")
@RequiredArgsConstructor
public class PostingController {
    private final PostingService postingService;

    @PostMapping
    public ResponseEntity<Void> writePosting(@RequestBody PostingReqDto postingReqDto){
        postingService.write(postingReqDto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostingResDto> getOnePosting(@PathVariable Long id){
        return ResponseEntity.ok(postingService.getOnePosting(id));
    }

    @GetMapping
    public ResponseEntity<PostingListResDto> getAllPosting(){
        return ResponseEntity.ok(postingService.getAllPosting());
    }

    @GetMapping("/my")
    public ResponseEntity<PostingListResDto> getMyAllPosting(@RequestHeader String member){
        return ResponseEntity.ok(postingService.getAllMyPosting(member));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePosting(@PathVariable Long id, @RequestBody PostingUpdateReqDto updateReqDto, @RequestHeader String member){
        postingService.updatePosting(id, updateReqDto, member);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePosting(@PathVariable Long id, @RequestHeader String member){
        postingService.deletePosting(id, member);
        return ResponseEntity.noContent().build();
    }

}
