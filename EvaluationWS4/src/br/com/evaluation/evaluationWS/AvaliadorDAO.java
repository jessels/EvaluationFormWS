package br.com.evaluation.evaluationWS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AvaliadorDAO {
	
	public boolean inserirAvaliador(Avaliador avaliador){
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryInserir = "INSERT INTO avaliador VALUES (null, ?, ?, ?, ?, ?)";
			
			PreparedStatement ppStm = conn.prepareStatement(queryInserir);
			
			ppStm.setString(1, avaliador.getNome());
			ppStm.setString(2, avaliador.getInstituicao());
			ppStm.setString(3, avaliador.getLogin());
			ppStm.setString(4, avaliador.getSenha());
			ppStm.setString(5, avaliador.getTam_camisa());
			
			ppStm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	
		public boolean atualizarAvaliador(Avaliador avaliador){
			try {
				Connection conn = ConectaMySql.abreConexao();
				String queryAtualiza = "UPDATE avaliador SET nome_avaliador = ?, instituicao = ?, login = ?, senha = ?, tamanho_camiseta = ? WHERE id_avaliador = ?";
				
				PreparedStatement ppStm = conn.prepareStatement(queryAtualiza);
				
				ppStm.setString(1, avaliador.getNome());
				ppStm.setString(2, avaliador.getInstituicao());
				ppStm.setString(3, avaliador.getLogin());
				ppStm.setString(4, avaliador.getSenha());
				ppStm.setString(5, avaliador.getTam_camisa());
				ppStm.setInt(6, avaliador.getId_avaliador());
				
				ppStm.executeUpdate();
				
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}		
			return true;
		}
	
	
	public boolean excluirAvaliador(int id){
		
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryExcluir = "DELETE FROM avaliador WHERE id_avaliador = ?";
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
	
	public ArrayList<Avaliador> buscarTodosAdministradores(){
		ArrayList<Avaliador> lista = new ArrayList<Avaliador>();
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryBuscarTodos = "SELECT * FROM avaliador";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarTodos);
				
			
			ResultSet rSet = ppStm.executeQuery();
			
			while(rSet.next()){
				Avaliador avalia = new Avaliador();
				
				avalia.setId_avaliador(rSet.getInt(1));
				avalia.setNome(rSet.getString(2));
				avalia.setInstituicao(rSet.getString(3));
				avalia.setLogin(rSet.getString(4));
				avalia.setSenha(rSet.getString(5));
				avalia.setTam_camisa(rSet.getString(6));
				
				
				lista.add(avalia);
			}
			
						
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
	
		}
		
		return lista;
	}
	
	public Avaliador buscarAvaliadorPorId(int id){
		Avaliador avalia = null;
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryBuscarPorId = "SELECT * FROM avaliador WHERE id_avaliador = ?";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarPorId);
				ppStm.setInt(1, id);
			
			ResultSet rSet = ppStm.executeQuery();
			
			if(rSet.next()){
				avalia = new Avaliador();
				avalia.setId_avaliador(rSet.getInt(1));
				avalia.setNome(rSet.getString(2));
				avalia.setInstituicao(rSet.getString(3));
				avalia.setLogin(rSet.getString(4));
				avalia.setSenha(rSet.getString(5));
				avalia.setTam_camisa(rSet.getString(6));
				
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
