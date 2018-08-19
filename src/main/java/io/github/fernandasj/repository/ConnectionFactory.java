package io.github.fernandasj.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fernanda
 */
public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://127.0.0.1:5432/SisFood";
        String user = "postgres";
        String password = "123";
        return DriverManager.getConnection(url, user, password);
    }
}
