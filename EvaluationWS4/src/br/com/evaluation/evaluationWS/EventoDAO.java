package br.com.evaluation.evaluationWS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EventoDAO {
	
	public boolean inserirEvento(Evento evento){
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryInserir = "INSERT INTO evento VALUES (null, ?, ?, ?)";
			
			PreparedStatement ppStm = conn.prepareStatement(queryInserir);
			
			ppStm.setString(1, evento.getNome());
			ppStm.setString(2, evento.getEndereco());
			ppStm.setString(3, evento.getInstituicao());
			
			ppStm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	
		public boolean atualizarEvento(Evento evento){
			try {
				Connection conn = ConectaMySql.abreConexao();
				String queryAtualiza = "UPDATE evento SET nome_evento = ?, endereco = ?, instituicao = ? WHERE id_evento = ?";
				
				PreparedStatement ppStm = conn.prepareStatement(queryAtualiza);
				
				ppStm.setString(1, evento.getNome());
				ppStm.setString(2, evento.getEndereco());
				ppStm.setString(3, evento.getInstituicao());
				ppStm.setInt(4, evento.getId_evento());
				
				ppStm.executeUpdate();
				
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}		
			return true;
		}
	
	
	public boolean excluirEvento(int id){
		
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryExcluir = "DELETE FROM evento WHERE id_evento = ?";
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
	
	public ArrayList<Evento> buscarTodosEventos(){
		ArrayList<Evento> lista = new ArrayList<Evento>();
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryBuscarTodos = "SELECT * FROM evento";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarTodos);
				
			
			ResultSet rSet = ppStm.executeQuery();
			
			while(rSet.next()){
				Evento evento = new Evento();
				
				evento.setId_evento(rSet.getInt(1));
				evento.setNome(rSet.getString(2));
				evento.setEndereco(rSet.getString(3));
				evento.setInstituicao(rSet.getString(4));
				
				
				
				lista.add(evento);
			}
			
						
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
	
		}
		
		return lista;
	}
	
	public Evento buscarEventoPorId(int id){
		Evento evento = null;
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryBuscarPorId = "SELECT * FROM evento WHERE id_evento = ?";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarPorId);
				ppStm.setInt(1, id);
			
			ResultSet rSet = ppStm.executeQuery();
			
			if(rSet.next()){
				evento = new Evento();
				evento.setId_evento(rSet.getInt(1));
				evento.setNome(rSet.getString(2));
				evento.setEndereco(rSet.getString(3));
				evento.setInstituicao(rSet.getString(4));
				
			}else{
				return evento;
			}
			
						
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
	
		}		
		
		return evento;
		
		
	}

}
