import java.sql.Connection;
import java.sql.DriverManager;

import lina.dbops.db.Database;
import lina.dbops.postgres.Connector;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        try {
            Connection c = Connector.connect("localhost", 5432, "covid", "lina", "123456");
            Database.getTablesName(c, "covid");
            System.out.println("Connection Réussi");
            c.close();
            System.out.println("Connection fermée");
        } catch (Exception ex) {
            System.out.println("Connection echoué");
            ex.printStackTrace();
        }
    }
}
