package uno.database.session;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;
 
public class ConnectionFactory {
    //static reference to itself
    private static ConnectionFactory instance = new ConnectionFactory();
    public static final String URL = "jdbc:oracle:thin:@dbsvcs.cs.uno.edu:1521:orcl";
    public static final String USER = "tdogipar6350A"; // lbunga6350A   //lbunga
    public static final String PASSWORD = "Cho7upei9o"; //ohdieLa4ei  //PbWKJkf4Tq
    public static final String DRIVER_CLASS = "oracle.jdbc.OracleDriver"; 
     
    //private constructor
    private ConnectionFactory() {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
     
    private Connection createConnection() {
        Connection connection = null;
        try {
            //connection = DriverManager.getConnection(URL, USER, PASSWORD);
        	OracleDriver ora = new OracleDriver();
        	connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }   
     
    public static Connection getConnection() {
        return instance.createConnection();
    }
}