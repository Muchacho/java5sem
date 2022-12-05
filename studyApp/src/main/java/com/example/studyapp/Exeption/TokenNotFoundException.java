package com.example.studyapp.Exeption;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TokenNotFoundException extends ResponseStatusException {

    public TokenNotFoundException() {
        super(HttpStatus.FORBIDDEN, "Non authorized");
    }
}