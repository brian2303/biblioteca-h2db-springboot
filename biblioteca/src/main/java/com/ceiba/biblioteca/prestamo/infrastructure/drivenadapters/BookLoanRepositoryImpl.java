package com.ceiba.biblioteca.prestamo.infrastructure.drivenadapters;

import com.ceiba.biblioteca.prestamo.infrastructure.drivenadapters.entities.BookLoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLoanRepositoryImpl extends JpaRepository<BookLoanEntity,Long> {
    BookLoanEntity findByUserIdentification(String userIdentification);
}
