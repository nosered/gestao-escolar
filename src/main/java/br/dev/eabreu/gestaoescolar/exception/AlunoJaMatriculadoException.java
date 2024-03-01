package br.dev.eabreu.gestaoescolar.exception;

public class AlunoJaMatriculadoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private static final String MENSAGEM = "Aluno já possui matricula ativa.";
	
	public AlunoJaMatriculadoException() {
		super(MENSAGEM);
	}
}