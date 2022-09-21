package br.edu.infnet.apppedido.model.exceptions;

public class PesoZeradoNegativoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public PesoZeradoNegativoException(String mensagem) {
		super(mensagem);
	}
}
