package lina.dbops.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class Database {
	public static LinkedList<String> getTablesName(Connection c, String dbName) throws Exception {
		String sql = "select table_name from information_schema.tables where table_catalog=? and table_schema='public' and table_type = 'BASE TABLE'";
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setString(1, dbName);
		ResultSet rs = null;
		try {
			rs = pst.executeQuery();
			LinkedList<String> result = new LinkedList<String>();
			while (rs.next())
				result.add(rs.getString(1));
			return result;
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (rs != null && !rs.isClosed())
				rs.close();
		}
	}
}
