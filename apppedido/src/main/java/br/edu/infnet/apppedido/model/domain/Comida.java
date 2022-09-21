package br.edu.infnet.apppedido.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.apppedido.model.exceptions.PesoZeradoNegativoException;

@Entity
@Table(name = "TComida")
public class Comida extends Produto {

	private float peso;
	private boolean vegano;
	private String ingredientes;

	@Override
	public float calcularVenda() throws PesoZeradoNegativoException {
		
		if(peso <= 0) {
			throw new PesoZeradoNegativoException("Impossível preencher o peso ("+peso+") com valor zerado ou negativo.");
		}
		
		float valorPeso = peso * 1.5f;
		
		return getValor() * 2 + valorPeso;
	}

	@Override
	public String toString() {
		return peso + ";" + vegano + ";" + ingredientes + ";" + super.toString();
	}

	@Override
	public void impressao() {
		System.out.println("#comida");
		System.out.println(this);
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public boolean isVegano() {
		return vegano;
	}

	public void setVegano(boolean vegano) {
		this.vegano = vegano;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
}