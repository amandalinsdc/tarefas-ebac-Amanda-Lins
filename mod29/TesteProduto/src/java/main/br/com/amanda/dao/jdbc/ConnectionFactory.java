/**
 * 
 */
package br.com.amanda.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author rodrigo.pires
 *
 */
public class ConnectionFactory {

	
	private static Connection connection;
	
	private ConnectionFactory(Connection connection) {
		
	}
	
	public static Connection getConnection() throws SQLException {
		if (connection == null) {
			connection = initConnection();
			return connection;
		} else if (connection!= null && connection.isClosed()) {
			connection = initConnection();
			return connection;
		} else {
			return connection;
		}
	}

	private static Connection initConnection() {
		try {
            return DriverManager.getConnection(
            		"jdbc:mysql://localhost:3306/vendas_online_test", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
}
