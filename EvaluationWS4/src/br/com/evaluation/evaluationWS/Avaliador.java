package br.com.evaluation.evaluationWS;

public class Avaliador {
	
	private int id_avaliador;
	private String nome;
	private String instituicao;
	private String login;
	private String senha;
	private String tam_camisa;
	
	
	public Avaliador(){
		
	}


	public Avaliador(int id_avaliador, String nome, String instituicao, String login, String senha, String tam_camisa) {
		this.id_avaliador = id_avaliador;
		this.nome = nome;
		this.instituicao = instituicao;
		this.login = login;
		this.senha = senha;
		this.tam_camisa = tam_camisa;
	}


	public int getId_avaliador() {
		return id_avaliador;
	}


	public void setId_avaliador(int id_avaliador) {
		this.id_avaliador = id_avaliador;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getInstituicao() {
		return instituicao;
	}


	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
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


	public String getTam_camisa() {
		return tam_camisa;
	}


	public void setTam_camisa(String tam_camisa) {
		this.tam_camisa = tam_camisa;
	}
	

}
