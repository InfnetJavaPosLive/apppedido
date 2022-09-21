package br.edu.infnet.apppedido.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.apppedido.model.exceptions.QuantidadeIncorretaException;

@Entity
@Table(name = "TSobremesa")
public class Sobremesa extends Produto {

	private int quantidade;
	private boolean doce;
	private String informacao;
	
	@Override
	public float calcularVenda() throws QuantidadeIncorretaException {
		
		if(quantidade < 0 || quantidade > 5) {
			throw new QuantidadeIncorretaException("Impossível preencher a quantidade ("+quantidade+") com valor negativo ou superior a 5.");
		}
		
		float valorQtde = quantidade * 5;
		
		float valorDoce = doce ? 5 : 2;
		
		return getValor() + valorQtde + valorDoce;
	}
	
	@Override
	public String toString() {
		return quantidade + ";" + doce + ";" + informacao + ";" + super.toString();
	}

	@Override
	public void impressao() {
		System.out.println("#sobremesa");
		System.out.println(this);
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public boolean isDoce() {
		return doce;
	}

	public void setDoce(boolean doce) {
		this.doce = doce;
	}

	public String getInformacao() {
		return informacao;
	}

	public void setInformacao(String informacao) {
		this.informacao = informacao;
	}
}