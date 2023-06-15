package Modelo;

import Datos.Detalle_Producto_ProductosDAO;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.persistence.*;

@Entity
@Table(name = "\"Detalle_Producto_Productos\"", schema = "\"Proyecto\"", catalog = "Ecommerce")
public class Detalle_Producto_Productos implements Serializable {
    @Basic
    @Id
    @Column(name = "\"FK_Detalle_Producto\"", nullable = false)
    private int FK_Detalle_Producto;
    @Basic
    @Id
    @Column(name = "\"FK_Producto\"", nullable = false)
    private int FK_Producto;
    @Basic
    @Column(name = "\"Cantidad\"", nullable = true)
    private Integer Cantidad;
    private static final long serialVersionUID = 1L;

    public Detalle_Producto_Productos (){

    }

    public Detalle_Producto_Productos (int FK_Detalle_Producto, int FK_Producto){
        this.FK_Detalle_Producto = FK_Detalle_Producto;
        this.FK_Producto = FK_Producto;
    }

    public Detalle_Producto_Productos (int FK_Detalle_Producto, int FK_Producto, int Cantidad){
        this.FK_Detalle_Producto = FK_Detalle_Producto;
        this.FK_Producto = FK_Producto;
        this.Cantidad = Cantidad;
    }

    public void setFK_Detalle_Producto(int FK_Detalle_Producto) {
        this.FK_Detalle_Producto = FK_Detalle_Producto;
    }

    public int getFK_Detalle_Producto() {
        return FK_Detalle_Producto;
    }

    public void setFK_Producto(int FK_Producto) {
        this.FK_Producto = FK_Producto;
    }

    public int getFK_Producto() {
        return FK_Producto;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public LinkedList<Detalle_Producto_Productos> getAllDetallesOfProducto(int ID_Producto) throws SQLException {
        Detalle_Producto_ProductosDAO detalleDAO = new Detalle_Producto_ProductosDAO();
        LinkedList<Detalle_Producto_Productos> detalleList = detalleDAO.getProductoDetalles(ID_Producto);
        detalleDAO.closeConn();
        return detalleList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Detalle_Producto_Productos{");
        sb.append("FK_Detalle_Producto=").append(FK_Detalle_Producto);
        sb.append(", FK_Producto=").append(FK_Producto);
        sb.append(", Cantidad=").append(Cantidad);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Detalle_Producto_Productos that = (Detalle_Producto_Productos) o;

        if (FK_Detalle_Producto != that.FK_Detalle_Producto) return false;
        if (FK_Producto != that.FK_Producto) return false;
        if (Cantidad != null ? !Cantidad.equals(that.Cantidad) : that.Cantidad != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = FK_Detalle_Producto;
        result = 31 * result + FK_Producto;
        result = 31 * result + (Cantidad != null ? Cantidad.hashCode() : 0);
        return result;
    }
}
