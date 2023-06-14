package Datos;

import Modelo.Categorias_Beans;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import Modelo.CategoriasEntity;
import Modelo.ClientesEntity;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;

public class Categorias_DAO {
    Conexion conn;
    PreparedStatement PStatement;
    ResultSet RSet;

    public Categorias_DAO () throws SQLException {
        this.conn = new Conexion();
    }
    public Categorias_DAO(Connection conn){
         this.conn = new Conexion(conn);
    }

    public void insertCategoria(Categorias_Beans cate) throws SQLException {
        String statement = "INSERT INTO \"Proyecto\".\"Categorias\" (\"ID_Categorias\", \"Nombre\", \"Image_Name\")" +
                " VALUES" +
                "(DEFAULT, ?, ?)";
        PreparedStatement PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setString(1, cate.getNombre());
        PStatement.setString(2, cate.getImageName());
        PStatement.executeUpdate();
    }

    public Categorias_Beans DeleteCategoria(int ID_Producto) throws SQLException {
        Categorias_Beans temp=null;
        String statement = "DELETE FROM \"Proyecto\".\"Categorias\" WHERE \"ID_Categorias\" = ? ";
        temp=this.getCategoria(ID_Producto);
        if(temp == null){
            return null;
        }
        PStatement = this.conn.getConnection().prepareStatement(statement);
        PStatement.setInt(1, temp.getID_Categorias());
        PStatement.executeUpdate();
        return temp;
    }

    public void updateCategoria(Categorias_Beans cate) throws SQLException {
        PStatement = conn.getConnection().prepareStatement("UPDATE \"Proyecto\".\"Categorias\" set " +
                "\"Nombre\" = ?, \"Image_Name\" = ? WHERE " +
                "\"ID_Categorias\" = ?;");
        PStatement.setString(1, cate.getNombre());
        PStatement.setString(2, cate.getImageName());
        PStatement.setInt(3, cate.getID_Categorias());
        PStatement.executeUpdate();
        return;
    }

    public Categorias_Beans getCategoria(int ID_Categoria) throws SQLException {
        Categorias_Beans cate;
        PStatement = conn.getConnection().prepareStatement("SELECT * FROM ONLY \"Proyecto\".\"Categorias\"" +
                "WHERE \"ID_Categorias\" = ?");
        this.PStatement.setInt(1, ID_Categoria);
        this.RSet = this.PStatement.executeQuery();
        if(this.RSet.next()){
            cate = extractCategoria(this.RSet);
            PStatement.close();
            RSet.close();
            return cate;
        }
        return null;
    }

    public ArrayList<CategoriasEntity> HibernateGetCategorias() {
        CategoriasEntity categoriaEntity = new CategoriasEntity();
        ArrayList<CategoriasEntity> temp = new ArrayList<>();
        Session session = HibernateUtil.getSession();
        CriteriaQuery<CategoriasEntity> criteria = session.getCriteriaBuilder().createQuery(CategoriasEntity.class);
        criteria.from(CategoriasEntity.class);
        temp = (ArrayList<CategoriasEntity>) session.createQuery(criteria).getResultList();
        return temp;
    }

    public LinkedList<Categorias_Beans> getCategorias() throws SQLException {
        Categorias_Beans categoria;
        LinkedList<Categorias_Beans> temp = new LinkedList<>();
        PStatement = conn.getConnection().prepareStatement("SELECT \"ID_Categorias\", \"Nombre\", \"Image_Name\" From ONLY \"Proyecto\".\"Categorias\";");
        this.RSet = this.PStatement.executeQuery();
        while (this.RSet.next()){
            categoria = extractCategoria(this.RSet);
            temp.add(categoria);
        }
        PStatement.close();
        RSet.close();
        return temp;
    }

    public void closeConn() throws SQLException{
        this.conn.closeConn();
    }

    private Categorias_Beans extractCategoria(ResultSet rset) throws SQLException {
        return new Categorias_Beans(rset.getInt("ID_Categorias"), rset.getString("Nombre"), rset.getString("Image_Name"));
    }
}
