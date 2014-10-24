package br.com.evaluation.evaluationWS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoriaDAO {
	
	
	public boolean inserirCategoria(Categoria categoria){
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryInserir = "INSERT INTO categoria VALUES (null, ?)";
			
			PreparedStatement ppStm = conn.prepareStatement(queryInserir);
			
			ppStm.setString(1, categoria.getDescricao());
			
			
			ppStm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	
		public boolean atualizarCategoria(Categoria categoria){
			try {
				Connection conn = ConectaMySql.abreConexao();
				String queryAtualiza = "UPDATE categoria SET descricao = ? WHERE id_categoria = ?";
				
				PreparedStatement ppStm = conn.prepareStatement(queryAtualiza);
				ppStm.setString(1, categoria.getDescricao());
				ppStm.setInt(2, categoria.getId_categoria());
				
				
				ppStm.executeUpdate();
				
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}		
			return true;
		}
	
	
	public boolean excluirCategoria(int id){
		
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryExcluir = "DELETE FROM categoria WHERE id_categoria = ?";
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
	
	public ArrayList<Categoria> buscarTodasCategorias(){
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryBuscarTodos = "SELECT * FROM categoria";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarTodos);
				
			
			ResultSet rSet = ppStm.executeQuery();
			
			while(rSet.next()){
				Categoria categ = new Categoria();
				
				categ.setId_categoria(rSet.getInt(1));
				categ.setDescricao(rSet.getString(2));
			
				
				
				lista.add(categ);
			}
			
						
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
	
		}
		
		return lista;
		

}
	public Categoria buscarCategoriaPorId(int id){
		Categoria cat = null;
		try {
			Connection conn = ConectaMySql.abreConexao();
			String queryBuscarPorId = "SELECT * FROM categoria WHERE id_categoria = ?";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarPorId);
				ppStm.setInt(1, id);
			
			ResultSet rSet = ppStm.executeQuery();
			
			if(rSet.next()){
				cat = new Categoria();
				cat.setId_categoria(rSet.getInt(1));
				cat.setDescricao(rSet.getString(2));
				
			}else{
				return cat;
			}
			
						
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
	
		}		
		
		return cat;
		
		
	}
}