package br.com.evaluation.evaluationWS;

import java.io.Serializable;

public class TabelaAvaliativa implements Serializable{
	
	
	private static final long serialVersionUID = -1690584357884220897L;
	private int id_tabela_av;
	private String nome;
	
	
	
	public TabelaAvaliativa(){
		
	}


	public TabelaAvaliativa(int id_tabela_av, String nome) {
		super();
		this.id_tabela_av = id_tabela_av;
		this.nome = nome;
		
	}


	public int getId_tabela_av() {
		return id_tabela_av;
	}


	public void setId_tabela_av(int id_tabela_av) {
		this.id_tabela_av = id_tabela_av;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	@Override
	public String toString() {
		return nome;
	}

	
}