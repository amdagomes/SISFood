package io.github.fernandasj.views;


import io.github.fernandasj.repository.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author fernanda
 */
public class TestConnection {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        try {
            Connection conn = factory.getConnection();
            JOptionPane.showMessageDialog(null, "Conectado");
            System.out.println("Conectado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha");
            System.out.println(ex);
        }
        
        
    }
}
