package Datos;

import Modelo.Direcciones_Beans;
import java.sql.*;
import java.util.LinkedList;

public class Direcciones_DAO {
    Conexion conn;
    PreparedStatement PStatement;
    ResultSet RSet;

    public Direcciones_DAO() throws SQLException {
        this.conn = new Conexion();
    }

    public Direcciones_DAO(Connection conn){
        this.conn = new Conexion(conn);
    }

    public void insertDireccion(Direcciones_Beans direccion) throws SQLException {
        String statement = "INSERT INTO \"Proyecto\".\"Direcciones\" (\"ID_Direcciones\", \"FK_Direccion_C\", \"Codigo_Postal\", \"Direccion\") VALUES" +
                "(DEFAULT, ?, ?, ?)";
        PreparedStatement PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setInt(1, direccion.getDireccion_C());
        PStatement.setString(2, direccion.getCodigo_Postal());
        PStatement.setString(3, direccion.getDireccion());

        PStatement.executeUpdate();
    }

    public Direcciones_Beans DeleteDireccion(int ID_Direccion) throws SQLException {
        Direcciones_Beans temp=null;
        String statement = "DELETE FROM \"Proyecto\".\"Direcciones\" WHERE \"ID_Direcciones\" = ? ";
        temp=this.getDireccion(ID_Direccion);
        if(temp == null){
            return null;
        }
        PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setInt(1, temp.getID_Direcciones());
        PStatement.executeUpdate();
        return temp;
    }

    public void updateDireccion(Direcciones_Beans direccion) throws SQLException {
        PStatement = conn.getConnection().prepareStatement("UPDATE \"Proyecto\".\"Direcciones\" SET " +
                "\"FK_Direccion_C\" = ?, \"Codigo_Postal\" = ?, \"Direccion\" = ? WHERE " +
                "\"ID_Direcciones\" = ?;");
        PStatement.setInt(1, direccion.getDireccion_C());
        PStatement.setString(2, direccion.getCodigo_Postal());
        PStatement.setString(3, direccion.getDireccion());
        PStatement.setInt(4, direccion.getID_Direcciones());
        PStatement.executeUpdate();
        return;
    }

    public Direcciones_Beans searchDireccion(String CP, String Direccion) throws SQLException {
        Direcciones_Beans direccion;
        PStatement = conn.getConnection().prepareStatement("SELECT * FROM ONLY \"Proyecto\".\"Direcciones\"" +
                "WHERE \"Codigo_Postal\" = ? AND \"Direccion\" = ? ");
        this.PStatement.setString(1, CP);
        this.PStatement.setString(2, Direccion);
        this.RSet = this.PStatement.executeQuery();
        if(this.RSet.next()){
            direccion = extractDireccion(this.RSet);
            PStatement.close();
            RSet.close();
            return direccion;
        }
        return null;
    }

    public Direcciones_Beans getDireccion(int ID_Direccion) throws SQLException {
        Direcciones_Beans direccion;
        PStatement = conn.getConnection().prepareStatement("SELECT * FROM ONLY \"Proyecto\".\"Direcciones\"" +
                "WHERE \"ID_Direcciones\" = ?");
        this.PStatement.setInt(1, ID_Direccion);
        this.RSet = this.PStatement.executeQuery();
        if(this.RSet.next()){
            direccion = extractDireccion(this.RSet);
            PStatement.close();
            RSet.close();
            return direccion;
        }
        return null;
    }

    public LinkedList<Direcciones_Beans> getDirecciones() throws SQLException {
        Direcciones_Beans direccion;
        LinkedList<Direcciones_Beans> temp = new LinkedList<>();
        PStatement = conn.getConnection().prepareStatement("SELECT * From ONLY \"Proyecto\".\"Direcciones\";");
        this.RSet = this.PStatement.executeQuery();
        while (this.RSet.next()){
            direccion = extractDireccion(this.RSet);
            temp.add(direccion);
        }
        PStatement.close();
        RSet.close();
        return temp;
    }

    public void closeConn() throws SQLException{
        this.conn.closeConn();
    }

    private Direcciones_Beans extractDireccion(ResultSet rset) throws SQLException {
        return new Direcciones_Beans(rset.getInt("ID_Direcciones"), rset.getInt("FK_Direccion_C"),
                rset.getString("Codigo_Postal"), rset.getString("Direccion"));
    }

}
