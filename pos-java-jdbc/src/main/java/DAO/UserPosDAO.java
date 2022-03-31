package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.UserPosjava;

public class UserPosDAO {

	private Connection connection;

	public UserPosDAO() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(UserPosjava userposjava) {
		try {
			String sql = "insert into userposjava (id, nome, email) values (?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setLong(1, userposjava.getId());
			insert.setString(2, userposjava.getNome());
			insert.setString(3, userposjava.getEmail());
			insert.execute();
			connection.commit(); // salva no banco

		} catch (Exception e) {

			try {
				connection.rollback();// reverte operação
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}

	}

	public List<UserPosjava> Listar() throws Exception {

		List<UserPosjava> list = new ArrayList<UserPosjava>();

		String sql = "select * from userposjava";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		while (resultado.next()) {
			UserPosjava userposjava = new UserPosjava();
			userposjava.setId(resultado.getLong("id"));
			userposjava.setNome(resultado.getString("nome"));
			userposjava.setEmail(resultado.getString("email"));
			
			list.add(userposjava);
			
			
		}
		
		return list;
	}
	
	public UserPosjava buscarUmObjeto(Long id) throws Exception {

		UserPosjava userposjava = new UserPosjava();

		String sql = "select * from userposjava where id ="+id;

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		while (resultado.next()) {
			userposjava.setId(resultado.getLong("id"));
			userposjava.setNome(resultado.getString("nome"));
			userposjava.setEmail(resultado.getString("email"));
		}
			
					
		return userposjava;
	}
	
	public void atualizar (UserPosjava userposjava) throws SQLException  {
		
		try {
		
			String sql = "update userposjava set nome = ?  where id= "+userposjava.getId();
		
			PreparedStatement statement  = connection.prepareStatement(sql);
		
			statement.setString(1,userposjava.getNome());
			
			statement.execute();
			connection.commit();
		
		}catch(Exception e) {
			
			connection.rollback();
			
			e.printStackTrace();
		}
		}
		
	}
	
	


