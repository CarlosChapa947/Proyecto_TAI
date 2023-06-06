package Datos;

import Modelo.Detalle_Producto_Productos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Detalle_Producto_ProductosDAO {
    Conexion conn;
    PreparedStatement PStatement;
    ResultSet RSet;

    public Detalle_Producto_ProductosDAO() throws SQLException {
        this.conn = new Conexion();
    }

    public Detalle_Producto_ProductosDAO(Connection conn){
        this.conn = new Conexion(conn);
    }

    public void insertDetalleProducto(Detalle_Producto_Productos detalle) throws SQLException {
        String statement = "INSERT INTO \"Proyecto\".\"Detalle_Producto_Productos\" (\"FK_Detalle_Producto\", \"FK_Producto\", \"Cantidad\" )" +
                " VALUES" +
                "(?, ?, ?)";
        PreparedStatement PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setInt(1, detalle.getFK_Detalle_Producto());
        PStatement.setInt(2, detalle.getFK_Producto());
        PStatement.setInt(3, detalle.getCantidad());
        PStatement.executeUpdate();
    }

    public Detalle_Producto_Productos DeleteDetalleProducto(int FK_Detalle_Producto, int FK_Producto) throws SQLException {
        Detalle_Producto_Productos temp=null;
        String statement = "DELETE FROM \"Proyecto\".\"Detalle_Producto_Productos\" WHERE \"FK_Detalle_Producto\" = ? AND " +
                "\"FK_Producto\" = ?; ";
        temp=this.getDetalleProducto(FK_Detalle_Producto, FK_Producto);
        if(temp == null){
            return null;
        }
        PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setInt(1, temp.getFK_Detalle_Producto());
        PStatement.setInt(2, temp.getFK_Producto());
        PStatement.executeUpdate();
        return temp;
    }

    public void updateDetalleProductoCantidad(Detalle_Producto_Productos detalle) throws SQLException {
        PStatement = conn.getConnection().prepareStatement("UPDATE \"Proyecto\".\"Detalle_Producto_Productos\" SET " +
                "\"Cantidad\" = ? WHERE " +
                "\"FK_Detalle_Producto\" = ? AND \"FK_Producto\" = ?;");
        PStatement.setInt(1, detalle.getCantidad());
        PStatement.setInt(2, detalle.getFK_Detalle_Producto());
        PStatement.setInt(3, detalle.getFK_Producto());
        PStatement.executeUpdate();
        return;
    }

    public LinkedList<Detalle_Producto_Productos> getProductoDetalles(int ID_Producto) throws SQLException {
        Detalle_Producto_Productos detalle;
        LinkedList<Detalle_Producto_Productos> temp = new LinkedList<>();
        PStatement = conn.getConnection().prepareStatement("SELECT * FROM ONLY \"Proyecto\".\"Detalle_Producto_Productos\"" +
                "WHERE \"FK_Producto\" = ?;");
        this.PStatement.setInt(1, ID_Producto);
        this.RSet = this.PStatement.executeQuery();
        while (this.RSet.next()){
            detalle = extractDetalleProducto(this.RSet);
            temp.add(detalle);
        }
        PStatement.close();
        RSet.close();
        return temp;
    }

    public LinkedList<Detalle_Producto_Productos> getDetalleProductos(int ID_Detalle) throws SQLException {
        Detalle_Producto_Productos detalle;
        LinkedList<Detalle_Producto_Productos> temp = new LinkedList<>();
        PStatement = conn.getConnection().prepareStatement("SELECT * FROM ONLY \"Proyecto\".\"Detalle_Producto_Productos\"" +
                "WHERE \"FK_Detalle_Producto\" = ?;");
        this.PStatement.setInt(1, ID_Detalle);
        this.RSet = this.PStatement.executeQuery();
        while (this.RSet.next()){
            detalle = extractDetalleProducto(this.RSet);
            temp.add(detalle);
        }
        PStatement.close();
        RSet.close();
        return temp;
    }

    public Detalle_Producto_Productos getDetalleProducto(int FK_Detalle_Producto, int FK_Producto) throws SQLException {
        Detalle_Producto_Productos temp;
        PStatement = conn.getConnection().prepareStatement("SELECT * FROM ONLY \"Proyecto\".\"Detalle_Producto_Productos\"" +
                "WHERE \"FK_Detalle_Producto\" = ? AND \"FK_Producto\" = ?");
        this.PStatement.setInt(1, FK_Detalle_Producto);
        this.PStatement.setInt(2, FK_Producto);
        this.RSet = this.PStatement.executeQuery();
        if(this.RSet.next()){
            temp = extractDetalleProducto(this.RSet);
            PStatement.close();
            RSet.close();
            return temp;
        }
        return null;
    }


    public void closeConn() throws SQLException{
        this.conn.closeConn();
    }

    private Detalle_Producto_Productos extractDetalleProducto(ResultSet rset) throws SQLException {
        return new Detalle_Producto_Productos(rset.getInt("FK_Detalle_Producto"), rset.getInt("FK_Producto"),
                rset.getInt("Cantidad"));
    }

}
