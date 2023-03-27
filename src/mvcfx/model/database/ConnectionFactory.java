package mvcfx.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    private static Connection connection;
    private static Database database;

    public static void createDatabase(Database db) {
        database = db;
    }    
    
    public static Connection getConnection() {
        if(connection == null){
            try {
                connection = database.getConnection();                
            } catch (SQLException  ex) {            
                System.out.println(ex);
            }
        }
        return connection;
    }
    
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
