package com.ceiba.biblioteca.prestamo.infrastructure.entrypoints;


import com.ceiba.biblioteca.prestamo.domain.usecase.BookLoanUseCase;
import com.ceiba.biblioteca.prestamo.infrastructure.entrypoints.dto.BookLoanDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id-prestamo}")
    public ResponseEntity<BookLoanDTO> getBookLoan(@PathVariable("id-prestamo") String bookLoanId){
        return ResponseEntity.ok(
                mapToBookLoanDTO(bookLoanUseCase.findById(Long.valueOf(bookLoanId)))
        );
    }

}

