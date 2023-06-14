package Datos;

import Modelo.Clientes_Beans;

import java.sql.*;
import java.util.LinkedList;
import Modelo.ClientesEntity;
import org.hibernate.*;
import org.hibernate.Session;

public class Clientes_DAO {
    Conexion conn;
    PreparedStatement PStatement;
    ResultSet RSet;

    public Clientes_DAO () throws SQLException {
        this.conn = new Conexion();
    }
    public Clientes_DAO (Connection conn){
        this.conn = new Conexion(conn);
    }

    public void HibernateRegisterNewCliente(ClientesEntity ClienteEntity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(ClienteEntity);
        session.getTransaction().commit();
        session.close();
    }

    public void RegisterNewCliente(Clientes_Beans cliente) throws SQLException{
        String statement = "INSERT INTO \"Proyecto\".\"Clientes\" " +
                "(\"Nombre\", \"Apellido_P\", \"Apellido_M\", \"Email\", \"Telefono\", \"Direccion_Primaria\", \"Clave\") VALUES" +
                "(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setString(1, cliente.getNombre());
        PStatement.setString(2, cliente.getApellido_P());
        PStatement.setString(3, cliente.getApellido_M());
        PStatement.setString(4, cliente.getEmail());
        PStatement.setString(5, null);
        PStatement.setNull(6, Types.INTEGER);
        PStatement.setString(7, cliente.getClave());

        PStatement.executeUpdate();
    }

    public void insertCliente(Clientes_Beans cliente) throws SQLException {
        String statement = "INSERT INTO \"Proyecto\".\"Clientes\" " +
                "(\"ID_Cliente\", \"Nombre\", \"Apellido_P\", \"Apellido_M\", \"Email\", \"Telefono\", \"Direccion_Primaria\", \"Clave\") VALUES" +
                "(?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setString(1, "DEFAULT");
        PStatement.setString(2, cliente.getNombre());
        PStatement.setString(3, cliente.getApellido_P());
        PStatement.setString(4, cliente.getApellido_M());
        PStatement.setString(5, cliente.getEmail());
        PStatement.setString(6, cliente.getTelefono());
        PStatement.setInt(7, cliente.getDireccion_Primaria());
        PStatement.setString(8, cliente.getClave());

        PStatement.executeUpdate();
    }

    public Clientes_Beans DeleteCLiente(int ID_Cliente) throws SQLException {
        Clientes_Beans temp=null;
        String statement = "DELETE FROM \"Proyecto\".\"Clientes\" WHERE \"ID_Cliente\" = ? ";
        temp=this.getCliente(ID_Cliente);
        if(temp == null){
            return null;
        }
        PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setInt(1, temp.getID_Clientes());
        PStatement.executeUpdate();
        return temp;
    }

    public void updateCliente(Clientes_Beans cliente) throws SQLException {
        PStatement = conn.getConnection().prepareStatement("UPDATE \"Proyecto\".\"Clientes\" set " +
                "\"Nombre\" = ?, \"Apellido_P\" = ?, \"Apellido_M\" = ?, \"Email\" = ?, \"Telefono\" = ?,  \"Direccion_Primaria\" = ?, " +
                "\"Clave\" = ? WHERE \"ID_Cliente\" = ?;");
        PStatement.setString(1, cliente.getNombre());
        PStatement.setString(2, cliente.getApellido_P());
        PStatement.setString(3, cliente.getApellido_M());
        PStatement.setString(4, cliente.getEmail());
        PStatement.setString(5, cliente.getTelefono());
        PStatement.setInt(6, cliente.getDireccion_Primaria());
        PStatement.setInt(7, cliente.getID_Clientes());
        PStatement.setString(8, cliente.getClave());
        PStatement.executeUpdate();
        return;
    }

    public Clientes_Beans loginCliente(String email, String password) throws SQLException{
        Clientes_Beans cliente;
        PStatement = conn.getConnection().prepareStatement("SELECT * FROM ONLY \"Proyecto\".\"Clientes\"" +
                "WHERE \"Email\" = ? and \"Clave\" = ? ");
        this.PStatement.setString(1, email);
        this.PStatement.setString(2, password);
        this.RSet = this.PStatement.executeQuery();
        if(this.RSet.next()){
            cliente = extractCliente(this.RSet);
            PStatement.close();
            RSet.close();
            return cliente;
        }
        return null;
    }

    public ClientesEntity HibernatesearchCliente(String email) throws SQLException {
        ClientesEntity cliente;
        Session session = HibernateUtil.getSession();
        cliente = session.get(ClientesEntity.class, email);
        session.close();
        if(cliente != null) {
            return cliente;
        } else {
            return null;
        }
    }

    public Clientes_Beans searchCliente(String email) throws SQLException {
        Clientes_Beans cliente;
        PStatement = conn.getConnection().prepareStatement("SELECT * FROM ONLY \"Proyecto\".\"Clientes\"" +
                "WHERE \"Email\" = ?");
        this.PStatement.setString(1, email);
        this.RSet = this.PStatement.executeQuery();
        if(this.RSet.next()){
            cliente = extractCliente(this.RSet);
            PStatement.close();
            RSet.close();
            return cliente;
        }
        return null;
    }

    public Clientes_Beans getCliente(int ID_Cliente) throws SQLException {
        Clientes_Beans cliente;
        PStatement = conn.getConnection().prepareStatement("SELECT * FROM ONLY \"Proyecto\".\"Clientes\"" +
                "WHERE \"ID_Cliente\" = ?");
        this.PStatement.setInt(1, ID_Cliente);
        this.RSet = this.PStatement.executeQuery();
        if(this.RSet.next()){
            PStatement.close();
            cliente = extractCliente(this.RSet);
            RSet.close();
            return cliente;
        }
        return null;
    }

    public LinkedList<Clientes_Beans> getClientes() throws SQLException {
        Clientes_Beans cliente;
        LinkedList<Clientes_Beans> temp = new LinkedList<>();
        PStatement = conn.getConnection().prepareStatement("SELECT * From ONLY \"Proyecto\".\"Clientes\";");
        this.RSet = this.PStatement.executeQuery();
        while (this.RSet.next()){
            cliente = extractCliente(this.RSet);
            temp.add(cliente);
        }
        PStatement.close();
        RSet.close();
        return temp;
    }

    public void closeConn() throws SQLException{
        this.conn.closeConn();
    }

    private Clientes_Beans extractCliente(ResultSet rset) throws SQLException {
        return new Clientes_Beans(rset.getInt("ID_Cliente"), rset.getInt("Direccion_Primaria"),
                rset.getString("Nombre"), rset.getString("Apellido_P"), rset.getString("Apellido_M"),
                rset.getString("Telefono"), rset.getString("Email"), rset.getString("Clave"));
    }
}
