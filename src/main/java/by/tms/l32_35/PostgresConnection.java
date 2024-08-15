package by.tms.l32_35;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {
    public static Connection getConnection() throws SQLException {
       return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "bigbase");
    }
}