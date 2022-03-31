package br.com.everis.entradaraco.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.everis.entradaraco.modelo.EntradaRaco;
import br.com.everis.entradaraco.service.RacoService;

@Controller
public class EntradaControle {
	
	private static final String CADASTRO_VIEW = "html/DadosEntrada";
	private static final String CONSULTA_VIEW = "html/ConsultaDados";
	
	private RacoService racoService = new RacoService();
	
	@RequestMapping("/")
	public ModelAndView root(EntradaRaco entradaRaco) {
		return novo(entradaRaco);
	}
	
	@RequestMapping("/iniciar")
	public ModelAndView novo(EntradaRaco entradaRaco) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		return mv;
	}
	
	
	@RequestMapping("/pesquisar")
	public ModelAndView pesquisar() {
		ModelAndView mv = new ModelAndView(CONSULTA_VIEW);
		
		List<EntradaRaco> entradas = null;
		try {
			entradas = racoService.getEntradas();
		} catch (Exception e) {
			mv.addObject("erro", e.getMessage());
		}
		mv.addObject("entradas", entradas);
		
		System.out.println("Apenas um teste");
		
		return mv;
	}
	
	
	@RequestMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") String rowId) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		
		EntradaRaco entradaRaco = null;
		try {
			entradaRaco = racoService.getEntradaByRowId(rowId);
			if(entradaRaco == null) {
				entradaRaco = new EntradaRaco();
				mv.addObject("erro", "Registro não localizado");
			}
		} catch (Exception e) {
			mv.addObject("erro", "Não foi possível localizar o registro");
		}
		
		mv.addObject(entradaRaco);
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid EntradaRaco entradaRaco, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(entradaRaco);
		}
		
		try {
			racoService.salvar(entradaRaco);
			attributes.addFlashAttribute("sucesso", "Dados inseridos com sucesso!");
		}catch (Exception e) {
			result.rejectValue("ani", e.getMessage(), e.getMessage());
			return novo(entradaRaco);
		}
		
		return new ModelAndView("redirect:/iniciar");
	}
	
}
