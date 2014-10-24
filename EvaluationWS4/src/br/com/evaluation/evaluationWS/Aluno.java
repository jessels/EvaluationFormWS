package br.com.evaluation.evaluationWS;

import java.io.Serializable;

public class Aluno implements Serializable{
	
	
	private static final long serialVersionUID = -3090757124380641094L;
	
	private int id;
	private String nome;
	private String tam_camisa;
	
	public Aluno(){
		
	}
	
	public Aluno(int id, String nome, String tam_camisa) {
		this.id = id;
		this.nome = nome;
		this.tam_camisa = tam_camisa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTam_camisa() {
		return tam_camisa;
	}

	public void setTam_camisa(String tam_camisa) {
		this.tam_camisa = tam_camisa;
	}
	

}
