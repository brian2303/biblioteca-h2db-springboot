package com.ceiba.biblioteca.prestamo.infrastructure.entrypoints.dto;

public class BookLoanBadRequestDTO {
    private String mensaje;

    public BookLoanBadRequestDTO(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
