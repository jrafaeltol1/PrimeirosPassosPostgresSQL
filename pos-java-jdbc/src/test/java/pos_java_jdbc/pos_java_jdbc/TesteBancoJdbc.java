package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import DAO.UserPosDAO;
import conexaojdbc.SingleConnection;
import junit.framework.TestCase;
import model.UserPosjava;

public class TesteBancoJdbc{
	
	@Test
	public void initBanco() {
		UserPosDAO userPosDAO = new UserPosDAO();
		UserPosjava userPosJava = new UserPosjava();
		
		userPosJava.setId(5L);
		userPosJava.setNome("Ricardo");
		userPosJava.setEmail("tesdeDeEmail@email.com");
		
		
		userPosDAO.salvar(userPosJava);
		
			
	}
	
	@Test
	public void initListar() {
		UserPosDAO dao =new UserPosDAO();
		try {
			List<UserPosjava> list = dao.Listar();
			
			for (UserPosjava userPosjava : list) {
				System.out.println(userPosjava);
				System.out.println("--------------------------------");
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
