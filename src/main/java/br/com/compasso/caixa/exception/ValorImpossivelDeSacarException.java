package br.com.compasso.caixa.exception;

public class ValorImpossivelDeSacarException extends Exception{

	private static final long serialVersionUID = 1L;

	public ValorImpossivelDeSacarException() {
		super();
	}
	
	public ValorImpossivelDeSacarException(String message) {
		super(message);
	}
}
