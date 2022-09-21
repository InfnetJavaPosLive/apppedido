package br.edu.infnet.apppedido.model.exceptions;

public class TamanhoBebidaInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public TamanhoBebidaInvalidoException(String mensagem) {
		super(mensagem);
	}
}
