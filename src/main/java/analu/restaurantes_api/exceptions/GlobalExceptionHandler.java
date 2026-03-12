package analu.restaurantes_api.exceptions;

import analu.restaurantes_api.exceptions.handler.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {

    ErrorResponse error = new ErrorResponse(
            ex.getStatus().value(),
            ex.getMessage()
    );

    return new ResponseEntity<>(error, ex.getStatus());
  }
}
