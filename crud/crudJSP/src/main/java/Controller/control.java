package Controller;

import DAO.clienteDAO;
import DAO.productoDAO;
import DAO.ventaDAO;
import Model.Cliente;
import Model.Producto;
import Model.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "control", urlPatterns = {"/control"})
public class control extends HttpServlet {

    ventaDAO veDAO;
    clienteDAO clieDAO;
    productoDAO proDAO;

    public control() {
        super();
        veDAO = new ventaDAO();
        clieDAO = new clienteDAO();
        proDAO = new productoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruta = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("inicio")) {
            ruta = "/view/datos.jsp";
            try {
                request.setAttribute("base", veDAO.llenarVenta());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equalsIgnoreCase("nuevo")) {
            ruta = "/view/registro.jsp";
            try {
                request.setAttribute("baseCliente", clieDAO.llenarCliente());
                request.setAttribute("baseProducto", proDAO.llenarProducto());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equalsIgnoreCase("eliminar")) {
            ruta = "/view/datos.jsp";
            try {
                int idEliminar = Integer.parseInt(request.getParameter("id_venta"));
                veDAO.Eliminar(idEliminar);
                request.setAttribute("base", veDAO.llenarVenta());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equalsIgnoreCase("actualizar")) {
            ruta = "/view/datos.jsp";
            try {
                int idActu = Integer.parseInt(request.getParameter("id_venta"));
                request.setAttribute("base", veDAO.llenarPorID(idActu));
                request.setAttribute("baseCliente", clieDAO.llenarCliente());
                request.setAttribute("baseProducto", proDAO.llenarProducto());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        RequestDispatcher rt = request.getRequestDispatcher(ruta);
        rt.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ID = request.getParameter("txtID");
        Cliente cli = new Cliente();
        Producto pro = new Producto();
        Venta ve = new Venta();
        ve.setFecha(request.getParameter("txtFecha"));
        cli.setId_cliente(Integer.parseInt(request.getParameter("cmbCliente")));
        pro.setId_producto(Integer.parseInt(request.getParameter("cmbProducto")));
        ve.setCliente(cli);
        ve.setProducto(pro);

        if (ID == null || ID.isEmpty()) {
            try {
                veDAO.Guardar(ve);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                ve.setId_venta(Integer.parseInt(ID));
                veDAO.Actualizar(ve);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

}
