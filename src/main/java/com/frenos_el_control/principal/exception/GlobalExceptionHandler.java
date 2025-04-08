package com.frenos_el_control.principal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BrandCarException.class)
    public ResponseEntity<Map<String, String>> handleBrandCarException(BrandCarException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        errorResponse.put("status", "404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    @ExceptionHandler(CarTypeException.class)
    public ResponseEntity<Map<String,String>> handleCarTypeException(CarTypeException ex){
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        errorResponse.put("status", "404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    @ExceptionHandler(HistoryPriceException.class)
    public ResponseEntity<Map<String,String>> handleHistoryPriceException(CarTypeException ex){
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        errorResponse.put("status", "404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    @ExceptionHandler(InventoryException.class)
    public ResponseEntity<Map<String,String>> handleInventoryException(CarTypeException ex){
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        errorResponse.put("status", "404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
