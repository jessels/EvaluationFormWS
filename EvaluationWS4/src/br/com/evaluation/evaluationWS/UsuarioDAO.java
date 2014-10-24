	package br.com.evaluation.evaluationWS;
	
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	
	
	
	public class UsuarioDAO {
		
		public boolean inserirUsuario(Usuario usuario){
			try {
				Connection conn = ConectaMySql.abreConexao();
				String queryInserir = "INSERT INTO usuario VALUES (null, ?, ?, ?)";
				
				PreparedStatement ppStm = conn.prepareStatement(queryInserir);
				
				ppStm.setString(1, usuario.getNome());
				ppStm.setString(2, usuario.getLogin());
				ppStm.setString(3, usuario.getSenha());
				
				ppStm.executeUpdate();
				
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}		
			return true;
		}
		
			public boolean atualizarUsuario(Usuario usuario){
				try {
					Connection conn = ConectaMySql.abreConexao();
					String queryAtualiza = "UPDATE usuario SET nome = ?, login = ?, senha = ? WHERE id_user = ?";
					
					PreparedStatement ppStm = conn.prepareStatement(queryAtualiza);
					
					ppStm.setString(1, usuario.getNome());
					ppStm.setString(2, usuario.getLogin());
					ppStm.setString(3, usuario.getSenha());
					ppStm.setInt(4, usuario.getId());
					
					ppStm.executeUpdate();
					
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}		
				return true;
			}
		
		
		public boolean excluirUsuario(int id){
			
			try {
				Connection conn = ConectaMySql.abreConexao();
				String queryExcluir = "DELETE FROM usuario WHERE id_user = ?";
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
		
		public ArrayList<Usuario> buscarTodosUsuarios(){
			ArrayList<Usuario> lista = new ArrayList<Usuario>();
			try {
				Connection conn = ConectaMySql.abreConexao();
				String queryBuscarTodos = "SELECT * FROM usuario";
				
				PreparedStatement ppStm = conn.prepareStatement(queryBuscarTodos);
					
				
				ResultSet rSet = ppStm.executeQuery();
				
				while(rSet.next()){
					Usuario usr = new Usuario();
					
					usr.setId(rSet.getInt(1));
					usr.setNome(rSet.getString(2));
					usr.setLogin(rSet.getString(3));
					usr.setSenha(rSet.getString(4));
					
					
					lista.add(usr);
				}
				
							
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
		
			}
			
			return lista;
		}
		
		public Usuario buscarUsuarioPorId(int id){
			Usuario usr = null;
			try {
				Connection conn = ConectaMySql.abreConexao();
				String queryBuscarPorId = "SELECT * FROM usuario WHERE id_user = ?";
				
				PreparedStatement ppStm = conn.prepareStatement(queryBuscarPorId);
					ppStm.setInt(1, id);
				
				ResultSet rSet = ppStm.executeQuery();
				
				if(rSet.next()){
					usr = new Usuario();
					usr.setId(rSet.getInt(1));
					usr.setNome(rSet.getString(2));
					usr.setLogin(rSet.getString(3));
					usr.setSenha(rSet.getString(4));
					
				}else{
					return usr;
				}
				
							
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
		
			}		
			
			return usr;
			
			
		}
		public Usuario buscarUsuarioPorLogin(String login){
			Usuario usr = null;
			try {
				Connection conn = ConectaMySql.abreConexao();
				String queryBuscarPorId = "SELECT * FROM usuario WHERE login = ?";
				
				PreparedStatement ppStm = conn.prepareStatement(queryBuscarPorId);
					ppStm.setString(1, login);
				
				ResultSet rSet = ppStm.executeQuery();
				
				if(rSet.next()){
					usr = new Usuario();
					usr.setId(rSet.getInt(1));
					usr.setNome(rSet.getString(2));
					usr.setLogin(rSet.getString(3));
					usr.setSenha(rSet.getString(4));
					
				}else{
					return usr;
				}
				
							
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
		
			}		
			
			return usr;
			
		}
	}
