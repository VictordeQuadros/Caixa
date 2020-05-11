package br.com.compasso.caixa.exception;

public class SemValorException extends Exception {

	private static final long serialVersionUID = 1L;

	public SemValorException() {
		super();
	}
	
	public SemValorException(String message) {
		super(message);
	}
}
