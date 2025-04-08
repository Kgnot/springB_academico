package com.frenos_el_control.principal.exception;

public class CarTypeException extends RuntimeException{

    public CarTypeException()
    {
        super("No se encontró el tipo de carro.");
    }
}
