package br.edu.infnet.apppedido.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.apppedido.model.domain.Comida;
import br.edu.infnet.apppedido.model.test.AppImpressao;

@Service
public class ComidaService {

	private static Map<Integer, Comida> mapaComida = new HashMap<Integer, Comida>();
	private static Integer id = 1;
	
	public void incluir(Comida comida) {
		comida.setId(id++);
		mapaComida.put(comida.getId(), comida);
				
		AppImpressao.relatorio("Inclusão da comida " + comida.getNome() + " realizada com sucesso!!!", comida);
	}
	
	public Collection<Comida> obterLista(){
		return mapaComida.values();
	}
	
	public void excluir(Integer id){
		mapaComida.remove(id);
	}
}
