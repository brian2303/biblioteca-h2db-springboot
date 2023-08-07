package com.ceiba.biblioteca.prestamo.domain.usecase;

import com.ceiba.biblioteca.prestamo.domain.model.BookLoan;
import com.ceiba.biblioteca.prestamo.domain.model.gateway.BookLoanRepository;

public class BookLoanUseCase {

    BookLoanRepository bookLoanRepository;

    public BookLoanUseCase(BookLoanRepository bookLoanRepository) {
        this.bookLoanRepository = bookLoanRepository;
    }

    public BookLoan addBookLoan(BookLoan bookLoan){
        return bookLoanRepository.addLoan(bookLoan);
    }
}
