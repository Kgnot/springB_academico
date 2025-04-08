package com.frenos_el_control.principal.exception;

public class InventoryException extends RuntimeException {

    public InventoryException()
    {
        super("Hubo un error en la búsqueda de algún item del inventario");
    }
}
