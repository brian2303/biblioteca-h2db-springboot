package com.ceiba.biblioteca.prestamo.domain.model.gateway;

import com.ceiba.biblioteca.prestamo.domain.model.BookLoan;

public interface BookLoanRepository {
    public BookLoan addLoan(BookLoan bookLoan);
}
