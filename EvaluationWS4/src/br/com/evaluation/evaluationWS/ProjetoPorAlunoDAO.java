package br.com.evaluation.evaluationWS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProjetoPorAlunoDAO {
	
	public boolean inserirProjetoPorAluno(ProjetoPorAluno projetoPorAluno){
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryInserir = "INSERT INTO projeto_aluno VALUES (null, ?, ?)";
			
			PreparedStatement ppStm = conn.prepareStatement(queryInserir);
			
			ppStm.setInt(1, projetoPorAluno.getId_aluno());
			ppStm.setInt(2, projetoPorAluno.getId_projeto());
			
			ppStm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	
		public boolean atualizarProjetoPorAluno(ProjetoPorAluno projetoPorAluno){
			try {
				Connection conn = ConectaMySql.abreConexao();
				String queryAtualiza = "UPDATE projeto_aluno SET id_aluno = ?, id_projeto = ? WHERE id_projeto_aluno = ?";
				
				PreparedStatement ppStm = conn.prepareStatement(queryAtualiza);
				
				ppStm.setInt(1, projetoPorAluno.getId_aluno());
				ppStm.setInt(2, projetoPorAluno.getId_projeto());
				ppStm.setInt(3, projetoPorAluno.getId_projeto_aluno());
				
				ppStm.executeUpdate();
				
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}		
			return true;
		}
	
	
	public boolean excluirProjetoPorAluno(int id){
		
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryExcluir = "DELETE FROM projeto_aluno WHERE id_projeto_aluno = ?";
			PreparedStatement ppStm = conn.prepareStatement(queryExcluir);
			ppStm.setInt(1, id);
						
			ppStm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	
	public ArrayList<ProjetoPorAluno> buscarTodosProjetosPorAluno(){
		ArrayList<ProjetoPorAluno> lista = new ArrayList<ProjetoPorAluno>();
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryBuscarTodos = "SELECT * FROM projeto_aluno";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarTodos);
				
			
			ResultSet rSet = ppStm.executeQuery();
			
			while(rSet.next()){
				ProjetoPorAluno ppa = new ProjetoPorAluno();
				
				ppa.setId_projeto_aluno(rSet.getInt(1));
				ppa.setId_aluno(rSet.getInt(2));
				ppa.setId_projeto(rSet.getInt(3));
				
				
				lista.add(ppa);
			}
			
						
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
	
		}
		
		return lista;
	}
	
	public ProjetoPorAluno buscarProjetoPorId(int id){
		ProjetoPorAluno ppa = null;
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryBuscarPorId = "SELECT * FROM projeto_aluno WHERE id_projeto_aluno = ?";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarPorId);
				ppStm.setInt(1, id);
			
			ResultSet rSet = ppStm.executeQuery();
			
			if(rSet.next()){
				ppa = new ProjetoPorAluno();
				ppa.setId_projeto_aluno(rSet.getInt(1));
				ppa.setId_aluno(rSet.getInt(2));
				ppa.setId_projeto(rSet.getInt(3));
				
				
			}else{
				return ppa;
			}
			
						
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
	
		}		
		
		return ppa;
		
		
	}
	
	
	

}
