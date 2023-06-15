/* Listener encargado de cargar cualquier variable o tomar cualquier accion al momento de desplegar el servidos
*  inicializar una sesion, poner un atributo, etc etc, actualmente su uso es nominal, sin embargo seria muy util
*  en caso de querer ampliar el scope del proyecto */

package Controlador;

import Datos.Categorias_DAO;
import Datos.Productos_DAO;
import Modelo.CategoriasEntity;
import Modelo.Categorias_Beans;
import Modelo.Productos_Beans;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

@WebListener
public class TestListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public TestListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        Categorias_DAO cate_DAO=null;
        Productos_DAO produ_DAO=null;
        try {
            String temp = "../../Img/Test2.png";
            cate_DAO = new Categorias_DAO();
            produ_DAO = new Productos_DAO();
            ArrayList<Categorias_Beans> categorias = cate_DAO.HibernateGetCategorias();
            LinkedList<Productos_Beans> productos = produ_DAO.getProductos();
            sce.getServletContext().setAttribute("appCategorias", categorias);
            sce.getServletContext().setAttribute("appProductos", productos);
            sce.getServletContext().setAttribute("ImgPath", temp);
            cate_DAO.closeConn();
            produ_DAO.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
