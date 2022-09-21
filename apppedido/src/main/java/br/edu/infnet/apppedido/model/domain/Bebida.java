package br.edu.infnet.apppedido.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.apppedido.model.exceptions.TamanhoBebidaInvalidoException;

@Entity
@Table(name = "TBebida")
public class Bebida extends Produto {
	
	private boolean gelada;
	private float tamanho;
	private String marca;
	
	@Override
	public float calcularVenda() throws TamanhoBebidaInvalidoException {
		
		if(tamanho < 50) {
			throw new TamanhoBebidaInvalidoException("Impossível preencher o tamanho ("+tamanho+") com valor menor que 50.");
		}		
		
		float valorGelada = gelada ? 10 : 5;
		
		float valorTamanho = tamanho * 0.05f;

		return getValor() * 2 + valorGelada + valorTamanho;
	}
	
	@Override
	public String toString() {
		return gelada + ";" + tamanho + ";" + marca + ";" + super.toString();
	}

	@Override
	public void impressao() {
		System.out.println("#bebida");
		System.out.println(this);
	}

	public boolean isGelada() {
		return gelada;
	}

	public void setGelada(boolean gelada) {
		this.gelada = gelada;
	}

	public float getTamanho() {
		return tamanho;
	}

	public void setTamanho(float tamanho) {
		this.tamanho = tamanho;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}