package br.com.evaluation.evaluationWS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AvaliacaoDAO {
	
	
	public boolean inserirAvaliacao(Avaliacao avaliacao){
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryInserir = "INSERT INTO avaliacao VALUES (null, ?, ?, ?, ?)";
			String dateFormatada = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			dateFormatada = sdf.format(avaliacao.getData_av());
			
			
			PreparedStatement ppStm = conn.prepareStatement(queryInserir);
			
			ppStm.setInt(1, avaliacao.getId_avaliador());
			ppStm.setInt(2, avaliacao.getId_projeto());
			ppStm.setInt(3, avaliacao.getId_tabela_av());
			ppStm.setDate(4, new java.sql.Date(avaliacao.getData_av().getTime()));
			
			ppStm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	
		public boolean atualizarAvaliacao(Avaliacao avaliacao){
			try {
				Connection conn = ConectaMySql.abreConexao();
				String queryAtualiza = "UPDATE avaliacao SET id_avaliador = ?, id_projeto = ?, id_tabela_av = ?, "
						+  "data_av = ? WHERE id_avaliacao = ?";
				
				PreparedStatement ppStm = conn.prepareStatement(queryAtualiza);
				
				ppStm.setInt(1, avaliacao.getId_avaliador());
				ppStm.setInt(2, avaliacao.getId_projeto());
				ppStm.setInt(3, avaliacao.getId_tabela_av());
				ppStm.setDate(4, new java.sql.Date(avaliacao.getData_av().getTime()));
				ppStm.setInt(5, avaliacao.getId_avaliacao());
				
				ppStm.executeUpdate();
				
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}		
			return true;
		}
	
	
	public boolean excluirAvaliacao(int id){
		
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryExcluir = "DELETE FROM avaliacao WHERE ID_avaliacao = ?";
			
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
	
	public ArrayList<Avaliacao> buscarTodasAvaliacoes(){
		ArrayList<Avaliacao> lista = new ArrayList<Avaliacao>();
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryBuscarTodos = "SELECT * FROM avaliacao";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarTodos);
				
			
			ResultSet rSet = ppStm.executeQuery();
			
			while(rSet.next()){
				Avaliacao avalia = new Avaliacao();
				
				avalia.setId_avaliacao(rSet.getInt(1));
				avalia.setId_avaliador(rSet.getInt(2));
				avalia.setId_projeto(rSet.getInt(3));
				avalia.setId_tabela_av(rSet.getInt(4));
				avalia.setData_av(rSet.getDate(5));
				
				
				
				lista.add(avalia);
			}
			
						
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
	
		}
		
		return lista;
	}
	
	public Avaliacao buscarAvaliacaoPorId(int id){
		Avaliacao avalia = null;
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryBuscarPorId = "SELECT * FROM avaliacao WHERE ID_avaliacao = ?";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarPorId);
				ppStm.setInt(1, id);
			
			ResultSet rSet = ppStm.executeQuery();
			
			if(rSet.next()){
				avalia = new Avaliacao();
				avalia.setId_avaliacao(rSet.getInt(1));
				avalia.setId_avaliador(rSet.getInt(2));
				avalia.setId_projeto(rSet.getInt(3));
				avalia.setId_tabela_av(rSet.getInt(4));
				avalia.setData_av(rSet.getDate(5));
				
				
			
				
			}else{
				return avalia;
			}
			
						
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
	
		}		
		
		return avalia;
		
		
	}

}
