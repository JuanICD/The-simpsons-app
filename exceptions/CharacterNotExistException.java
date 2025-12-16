package com.exceptions;

public class CharacterNotExistException extends RuntimeException {
    public CharacterNotExistException(String message) {
        super(message);
    }
}
