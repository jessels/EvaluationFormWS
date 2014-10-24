package br.com.evaluation.evaluationWS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CriterioDAO {
	
	public boolean inserirCriterio(Criterio criterio){
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryInserir = "INSERT INTO criterio VALUES (null, ?, ?)";
			
			PreparedStatement ppStm = conn.prepareStatement(queryInserir);
			
			ppStm.setInt(1, criterio.getPeso());
			ppStm.setString(2, criterio.getDescricao());
						
			ppStm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	
		public boolean atualizarCriterio(Criterio criterio){
			try {
				Connection conn = ConectaMySql.abreConexao();
				String queryAtualiza = "UPDATE criterio SET peso = ?, descricao = ? WHERE id_criterio = ?";
				
				PreparedStatement ppStm = conn.prepareStatement(queryAtualiza);
				
				ppStm.setInt(1, criterio.getPeso());
				ppStm.setString(2, criterio.getDescricao());
				ppStm.setInt(3, criterio.getId_criterio());
				
				ppStm.executeUpdate();
				
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}		
			return true;
		}
	
	
	public boolean excluirCriterio(int id){
		
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryExcluir = "DELETE FROM criterio WHERE id_criterio = ?";
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
	
	public ArrayList<Criterio> buscarTodosCriterios(){
		ArrayList<Criterio> lista = new ArrayList<Criterio>();
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryBuscarTodos = "SELECT * FROM criterio";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarTodos);
				
			
			ResultSet rSet = ppStm.executeQuery();
			
			while(rSet.next()){
				Criterio crit = new Criterio();
				
				crit.setId_criterio(rSet.getInt(1));
				crit.setPeso(rSet.getInt(2));
				crit.setDescricao(rSet.getString(3));
				
				
				
				lista.add(crit);
			}
			
						
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
	
		}
		
		return lista;
	}
	
	public Criterio buscarCriterioPorId(int id){
		Criterio crit = null;
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryBuscarPorId = "SELECT * FROM criterio WHERE id_criterio = ?";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarPorId);
				ppStm.setInt(1, id);
			
			ResultSet rSet = ppStm.executeQuery();
			
			if(rSet.next()){
				crit = new Criterio();
				crit.setId_criterio(rSet.getInt(1));
				crit.setPeso(rSet.getInt(2));
				crit.setDescricao(rSet.getString(3));
				
			}else{
				return crit;
			}
			
						
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
	
		}		
		
		return crit;
		
		
	}

}
