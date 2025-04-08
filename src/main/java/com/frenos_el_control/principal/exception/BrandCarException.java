package com.frenos_el_control.principal.exception;

public class BrandCarException extends RuntimeException {

    public BrandCarException() {
        super("No se encontró el carro o hubo algún error");
    }

    public BrandCarException(String message) {
        super(message);
    }

    public BrandCarException(String message, Throwable cause) {
        super(message, cause);
    }

    public BrandCarException(Throwable cause) {
        super(cause);
    }
}