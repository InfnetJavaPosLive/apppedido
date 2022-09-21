package br.edu.infnet.apppedido.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SobremesaController {

	@GetMapping(value = "/sobremesa/lista")
	public String telaLista() {
		return "sobremesa/lista";
	}
}
