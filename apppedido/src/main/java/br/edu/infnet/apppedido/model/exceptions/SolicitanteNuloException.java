package br.edu.infnet.apppedido.model.exceptions;

public class SolicitanteNuloException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public SolicitanteNuloException(String mensagem) {
		super(mensagem);
	}
}
