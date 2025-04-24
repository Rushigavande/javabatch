package com.luv2code.lms.service;

import com.luv2code.lms.model.Book;
import com.luv2code.lms.model.Borrowing;
import com.luv2code.lms.model.Member;
import com.luv2code.lms.repository.BookRepository;
import com.luv2code.lms.repository.BorrowingRepository;
import com.luv2code.lms.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowingService {

    private final BorrowingRepository borrowingRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    public BorrowingService(BorrowingRepository borrowingRepository, MemberRepository memberRepository, BookRepository bookRepository) {
        this.borrowingRepository = borrowingRepository;
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
    }

    public Borrowing borrowBook(Long memberId, Long bookId) {
        Optional<Member> member = memberRepository.findById(memberId);
        Optional<Book> book = bookRepository.findById(bookId);

        if (member.isPresent() && book.isPresent() && book.get().getAvailableCopies() > 0) {
            Book updatedBook = book.get();
            updatedBook.setAvailableCopies(updatedBook.getAvailableCopies() - 1);
            bookRepository.save(updatedBook);

            Borrowing borrowing = new Borrowing();
            borrowing.setMember(member.get());
            borrowing.setBook(book.get());
            return borrowingRepository.save(borrowing);
        }

        throw new RuntimeException("Either member or book not found, or no available copies");
    }

    public Borrowing returnBook(Long memberId, Long bookId) {
        Optional<Borrowing> borrowing = borrowingRepository.findByMemberIdAndBookId(memberId, bookId);
        if (borrowing.isPresent()) {
            Borrowing returnBorrowing = borrowing.get();
            Book book = returnBorrowing.getBook();
            book.setAvailableCopies(book.getAvailableCopies() + 1);
            bookRepository.save(book);

            borrowingRepository.delete(returnBorrowing);
            return returnBorrowing;
        }

        throw new RuntimeException("No borrowing record found for the member and book");
    }

    public List<Borrowing> getAllBorrowings() {
        return borrowingRepository.findAll();
    }
}
