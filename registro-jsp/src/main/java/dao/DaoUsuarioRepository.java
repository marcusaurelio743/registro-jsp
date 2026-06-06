package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import connection.SigleConnection;
import model.ModelLogin;

public class DaoUsuarioRepository {
	private Connection connection;
	private static final String  QUERY_INSERT = "INSERT INTO public.model_login (login, senha, nome) VALUES( ?, ?, ?);";
	private static final String QUERY_BUSCAR_TODOS = "SELECT * FROM public.model_login;";
	private static final String QUERY_BUSCAR_DELETAR = "DELETE FROM public.model_login WHERE id = ?;";
	private static final String QUERY_BUSCAR_BY_LOGIN = "SELECT * FROM public.model_login where login = ?;";
	private static final String QUERY_BUSCAR_BY_ID = "SELECT * FROM public.model_login where id = ?;";
	private static final String QUERY_UPDATE = "UPDATE public.model_login SET login=?,senha=?, nome=? WHERE id=?";
	public DaoUsuarioRepository() {
		connection = SigleConnection.getConnection();
	}
	public void salvar(ModelLogin modelLogin) {
		
		try {
			if(modelLogin.isNew()) {
			PreparedStatement statement = connection.prepareStatement(QUERY_INSERT);
			statement.setString(1, modelLogin.getLogin());
			statement.setString(2, modelLogin.getSenha());
			statement.setString(3, modelLogin.getNome());
			statement.execute();
			connection.commit();
			}else {
				PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE);
				statement.setString(1, modelLogin.getLogin());
				statement.setString(2, modelLogin.getSenha());
				statement.setString(3, modelLogin.getNome());
				statement.setLong(4, modelLogin.getId());
				statement.execute();
				connection.commit();
				
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private List<ModelLogin> buscar(String sql,String login){
		List<ModelLogin> users = new ArrayList<ModelLogin>();
			try {
				try(PreparedStatement statement = connection.prepareStatement(sql)){
					if(Objects.nonNull(login)) statement.setString(1, login);
					ResultSet result = statement.executeQuery();
					
					while(result.next()) {
						ModelLogin object = new ModelLogin();
						object.setId(result.getLong("id"));
						object.setLogin(result.getString("login"));
						object.setNome(result.getString("nome"));
						object.setSenha(result.getString("senha"));
						users.add(object);
					}
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return users;
		
	}
	private List<ModelLogin> buscarById(String sql,Long id){
		List<ModelLogin> users = new ArrayList<ModelLogin>();
			try {
				try(PreparedStatement statement = connection.prepareStatement(sql)){
					if(Objects.nonNull(id)) statement.setLong(1,id);
					ResultSet result = statement.executeQuery();
					
					while(result.next()) {
						ModelLogin object = new ModelLogin();
						object.setId(result.getLong("id"));
						object.setLogin(result.getString("login"));
						object.setNome(result.getString("nome"));
						object.setSenha(result.getString("senha"));
						users.add(object);
					}
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return users;
		
	}
	
	public ModelLogin buscarPorLogin(String login) {
		List<ModelLogin> usuarios = buscar(QUERY_BUSCAR_BY_LOGIN,login);
		if(usuarios.isEmpty()) {
			return null;
		}
		return usuarios.get(0);
	}
	public ModelLogin buscarPorId(Long id) {
		List<ModelLogin> usuarios = buscarById(QUERY_BUSCAR_BY_ID,id);
		if(usuarios.isEmpty()) {
			return null;
		}
		return usuarios.get(0);
	}
	
	public List<ModelLogin> buscarTodos(){
		return buscar(QUERY_BUSCAR_TODOS, null);
	}
	
	public void deletar(Long id) {
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_BUSCAR_DELETAR);
			statement.setLong(1, id);
			statement.execute();
			connection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
