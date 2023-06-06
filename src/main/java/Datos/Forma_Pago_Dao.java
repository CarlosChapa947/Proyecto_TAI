package Datos;
import Modelo.Forma_Pago_Beans;
import java.sql.*;
import java.util.LinkedList;

public class Forma_Pago_Dao {
    Conexion conn;
    PreparedStatement PStatement;
    ResultSet RSet;

    public Forma_Pago_Dao() throws SQLException {
        this.conn = new Conexion();
    }

    public Forma_Pago_Dao(Connection conn){
        this.conn = new Conexion(conn);
    }

    public void insertForma(Forma_Pago_Beans forma) throws SQLException {
        String statement = "INSERT INTO \"Proyecto\".\"Forma_Pago\" " +
                "(\"ID_Forma_Pago\", \"FK_Cliente_FP\", \"Tipo_Pago\", \"Proveedor\", \"Num_Cuenta\", \"Expiracion\") VALUES" +
                "(DEFAULT, ?, ?, ?, ?, ?)";
        PreparedStatement PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setInt(1, forma.getFK_Cliente_FP());
        PStatement.setString(2, forma.getTipo_Pago());
        PStatement.setString(3, forma.getProveedor());
        PStatement.setString(4, forma.getNum_Cuenta());
        PStatement.setDate(5, forma.getExpiracion());

        PStatement.executeUpdate();
    }

    public Forma_Pago_Beans DeleteForma(int ID_Forma) throws SQLException {
        Forma_Pago_Beans temp=null;
        String statement = "DELETE FROM \"Proyecto\".\"Forma_Pago\" WHERE \"ID_Forma_Pago\" = ? ";
        temp=this.getCliente(ID_Forma);
        if(temp == null){
            return null;
        }
        PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setInt(1, temp.getID_Forma_Pago());
        PStatement.executeUpdate();
        return temp;
    }

    public void updateFormas(Forma_Pago_Beans forma) throws SQLException {
        PStatement = conn.getConnection().prepareStatement("UPDATE \"Proyecto\".\"Forma_Pago\" set " +
                "\"FK_Cliente_FP\" = ?, \"Tipo_Pago\" = ?, \"Proveedor\" = ?, \"Num_Cuenta\" = ?, \"Expiracion\" = ? WHERE " +
                "\"ID_Forma_Pago\" = ?;");
        PStatement.setInt(1, forma.getFK_Cliente_FP());
        PStatement.setString(2, forma.getTipo_Pago());
        PStatement.setString(3, forma.getProveedor());
        PStatement.setString(4, forma.getNum_Cuenta());
        PStatement.setDate(5, forma.getExpiracion());
        PStatement.setInt(6, forma.getID_Forma_Pago());
        PStatement.executeUpdate();
        return;
    }

    public Forma_Pago_Beans searchForma(String Num_Cuenta, Date Expiracion) throws SQLException {
        Forma_Pago_Beans forma;
        PStatement = conn.getConnection().prepareStatement("SELECT * FROM ONLY \"Proyecto\".\"Forma_Pago\"" +
                "WHERE \"Num_Cuenta\" = ? AND \"Expiracion\" = ? ");
        this.PStatement.setString(1, Num_Cuenta);
        this.PStatement.setDate(2, Expiracion);
        this.RSet = this.PStatement.executeQuery();
        if(this.RSet.next()){
            forma = extractForma(this.RSet);
            PStatement.close();
            RSet.close();
            return forma;
        }
        return null;
    }

    public Forma_Pago_Beans getCliente(int ID_Forma) throws SQLException {
        Forma_Pago_Beans forma;
        PStatement = conn.getConnection().prepareStatement("SELECT * FROM ONLY \"Proyecto\".\"Forma_Pago\"" +
                "WHERE \"ID_Forma_Pago\" = ?");
        this.PStatement.setInt(1, ID_Forma);
        this.RSet = this.PStatement.executeQuery();
        if(this.RSet.next()){
            forma = extractForma(this.RSet);
            PStatement.close();
            RSet.close();
            return forma;
        }
        return null;
    }

    public LinkedList<Forma_Pago_Beans> getFormas() throws SQLException {
        Forma_Pago_Beans forma;
        LinkedList<Forma_Pago_Beans> temp = new LinkedList<>();
        PStatement = conn.getConnection().prepareStatement("SELECT * From ONLY \"Proyecto\".\"Forma_Pago\";");
        this.RSet = this.PStatement.executeQuery();
        while (this.RSet.next()){
            forma = extractForma(this.RSet);
            temp.add(forma);
        }
        PStatement.close();
        RSet.close();
        return temp;
    }

    public void closeConn() throws SQLException{
        this.conn.closeConn();
    }

    private Forma_Pago_Beans extractForma(ResultSet rset) throws SQLException {
        return new Forma_Pago_Beans(rset.getInt("ID_Forma_Pago"), rset.getInt("FK_Cliente_FP"), rset.getString("Num_Cuenta"),
                rset.getString("Tipo_Pago"), rset.getString("Proveedor"),
                rset.getDate("Expiracion"));
    }
}
