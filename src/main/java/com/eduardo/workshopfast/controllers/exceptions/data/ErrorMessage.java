package com.eduardo.workshopfast.controllers.exceptions.data;

public record ErrorMessage(
        int status,
        String message
) {
}
