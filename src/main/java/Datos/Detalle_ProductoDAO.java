package Datos;

import Modelo.Detalle_Producto_Beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Detalle_ProductoDAO {
    Conexion conn;
    PreparedStatement PStatement;
    ResultSet RSet;

    public Detalle_ProductoDAO() throws SQLException {
        this.conn = new Conexion();
    }

    public Detalle_ProductoDAO(Connection conn){
        this.conn = new Conexion(conn);
    }

    public void insertDetalleProducto(Detalle_Producto_Beans detalle) throws SQLException {
        String statement = "INSERT INTO \"Proyecto\".\"Detalle_Producto\" (\"ID_Detalle_Producto\", \"Color\", \"Talla\" )" +
                " VALUES" +
                "(DEFAULT, ?, ?)";
        PreparedStatement PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setString(1, detalle.getColor());
        PStatement.setString(2, detalle.getTalla());
        PStatement.executeUpdate();
    }

    public Detalle_Producto_Beans DeleteDetalleProducto(int ID_Detalle_Producto) throws SQLException {
        Detalle_Producto_Beans temp=null;
        String statement = "DELETE FROM \"Proyecto\".\"Detalle_Producto\" WHERE \"ID_Detalle_Producto\" = ? ";
        temp=this.getDetalleProducto(ID_Detalle_Producto);
        if(temp == null){
            return null;
        }
        PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setInt(1, temp.getID_Detalle_Producto());
        PStatement.executeUpdate();
        return temp;
    }

    public void updateDetalleProducto(Detalle_Producto_Beans detalle) throws SQLException {
        PStatement = conn.getConnection().prepareStatement("UPDATE \"Proyecto\".\"Detalle_Producto\" SET " +
                "\"Color\" = ?, \"Talla\" = ? WHERE " +
                "\"ID_Detalle_Producto\" = ?;");
        PStatement.setString(1, detalle.getColor());
        PStatement.setString(2, detalle.getTalla());
        PStatement.setInt(3, detalle.getID_Detalle_Producto());
        PStatement.executeUpdate();
        return;
    }

    public Detalle_Producto_Beans getDetalleProducto(int ID_Detalle_Producto) throws SQLException {
        Detalle_Producto_Beans direccion;
        PStatement = conn.getConnection().prepareStatement("SELECT * FROM ONLY \"Proyecto\".\"Detalle_Producto\"" +
                "WHERE \"ID_Detalle_Producto\" = ?");
        this.PStatement.setInt(1, ID_Detalle_Producto);
        this.RSet = this.PStatement.executeQuery();
        if(this.RSet.next()){
            direccion = extractDetalleProducto(this.RSet);
            PStatement.close();
            RSet.close();
            return direccion;
        }
        return null;
    }

    public void closeConn() throws SQLException{
        this.conn.closeConn();
    }

    private Detalle_Producto_Beans extractDetalleProducto(ResultSet rset) throws SQLException {
        return new Detalle_Producto_Beans(rset.getInt("ID_Detalle_Producto"), rset.getString("Color"),
                rset.getString("Talla"));
    }

}
