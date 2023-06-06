/* Filtro para asegurar las existencias de inventario al momento de querer agregar un producto al carrito
* A futuro seria util para ampliar la funcionalidad del proyecto, pero por el momento lo dejo fuera del scope */

package Controlador;

import Datos.Detalle_Producto_ProductosDAO;
import Modelo.Detalle_Producto_Productos;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter(filterName = "Carrito_Filter", urlPatterns = {"/addToCart", "/updateCart"})
public class Carrito_Filter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        int ID_Producto = Integer.parseInt(request.getParameter("productId"));
        int ID_Detalle = Integer.parseInt(request.getParameter("Detalle_Producto"));
        int Cantidad = Integer.parseInt(request.getParameter("productQuantity"));
        Detalle_Producto_ProductosDAO detalleProductoDAO = null;
        Detalle_Producto_Productos detalleProducto;
        try {
            detalleProductoDAO = new Detalle_Producto_ProductosDAO();
            detalleProducto = detalleProductoDAO.getDetalleProducto(ID_Detalle, ID_Producto);
            if(detalleProducto != null){
                if (Cantidad > detalleProducto.getCantidad()){
                    res.sendRedirect("./viewCart");
                    return;
                }
            } else if (session.getAttribute("currentSessionUser") == null){
                res.sendRedirect("/Login");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        chain.doFilter(request, response);
    }
}
