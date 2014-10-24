package br.com.evaluation.evaluationWS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaMySql {
	
	private static final String URL = "jdbc:mysql://localhost/evaluation_form";
	private static final String USER = "root";
	private static final String SENHA = "";
	
	
	public static Connection abreConexao() throws SQLException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		
		return DriverManager.getConnection(URL, USER, SENHA);
	}

}
