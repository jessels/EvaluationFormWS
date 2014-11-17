package br.com.evaluation.evaluationWS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TabelaAvaliativaDAO {
	
	public TabelaAvaliativa inserirTabelaAvaliativa(TabelaAvaliativa tabelaAvaliativa){
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryInserir = "INSERT INTO tabela_avaliativa VALUES (null, ?)";
			
			PreparedStatement ppStm = conn.prepareStatement(queryInserir, PreparedStatement.RETURN_GENERATED_KEYS);
			
			ppStm.setString(1, tabelaAvaliativa.getNome());
			
			
			int affectedRows = ppStm.executeUpdate();
			
			if (affectedRows == 0) {
	            throw new SQLException("Creating user failed, no rows affected.");
	        }

	       
        	ResultSet generatedKeys = ppStm.getGeneratedKeys();
            if (generatedKeys.next()) {
            	tabelaAvaliativa.setId_tabela_av((int)generatedKeys.getLong(1));
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
	       
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
		return tabelaAvaliativa;
	}
	
		public boolean atualizarTabelaAvaliativa(TabelaAvaliativa tabelaAvaliativa){
			try {
				Connection conn = ConectaMySql.abreConexao();
				String queryAtualiza = "UPDATE tabela_avaliativa SET nome_tabela = ? WHERE id_tabela_av = ?";
				
				PreparedStatement ppStm = conn.prepareStatement(queryAtualiza);
				
				ppStm.setString(1, tabelaAvaliativa.getNome());
				ppStm.setInt(2, tabelaAvaliativa.getId_tabela_av());
				
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
				tba.setNome(rSet.getString(2));
				
				
				
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
				tba.setNome(rSet.getString(2));
				
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
