package br.edu.infnet.apppedido.model.domain;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.infnet.apppedido.interfaces.IPrinter;
import br.edu.infnet.apppedido.model.exceptions.PedidoSemProdutoException;
import br.edu.infnet.apppedido.model.exceptions.SolicitanteNuloException;

@Entity
@Table(name = "TPedido")
public class Pedido implements IPrinter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private LocalDateTime data;
	private boolean web;
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idSolicitante")
	private Solicitante solicitante;
	@ManyToMany(cascade = CascadeType.DETACH)
	private Set<Produto> produtos;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}
	
	public Pedido(Solicitante solicitante, Set<Produto> produtos) throws SolicitanteNuloException, PedidoSemProdutoException {
		
		if(solicitante == null) {
			throw new SolicitanteNuloException("Impossivel criar um Pedido sem um solicitante!");
		}
		
//		if(produtos == null) {
//			throw new PedidoSemProdutoException("Impossível criar um pedido sem uma listagem de produtos associada!");
//		}

//		if(produtos.size() < 1) {
//			throw new PedidoSemProdutoException("Impossível criar um pedido com menos de um produto!");
//		}
		
		this.data = LocalDateTime.now();		
		this.solicitante = solicitante;
		this.produtos = produtos;
	}
	
	@Override
	public void impressao() {
		System.out.println("#pedido");
		System.out.println(this);
	}

	@Override
	public String toString() {
		return descricao + ";" + data + ";" + web + ";" + solicitante + ";" + produtos.size();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public boolean isWeb() {
		return web;
	}

	public void setWeb(boolean web) {
		this.web = web;
	}

	public Solicitante getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}