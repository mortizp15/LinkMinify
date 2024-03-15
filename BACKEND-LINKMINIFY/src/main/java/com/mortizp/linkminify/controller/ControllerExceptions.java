package com.mortizp.linkminify.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mortizp.linkminify.exceptions.BadRequestException;
import com.mortizp.linkminify.exceptions.ConflictException;
import com.mortizp.linkminify.exceptions.ForbiddenException;
import com.mortizp.linkminify.exceptions.NotFoundException;
import com.mortizp.linkminify.exceptions.UnauthorizedException;
import com.mortizp.linkminify.response.EntityResponse;

@ControllerAdvice
public class ControllerExceptions {

    // 404
    @ExceptionHandler
    public ResponseEntity<EntityResponse> handleNotFoundException(NotFoundException exception) {
        EntityResponse error = new EntityResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // 400
    @ExceptionHandler
    public ResponseEntity<EntityResponse> handleBadRequestException(BadRequestException exception) {
        EntityResponse error = new EntityResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // 409
    @ExceptionHandler
    public ResponseEntity<EntityResponse> handleConflictException(ConflictException exception) {
        EntityResponse error = new EntityResponse();

        error.setStatus(HttpStatus.CONFLICT.value());
        error.setMessage(exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    // 401
    @ExceptionHandler
    public ResponseEntity<EntityResponse> handleUnauthorized(UnauthorizedException exception) {
        EntityResponse error = new EntityResponse();

        error.setStatus(HttpStatus.UNAUTHORIZED.value());
        error.setMessage(exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    // 403
    @ExceptionHandler
    public ResponseEntity<EntityResponse> handleForbidden(ForbiddenException exception) {
        EntityResponse error = new EntityResponse();

        error.setStatus(HttpStatus.FORBIDDEN.value());
        error.setMessage(exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }

}
