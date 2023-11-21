package uz.alif.authentication_news_app.exception.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import uz.alif.authentication_news_app.exception.AppLoginException;
import uz.alif.authentication_news_app.exception.NewsAppResourceNotFoundException;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody()
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Object requestArgumentInvalidException(MethodArgumentNotValidException exception) {
        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError ->
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage())
        );
        return errorMap;
    }

    @ExceptionHandler(AppLoginException.class)
    public ResponseEntity<?> appLoginException(AppLoginException exception) {
        return ResponseEntity.status(404).body(exception.getMessage());
    }

    @ExceptionHandler(NewsAppResourceNotFoundException.class)
    public ResponseEntity<?> appLoginException(NewsAppResourceNotFoundException exception) {
        return ResponseEntity.status(404).body(exception.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> appLoginException(AccessDeniedException exception) {
        return ResponseEntity.status(403).body(exception.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> illegalArgumentException(IllegalArgumentException exception) {
        return ResponseEntity.status(400).body("permission name is not valid");
    }


}
