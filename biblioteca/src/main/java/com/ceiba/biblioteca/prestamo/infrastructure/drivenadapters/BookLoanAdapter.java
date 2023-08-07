package com.ceiba.biblioteca.prestamo.infrastructure.drivenadapters;

import com.ceiba.biblioteca.prestamo.domain.model.BookLoan;
import com.ceiba.biblioteca.prestamo.domain.model.gateway.BookLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.ceiba.biblioteca.prestamo.application.utils.MapModelUtils.mapToEntityFromModel;
import static com.ceiba.biblioteca.prestamo.application.utils.MapModelUtils.mapToModelFromEntity;

@Service
public class BookLoanAdapter implements BookLoanRepository {

    @Autowired
    BookLoanRepositoryImpl bookLoanRepository;

    @Override
    public BookLoan addLoan(BookLoan bookLoan) {
        return mapToModelFromEntity(
                bookLoanRepository.save(mapToEntityFromModel(bookLoan))
        );
    }
}
