/* Servlet encargado de todo lo relacionado la logica necesaria para el registro e inicio de sesion de usuarios */

package Controlador;

import Datos.Clientes_DAO;
import Modelo.ClientesEntity;
import Modelo.Clientes_Beans;
import Modelo.Carrito_Cliente_Beans;
import Datos.Carrito_Cliente_DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/Login", "/LoginUser", "/Logout", "/SignUp", "/SignUser"}, loadOnStartup = 2)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_path = request.getServletPath(), url;
        switch (user_path){
            case "/SignUp":{
                user_path = "/SignUp";
                url = "./WEB-INF/Vista" + user_path + ".jsp";
                request.getRequestDispatcher(url).forward(request, response);
                break;
            }
            case "/Logout": {
                user_path = "/Home";
                HttpSession session = request.getSession(true);
                session.removeAttribute("currentSessionUser");
                session.removeAttribute("currentCart");
                url = "./WEB-INF/Vista" + user_path + ".jsp";
                request.getRequestDispatcher(url).forward(request, response);
                break;
            }
            case "/Login": {
                user_path = "/Login";
                url = "./WEB-INF/Vista" + user_path + ".jsp";
                request.getRequestDispatcher(url).forward(request, response);
            }
        }
        //url = "./WEB-INF/Vista" + user_path + ".jsp";
        //request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_path = request.getServletPath(), url;
        Clientes_DAO clientesDAO = null;
        Clientes_Beans cliente = null;
        ClientesEntity clientesEntity = null;
        Carrito_Cliente_Beans carrito = null;
        Carrito_Cliente_DAO carritoDAO = null;
        switch (user_path){
            case "/LoginUser":{
                user_path = "/Home";
                try {
                    clientesDAO = new Clientes_DAO();
                    cliente = clientesDAO.loginCliente(request.getParameter("email"), request.getParameter("password"));
                    clientesDAO.closeConn();
                    if (cliente != null) {
                        carritoDAO = new Carrito_Cliente_DAO();
                        HttpSession session = request.getSession(true);
                        session.setAttribute("currentSessionUser", cliente);
                        session.setAttribute("currentCart", carritoDAO.getCarritoCliente(cliente.getID_Clientes()));
                        carritoDAO.closeConn();
                        response.sendRedirect("index.jsp"); //logged-in page
                    }
                    else
                        response.sendRedirect("index.jsp"); //error page
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "/SignUser":{
                try {
                    clientesDAO = new Clientes_DAO();
                    carritoDAO = new Carrito_Cliente_DAO();
                    cliente = clientesDAO.searchCliente(request.getParameter("email"));
                    if(cliente != null){
                        carritoDAO.closeConn();
                        clientesDAO.closeConn();
                        response.sendRedirect("index.jsp");
                    } else {
                        clientesEntity = new ClientesEntity(
                                request.getParameter("Nombres"),
                                request.getParameter("APaterno"),
                                request.getParameter("AMaterno"),
                                request.getParameter("email"),
                                request.getParameter("password")
                        );
                        clientesDAO.HibernateRegisterNewCliente(clientesEntity);
                        clientesEntity = clientesDAO.HibernatesearchCliente(request.getParameter("email"));
                        clientesDAO.closeConn();
                        if (clientesEntity != null) {
                            carrito = new Carrito_Cliente_Beans(cliente.getID_Clientes(), "C");
                            carritoDAO.insertCarrito(carrito);
                            carritoDAO.closeConn();
                        }
                        clientesDAO.closeConn();
                        carritoDAO.closeConn();
                        response.sendRedirect("index.jsp");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //url = "./WEB-INF/Vista" + user_path + ".jsp";
        //request.getRequestDispatcher(url).forward(request, response);
    }
}
