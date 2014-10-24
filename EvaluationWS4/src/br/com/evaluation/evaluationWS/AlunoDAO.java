package br.com.evaluation.evaluationWS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AlunoDAO {
	
	public boolean inserirAluno(Aluno aluno){
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryInserir = "INSERT INTO aluno VALUES (null, ?, ?)";
			
			PreparedStatement ppStm = conn.prepareStatement(queryInserir);
			
			ppStm.setString(1, aluno.getNome());
			ppStm.setString(2, aluno.getTam_camisa());
			
			ppStm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	
		public boolean atualizarAluno(Aluno aluno){
			try {
				Connection conn = ConectaMySql.abreConexao();
				String queryAtualiza = "UPDATE aluno SET Nome_aluno = ?, tamanho_camiseta = ? WHERE id_aluno = ?";
				
				PreparedStatement ppStm = conn.prepareStatement(queryAtualiza);
				
				ppStm.setString(1, aluno.getNome());
				ppStm.setString(2, aluno.getTam_camisa());
				ppStm.setInt(3, aluno.getId());
				
				ppStm.executeUpdate();
				
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}		
			return true;
		}
	
	
	public boolean excluirAluno(int id){
		
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryExcluir = "DELETE FROM aluno WHERE id_aluno = ?";
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
	
	public ArrayList<Aluno> buscarTodosAlunos(){
		ArrayList<Aluno> lista = new ArrayList<Aluno>();
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryBuscarTodos = "SELECT * FROM aluno";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarTodos);
				
			
			ResultSet rSet = ppStm.executeQuery();
			
			while(rSet.next()){
				Aluno aluno = new Aluno();
				
				aluno.setId(rSet.getInt(1));
				aluno.setNome(rSet.getString(2));
				aluno.setTam_camisa(rSet.getString(3));
				
				
				lista.add(aluno);
			}
			
						
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
	
		}
		
		return lista;
	}
	
	public Aluno buscarAlunoPorId(int id){
		Aluno aluno = null;
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryBuscarPorId = "SELECT * FROM aluno WHERE id_aluno = ?";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarPorId);
				ppStm.setInt(1, id);
			
			ResultSet rSet = ppStm.executeQuery();
			
			if(rSet.next()){
				aluno = new Aluno();
				aluno.setId(rSet.getInt(1));
				aluno.setNome(rSet.getString(2));
				aluno.setTam_camisa(rSet.getString(3));
				
			}else{
				return aluno;
			}
			
						
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
	
		}		
		
		return aluno;
		
		
	}

}
