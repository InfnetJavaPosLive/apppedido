package br.edu.infnet.apppedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.apppedido.model.service.PedidoService;
import br.edu.infnet.apppedido.model.service.ProdutoService;
import br.edu.infnet.apppedido.model.service.SolicitanteService;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private SolicitanteService solicitanteService;
	@Autowired
	private ProdutoService produtoService;

	@GetMapping(value = "/pedido")
	public String telaCadastro(Model model) {
		
		model.addAttribute("solicitantes", solicitanteService.obterLista());
		model.addAttribute("produtos", produtoService.obterLista());

		return "pedido/cadastro";
	}

	@GetMapping(value = "/pedido/lista")
	public String telaLista(Model model) {
		
		model.addAttribute("listagem", pedidoService.obterLista());

		return "pedido/lista";
	}

	@PostMapping(value = "/pedido/incluir")
	public String incluir() {

		return "redirect:/pedido/lista";
	}

	@GetMapping(value = "/pedido/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		pedidoService.excluir(id);
		
		return "redirect:/pedido/lista";
	}
}
