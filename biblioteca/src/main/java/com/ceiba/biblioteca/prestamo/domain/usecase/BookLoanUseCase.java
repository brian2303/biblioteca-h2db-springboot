package com.ceiba.biblioteca.prestamo.domain.usecase;

import com.ceiba.biblioteca.prestamo.domain.model.BookLoan;
import com.ceiba.biblioteca.prestamo.domain.model.gateway.BookLoanRepository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookLoanUseCase {

    private static final int AFFILIATE_USER = 1;
    private static final int EMPLOYEE_USER = 2;
    private static final int GUEST_USER = 3;

    private static final String USER_NOT_ALLOWED = "Tipo de usuario no permitido en la biblioteca";
    private static final String USER_BOOK_LOAN_ALREADY_EXISTS = "El usuario con identificación %s ya tiene un libro prestado" +
            " por lo cual no se le puede realizar otro préstamo";


    BookLoanRepository bookLoanRepository;

    public BookLoanUseCase(BookLoanRepository bookLoanRepository) {
        this.bookLoanRepository = bookLoanRepository;
    }

    public BookLoan addBookLoan(BookLoan bookLoan){

        BookLoan bookLoanFound = bookLoanRepository.findByUserIdentification(bookLoan.getUserIdentification());

        if (bookLoanFound.getId() != null && bookLoanFound.getUserType() == GUEST_USER){
            throw new RuntimeException(
                    String.format(USER_BOOK_LOAN_ALREADY_EXISTS,bookLoanFound.getUserIdentification())
            );
        }

        if (bookLoan.getUserType() == AFFILIATE_USER){
            return addBookLoanByUser(10,bookLoan);
        }

        if (bookLoan.getUserType() == EMPLOYEE_USER){
            return addBookLoanByUser(8,bookLoan);
        }

        if (bookLoan.getUserType() == GUEST_USER){
            return addBookLoanByUser(7,bookLoan);
        }
        throw new RuntimeException(USER_NOT_ALLOWED);
    }

    private BookLoan addBookLoanByUser(Integer days,BookLoan bookLoan){
        LocalDate maximumDate = addDaysSkippingWeekends(LocalDate.now(),days);
        String dateFormat = maximumDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        bookLoan.setMaximumReturnDate(dateFormat);
        return bookLoanRepository.addLoan(bookLoan);
    }

    public BookLoan findById(Long id){
        return bookLoanRepository.findById(id);
    }

    private static LocalDate addDaysSkippingWeekends(LocalDate date, int days) {
        LocalDate result = date;
        int addedDays = 0;
        while (addedDays < days) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        return result;
    }
}
