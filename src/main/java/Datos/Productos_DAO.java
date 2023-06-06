package Datos;

import Modelo.Productos_Beans;
import java.sql.*;
import java.util.LinkedList;

public class Productos_DAO {
    Conexion conn;
    PreparedStatement PStatement;
    ResultSet RSet;

    public Productos_DAO () throws SQLException {
        this.conn = new Conexion();
    }

    public Productos_DAO (Connection conn){
        this.conn = new Conexion(conn);
    }

    public void insertProducto(Productos_Beans producto) throws SQLException {
        String statement = "INSERT INTO \"Proyecto\".\"Productos\" (\"ID_Productos\", \"Nombre\", \"Precio_Unitario\", \"Descripcion\"," +
                "\"Categoria\", \"Image_Name\" ) VALUES" +
                "(DEFAULT, ?, ?, ?, ?, ?)";
        PreparedStatement PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setString(1, producto.getNombre());
        PStatement.setDouble(2, producto.getPrecio_Unitario());
        PStatement.setString(3, producto.getDescripcion());
        PStatement.setInt(4, producto.getFK_Categoria());
        PStatement.setString(5, producto.getImg());
        PStatement.executeUpdate();
    }

    public Productos_Beans DeleteProducto(int ID_Producto) throws SQLException {
        Productos_Beans temp=null;
        String statement = "DELETE FROM \"Proyecto\".\"Productos\" WHERE \"ID_Productos\" = ? ";
        temp=this.getProducto(ID_Producto);
        if(temp == null){
            return null;
        }
        PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setInt(1, temp.getID_Productos());
        PStatement.executeUpdate();
        return temp;
    }

    public void updateProducto(Productos_Beans producto) throws SQLException {
        PStatement = conn.getConnection().prepareStatement("UPDATE \"Proyecto\".\"Productos\" set " +
                "\"Nombre\" = ?, \"Precio_Unitario\" = ?, \"Descripcion\" = ?, \"Categoria\" = ?, \"Image_Name\" = ? WHERE " +
                "\"ID_Productos\" = ?;");
        PStatement.setString(1, producto.getNombre());
        PStatement.setDouble(2, producto.getPrecio_Unitario());
        PStatement.setString(3, producto.getDescripcion());
        PStatement.setInt(4, producto.getFK_Categoria());
        PStatement.setString(5, producto.getImg());
        PStatement.setInt(6, producto.getID_Productos());
        PStatement.executeUpdate();
        return;
    }


    public Productos_Beans getProducto(int ID_Productos) throws SQLException {
        Productos_Beans producto;
        PStatement = conn.getConnection().prepareStatement("SELECT * FROM ONLY \"Proyecto\".\"Productos\"" +
                "WHERE \"ID_Productos\" = ?");
        this.PStatement.setInt(1, ID_Productos);
        this.RSet = this.PStatement.executeQuery();
        if(this.RSet.next()){
            producto = extractProducto(this.RSet);
            PStatement.close();
            RSet.close();
            return producto;
        }
        return null;
    }

    public LinkedList<Productos_Beans> getProductosInCategoria(int ID_Cate) throws SQLException {
        Productos_Beans producto;
        LinkedList<Productos_Beans> temp = new LinkedList<>();
        PStatement = conn.getConnection().prepareStatement("SELECT * From ONLY \"Proyecto\".\"Productos\"" +
                " WHERE \"Categoria\" = ?;");
        PStatement.setInt(1, ID_Cate);
        this.RSet = this.PStatement.executeQuery();
        while (this.RSet.next()){
            producto = extractProducto(this.RSet);
            temp.add(producto);
        }
        PStatement.close();
        RSet.close();
        return temp;
    }

    public LinkedList<Productos_Beans> getProductos() throws SQLException {
        Productos_Beans producto;
        LinkedList<Productos_Beans> temp = new LinkedList<>();
        PStatement = conn.getConnection().prepareStatement("SELECT * From ONLY \"Proyecto\".\"Productos\";");
        this.RSet = this.PStatement.executeQuery();
        while (this.RSet.next()){
            producto = extractProducto(this.RSet);
            temp.add(producto);
        }
        PStatement.close();
        RSet.close();
        return temp;
    }

    public void closeConn() throws SQLException{
        this.conn.closeConn();
    }

    private Productos_Beans extractProducto(ResultSet rset) throws SQLException {
        return new Productos_Beans(rset.getInt("ID_Productos"), rset.getInt("Categoria"),
                rset.getDouble("Precio_Unitario"), rset.getString("Nombre"),
                rset.getString("Descripcion"), rset.getString("Image_Name"));
    }
}
