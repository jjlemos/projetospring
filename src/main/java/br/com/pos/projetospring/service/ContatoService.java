package br.com.pos.projetospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pos.projetospring.model.Contato;
import br.com.pos.projetospring.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository repository;
	
	public ContatoRepository getRepository() {
		return repository;
	}

	public void setRepository(ContatoRepository repository) {
		this.repository = repository;
	}

	public Contato save(Contato contato){
		return repository.saveAndFlush(contato);
	}
	
	public void delete(Long id){
		repository.delete(id);
	}
	
	public List<Contato> findAll() {
		return repository.findAll();
	}
	
	public Contato findOne(Long id){
		return repository.findOne(id);
	}
	
	
	
	
}
