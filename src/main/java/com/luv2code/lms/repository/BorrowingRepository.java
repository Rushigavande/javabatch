package com.luv2code.lms.repository;


import com.luv2code.lms.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
    Optional<Borrowing> findByMemberIdAndBookId(Long memberId, Long bookId);
}
