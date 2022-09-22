package br.edu.infnet.apppedido.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apppedido.model.domain.Bebida;
import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.repository.BebidaRepository;
import br.edu.infnet.apppedido.model.test.AppImpressao;

@Service
public class BebidaService {
	
	@Autowired
	private BebidaRepository bebidaRepository;

	public void incluir(Bebida bebida) {		
		bebidaRepository.save(bebida);
		
		AppImpressao.relatorio("Inclusão da bebida " + bebida.getNome() + " realizada com sucesso!!!", bebida);
	}
	
	public Collection<Bebida> obterLista(){
		return (Collection<Bebida>) bebidaRepository.findAll();
	}
	
	public Collection<Bebida> obterLista(Usuario usuario){
		return (Collection<Bebida>) bebidaRepository.findAll(usuario.getId());
	}

	public void excluir(Integer id){
		bebidaRepository.deleteById(id);		
	}
}
