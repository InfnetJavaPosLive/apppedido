package br.edu.infnet.apppedido.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.infnet.apppedido.interfaces.IPrinter;
import br.edu.infnet.apppedido.model.exceptions.CpfInvalidoException;

@Entity
@Table(name = "TSolicitante")
public class Solicitante implements IPrinter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private String email;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	public Solicitante() {

	}
	
	public Solicitante(String cpf, String email, String nome) throws CpfInvalidoException {
		
		if(cpf == null) {
			throw new CpfInvalidoException("Não é possível aceitar CPF nulo.");
		}
		
		if(cpf.isEmpty()) {
			throw new CpfInvalidoException("Não é possível aceitar CPF sem preenchimento.");
		}

		this.cpf = cpf;
		this.email = email;
		this.nome = nome;
	}

	@Override
	public void impressao() {
		System.out.println("#solicitante");
		System.out.println(this);
	}

	@Override
	public String toString() {
		return nome + ";" + cpf + ";" + email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}