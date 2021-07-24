package com.mukesh.surl.handler;

import com.mukesh.surl.exception.InvalidDataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Configuration
@Slf4j
public class SurlExceptionHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({InvalidDataException.class})
  @ResponseBody
  public String handleResourceNotFound(InvalidDataException ex) {
    log.error("InvalidDataException ::", ex);
    return ex.getMessage();
  }
}
