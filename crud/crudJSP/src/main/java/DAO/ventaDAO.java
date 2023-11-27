package DAO;

import Model.Cliente;
import Model.Producto;
import Model.Venta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ventaDAO extends Conexion {

    public void Eliminar(int id_venta) throws Exception{
        try {
            this.Conectar();
            String query = "Delete from venta where id_venta=?";
            PreparedStatement smt = this.getCnx().prepareStatement(query);
            smt.setInt(1, id_venta);
            smt.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Desconenctar();
        }
    }
    public void Actualizar(Venta ve) throws Exception{
        try {
            this.Conectar();
            String query = "Update venta set fecha=?,id_cliente=?,id_product=? where id_venta=?";
            PreparedStatement smt = this.getCnx().prepareStatement(query);
            smt.setString(1, ve.getFecha());
            smt.setInt(2, ve.getCliente().getId_cliente());
            smt.setInt(3, ve.getProducto().getId_producto());
            smt.setInt(4,ve.getId_venta());
            smt.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Desconenctar();
        }
    }
    public void Guardar(Venta ve) throws Exception{
        try {
            this.Conectar();
            String query = "Insert into venta (fecha,id_cliente,id_producto) values (?,?,?)";
            PreparedStatement smt = this.getCnx().prepareStatement(query);
            smt.setString(1, ve.getFecha());
            smt.setInt(2, ve.getCliente().getId_cliente());
            smt.setInt(3, ve.getProducto().getId_producto());
            smt.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Desconenctar();
        }
    }
    public ArrayList<Venta> llenarVenta() throws Exception {
        ArrayList<Venta> lista = new ArrayList<Venta>();
        try {
            this.Conectar();
            String query = "select v.id_venta,v.fecha,c.nombre,c.apellido,p.nombre_producto from venta v\n"
                    + "inner join cliente c on c.id_cliente = v.id_cliente\n"
                    + "inner join producto p on p.id_producto = v.id_producto";
            PreparedStatement smt = this.getCnx().prepareStatement(query);
            ResultSet rt = smt.executeQuery();
            while (rt.next()) {
                Venta v = new Venta();
                Producto p = new Producto();
                Cliente c = new Cliente();
                v.setId_venta(rt.getInt("v.id_venta"));
                v.setFecha(rt.getString("v.fecha"));
                c.setNombre(rt.getString("c.nombre"));
                c.setApellido(rt.getString("c.apellido"));
                p.setNombre_producto(rt.getString("p.nombre_producto"));
                v.setCliente(c);
                v.setProducto(p);
                lista.add(v);
            }
        } catch (Exception e){
            throw e;
        }finally {
            this.Desconenctar();
        }
        return lista;
    }
    
    public Venta llenarPorID(int idBus) throws Exception{
        Venta ve = new Venta();
        try {
            this.Conectar();
            String query = "Select * from venta where id_venta= ?";
            PreparedStatement smt = this.getCnx().prepareStatement(query);
            smt.setInt(1, idBus);
            ResultSet rt = smt.executeQuery();
            while(rt.next()){
                Cliente c = new Cliente();
                Producto p = new Producto();
                ve.setId_venta(rt.getInt("id_venta"));
                ve.setFecha(rt.getString("fecha"));
                c.setId_cliente(rt.getInt("id_cliente"));
                p.setId_producto(rt.getInt("id_grado"));
                ve.setCliente(c);
                ve.setProducto(p);
                
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Desconenctar();
        }
        return ve;
    }
}
