package com.project.property_management.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorModel {

    private String errorCode;
    private String errorMessage;
}
