package com.ceiba.biblioteca.prestamo.infrastructure.drivenadapters.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "book_loan")
public class BookLoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 10)
    private String isbn;
    @Column(name = "user_identification", length = 10)
    private String userIdentification;
    @Column(name = "user_type", length = 1)
    private Integer userType;

    @Column(name = "maximum_return_date")
    private String maximumReturnDate;

    public String getMaximumReturnDate() {
        return maximumReturnDate;
    }

    public void setMaximumReturnDate(String maximumReturnDate) {
        this.maximumReturnDate = maximumReturnDate;
    }



    public BookLoanEntity() {}

    public BookLoanEntity(Long id, String isbn, String userIdentification, Integer userType, String maximumReturnDate) {
        this.id = id;
        this.isbn = isbn;
        this.userIdentification = userIdentification;
        this.userType = userType;
        this.maximumReturnDate = maximumReturnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUserIdentification() {
        return userIdentification;
    }

    public void setUserIdentification(String userIdentification) {
        this.userIdentification = userIdentification;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}
