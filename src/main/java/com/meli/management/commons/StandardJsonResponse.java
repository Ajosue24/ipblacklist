package com.meli.management.commons;

import com.meli.management.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardJsonResponse<T> {
    private HttpStatus httpStatus;
    private String message;
    private String severity;
    private T data;


    public StandardJsonResponse onlySuccessMessageAndData(String message, T data){
        return new StandardJsonResponse(HttpStatus.OK,message, Constants.SUCCESS,data);
    }


    public StandardJsonResponse onlyErrorBadRequest(String message, T data){
        return new StandardJsonResponse(HttpStatus.BAD_REQUEST,message, Constants.ERROR,data);
    }
}
