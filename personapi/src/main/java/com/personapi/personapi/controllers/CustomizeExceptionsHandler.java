package com.personapi.personapi.controllers;


import com.personapi.personapi.config.model.FieldErroMessageModel;
import com.personapi.personapi.config.model.MessageErroModel;
import com.personapi.personapi.config.model.constant.ResponseExceptionHandler;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
@RestController
public class CustomizeExceptionsHandler extends ResponseEntityExceptionHandler implements MessageSourceAware {

    private MessageSource messageSource;


    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    protected final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException, HttpHeaders httpHeaders,
                                                                        HttpStatus httpStatus, WebRequest request) {
        return handlerFieldErros(methodArgumentNotValidException.getBindingResult());
    }

    private ResponseEntity<Object> handlerFieldErros(BindingResult bidingResult) {
        List<FieldErroMessageModel> fields = new ArrayList<>();

        String nameField;
        String message;

        for (FieldError error : bidingResult.getFieldErrors()) {
            nameField = buildSnakeCase(error.getField());
            message = buildMessage(error);

            FieldErroMessageModel fieldErroMessageModel = new FieldErroMessageModel();

            fieldErroMessageModel.setField(nameField);
            fieldErroMessageModel.setMessage(message);

            fields.add(fieldErroMessageModel);
        }
        MessageErroModel invalidRequest = new MessageErroModel();
        invalidRequest.setCode(ResponseExceptionHandler.VALIDATION_ERROR.getTextException());
        invalidRequest.setMessage(ResponseExceptionHandler.ERRO_VALIDATION_FIELDS.getTextException());
        invalidRequest.setFields(fields);

        return new ResponseEntity<>(invalidRequest, BAD_REQUEST);
    }

    public String buildSnakeCase(String nameField) {
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";
        return nameField.replaceAll(regex, replacement).toLowerCase();
    }

    private String buildMessage(FieldError fieldError) {
        String result = null;

        if (fieldError.getArguments().length == 1 && fieldError.getArguments()[0] instanceof MessageSourceResolvable) {
            MessageSourceResolvable msg = (MessageSourceResolvable) fieldError.getArguments()[0];
            result = this.messageSource.getMessage(msg, Locale.getDefault());
        }
        if (!StringUtils.hasLength(result) || fieldError.getField().equals(result)) {
            result = fieldError.getDefaultMessage();
        }
        return result;
    }
}