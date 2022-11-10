package edu.ifmt.cobrancaifmt2.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.ifmt.cobrancaifmt2.modelo.StatusTitulo;
import edu.ifmt.cobrancaifmt2.modelo.Titulo;
import edu.ifmt.cobrancaifmt2.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {

	@Autowired
	private Titulos titulos;

	@GetMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		return mv;
	}
	
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo(){
		return Arrays.asList(StatusTitulo.values());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo) {
		titulos.save(titulo);
		List<Titulo> todosTitulos = titulos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos",todosTitulos);
		
		
		mv.addObject("mensagem", "Foi salvo sucesso");
		return mv;
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		List<Titulo> todosTitulos = titulos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos",todosTitulos);
		return mv;
	}
}
