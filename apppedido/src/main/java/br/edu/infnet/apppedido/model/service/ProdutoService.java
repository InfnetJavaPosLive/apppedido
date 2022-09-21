package br.edu.infnet.apppedido.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apppedido.model.domain.Produto;

@Service
public class ProdutoService {
	
	@Autowired
	private BebidaService bebidaService;	
	@Autowired
	private ComidaService comidaService;

	public List<Produto> obterLista(){
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		produtos.addAll(bebidaService.obterLista());
		produtos.addAll(comidaService.obterLista());
		
		return produtos;
	}
}