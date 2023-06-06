package Datos;

import Modelo.Carrito_Cliente_Beans;

import java.sql.*;
import java.util.LinkedList;

public class Carrito_Cliente_DAO {
    Conexion conn;
    PreparedStatement PStatement;
    ResultSet RSet;

    public Carrito_Cliente_DAO() throws SQLException {
        this.conn = new Conexion();
    }

    public Carrito_Cliente_DAO(Connection conn){
        this.conn = new Conexion(conn);
    }

    public void insertCarrito(Carrito_Cliente_Beans orden) throws SQLException {
        String statement = "INSERT INTO \"Proyecto\".\"Carrito_Cliente\" " +
                "(\"ID_Carrito\", \"FK_Cliente\", \"Status\") VALUES" +
                "(DEFAULT, ?, ?)";
        PreparedStatement PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setInt(1, orden.getFK_Cliente());
        PStatement.setString(2, orden.getStatus());

        PStatement.executeUpdate();
    }

    public Carrito_Cliente_Beans DeleteCarrioto(int ID_Carrito) throws SQLException {
        Carrito_Cliente_Beans temp=null;
        String statement = "DELETE FROM \"Proyecto\".\"Carrito_Cliente\" WHERE \"ID_Carrito\" = ? ";
        temp=this.getCarrito(ID_Carrito);
        if(temp == null){
            return null;
        }
        PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setInt(1, temp.getID_Carrito());
        PStatement.executeUpdate();
        return temp;
    }

    public void updateCarrito(Carrito_Cliente_Beans orden) throws SQLException {
        PStatement = conn.getConnection().prepareStatement("UPDATE \"Proyecto\".\"Carrito_Cliente\" set " +
                "\"FK_Cliente\" = ?, \"Status\" = ? WHERE " +
                "\"ID_Carrito\" = ?;");
        PStatement.setDouble(1, orden.getFK_Cliente());
        PStatement.setString(2, orden.getStatus());
        PStatement.setInt(3, orden.getID_Carrito());
        PStatement.executeUpdate();
        return;
    }

    public Carrito_Cliente_Beans getCarrito(int ID_Carrito) throws SQLException {
        Carrito_Cliente_Beans orden;
        PStatement = conn.getConnection().prepareStatement("SELECT * FROM ONLY \"Proyecto\".\"Carrito_Cliente\"" +
                "WHERE \"ID_Carrito\" = ?");
        this.PStatement.setInt(1, ID_Carrito);
        this.RSet = this.PStatement.executeQuery();
        if(this.RSet.next()){
            orden = extractCarritoCliente(this.RSet);
            PStatement.close();
            RSet.close();
            return orden;
        }
        return null;
    }

    public void clearCarrito(int ID_Carrito) throws SQLException {
        PStatement = conn.getConnection().prepareStatement("DELETE FROM \"Proyecto\".\"Carrito_Cliente_Productos\"" +
                "WHERE \"Carrito_Cliente_ID_Carrito\" = ?");
        this.PStatement.setInt(1, ID_Carrito);
        this.PStatement.executeUpdate();
    }

    public Carrito_Cliente_Beans getCarritoCliente(int ID_Cliente) throws SQLException {
        Carrito_Cliente_Beans orden;
        PStatement = conn.getConnection().prepareStatement("SELECT * FROM ONLY \"Proyecto\".\"Carrito_Cliente\"" +
                "WHERE \"FK_Cliente\" = ?");
        this.PStatement.setInt(1, ID_Cliente);
        this.RSet = this.PStatement.executeQuery();
        if(this.RSet.next()){
            orden = extractCarritoCliente(this.RSet);
            PStatement.close();
            RSet.close();
            return orden;
        }
        return null;
    }

    public LinkedList<Carrito_Cliente_Beans> getCarritoClientes() throws SQLException {
        Carrito_Cliente_Beans orden;
        LinkedList<Carrito_Cliente_Beans> temp = new LinkedList<>();
        PStatement = conn.getConnection().prepareStatement("SELECT * From ONLY \"Proyecto\".\"Carrito_Cliente\";");
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

    private Carrito_Cliente_Beans extractCarritoCliente(ResultSet rset) throws SQLException {
        return new Carrito_Cliente_Beans(rset.getInt("ID_Carrito"), rset.getInt("FK_Cliente"),
                rset.getString("Status"));
    }
}
