package com.ceiba.biblioteca.prestamo.domain.model;


import java.time.LocalDate;

public class BookLoan {
    private Long id;
    private String isbn;
    private String userIdentification;
    private int userType;

    private LocalDate maximumReturnDate;

    public BookLoan(Long id, String isbn, String userIdentification, int userType, LocalDate maximumReturnDate) {
        this.id = id;
        this.isbn = isbn;
        this.userIdentification = userIdentification;
        this.userType = userType;
        this.maximumReturnDate = maximumReturnDate;
    }

    public BookLoan(Long id, LocalDate maximumReturnDate) {
        this.id = id;
        this.maximumReturnDate = maximumReturnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getMaximumReturnDate() {
        return maximumReturnDate;
    }

    public void setMaximumReturnDate(LocalDate maximumReturnDate) {
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

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
