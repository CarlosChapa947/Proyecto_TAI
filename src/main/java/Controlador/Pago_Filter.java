/* Filtro desplegado al momento de querer registrar una orden, idealmente se usaria para cuestiones de validacion
*  seguridad, etc, pero por el momento su funcion principal es el registro o validacion de la direccion y forma de pago a utilizar
* en la base da datos debido a la falta de una pagina dedicada a ello
* Tambien fue añadida una funcion de validacion para asegurarse que al momento de queres registrar la orden, se cuente con
* suficientes productos en el inventario*/

package Controlador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedList;

import Datos.*;
import Modelo.*;

@WebFilter(filterName = "Pago_Filter", urlPatterns = {"/purchase"})
public class Pago_Filter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        Clientes_Beans cliente = (Clientes_Beans) session.getAttribute("currentSessionUser");
        Carrito_Cliente_Beans carritoCliente;
        Forma_Pago_Beans detPago = null;
        Forma_Pago_Dao detPagoDAO = null;
        Direcciones_DAO direccionDAO=null;
        Carrito_Cliente_Productos_DAO carritoProductosDAO = null;
        Detalle_Producto_ProductosDAO detalleProductosDAO;
        Detalle_Producto_Productos detalleProductos;
        Direcciones_Beans direccion = new Direcciones_Beans(cliente.getID_Clientes(), request.getParameter("Codigo-Postal"),
                request.getParameter("address"));
        LinkedList<Carrito_Cliente_Productos_Beans> productosInCart = null;
        try {
            carritoProductosDAO = new Carrito_Cliente_Productos_DAO();
            detalleProductosDAO = new Detalle_Producto_ProductosDAO();
            carritoCliente = (Carrito_Cliente_Beans) session.getAttribute("currentCart");
            productosInCart = carritoProductosDAO.getCarritoProductos(carritoCliente.getID_Carrito());
            carritoProductosDAO.closeConn();
            for (Carrito_Cliente_Productos_Beans i: productosInCart){
                detalleProductos = detalleProductosDAO.getDetalleProducto(i.getDetalle_Del_Producto(), i.getID_Producto());
                if (i.getCantidad() > detalleProductos.getCantidad()){
                    detalleProductosDAO.closeConn();
                    res.sendRedirect("./viewCart");
                    return;
                }
            }
            detalleProductosDAO.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Direcciones_Beans direccionTemp=null;
            direccionDAO = new Direcciones_DAO();
            direccionTemp = direccionDAO.searchDireccion(direccion.getCodigo_Postal(), direccion.getDireccion());
            if (direccionTemp == null){
                direccionDAO.insertDireccion(direccion);
                direccionTemp = direccionDAO.searchDireccion(direccion.getCodigo_Postal(), direccion.getDireccion());
            }
            request.setAttribute("Direccion_Compra", direccionTemp);
            direccionDAO.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        detPago = new Forma_Pago_Beans(cliente.getID_Clientes(), request.getParameter("creditcard"),
                request.getParameter("Tipo-Pago"), request.getParameter("Proveedor"), Date.valueOf(request.getParameter("Expiracion")+"-01"));
        try {
            Forma_Pago_Beans PagoTemp=null;
            detPagoDAO = new Forma_Pago_Dao();
            PagoTemp = detPagoDAO.searchForma(detPago.getNum_Cuenta(), detPago.getExpiracion());
            if (PagoTemp == null){
                detPagoDAO.insertForma(detPago);
                PagoTemp = detPagoDAO.searchForma(detPago.getNum_Cuenta(), detPago.getExpiracion());
            }
            request.setAttribute("Detalle_Pago", PagoTemp);
            detPagoDAO.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        chain.doFilter(request, response);
    }
}
