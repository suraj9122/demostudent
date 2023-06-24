/*package com.example.demo.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptions {

public ResponseEntity<ApiResponse>resourseNotFoundExceptionhandler(ResponseNotFoundException ex){
	
String message=ex.getMessage();
ApiResponse apiResponse=new ApiResponse(message,false);
return newResponseEntity<ApiResponse>(api,HttpStatus.NOT_FOUND);
}

}
*/