package edu.ifmt.cobrancaifmt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ifmt.cobrancaifmt2.modelo.Titulo;
import edu.ifmt.cobrancaifmt2.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@Autowired
	private Titulos titulos;
	
	@GetMapping("/novo")
	public String novo() {
		return "CadastroTitulo";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvar(Titulo titulo) {
		titulos.save(titulo);
		return "CadastroTitulo";
	}
}