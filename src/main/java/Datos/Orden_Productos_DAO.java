package Datos;

import Modelo.Orden_Productos_Beans;

import java.sql.*;
import java.util.LinkedList;

public class Orden_Productos_DAO {
    Conexion conn;
    PreparedStatement PStatement;
    ResultSet RSet;

    public Orden_Productos_DAO() throws SQLException {
     this.conn = new Conexion();
    }

    public Orden_Productos_DAO(Connection conn){
        this.conn = new Conexion(conn);
    }

    public void insertOrden(Orden_Productos_Beans orden) throws SQLException {
        String statement = "INSERT INTO \"Proyecto\".\"Orden_Cliente_Productos\" " +
                "(\"Orden_Cliente_ID_Orden_Cliente\", \"Productos_ID_Productos\", \"Detalle_Del_Producto\", \"Cantidad_Orden\", \"Precio_Final\") VALUES" +
                "(?, ?, ?, ?, ?)";
        PreparedStatement PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setInt(1, orden.getID_Orden());
        PStatement.setInt(2, orden.getID_Producto());
        PStatement.setInt(3, orden.getDetalle_Del_Producto());
        PStatement.setInt(4, orden.getCantidad());
        PStatement.setDouble(5, orden.getPrecio_Final());

        PStatement.executeUpdate();
    }

    public Orden_Productos_Beans DeleteOrdenProducto(int ID_Orden, int ID_Producto) throws SQLException {
        Orden_Productos_Beans temp=null;
        String statement = "DELETE FROM \"Proyecto\".\"Orden_Cliente_Productos\" WHERE \"Orden_Cliente_ID_Orden_Cliente\" = ? AND" +
                "\"Productos_ID_Productos\" = ? ";
        temp=this.getOrdenProducto(ID_Orden, ID_Producto);
        if(temp == null){
            return null;
        }
        PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setInt(1, temp.getID_Orden());
        PStatement.setInt(2, temp.getID_Producto());
        PStatement.executeUpdate();
        return temp;
    }

    public void updateOrden(Orden_Productos_Beans orden) throws SQLException {
        PStatement = conn.getConnection().prepareStatement("UPDATE \"Proyecto\".\"Orden_Cliente_Productos\" set " +
                " \"Detalle_Del_Producto\" = ?, \"Cantidad_Orden\" = ?, \"Precio_Final\" = ? WHERE " +
                "\"Orden_Cliente_ID_Orden_Cliente\" = ? and \"Productos_ID_Productos\" = ?;");
        PStatement.setInt(1, orden.getDetalle_Del_Producto());
        PStatement.setInt(2, orden.getCantidad());
        PStatement.setDouble(3, orden.getPrecio_Final());
        PStatement.setInt(4, orden.getID_Orden());
        PStatement.setInt(5, orden.getID_Producto());
        PStatement.executeUpdate();
        return;
    }

    public LinkedList<Orden_Productos_Beans> getOrdenProductos(int ID_Orden) throws SQLException {
        Orden_Productos_Beans orden;
        LinkedList<Orden_Productos_Beans> temp = new LinkedList<>();
        PStatement = conn.getConnection().prepareStatement("SELECT * FROM ONLY \"Proyecto\".\"Orden_Cliente_Productos\"" +
                "WHERE \"Orden_Cliente_ID_Orden_Cliente\" = ?;");
        this.PStatement.setInt(1, ID_Orden);
        this.RSet = this.PStatement.executeQuery();
        while (this.RSet.next()){
            orden = extractOrdenProducto(this.RSet);
            temp.add(orden);
        }
        PStatement.close();
        RSet.close();
        return temp;
    }

    public Orden_Productos_Beans getOrdenProducto(int ID_Orden, int ID_Productos) throws SQLException {
        Orden_Productos_Beans orden;
        PStatement = conn.getConnection().prepareStatement("SELECT * FROM ONLY \"Proyecto\".\"Orden_Cliente_Productos\"" +
                "WHERE \"Orden_Cliente_ID_Orden_Cliente\" = ? and \"Productos_ID_Productos\" = ? ;");
        this.PStatement.setInt(1, ID_Orden);
        this.PStatement.setInt(2, ID_Productos);
        this.RSet = this.PStatement.executeQuery();
        if(this.RSet.next()){
            orden = extractOrdenProducto(this.RSet);
            PStatement.close();
            RSet.close();
            return orden;
        }
        return null;
    }

    public LinkedList<Orden_Productos_Beans> getALLOrdenProductos() throws SQLException {
        Orden_Productos_Beans orden;
        LinkedList<Orden_Productos_Beans> temp = new LinkedList<>();
        PStatement = conn.getConnection().prepareStatement("SELECT * From ONLY \"Proyecto\".\"Orden_Cliente_Productos\";");
        this.RSet = this.PStatement.executeQuery();
        while (this.RSet.next()){
            orden = extractOrdenProducto(this.RSet);
            temp.add(orden);
        }
        PStatement.close();
        RSet.close();
        return temp;
    }

    public void closeConn() throws SQLException{
        this.conn.closeConn();
    }

    private Orden_Productos_Beans extractOrdenProducto(ResultSet rset) throws SQLException {
        return new Orden_Productos_Beans(rset.getInt("Orden_Cliente_ID_Orden_Cliente"),
                rset.getInt("Productos_ID_Productos"),
                rset.getInt("Cantidad_Orden"),rset.getInt("Detalle_Del_Producto"), rset.getInt("Precio_Final"));
    }
}
