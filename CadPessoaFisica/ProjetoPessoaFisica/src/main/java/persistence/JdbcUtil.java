package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import persistence.JdbcUtil;

public class JdbcUtil {

	//https://docs.microsoft.com/pt-br/sql/connect/jdbc/using-the-jdbc-driver
    
	
    
  //  private static String connectionDriverClass="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    // private static String connectionDriverClass="com.microsoft.jdbc.sqlserver.SQLServerDriver"; //classnotfoundEx      
   // private static String connectionUrl="jdbc:sqlserver://172.17.0.2:1433;databaseName=bd_pessoafisica";
    // private static String connectionUrl="jdbc:jtds:172.17.0.2:1433;databaseName=bd_pessoafisica;integratedSecurity=true";   

   // private static String connectionUsername="sa";
   // static String connectionPassword="Aluno#123";


    //private static String connectionDriverClass="org.gjt.mm.mysql.Driver";
	
   private static String connectionDriverClass="com.mysql.jdbc.Driver";
    private static String connectionUrl="jdbc:mysql://localhost:3306/bd_pessoafisica";
    private static String connectionUsername="root";
    private static String connectionPassword="";


    
    
	 private static Connection conn;
	 
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		if(JdbcUtil.conn != null) {
			return JdbcUtil.conn;
		}else {
			Class.forName(connectionDriverClass);
			return DriverManager.getConnection(
					JdbcUtil.connectionUrl,
					JdbcUtil.connectionUsername,
					JdbcUtil.connectionPassword);
		}
	}
}
