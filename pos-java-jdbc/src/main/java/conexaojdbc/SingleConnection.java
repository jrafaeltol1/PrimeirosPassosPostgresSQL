package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	private static String url = "jdbc:postgresql://localhost:5432/posjava";
	private static String password = "Ra190020";
	private static String  user = "postgres";
	private static Connection connection = null;
	
	
	/*Sempre que de qualquer lugar invocar o SingleConnetion esse método será chamado */
	static {
		conectar();
	}
	
	
	/*Construtor chama o método conectar quando invocado*/
	public SingleConnection() {
		conectar();
	}
	
	
	private static void conectar() {
		try {
			/*Conexão é aberto e fechado uma  vez só*/
			/*Sessões são abertas e fechadas várias vezes*/
			if(connection == null) {
				Class.forName("org.postgresql.Driver");//Carrega o driver do banco em questão
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);/*para não salvar automaticamente - para decidir*/
				
				
				
				/*Confirmação de conexão*/
				System.out.println("Conectou com sucesso");
				
				
				
				
			}
			
			
		}catch (Exception e) {
           e.printStackTrace();		}
		
		
	}
	
	public static Connection getConnection() {
		return connection;
		
	}
			
	
	

}
