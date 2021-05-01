package com.meli.management.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandartJsonResponse<T> {
    private HttpStatus httpStatus;
    private String message;
    private String severity;
    private T data;
}
