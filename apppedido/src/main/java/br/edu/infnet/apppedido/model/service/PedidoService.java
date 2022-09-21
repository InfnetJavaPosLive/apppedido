package br.edu.infnet.apppedido.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.apppedido.model.domain.Pedido;
import br.edu.infnet.apppedido.model.test.AppImpressao;

@Service
public class PedidoService {

	private static Map<Integer, Pedido> mapaPedido = new HashMap<Integer, Pedido>();
	private static Integer id = 1;
	
	public void incluir(Pedido pedido) {
		pedido.setId(id++);
		mapaPedido.put(pedido.getId(), pedido);
				
		AppImpressao.relatorio("Inclusão do pedido " + pedido.getDescricao() + " realizada com sucesso!!!", pedido);
	}
	
	public Collection<Pedido> obterLista(){
		return mapaPedido.values();
	}
	
	public void excluir(Integer id){
		mapaPedido.remove(id);
	}
}
