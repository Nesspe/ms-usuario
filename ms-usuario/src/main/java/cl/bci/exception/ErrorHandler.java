package cl.bci.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ErrorNegocioException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse errorNegocioException(ErrorNegocioException ce) {
    	ErrorResponse response = new ErrorResponse();
    	response.setMensaje(ce.getMessage());
        return response;
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorResponse noAccesoException(AccessDeniedException ce) {
    	ErrorResponse response = new ErrorResponse();
    	response.setMensaje(ce.getMessage());
        return response;
    }
}