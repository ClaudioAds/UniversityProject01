
package br.com.ifpb.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author claudio
 */
public class Conexao {

    private static final String URL = "jdbc:postgresql://localhost:5432/imc_padroes";
    private static final String USER = "postgres";
    private static final String SENHA = "claudio";

    public static Connection getConnection() {
        try {
            System.out.println("Conexão Realizada com Sucesso!");
            return DriverManager.getConnection(URL, USER, SENHA);

        } catch (SQLException ex) {
            System.out.println("Falha na Conexão!");
            throw new RuntimeException(ex);
        }
    }

    public static void closeConnection(java.sql.Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(java.sql.Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(java.sql.Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
