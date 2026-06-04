package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SigleConnection;
import model.ModelLogin;

public class DaoLoginRepository {
	private Connection connection;
	private static String QUERY_VALIDA_LOGIN = "select * from model_login where upper(login) =upper( ?) and upper(senha) = upper(?)";
	
	public DaoLoginRepository() {
		connection= SigleConnection.getConnection();
	}
	
	public boolean validarAutenticacao(ModelLogin modelLogin)  {
		try {
		
		PreparedStatement statement = connection.prepareStatement(QUERY_VALIDA_LOGIN);
		statement.setString(1, modelLogin.getLogin());
		statement.setString(2, modelLogin.getSenha());
		
		ResultSet resultado = statement.executeQuery();
		
		if(resultado.next()) {
			return Boolean.TRUE;
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return Boolean.FALSE;
		
	}

}
