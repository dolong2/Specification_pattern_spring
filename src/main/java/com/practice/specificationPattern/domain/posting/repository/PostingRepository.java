package com.practice.specificationPattern.domain.posting.repository;

import com.practice.specificationPattern.domain.posting.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostingRepository extends JpaRepository<Posting, Long> {
}
