package br.com.pos.projetospring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.pos.projetospring.model.Contato;
import br.com.pos.projetospring.service.ContatoService;


@Controller
//@RequestMapping("/contato")
public class ContatoController {

	@Autowired
	private ContatoService service;

	public ContatoService getService() {
		return service;
	}

	
	public void setService(ContatoService service) {
		this.service = service;
	}
	
	@PostMapping("/contato")	
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("contato");
		
		mv.addObject("contatos", service.findAll());
		//mv.addObject(new Contato());
		
		return mv;
	}

	
	@GetMapping("/add")
	public ModelAndView add(Contato contato) {
		ModelAndView mv = new ModelAndView("contatoAdd");
		mv.addObject("contato", contato);
		
		return mv;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		service.delete(id);;
		return findAll();
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		return add(service.findOne(id));
	}


	@PostMapping("/save")
	public String save(Contato contato) {
	this.service.save(contato);
	return "redirect:/contato";
	}
	
//	@PostMapping("/save")
//	public ModelAndView save(@Valid Contato contato, BindingResult result) {
//
//		if (result.hasErrors()) {
//			return add(contato);
//		}
//
//		service.save(contato);
//
//		return findAll();
//	}

}