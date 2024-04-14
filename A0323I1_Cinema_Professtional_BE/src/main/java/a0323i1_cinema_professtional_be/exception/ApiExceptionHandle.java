package a0323i1_cinema_professtional_be.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;
@ControllerAdvice
public class ApiExceptionHandle {
  public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
     ApiException apiException= new ApiException(e.getMessage(),
              e,
              HttpStatus.BAD_REQUEST,
              ZonedDateTime.now(ZoneId.of("Z")));
     return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);


  }
}
