package br.edu.infnet.apppedido.model.exceptions;

public class CpfInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CpfInvalidoException(String mensagem) {
		super(mensagem);
	}
}
