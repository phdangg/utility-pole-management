package com.evn.utilitypolemanagement.exceptions.Pole;

public class PoleAlreadyExistsException extends RuntimeException {
    public PoleAlreadyExistsException(String message) {
        super(message);
    }
}