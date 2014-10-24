package br.com.evaluation.evaluationWS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProjetoDAO {
	
	
	public boolean inserirProjeto(Projeto projeto){
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryInserir = "INSERT INTO projeto VALUES (null, ?)";
			
			PreparedStatement ppStm = conn.prepareStatement(queryInserir);
			
			ppStm.setString(1, projeto.getNome());
			
			
			ppStm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	
		public boolean atualizarProjeto(Projeto projeto){
			try {
				Connection conn = ConectaMySql.abreConexao();
				String queryAtualiza = "UPDATE projeto SET nome_projeto = ? WHERE id_projeto = ?";
				
				PreparedStatement ppStm = conn.prepareStatement(queryAtualiza);
				
				ppStm.setString(1, projeto.getNome());
				ppStm.setInt(2, projeto.getId_projeto());
				
				ppStm.executeUpdate();
				
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}		
			return true;
		}
	
	
	public boolean excluirProjeto(int id){
		
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryExcluir = "DELETE FROM projeto WHERE id_projeto = ?";
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
	
	public ArrayList<Projeto> buscarTodosProjetos(){
		ArrayList<Projeto> lista = new ArrayList<Projeto>();
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryBuscarTodos = "SELECT * FROM projeto";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarTodos);
				
			
			ResultSet rSet = ppStm.executeQuery();
			
			while(rSet.next()){
				Projeto proj = new Projeto();
				
				proj.setId_projeto(rSet.getInt(1));
				proj.setNome(rSet.getString(2));
								
				
				lista.add(proj);
			}
			
						
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
	
		}
		
		return lista;
	}
	
	public Projeto buscarProjetoPorId(int id){
		Projeto proj = null;
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryBuscarPorId = "SELECT * FROM projeto WHERE id_projeto = ?";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarPorId);
				ppStm.setInt(1, id);
			
			ResultSet rSet = ppStm.executeQuery();
			
			if(rSet.next()){
				proj = new Projeto();
				proj.setId_projeto(rSet.getInt(1));
				proj.setNome(rSet.getString(2));
				
			}else{
				return proj;
			}
			
						
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
	
		}		
		
		return proj;
		
		
	}

}
