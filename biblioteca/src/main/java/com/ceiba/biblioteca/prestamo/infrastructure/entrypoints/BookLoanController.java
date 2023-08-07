package com.ceiba.biblioteca.prestamo.infrastructure.entrypoints;


import com.ceiba.biblioteca.prestamo.domain.usecase.BookLoanUseCase;
import com.ceiba.biblioteca.prestamo.infrastructure.entrypoints.dto.BookLoanDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ceiba.biblioteca.prestamo.application.utils.MapModelUtils.mapToBookLoan;
import static com.ceiba.biblioteca.prestamo.application.utils.MapModelUtils.mapToBookLoanDTO;

@RestController
@RequestMapping("prestamo")
public class BookLoanController {

    private final BookLoanUseCase bookLoanUseCase;

    @Autowired
    public BookLoanController(BookLoanUseCase bookLoanUseCase) {
        this.bookLoanUseCase = bookLoanUseCase;
    }

    @PostMapping
    public ResponseEntity<BookLoanDTO> addLoan(@RequestBody BookLoanDTO bookLoanDTO){
        return ResponseEntity.ok(
                mapToBookLoanDTO(bookLoanUseCase.addBookLoan(mapToBookLoan(bookLoanDTO)))
        );
    }

}

