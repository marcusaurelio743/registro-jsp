package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SigleConnection {
	private static String url = "jdbc:postgresql://localhost:5432/registro";
	private static String user = "admin";
	private static String senha = "admin123";
	
	private static Connection connection = null;
	
	static {
		conectar();
	}
	public SigleConnection() {
		conectar();
	}
	
	private static void conectar() {
		try {
			if(connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, senha);
				connection.setAutoCommit(false);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
