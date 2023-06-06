package Datos;

import Modelo.Orden_Cliente_Beans;
import java.sql.*;
import java.util.LinkedList;

public class Orden_Cliente_DAO {
    Conexion conn;
    PreparedStatement PStatement;
    ResultSet RSet;

    public Orden_Cliente_DAO() throws SQLException {
        this.conn = new Conexion();
    }

    public Orden_Cliente_DAO (Connection conn){
        this.conn = new Conexion(conn);
    }

    public void insertOrden(Orden_Cliente_Beans orden) throws SQLException {
        String statement = "INSERT INTO \"Proyecto\".\"Orden_Cliente\" " +
                "(\"ID_Orden_Cliente\", \"Total\", \"Fecha_Ultima_A\", \"Num_Confirmacion\", \"Status\", \"FK_Cliente_OC\", \"Direccion\", " +
                " \"Detalles_Pago\") VALUES" +
                "(DEFAULT, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setDouble(1, orden.getTotal());
        PStatement.setTimestamp(2, orden.getFecha());
        PStatement.setInt(3, orden.getNum_Confirmacion());
        PStatement.setString(4, orden.getStatus());
        PStatement.setInt(5, orden.getFK_Cliente_O());
        PStatement.setInt(6, orden.getFK_Direccion());
        PStatement.setInt(7, orden.getDetalle_Pago());

        PStatement.executeUpdate();
    }

    public Orden_Cliente_Beans DeleteOrdenCliente(int ID_Orden) throws SQLException {
        Orden_Cliente_Beans temp=null;
        String statement = "DELETE FROM \"Proyecto\".\"Orden_Cliente\" WHERE \"ID_Orden_Cliente\" = ? ";
        temp=this.getOrden(ID_Orden);
        if(temp == null){
            return null;
        }
        PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setInt(1, temp.getID_Orden_Cliente());
        PStatement.executeUpdate();
        return temp;
    }

    public void updateOrden(Orden_Cliente_Beans orden) throws SQLException {
        PStatement = conn.getConnection().prepareStatement("UPDATE \"Proyecto\".\"Orden_Cliente\" set " +
                "\"Total\" = ?, \"Fecha_Ultima_A\" = ?, \"Num_Confirmacion\" = ?, \"Status\" = ?, \"FK_Cliente_OC\" = ?,  \"Direccion\" = ?, " +
                "\"Detalles_Pago\" = ? WHERE " +  "\"ID_Orden_Cliente\" = ?;");
        PStatement.setDouble(1, orden.getTotal());
        PStatement.setTimestamp(2, orden.getFecha());
        PStatement.setInt(3, orden.getNum_Confirmacion());
        PStatement.setString(4, orden.getStatus());
        PStatement.setInt(5, orden.getFK_Cliente_O());
        PStatement.setInt(6, orden.getFK_Direccion());
        PStatement.setInt(7, orden.getDetalle_Pago());
        PStatement.setInt(8, orden.getID_Orden_Cliente());
        PStatement.executeUpdate();
        return;
    }

    public Orden_Cliente_Beans searchOrden(int Num_Confirmacion, int Cliente, Timestamp time) throws SQLException {
        Orden_Cliente_Beans orden;
        PStatement = conn.getConnection().prepareStatement("SELECT * FROM ONLY \"Proyecto\".\"Orden_Cliente\"" +
                "WHERE \"Num_Confirmacion\" = ? AND \"FK_Cliente_OC\" = ? AND \"Fecha_Ultima_A\" = ? ");
        this.PStatement.setInt(1, Num_Confirmacion);
        this.PStatement.setInt(2, Cliente);
        this.PStatement.setTimestamp(3, time);
        this.RSet = this.PStatement.executeQuery();
        if(this.RSet.next()){
            orden = extractOrdenCliente(this.RSet);
            PStatement.close();
            RSet.close();
            return orden;
        }
        return null;
    }

    public Orden_Cliente_Beans getOrden(int ID_Orden) throws SQLException {
        Orden_Cliente_Beans orden;
        PStatement = conn.getConnection().prepareStatement("SELECT * FROM ONLY \"Proyecto\".\"Orden_Cliente\"" +
                "WHERE \"ID_Orden_Cliente\" = ?");
        this.PStatement.setInt(1, ID_Orden);
        this.RSet = this.PStatement.executeQuery();
        if(this.RSet.next()){
            orden = extractOrdenCliente(this.RSet);
            PStatement.close();
            RSet.close();
            return orden;
        }
        return null;
    }

    public LinkedList<Orden_Cliente_Beans> getOrdenClientes() throws SQLException {
        Orden_Cliente_Beans orden;
        LinkedList<Orden_Cliente_Beans> temp = new LinkedList<>();
        PStatement = conn.getConnection().prepareStatement("SELECT * From ONLY \"Proyecto\".\"Orden_Cliente\";");
        this.RSet = this.PStatement.executeQuery();
        while (this.RSet.next()){
            orden = extractOrdenCliente(this.RSet);
            temp.add(orden);
        }
        PStatement.close();
        RSet.close();
        return temp;
    }

    public LinkedList<Orden_Cliente_Beans> searchOrdenesCliente(int ID_Cliente) throws SQLException {
        Orden_Cliente_Beans orden;
        LinkedList<Orden_Cliente_Beans> temp = new LinkedList<>();
        PStatement = conn.getConnection().prepareStatement("SELECT * From ONLY \"Proyecto\".\"Orden_Cliente\"" +
                "WHERE \"FK_Cliente_OC\" = ?;");
        PStatement.setInt(1, ID_Cliente);
        this.RSet = this.PStatement.executeQuery();
        while (this.RSet.next()){
            orden = extractOrdenCliente(this.RSet);
            temp.add(orden);
        }
        PStatement.close();
        RSet.close();
        return temp;
    }

    public void closeConn() throws SQLException{
        this.conn.closeConn();
    }

    private Orden_Cliente_Beans extractOrdenCliente(ResultSet rset) throws SQLException {
        return new Orden_Cliente_Beans(rset.getInt("ID_Orden_Cliente"), rset.getInt("FK_Cliente_OC"),
                rset.getInt("Num_Confirmacion"), rset.getInt("Direccion"), rset.getDouble("Total"),
                rset.getString("Status"), rset.getTimestamp("Fecha_Ultima_A"), rset.getInt("Detalles_Pago"));
    }
}
