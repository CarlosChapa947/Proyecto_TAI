package Modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "\"Carrito_Cliente_Productos\"", schema = "\"Proyecto\"", catalog = "Ecommerce")
public class Carrito_Cliente_Productos_Beans implements Serializable {
    @Basic
    @Id
    @Column(name = "\"Carrito_Cliente_ID_Carrito\"", nullable = false)
    private int ID_Carrito_Cliente;
    @Basic
    @Id
    @Column(name = "\"Productos_ID_Productos\"", nullable = false)
    private int ID_Producto;
    @Basic
    @Column(name = "\"Detalle_Del_Producto\"", nullable = false)
    private int Detalle_Del_Producto;
    @Basic
    @Column(name = "\"Cantidad\"", nullable = false)
    private int Cantidad;
    @Basic
    @Column(name = "\"Precio_Carrito\"", nullable = false)
    private double Precio_Carrito;
    private static final long serialVersionUID = 1L;
    public Carrito_Cliente_Productos_Beans(){

    }

    public Carrito_Cliente_Productos_Beans(int ID_Producto, int Cantidad, int Detalle_Del_Producto, Double Precio_Carrito){
        this.ID_Producto = ID_Producto;
        this.Cantidad = Cantidad;
        this.Detalle_Del_Producto = Detalle_Del_Producto;
        this.Precio_Carrito = Precio_Carrito;
    }

    public Carrito_Cliente_Productos_Beans(int ID_Producto, int ID_Carrito_Cliente, int Cantidad, int Detalle_Del_Producto, Double Precio_Carrito){
        this.ID_Producto = ID_Producto;
        this.ID_Carrito_Cliente = ID_Carrito_Cliente;
        this.Cantidad = Cantidad;
        this.Detalle_Del_Producto = Detalle_Del_Producto;
        this.Precio_Carrito = Precio_Carrito;
    }

    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public int getID_Producto() {
        return ID_Producto;
    }

    public void setID_Carrito_Cliente(int ID_Carrito_Cliente) {
        this.ID_Carrito_Cliente = ID_Carrito_Cliente;
    }

    public int getID_Carrito_Cliente() {
        return ID_Carrito_Cliente;
    }

    public void setPrecio_Carrito(Double precio_Carrito) {
        Precio_Carrito = precio_Carrito;
    }

    public Double getPrecio_Carrito() {
        return Precio_Carrito;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setDetalle_Del_Producto(int detalle_Del_Producto) {
        Detalle_Del_Producto = detalle_Del_Producto;
    }

    public int getDetalle_Del_Producto() {
        return Detalle_Del_Producto;
    }

    @Override
    public String toString() {
        return "Carrito_Cliente_Productos_Beans{" + "ID_Producto=" + ID_Producto +
                ", ID_Carrito_Cliente=" + ID_Carrito_Cliente +
                ", Cantidad=" + Cantidad +
                ", Precio_Carrito=" + Precio_Carrito +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Carrito_Cliente_Productos_Beans that = (Carrito_Cliente_Productos_Beans) o;

        if (ID_Carrito_Cliente != that.ID_Carrito_Cliente) return false;
        if (ID_Producto != that.ID_Producto) return false;
        if (Detalle_Del_Producto != that.Detalle_Del_Producto) return false;
        if (Cantidad != that.Cantidad) return false;
        if (Precio_Carrito != that.Precio_Carrito) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ID_Carrito_Cliente;
        result = 31 * result + ID_Producto;
        result = 31 * result + Detalle_Del_Producto;
        result = 31 * result + Cantidad;
        result = 31 * result +(int) Precio_Carrito;
        return result;
    }
}
