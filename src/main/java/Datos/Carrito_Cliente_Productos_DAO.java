package Datos;


import Modelo.Carrito_Cliente_Productos_Beans;
import org.hibernate.Session;

import java.sql.*;
import java.util.LinkedList;
public class Carrito_Cliente_Productos_DAO {
    Conexion conn;
    PreparedStatement PStatement;
    ResultSet RSet;

    public Carrito_Cliente_Productos_DAO() throws SQLException {
        this.conn = new Conexion();
    }

    public Carrito_Cliente_Productos_DAO(Connection conn){
        this.conn = new Conexion(conn);
    }

    public void insertCarritoProducto(Carrito_Cliente_Productos_Beans orden) throws SQLException {
        String statement = "INSERT INTO \"Proyecto\".\"Carrito_Cliente_Productos\" " +
                "(\"Carrito_Cliente_ID_Carrito\", \"Productos_ID_Productos\", \"Detalle_Del_Producto\",\"Cantidad\", \"Precio_Carrito\") VALUES" +
                "(?, ?, ?, ?, ?)";
        PreparedStatement PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setInt(1, orden.getID_Carrito_Cliente());
        PStatement.setInt(2, orden.getID_Producto());
        PStatement.setInt(3, orden.getDetalle_Del_Producto());
        PStatement.setInt(4, orden.getCantidad());
        PStatement.setDouble(5, orden.getPrecio_Carrito());

        PStatement.executeUpdate();
    }

    public Carrito_Cliente_Productos_Beans DeleteCarritoProducto(int ID_Carrito, int ID_Producto, int ID_Detalle) throws SQLException {
        Carrito_Cliente_Productos_Beans temp=null;
        String statement = "DELETE FROM \"Proyecto\".\"Carrito_Cliente_Productos\" WHERE \"Carrito_Cliente_ID_Carrito\" = ? AND " +
                "\"Productos_ID_Productos\" = ? AND \"Detalle_Del_Producto\" = ?";
        temp=this.getCarritoProducto(ID_Carrito, ID_Producto);
        if(temp == null){
            return null;
        }
        PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setInt(1, temp.getID_Carrito_Cliente());
        PStatement.setInt(2, temp.getID_Producto());
        PStatement.setInt(3, temp.getDetalle_Del_Producto());
        PStatement.executeUpdate();
        return temp;
    }

    public void updateCarritoDetalle(int ID_Carrito, int ID_Producto, int Detalle) throws SQLException {
        PStatement = conn.getConnection().prepareStatement("UPDATE \"Proyecto\".\"Carrito_Cliente_Productos\" set " +
                "\"Detalle_Del_Producto\" = ? WHERE " +
                "\"Carrito_Cliente_ID_Carrito\" = ? and \"Productos_ID_Productos\" = ?;");
        PStatement.setInt(1, Detalle);
        PStatement.setInt(2, ID_Carrito);
        PStatement.setInt(3, ID_Producto);
        PStatement.executeUpdate();
    }

    public void updateCarritoCantidad(int ID_Carrito, int ID_Producto, int Cantidad, int ID_Detalle) throws SQLException {
        PStatement = conn.getConnection().prepareStatement("UPDATE \"Proyecto\".\"Carrito_Cliente_Productos\" set " +
                "\"Cantidad\" = ? WHERE " +
                "\"Carrito_Cliente_ID_Carrito\" = ? and \"Productos_ID_Productos\" = ? AND \"Detalle_Del_Producto\" = ?;");
        PStatement.setInt(1, Cantidad);
        PStatement.setInt(2, ID_Carrito);
        PStatement.setInt(3, ID_Producto);
        PStatement.setInt(4, ID_Detalle);
        PStatement.executeUpdate();
    }

    public void HibernateUpdateCarritoProducto(Carrito_Cliente_Productos_Beans orden, int Cantidad){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Carrito_Cliente_Productos_Beans nuevaOrden = session.get(Carrito_Cliente_Productos_Beans.class, orden);
        nuevaOrden.setCantidad(nuevaOrden.getCantidad() + Cantidad);
        session.update(nuevaOrden);
        session.getTransaction().commit();
        session.close();
    }

    public void updateCarritoProducto(Carrito_Cliente_Productos_Beans orden) throws SQLException {
        PStatement = conn.getConnection().prepareStatement("UPDATE \"Proyecto\".\"Carrito_Cliente_Productos\" set " +
                " \"Cantidad\" = ?, \"Precio_Carrito\" = ? WHERE " +
                "\"Carrito_Cliente_ID_Carrito\" = ? and \"Productos_ID_Productos\" = ? AND \"Detalle_Del_Producto\" = ?;");
        PStatement.setInt(1, orden.getCantidad());
        PStatement.setDouble(2, orden.getPrecio_Carrito());
        PStatement.setInt(3, orden.getID_Carrito_Cliente());
        PStatement.setInt(4, orden.getID_Producto());
        PStatement.setInt(5, orden.getDetalle_Del_Producto());
        PStatement.executeUpdate();
        return;
    }

    public Carrito_Cliente_Productos_Beans searchProducto(int ID_Carrito, int ID_Productos, int ID_Detalle) throws SQLException{
        Carrito_Cliente_Productos_Beans orden;
        PStatement = conn.getConnection().prepareStatement("SELECT * FROM ONLY \"Proyecto\".\"Carrito_Cliente_Productos\"" +
                "WHERE \"Carrito_Cliente_ID_Carrito\" = ? and \"Productos_ID_Productos\" = ? AND \"Detalle_Del_Producto\" = ?;");
        this.PStatement.setInt(1, ID_Carrito);
        this.PStatement.setInt(2, ID_Productos);
        this.PStatement.setInt(3, ID_Detalle);
        this.RSet = this.PStatement.executeQuery();
        if(this.RSet.next()){
            orden = extractCarritoCliente(this.RSet);
            PStatement.close();
            RSet.close();
            return orden;
        }
        return null;
    }

    public LinkedList<Carrito_Cliente_Productos_Beans> getCarritoProductos(int ID_Carrito) throws SQLException {
        Carrito_Cliente_Productos_Beans orden;
        LinkedList<Carrito_Cliente_Productos_Beans> temp = new LinkedList<>();
        PStatement = conn.getConnection().prepareStatement("SELECT * FROM ONLY \"Proyecto\".\"Carrito_Cliente_Productos\"" +
                "WHERE \"Carrito_Cliente_ID_Carrito\" = ?;");
        this.PStatement.setInt(1, ID_Carrito);
        this.RSet = this.PStatement.executeQuery();
        while (this.RSet.next()){
            orden = extractCarritoCliente(this.RSet);
            temp.add(orden);
        }
        PStatement.close();
        RSet.close();
        return temp;
    }

    public Carrito_Cliente_Productos_Beans getCarritoProducto(int ID_Carrito, int ID_Productos) throws SQLException {
        Carrito_Cliente_Productos_Beans orden;
        PStatement = conn.getConnection().prepareStatement("SELECT * FROM ONLY \"Proyecto\".\"Carrito_Cliente_Productos\"" +
                "WHERE \"Carrito_Cliente_ID_Carrito\" = ? and \"Productos_ID_Productos\" = ? ;");
        this.PStatement.setInt(1, ID_Carrito);
        this.PStatement.setInt(2, ID_Productos);
        this.RSet = this.PStatement.executeQuery();
        if(this.RSet.next()){
            orden = extractCarritoCliente(this.RSet);
            PStatement.close();
            RSet.close();
            return orden;
        }
        return null;
    }

    public LinkedList<Carrito_Cliente_Productos_Beans> getALLCarritoProductos() throws SQLException {
        Carrito_Cliente_Productos_Beans orden;
        LinkedList<Carrito_Cliente_Productos_Beans> temp = new LinkedList<>();
        PStatement = conn.getConnection().prepareStatement("SELECT * From ONLY \"Proyecto\".\"Carrito_Cliente_Productos\";");
        this.RSet = this.PStatement.executeQuery();
        while (this.RSet.next()){
            orden = extractCarritoCliente(this.RSet);
            temp.add(orden);
        }
        PStatement.close();
        RSet.close();
        return temp;
    }

    public void closeConn() throws SQLException{
        this.conn.closeConn();
    }

    private Carrito_Cliente_Productos_Beans extractCarritoCliente(ResultSet rset) throws SQLException {
        return new Carrito_Cliente_Productos_Beans(rset.getInt("Productos_ID_Productos"),
                rset.getInt("Carrito_Cliente_ID_Carrito"),
                rset.getInt("Cantidad"), rset.getInt("Detalle_Del_Producto"), rset.getDouble("Precio_Carrito"));
    }
}
