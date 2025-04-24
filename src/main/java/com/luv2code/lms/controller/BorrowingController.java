package com.luv2code.lms.controller;

import com.luv2code.lms.dto.BorrowingRequest;
import com.luv2code.lms.model.Borrowing;
import com.luv2code.lms.service.BorrowingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrowings")
public class BorrowingController {

    private final BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @PostMapping("/borrow")
    public ResponseEntity<Borrowing> borrowBook(@RequestBody BorrowingRequest request) {
        Borrowing borrowing = borrowingService.borrowBook(request.getMemberId(), request.getBookId());
        return ResponseEntity.ok(borrowing);
    }

    @PostMapping("/return")
    public ResponseEntity<Borrowing> returnBook(@RequestBody BorrowingRequest request) {
        Borrowing borrowing = borrowingService.returnBook(request.getMemberId(), request.getBookId());
        return ResponseEntity.ok(borrowing);
    }

    @GetMapping
    public List<Borrowing> getAllBorrowings() {
        return borrowingService.getAllBorrowings();
    }
}
