package br.com.evaluation.evaluationWS;

import java.io.Serializable;
import java.util.Date;


public class Avaliacao implements Serializable{
	
	private static final long serialVersionUID = -278104483980801542L;
	
	private int id_avaliacao;
	private int id_avaliador;
	private int id_projeto;
	private int id_tabela_av;
	private Date data_av;
	
	
	public Avaliacao() {
		
	}
	public Avaliacao(int id_avaliacao, int id_avaliador, int id_projeto, int id_tabela_av,
			Date data_av) {
		this.id_avaliacao = id_avaliacao;
		this.id_avaliador = id_avaliador;
		this.id_projeto = id_projeto;
		this.id_tabela_av = id_tabela_av;
		this.data_av = data_av;
	}
	public int getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(int id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	public int getId_avaliador() {
		return id_avaliador;
	}
	public void setId_avaliador(int id_avaliador) {
		this.id_avaliador = id_avaliador;
	}
	public int getId_projeto() {
		return id_projeto;
	}
	public void setId_projeto(int id_projeto) {
		this.id_projeto = id_projeto;
	}
	public int getId_tabela_av() {
		return id_tabela_av;
	}
	public void setId_tabela_av(int id_tabela_av) {
		this.id_tabela_av = id_tabela_av;
	}
	
	public Date getData_av() {
		return data_av;
	}
	public void setData_av(Date data_av) {
		this.data_av = data_av;
	}
	

}
