package mvcfx.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMySQL implements Database{

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_aula?useTimezone=true&serverTimezone=UTC","root","root");                
    }



}
