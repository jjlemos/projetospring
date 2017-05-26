package br.com.pos.projetospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.pos.projetospring.model.Contato;
import br.com.pos.projetospring.model.Usuario;
import br.com.pos.projetospring.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	public UsuarioService getService() {
		return service;
	}

	
	public void setService(UsuarioService service) {
		this.service = service;
	}
	
//	@RequestMapping("/index")
//	public String teste(){
//		return "index";
//	}
	
	@PostMapping("/")
	public ModelAndView addUsuario(Usuario usuario) {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("usuario", usuario);
		
		return mv;
	}

	@GetMapping("/usuario")	
	public ModelAndView todosUsuarios() {
		ModelAndView mv = new ModelAndView("usuario");
		
		mv.addObject("usuarios", service.findAll());
		return mv;
	}
	

	@GetMapping("/excluir/{id}")
	public ModelAndView excluirUsuario(@PathVariable("id") Long id) {
		service.delete(id);;
		return todosUsuarios();
	}


	@PostMapping("/saveUser")
	public String salvarUsuario(Usuario user) {
	this.service.save(user);
	return "redirect:/login";
	}
	
}
