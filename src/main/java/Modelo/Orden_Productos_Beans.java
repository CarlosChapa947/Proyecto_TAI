package Modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "\"Orden_Cliente_Productos\"", schema = "\"Proyecto\"", catalog = "Ecommerce")
public class Orden_Productos_Beans implements Serializable {
    @Basic
    @Id
    @Column(name = "\"Orden_Cliente_ID_Orden_Cliente\"", nullable = false)
    private int ID_Orden;
    @Basic
    @Id
    @Column(name = "\"Productos_ID_Productos\"", nullable = false)
    private int ID_Producto;
    @Basic
    @Column(name = "\"Detalle_Del_Producto\"", nullable = false)
    private int Detalle_Del_Producto;
    @Basic
    @Column(name = "\"Cantidad_Orden\"", nullable = true)
    private Integer Cantidad;
    @Basic
    @Column(name = "\"Precio_Final\"", nullable = true, precision = 0)
    private Double Precio_Final;
    private static final long serialVersionUID = 1L;

    public Orden_Productos_Beans(){

    }

    public Orden_Productos_Beans(int ID_Orden, int ID_Producto, int Cantidad, int Detalle_Del_Producto, double Precio_Final){
        this.ID_Orden = ID_Orden;
        this.ID_Producto = ID_Producto;
        this.Cantidad = Cantidad;
        this.Precio_Final = Precio_Final;
        this.Detalle_Del_Producto = Detalle_Del_Producto;
    }

    public void setID_Orden(int ID_Orden) {
        this.ID_Orden = ID_Orden;
    }

    public int getID_Orden() {
        return ID_Orden;
    }

    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public int getID_Producto() {
        return ID_Producto;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setPrecio_Final(double precio_Final) {
        Precio_Final = precio_Final;
    }

    public double getPrecio_Final() {
        return Precio_Final;
    }

    public void setDetalle_Del_Producto(int detalle_Del_Producto) {
        Detalle_Del_Producto = detalle_Del_Producto;
    }

    public int getDetalle_Del_Producto() {
        return Detalle_Del_Producto;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Orden_Productos_Beans{");
        sb.append("ID_Orden=").append(ID_Orden);
        sb.append(", ID_Producto=").append(ID_Producto);
        sb.append(", Detalle_Del_Producto=").append(Detalle_Del_Producto);
        sb.append(", Cantidad=").append(Cantidad);
        sb.append(", Precio_Final=").append(Precio_Final);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orden_Productos_Beans that = (Orden_Productos_Beans) o;

        if (ID_Orden != that.ID_Orden) return false;
        if (ID_Producto != that.ID_Producto) return false;
        if (Detalle_Del_Producto != that.Detalle_Del_Producto) return false;
        if (Cantidad != null ? !Cantidad.equals(that.Cantidad) : that.Cantidad != null)
            return false;
        if (Precio_Final != null ? !Precio_Final.equals(that.Precio_Final) : that.Precio_Final != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ID_Orden;
        result = 31 * result + ID_Producto;
        result = 31 * result + Detalle_Del_Producto;
        result = 31 * result + (Cantidad != null ? Cantidad.hashCode() : 0);
        result = 31 * result + (Cantidad != null ? Cantidad.hashCode() : 0);
        return result;
    }
}
