package com.ceiba.biblioteca.prestamo.domain.model.gateway;

import com.ceiba.biblioteca.prestamo.domain.model.BookLoan;

import java.time.LocalDate;

public interface BookLoanRepository {
    BookLoan addLoan(BookLoan bookLoan);

    BookLoan findByUserIdentification(String userIdentification);

    BookLoan findById(Long id);
}
