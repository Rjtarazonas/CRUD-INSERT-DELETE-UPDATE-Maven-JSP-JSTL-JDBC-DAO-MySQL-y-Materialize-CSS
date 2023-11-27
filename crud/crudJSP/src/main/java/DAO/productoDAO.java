package DAO;

import Model.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class productoDAO extends Conexion {
    
    public ArrayList<Producto> llenarProducto() throws Exception {
        ArrayList<Producto> lista = new ArrayList<Producto>();
        try {
            this.Conectar();
            String query = "Select * from producto";
            PreparedStatement smt = this.getCnx().prepareStatement(query);
            ResultSet rt = smt.executeQuery();
            while (rt.next()) {
                Producto p = new Producto();
                p.setId_producto(rt.getInt("id_producto"));
                p.setNombre_producto(rt.getString("nombre_producto"));
                lista.add(p);

            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconenctar();
        }
        return lista;
    }
    
   
}
