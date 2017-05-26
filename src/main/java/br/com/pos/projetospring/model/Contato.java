package br.com.pos.projetospring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name="tb_contato")
public class Contato implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="nome", nullable = false, length = 50)
	@NotBlank(message = "Nome é uma informação obrigatória")
	private String nome;
	@Column(name="email", nullable = false, length = 15)
	@NotBlank(message = "email é uma informação obrigatória")
	private String email;
	@Column(name="telefone")
	private String telefone;
	@Column(name="cpf", nullable = false, length = 15)
	@NotBlank(message = "CPF é uma informação obrigatória")	
	private String cpf;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return "ContatoModel [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", cpf="
				+ cpf + "]";
	}
	

}
