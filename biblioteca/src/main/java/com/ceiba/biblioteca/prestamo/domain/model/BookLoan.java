package com.ceiba.biblioteca.prestamo.domain.model;


import java.time.LocalDate;

public class BookLoan {
    private Long id;
    private String isbn;
    private String userIdentification;
    private Integer userType;

    private String maximumReturnDate;

    public BookLoan() {
    }

    public BookLoan(Long id, String isbn, String userIdentification, Integer userType, String maximumReturnDate) {
        this.id = id;
        this.isbn = isbn;
        this.userIdentification = userIdentification;
        this.userType = userType;
        this.maximumReturnDate = maximumReturnDate;
    }

    public BookLoan(Long id, String maximumReturnDate) {
        this.id = id;
        this.maximumReturnDate = maximumReturnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaximumReturnDate() {
        return maximumReturnDate;
    }

    public void setMaximumReturnDate(String maximumReturnDate) {
        this.maximumReturnDate = maximumReturnDate;
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
