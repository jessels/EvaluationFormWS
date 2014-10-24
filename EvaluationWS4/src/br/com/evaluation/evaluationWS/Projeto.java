package br.com.evaluation.evaluationWS;

import java.io.Serializable;

public class Projeto implements Serializable{
	

	private static final long serialVersionUID = 3881452565391239160L;
	
	private int id_projeto;
	private String nome;
	
	
	public Projeto(){
		
	}


	public Projeto(int id_projeto, String nome) {
		super();
		this.id_projeto = id_projeto;
		this.nome = nome;
	}


	public int getId_projeto() {
		return id_projeto;
	}


	public void setId_projeto(int id_projeto) {
		this.id_projeto = id_projeto;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
