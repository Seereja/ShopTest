package com.example.springtest.exeptions;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class FieldsValidationError {
    public FieldsValidationError(List<String> errorFieldsMassage) {
        this.errorFieldsMassage = errorFieldsMassage;
    }

    List<String> errorFieldsMassage;

}
