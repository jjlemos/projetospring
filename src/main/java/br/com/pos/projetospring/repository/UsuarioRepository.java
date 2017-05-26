package br.com.pos.projetospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pos.projetospring.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
