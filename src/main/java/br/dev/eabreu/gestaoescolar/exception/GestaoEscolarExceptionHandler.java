package br.dev.eabreu.gestaoescolar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GestaoEscolarExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = { AlunoJaMatriculadoException.class })
	public ResponseEntity<Object> handleAlunoJaMatriculado(AlunoJaMatriculadoException exception) {
		String mensagem = exception.getMessage();
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(mensagem);
	}
}