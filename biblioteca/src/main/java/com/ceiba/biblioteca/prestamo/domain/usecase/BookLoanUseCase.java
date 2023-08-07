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

    BookLoanRepository bookLoanRepository;

    public BookLoanUseCase(BookLoanRepository bookLoanRepository) {
        this.bookLoanRepository = bookLoanRepository;
    }

    public BookLoan addBookLoan(BookLoan bookLoan){

        if (bookLoan.getUserType() != GUEST_USER && bookLoan.getUserType() != AFFILIATE_USER && bookLoan.getUserType() != EMPLOYEE_USER){
            throw new RuntimeException("Tipo de usuario no permitido en la biblioteca");
        }

        BookLoan bookLoanFound = bookLoanRepository.findByUserIdentification(bookLoan.getUserIdentification());

        if (bookLoanFound.getId() != null && bookLoanFound.getUserType() == GUEST_USER){
            throw new RuntimeException(
                    String.format("El usuario con identificación %s ya tiene un libro prestado por lo cual" +
                            " no se le puede realizar otro préstamo",bookLoanFound.getUserIdentification())
            );
        }

        if (bookLoan.getUserType() == AFFILIATE_USER){
            LocalDate maximumDate = addDaysSkippingWeekends(LocalDate.now(),10);
            String dateFormat = maximumDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            bookLoan.setMaximumReturnDate(dateFormat);
            return bookLoanRepository.addLoan(bookLoan);
        }

        if (bookLoan.getUserType() == EMPLOYEE_USER){
            LocalDate maximumDate = addDaysSkippingWeekends(LocalDate.now(),8);
            String dateFormat = maximumDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            bookLoan.setMaximumReturnDate(dateFormat);
            return bookLoanRepository.addLoan(bookLoan);
        }

        if (bookLoan.getUserType() == GUEST_USER){
            LocalDate maximumDate = addDaysSkippingWeekends(LocalDate.now(),7);
            String dateFormat = maximumDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            bookLoan.setMaximumReturnDate(dateFormat);
            return bookLoanRepository.addLoan(bookLoan);
        }
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
