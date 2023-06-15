package Modelo;

import Datos.Detalle_ProductoDAO;

import java.io.Serializable;
import java.sql.SQLException;
import javax.persistence.*;

@Entity
@Table(name = "\"Detalle_Producto\"", schema = "\"Proyecto\"", catalog = "Ecommerce")
public class Detalle_Producto_Beans implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "\"ID_Detalle_Producto\"", nullable = false)
    private int ID_Detalle_Producto;
    @Basic
    @Column(name = "\"Color\"", nullable = true, length = -1)
    private String Color;
    @Basic
    @Column(name = "\"Talla\"", nullable = true, length = -1)
    private String Talla;

    public Detalle_Producto_Beans (){

    }

    public Detalle_Producto_Beans (int ID_Detalle_Producto){
        this.ID_Detalle_Producto = ID_Detalle_Producto;
    }

    public Detalle_Producto_Beans (String Color, String Talla){
        this.Color = Color;
        this.Talla = Talla;
    }

    public Detalle_Producto_Beans (int ID_Detalle_Producto, String Color, String Talla){
        this.ID_Detalle_Producto = ID_Detalle_Producto;
        this.Color = Color;
        this.Talla = Talla;
    }

    public void setID_Detalle_Producto(int ID_Detalle_Producto) {
        this.ID_Detalle_Producto = ID_Detalle_Producto;
    }

    public int getID_Detalle_Producto() {
        return ID_Detalle_Producto;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getColor() {
        return Color;
    }

    public void setTalla(String talla) {
        Talla = talla;
    }

    public String getTalla() {
        return Talla;
    }

    public String searchTalla(int ID_Detalle_Producto) throws SQLException {
        Detalle_ProductoDAO detalleDAO = new Detalle_ProductoDAO();
        Detalle_Producto_Beans detalle = detalleDAO.getDetalleProducto(ID_Detalle_Producto);
        detalleDAO.closeConn();
        return detalle.getTalla();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Detalle_Producto_Beans{");
        sb.append("ID_Detalle_Producto=").append(ID_Detalle_Producto);
        sb.append(", Color='").append(Color).append('\'');
        sb.append(", Talla='").append(Talla).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Detalle_Producto_Beans that = (Detalle_Producto_Beans) o;

        if (ID_Detalle_Producto != that.ID_Detalle_Producto) return false;
        if (Color != null ? !Color.equals(that.Color) : that.Color != null) return false;
        if (Talla != null ? !Talla.equals(that.Talla) : that.Talla != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ID_Detalle_Producto;
        result = 31 * result + (Color != null ? Color.hashCode() : 0);
        result = 31 * result + (Talla!= null ? Talla.hashCode() : 0);
        return result;
    }
}
