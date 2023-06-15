package com.example.springtest.exeptions;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ValidationException extends RuntimeException {

    private List<String> errorFieldMessage;

    public ValidationException(List<String> errorFieldMessage) {
        super(errorFieldMessage.stream().collect(Collectors.joining(",")));
        this.errorFieldMessage = errorFieldMessage;
    }

}
