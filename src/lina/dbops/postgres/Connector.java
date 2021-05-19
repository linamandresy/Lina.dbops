package lina.dbops.postgres;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
	public static Connection connect(String host, int port, String dbName, String user, String password)
			throws Exception {
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://" + host + ":" + String.valueOf(port) + "/" + dbName;
		Connection result = DriverManager.getConnection(url, user, password);
		return result;
	}

}
