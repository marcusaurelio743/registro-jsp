package model;

import java.io.Serializable;

public class ModelLogin implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String login;
	private String senha;
	private String nome;
	private Long id;
	
	public boolean isNew() {
		if(this.id == null ) {
			return true;
		}else if(this.id != null && id > 0) {
			return false;
		}
		return id == null;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public ModelLogin(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}
	
	public ModelLogin(String login, String senha, String nome, Long id) {
		super();
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.id = id;
	}
	public ModelLogin() {
	}
	@Override
	public String toString() {
		return "ModelLogin [login=" + login + ", senha=" + senha + ", nome=" + nome + ", id=" + id + "]";
	}
	
	
	

}
