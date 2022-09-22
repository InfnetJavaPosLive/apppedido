package br.edu.infnet.apppedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.apppedido.model.domain.Bebida;
import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.service.BebidaService;

@Controller
public class BebidaController {
	
	@Autowired
	private BebidaService bebidaService;

	@GetMapping(value = "/bebida/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("listagem", bebidaService.obterLista(usuario));
		
		return "bebida/lista";
	}
	
	@GetMapping(value = "/bebida")
	public String telaCadastro() {
		return "bebida/cadastro";
	}
	
	@PostMapping(value = "/bebida/incluir")
	public String incluir(Bebida bebida, @SessionAttribute("user") Usuario usuario) {
		
		bebida.setUsuario(usuario);
		
		bebidaService.incluir(bebida);
		
		return "redirect:/bebida/lista";
	}
	
	@GetMapping(value = "/bebida/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		bebidaService.excluir(id);
		
		return "redirect:/bebida/lista";
	}
}