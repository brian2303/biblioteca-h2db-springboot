package com.ceiba.biblioteca.prestamo.application.utils;

import com.ceiba.biblioteca.prestamo.domain.model.BookLoan;
import com.ceiba.biblioteca.prestamo.infrastructure.drivenadapters.entities.BookLoanEntity;
import com.ceiba.biblioteca.prestamo.infrastructure.entrypoints.dto.BookLoanDTO;

public class MapModelUtils {
    public static BookLoan mapToBookLoan(BookLoanDTO bookLoanDTO){
        BookLoan bookLoan = new BookLoan();
        bookLoan.setIsbn(bookLoanDTO.getIsbn());
        bookLoan.setUserType(bookLoanDTO.getTipoUsuario());
        bookLoan.setUserIdentification(bookLoanDTO.getIdentificacionUsuario());
        return bookLoan;
    }

    public static BookLoanDTO mapToBookLoanDTO(BookLoan bookLoan){
        BookLoanDTO bookLoanDTO = new BookLoanDTO();
        bookLoanDTO.setId(bookLoan.getId());
        bookLoanDTO.setFechaMaximaDevolucion(bookLoan.getMaximumReturnDate());
        bookLoanDTO.setIsbn(bookLoan.getIsbn());
        bookLoanDTO.setTipoUsuario(bookLoan.getUserType());
        bookLoanDTO.setIdentificacionUsuario(bookLoan.getUserIdentification());
        return bookLoanDTO;
    }

    public static BookLoanEntity mapToEntityFromModel(BookLoan bookLoan){
        BookLoanEntity bookLoanEntity = new BookLoanEntity();
        bookLoanEntity.setIsbn(bookLoan.getIsbn());
        bookLoanEntity.setUserIdentification(bookLoan.getUserIdentification());
        bookLoanEntity.setUserType(bookLoan.getUserType());
        bookLoanEntity.setMaximumReturnDate(bookLoan.getMaximumReturnDate());
        return bookLoanEntity;
    }

    public static BookLoan mapToModelFromEntity(BookLoanEntity bookLoanEntity){
        BookLoan bookLoan = new BookLoan();
        if (bookLoanEntity != null){
            bookLoan.setId(bookLoanEntity.getId());
            bookLoan.setUserIdentification(bookLoanEntity.getUserIdentification());
            bookLoan.setUserType(bookLoanEntity.getUserType());
            bookLoan.setUserIdentification(bookLoanEntity.getUserIdentification());
            bookLoan.setIsbn(bookLoanEntity.getIsbn());
            bookLoan.setMaximumReturnDate(bookLoanEntity.getMaximumReturnDate());
        }
        return bookLoan;
    }
}
