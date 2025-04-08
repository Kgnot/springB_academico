package com.frenos_el_control.principal.exception;

public class HistoryPriceException extends RuntimeException {

    public HistoryPriceException()
    {
        super("El historial no se encuentrá porque una fecha está mal digitada o no cuadran inicio fin correctamente");
    }

}
