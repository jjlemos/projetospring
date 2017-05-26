package br.com.pos.projetospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pos.projetospring.model.Contato;
import br.com.pos.projetospring.model.Usuario;
import br.com.pos.projetospring.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	public UsuarioRepository getRepository() {
		return repository;
	}

	public void setRepository(UsuarioRepository repository) {
		this.repository = repository;
	}
	
	public Usuario save(Usuario usuario){
		return repository.saveAndFlush(usuario);
	}
	
	public void delete(Long id){
		repository.delete(id);
	}
	
	public List<Usuario> findAll() {
		return repository.findAll();
	}

}
