package DAO;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static String bd = "Panaderianena";
    private static String user = "root";
    private static String pass = "root123";
    private static String ruta = "jdbc:mysql://localhost:3307/" + bd;

    private Connection cnx;

    public Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }

    public void Conectar() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.cnx = (Connection) DriverManager.getConnection(ruta, user, pass);
            if (this.cnx != null) {
                System.out.println("Conectado Correctamente");
            } else {
                System.out.println("Error de Conexion");
            }
        } catch (SQLException e) {
        }
    }
    public void Desconenctar() throws Exception

    {
        try {
            if (this.cnx != null) {
                if (this.cnx.isClosed() != true) {
                    this.cnx.close();
                }
            }
        } catch (SQLException e) {
        }
    }
}
