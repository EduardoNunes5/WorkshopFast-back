package com.eduardo.workshopfast.controllers.exceptions.data;

import java.util.List;

public record ValidationErrorData(
        int status,
        List<FieldMessage> errors
) {
}
