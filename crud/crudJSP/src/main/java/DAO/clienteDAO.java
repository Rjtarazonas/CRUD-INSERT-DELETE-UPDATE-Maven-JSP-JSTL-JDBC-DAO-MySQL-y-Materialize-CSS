package DAO;

import Model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class clienteDAO extends Conexion {

    public ArrayList<Cliente> llenarCliente() throws Exception {
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        try {
            this.Conectar();
            String query = "Select * from cliente";
            PreparedStatement smt = this.getCnx().prepareStatement(query);
            ResultSet rt = smt.executeQuery();
            while (rt.next()) {
                Cliente c = new Cliente();
                c.setId_cliente(rt.getInt("id_cliente"));
                c.setNombre(rt.getString("nombre"));
                c.setApellido(rt.getString("apellido"));
                lista.add(c);

            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconenctar();
        }
        return lista;
    }

}
