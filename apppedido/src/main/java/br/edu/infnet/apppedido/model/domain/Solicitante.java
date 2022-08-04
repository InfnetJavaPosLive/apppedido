package br.edu.infnet.apppedido.model.domain;

public class Solicitante {

	public String nome;
	public String cpf;
	public String email;
	
	public Solicitante(String cpf, String email, String nome) {
		this.cpf = cpf;
		this.email = email;
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return nome + ";" + cpf + ";" + email;
	}
}