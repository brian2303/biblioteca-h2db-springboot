package com.ceiba.biblioteca.prestamo.application;

import com.ceiba.biblioteca.prestamo.domain.model.gateway.BookLoanRepository;
import com.ceiba.biblioteca.prestamo.domain.usecase.BookLoanUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigUseCase {

    @Bean
    public BookLoanUseCase bookLoanUseCase(BookLoanRepository bookLoanRepository){
        return new BookLoanUseCase(bookLoanRepository);
    }

}
