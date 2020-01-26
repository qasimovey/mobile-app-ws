package org.qasimovey.AppExceptionHandling;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice //Controller -a listene edir, when exception occurs, it will trigger
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest req) {
		ErrorMessage em=new ErrorMessage(new Date(),(ex.getLocalizedMessage()==null)?ex.toString():ex.getLocalizedMessage());
		ex.printStackTrace();
		return new ResponseEntity<>(em,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(FavoriteException.class)
	public ResponseEntity<Object> handleFavExpcetion(FavoriteException fe){
		ErrorMessage em=new ErrorMessage(new Date(),fe.getLocalizedMessage());
		return new ResponseEntity<Object>(em,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
