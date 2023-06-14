package Modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Detalle_Producto_Productos", schema = "Proyecto", catalog = "Ecommerce")
public class DetalleProductoProductosEntity implements Serializable {
    @Basic
    @Id
    @Column(name = "FK_Detalle_Producto", nullable = false)
    private int fkDetalleProducto;
    @Basic
    @Id
    @Column(name = "FK_Producto", nullable = false)
    private int fkProducto;
    @Basic
    @Column(name = "Cantidad", nullable = true)
    private Integer cantidad;
    private static final long serialVersionUID = 1L;

    public int getFkDetalleProducto() {
        return fkDetalleProducto;
    }

    public void setFkDetalleProducto(int fkDetalleProducto) {
        this.fkDetalleProducto = fkDetalleProducto;
    }

    public int getFkProducto() {
        return fkProducto;
    }

    public void setFkProducto(int fkProducto) {
        this.fkProducto = fkProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalleProductoProductosEntity that = (DetalleProductoProductosEntity) o;

        if (fkDetalleProducto != that.fkDetalleProducto) return false;
        if (fkProducto != that.fkProducto) return false;
        if (cantidad != null ? !cantidad.equals(that.cantidad) : that.cantidad != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fkDetalleProducto;
        result = 31 * result + fkProducto;
        result = 31 * result + (cantidad != null ? cantidad.hashCode() : 0);
        return result;
    }
}
