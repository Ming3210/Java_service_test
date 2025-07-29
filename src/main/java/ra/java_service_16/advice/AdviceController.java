package ra.java_service_16.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ra.java_service_16.model.dto.response.APIDataResponse;

import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class AdviceController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIDataResponse<Map<String, String>> > handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errors = e.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(FieldError -> FieldError.getField(), FieldError -> FieldError.getDefaultMessage()));
        return new ResponseEntity<>(new APIDataResponse<>(false, "Error", errors, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<APIDataResponse<String>> handleRuntimeException(RuntimeException e) {
        return new ResponseEntity<>(new APIDataResponse<>(false, "Error", e.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }
}
