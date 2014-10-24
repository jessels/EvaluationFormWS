package br.com.evaluation.evaluationWS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TabelaAvaliativaDAO {
	
	public boolean inserirTabelaAvaliativa(TabelaAvaliativa tabelaAvaliativa){
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryInserir = "INSERT INTO tabela_avaliativa VALUES (null, ?, ?)";
			
			PreparedStatement ppStm = conn.prepareStatement(queryInserir);
			
			ppStm.setInt(1, tabelaAvaliativa.getNota_final());
			ppStm.setInt(2, tabelaAvaliativa.getId_criterio());
			
			
			ppStm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	
		public boolean atualizarTabelaAvaliativa(TabelaAvaliativa tabelaAvaliativa){
			try {
				Connection conn = ConectaMySql.abreConexao();
				String queryAtualiza = "UPDATE tabela_avaliativa SET nota_final = ?, id_criterio = ? WHERE id_tabela_av = ?";
				
				PreparedStatement ppStm = conn.prepareStatement(queryAtualiza);
				
				ppStm.setInt(1, tabelaAvaliativa.getNota_final());
				ppStm.setInt(2, tabelaAvaliativa.getId_criterio());
				ppStm.setInt(3, tabelaAvaliativa.getId_tabela_av());
				
				ppStm.executeUpdate();
				
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}		
			return true;
		}
	
	
	public boolean excluirTabelaAvaliativa(int id){
		
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryExcluir = "DELETE FROM tabela_avaliativa WHERE id_tabela_av = ?";
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
	
	public ArrayList<TabelaAvaliativa> buscarTodasTabelas(){
		ArrayList<TabelaAvaliativa> lista = new ArrayList<TabelaAvaliativa>();
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryBuscarTodos = "SELECT * FROM tabela_avaliativa";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarTodos);
				
			
			ResultSet rSet = ppStm.executeQuery();
			
			while(rSet.next()){
				TabelaAvaliativa tba = new TabelaAvaliativa();
				
				tba.setId_tabela_av(rSet.getInt(1));
				tba.setNota_final(rSet.getInt(2));
				tba.setId_criterio(rSet.getInt(3));
				
				
				lista.add(tba);
			}
			
						
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
	
		}
		
		return lista;
	}
	
	public TabelaAvaliativa buscarTabelaPorId(int id){
		TabelaAvaliativa tba = null;
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryBuscarPorId = "SELECT * FROM tabela_avaliativa WHERE id_tabela_av = ?";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarPorId);
				ppStm.setInt(1, id);
			
			ResultSet rSet = ppStm.executeQuery();
			
			if(rSet.next()){
				tba = new TabelaAvaliativa();
				tba.setId_tabela_av(rSet.getInt(1));
				tba.setNota_final(rSet.getInt(2));
				tba.setId_criterio(rSet.getInt(3));
				
			}else{
				return tba;
			}
			
						
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
	
		}		
		
		return tba;
		
		
	}

}
