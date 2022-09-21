package br.edu.infnet.apppedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.apppedido.model.domain.Comida;
import br.edu.infnet.apppedido.model.service.ComidaService;

@Controller
public class ComidaController {
	
	@Autowired
	private ComidaService comidaService;

	@GetMapping(value = "/comida/lista")
	public String telaLista(Model model) {

		model.addAttribute("listagem", comidaService.obterLista());
		
		return "comida/lista";
	}
	
	@GetMapping(value = "/comida")
	public String telaCadastro() {
		return "comida/cadastro";
	}

	@PostMapping(value = "/comida/incluir")
	public String incluir(Comida comida) {
		
		comidaService.incluir(comida);
		
		return "redirect:/comida/lista";
	}
	
	@GetMapping(value = "/comida/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		comidaService.excluir(id);
		
		return "redirect:/comida/lista";
	}
}