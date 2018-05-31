
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
public class ConexaoMySql {

    private static final String URL = "jdbc:mysql://localhost:3306/imc_padroes";
    private static final String USER = "root";
    private static final String SENHA = "companheirismo";

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
            Logger.getLogger(ConexaoMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(java.sql.Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(java.sql.Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
