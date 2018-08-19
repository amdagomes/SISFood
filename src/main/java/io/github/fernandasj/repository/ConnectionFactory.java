package io.github.fernandasj.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fernanda
 */
public class ConnectionFactory {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
         Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost/Sisfood";
        String user = "postgres";
        String password = "14011997";
        return DriverManager.getConnection(url, user, password);
    }
}
