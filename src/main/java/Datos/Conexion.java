package Datos;
import java.sql.*;

public class Conexion {
    private static final String user = "postgres";
    private static final String password = "0000";
    private static final String bd = "Ecommerce";
    private static final String server = "jdbc:postgresql://localhost:5432/" + bd;
    private static final String driver = "org.postgresql.Driver";
    private Connection conn;
    private Statement sql_state;
    private ResultSet r_set;

    public Conexion() throws SQLException{
        this.conn = DriverManager.getConnection(server + "?serverTimezone=UTC", user, password);
        this.sql_state = this.conn.createStatement();
    }

    public Conexion(String user, String password, String url) throws SQLException{
        this.conn = DriverManager.getConnection(url, user, password);
        this.sql_state = this.conn.createStatement();
    }

    public Conexion(Connection conn){
        this.conn = conn;
    }

    public boolean setConnection(String user, String password, String url) throws SQLException{
        this.conn = DriverManager.getConnection(url, user, password);
        return true;
    }

    public Connection getConnection(){
        return this.conn;
    }

    public boolean setState() throws SQLException{
        this.sql_state = this.conn.createStatement();
        return true;
    }

    public Statement getState() {
        return this.sql_state;
    }

    public ResultSet getResultSet(String Query) throws SQLException{
        return this.sql_state.executeQuery(Query);
    }

    public boolean setResultSet(String Query) throws SQLException{
        this.r_set = this.sql_state.executeQuery(Query);
        return true;
    }

    public boolean execute_order(String order) throws SQLException{
        return sql_state.execute(order);
    }

    public void closeConn() throws SQLException{
        this.conn.close();
    }

    public void close(ResultSet r_set) throws SQLException {
        r_set.close();
    }

    public void  close(Statement sql_state) throws SQLException {
        sql_state.close();
    }

    public void close(Connection conn) throws SQLException {
        conn.close();
    }

    public void close(PreparedStatement PStatement) throws SQLException{
        PStatement.close();
    }
}
