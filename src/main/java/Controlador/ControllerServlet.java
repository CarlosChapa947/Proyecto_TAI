/* Servlet encargado de las funciones principales del sitio asi como el modulo de compra y carrito
*  Probablemente deba ser roto en modulos mas pequeños y separar las funciones, pero lo mantengo asi por cuestiones
* legacy */

package Controlador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.websocket.Session;
import java.io.IOException;

import Datos.*;
import Modelo.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

@WebServlet(name = "ControllerServlet", urlPatterns = {"/Categoria", "/addToCart", "/viewCart", "/updateCart", "/checkout",
        "/purchase", "/purchaseHistory"}, loadOnStartup = 1)
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_path = request.getServletPath(), url;

        switch (user_path){
            case "/Categoria":{
                int querystring = 0;
                if(request.getQueryString() != null){
                    querystring = Integer.parseInt(request.getQueryString());
                }
                user_path = "/Categoria";
                try {
                    Categorias_DAO cate_DAO;
                    Productos_DAO produ_DAO;
                    cate_DAO = new Categorias_DAO();
                    produ_DAO = new Productos_DAO();
                    ArrayList<Categorias_Beans> categorias = (ArrayList<Categorias_Beans>) getServletContext().getAttribute("appCategorias");
                    //LinkedList<Categorias_Beans> categorias = cate_DAO.getCategorias();
                    //request.setAttribute("Test", categorias);
                    request.setAttribute("Test2", produ_DAO.getProductosInCategoria(querystring));
                    url = "./WEB-INF/Vista" + user_path + ".jsp";
                    cate_DAO.closeConn();
                    produ_DAO.closeConn();
                    request.getRequestDispatcher(url).forward(request, response);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "/viewCart":{
                user_path = "/ViewCart";
                LinkedList<Carrito_Cliente_Productos_Beans> carritoClienteProductos;
                Productos_Beans productos = new Productos_Beans();
                Carrito_Cliente_Productos_DAO carritoClientePDao;
                HttpSession session = request.getSession();
                Carrito_Cliente_Beans carritoCliente = (Carrito_Cliente_Beans) session.getAttribute("currentCart");
                try {
                    carritoClientePDao = new Carrito_Cliente_Productos_DAO();
                    carritoClienteProductos = carritoClientePDao.getCarritoProductos(carritoCliente.getID_Carrito());
                    session.setAttribute("ListaProductos", carritoClienteProductos);
                    session.setAttribute("ListaProductosDetalle", productos.getProductosinCarrito(carritoClienteProductos));
                    carritoClientePDao.closeConn();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                url = "./WEB-INF/Vista" + user_path + ".jsp";
                request.getRequestDispatcher(url).forward(request, response);
                break;
            }
            case "/checkout":{
                double total = Double.parseDouble(request.getParameter("total_Carrito"));
                request.setAttribute("total", total);
                user_path = "/CheckOut";
                url = "./WEB-INF/Vista" + user_path + ".jsp";
                request.getRequestDispatcher(url).forward(request, response);
                break;
            }
            case "/purchaseHistory":{
                int querystring = 0;
                if(request.getQueryString() != null){
                    querystring = Integer.parseInt(request.getQueryString());
                }
                HttpSession session = request.getSession();
                Clientes_Beans cliente = (Clientes_Beans) session.getAttribute("currentSessionUser");
                Orden_Cliente_Beans orden = null;
                Orden_Cliente_DAO ordenDAO = null;
                Orden_Productos_DAO ordenProductosDAO = null;
                LinkedList<Orden_Cliente_Beans> listaOrdenes = null;
                LinkedList<Orden_Productos_Beans> listaOrdenProductos = null;
                try {
                    ordenDAO = new Orden_Cliente_DAO();
                    listaOrdenes = ordenDAO.searchOrdenesCliente(cliente.getID_Clientes());
                    request.setAttribute("listaOrdenes", listaOrdenes);
                    if (querystring != 0){
                        orden = ordenDAO.getOrden(querystring);
                        request.setAttribute("ordenSeleccionada", orden);
                    }
                    ordenDAO.closeConn();
                } catch (SQLException e) {
                    response.sendRedirect("index.jsp");
                    e.printStackTrace();
                    return;
                }

                try {
                    ordenProductosDAO = new Orden_Productos_DAO();
                    listaOrdenProductos = ordenProductosDAO.getOrdenProductos(querystring);
                    request.setAttribute("listaOrdenProductos", listaOrdenProductos);
                    ordenProductosDAO.closeConn();
                } catch (SQLException e) {
                    response.sendRedirect("index.jsp");
                    e.printStackTrace();
                    return;
                }

                user_path = "/PurchaseHistory";
                url = "./WEB-INF/Vista" + user_path + ".jsp";
                request.getRequestDispatcher(url).forward(request, response);
                break;
            }
        }
        //url = "./WEB-INF/Vista" + user_path + ".jsp";
        //request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_path = request.getServletPath(), url;

        switch (user_path){
            case "/addToCart":{
                int ID_Producto = Integer.parseInt(request.getParameter("productId"));
                int ID_Detalle = Integer.parseInt(request.getParameter("Detalle_Producto"));
                int Cantidad = Integer.parseInt(request.getParameter("productQuantity"));
                Carrito_Cliente_Beans carritoCliente;
                Carrito_Cliente_Productos_Beans productInCar;
                Carrito_Cliente_Productos_DAO productosCarritoDao;
                Productos_Beans producto;
                Productos_DAO productosDao;
                HttpSession session = request.getSession();
                if(session.getAttribute("currentSessionUser") == null){
                    user_path = "/Home";
                    url = "/WEB-INF/vista" + user_path + ".jsp";
                    response.sendRedirect("Login");
                    break;
                }
                try {
                    productosCarritoDao = new Carrito_Cliente_Productos_DAO();
                    carritoCliente = (Carrito_Cliente_Beans) session.getAttribute("currentCart");
                    productosDao = new Productos_DAO();
                    producto = productosDao.getProducto(ID_Producto);
                    productInCar = productosCarritoDao.searchProducto(carritoCliente.getID_Carrito(), ID_Producto, ID_Detalle);
                    if(productInCar != null){
                        //productInCar.setCantidad(productInCar.getCantidad() + Cantidad);
                        productosCarritoDao.HibernateUpdateCarritoProducto(productInCar, Cantidad);
                    } else {
                        productInCar = new Carrito_Cliente_Productos_Beans(ID_Producto, carritoCliente.getID_Carrito(),Cantidad, ID_Detalle, producto.getPrecio_Unitario());
                        productosCarritoDao.insertCarritoProducto(productInCar);
                    }
                    productosCarritoDao.closeConn();
                    productosDao.closeConn();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                response.sendRedirect("Categoria");
                break;
            }
            case "/updateCart":{
                HttpSession session = request.getSession();
                Carrito_Cliente_Productos_Beans carritoProducto;
                Carrito_Cliente_Productos_DAO carritoDAO;
                Carrito_Cliente_Beans carritoCliente = (Carrito_Cliente_Beans) session.getAttribute("currentCart");
                int ID_Producto = Integer.parseInt(request.getParameter("productId"));
                int cantidad = Integer.parseInt(request.getParameter("productQuantity"));
                int ID_Detalle = Integer.parseInt(request.getParameter("Detalle_Producto"));
                try {
                    carritoDAO = new Carrito_Cliente_Productos_DAO();
                    if(cantidad <= 0){
                        carritoDAO.DeleteCarritoProducto(carritoCliente.getID_Carrito(), ID_Producto, ID_Detalle);
                    } else {
                        carritoDAO.updateCarritoCantidad(carritoCliente.getID_Carrito(), ID_Producto, cantidad, ID_Detalle);
                    }
                    //user_path = "/viewCart";
                   // url = user_path ;
                    //request.getRequestDispatcher("./viewCart").forward(request, response);
                    carritoDAO.closeConn();
                    response.sendRedirect("./viewCart");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "/purchase":{
                user_path = "/confirmation";
                int confirmacion = 4;
                double total = Double.parseDouble(request.getParameter("total_Final"));
                HttpSession session = request.getSession();
                Clientes_Beans cliente = (Clientes_Beans) session.getAttribute("currentSessionUser");
                Carrito_Cliente_Beans carritoCliente = (Carrito_Cliente_Beans) session.getAttribute("currentCart");
                Carrito_Cliente_DAO carritoClienteDao = null;
                Forma_Pago_Beans Pago = (Forma_Pago_Beans) request.getAttribute("Detalle_Pago");
                Direcciones_Beans Direccion = (Direcciones_Beans) request.getAttribute("Direccion_Compra");
                LinkedList<Carrito_Cliente_Productos_Beans> productosInCart = null;
                Orden_Productos_Beans productosInOrden = null;
                Orden_Productos_DAO productosInOrdenDAO = null;
                Detalle_Producto_ProductosDAO detalleProductoDAO;
                Detalle_Producto_Productos detalleProducto;
                Productos_Beans producto;
                Timestamp time = new Timestamp(System.currentTimeMillis());
                Orden_Cliente_Beans orden = new Orden_Cliente_Beans(cliente.getID_Clientes(), confirmacion, Direccion.getID_Direcciones(),
                        total, "Registrada", time, Pago.getID_Forma_Pago());

                try {
                    Orden_Cliente_DAO ordenDAO = new Orden_Cliente_DAO();
                    ordenDAO.insertOrden(orden);
                    orden = ordenDAO.searchOrden(orden.getNum_Confirmacion(), orden.getFK_Cliente_O(), orden.getFecha());
                    ordenDAO.closeConn();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    productosInOrdenDAO = new Orden_Productos_DAO();
                    Productos_DAO temp= new Productos_DAO();
                    detalleProductoDAO = new Detalle_Producto_ProductosDAO();
                    Carrito_Cliente_Productos_DAO carritoProductosDAO = new Carrito_Cliente_Productos_DAO();
                    productosInCart = carritoProductosDAO.getCarritoProductos(carritoCliente.getID_Carrito());
                    for (Carrito_Cliente_Productos_Beans i: productosInCart){
                        productosInOrden = new Orden_Productos_Beans(orden.getID_Orden_Cliente(), i.getID_Producto(), i.getCantidad(),
                                i.getDetalle_Del_Producto(), i.getPrecio_Carrito());
                        producto = temp.getProducto(i.getID_Producto());
                        productosInOrdenDAO.insertOrden(productosInOrden);
                        detalleProducto = detalleProductoDAO.getDetalleProducto(i.getDetalle_Del_Producto(), i.getID_Producto());
                        detalleProducto.setCantidad(detalleProducto.getCantidad() - i.getCantidad());
                        detalleProductoDAO.updateDetalleProductoCantidad(detalleProducto);
                    }
                    productosInOrdenDAO.closeConn();
                    temp.closeConn();
                    carritoProductosDAO.closeConn();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    carritoClienteDao = new Carrito_Cliente_DAO();
                    carritoClienteDao.clearCarrito(carritoCliente.getID_Carrito());
                    carritoClienteDao.closeConn();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                response.sendRedirect("index.jsp");
                break;
            }
        }
        //url = "/WEB-INF/vista" + user_path + ".jsp";
        //request.getRequestDispatcher(url).forward(request, response);
    }
}
