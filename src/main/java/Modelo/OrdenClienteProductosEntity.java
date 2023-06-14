package Modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Orden_Cliente_Productos", schema = "Proyecto", catalog = "Ecommerce")
public class OrdenClienteProductosEntity implements Serializable {
    @Basic
    @Id
    @Column(name = "Orden_Cliente_ID_Orden_Cliente", nullable = false)
    private int ordenClienteIdOrdenCliente;
    @Basic
    @Id
    @Column(name = "Productos_ID_Productos", nullable = false)
    private int productosIdProductos;
    @Basic
    @Column(name = "Detalle_Del_Producto", nullable = false)
    private int detalleDelProducto;
    @Basic
    @Column(name = "Cantidad_Orden", nullable = true)
    private Integer cantidadOrden;
    @Basic
    @Column(name = "Precio_Final", nullable = true, precision = 0)
    private Double precioFinal;
    private static final long serialVersionUID = 1L;

    public int getOrdenClienteIdOrdenCliente() {
        return ordenClienteIdOrdenCliente;
    }

    public void setOrdenClienteIdOrdenCliente(int ordenClienteIdOrdenCliente) {
        this.ordenClienteIdOrdenCliente = ordenClienteIdOrdenCliente;
    }

    public int getProductosIdProductos() {
        return productosIdProductos;
    }

    public void setProductosIdProductos(int productosIdProductos) {
        this.productosIdProductos = productosIdProductos;
    }

    public int getDetalleDelProducto() {
        return detalleDelProducto;
    }

    public void setDetalleDelProducto(int detalleDelProducto) {
        this.detalleDelProducto = detalleDelProducto;
    }

    public Integer getCantidadOrden() {
        return cantidadOrden;
    }

    public void setCantidadOrden(Integer cantidadOrden) {
        this.cantidadOrden = cantidadOrden;
    }

    public Double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Double precioFinal) {
        this.precioFinal = precioFinal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdenClienteProductosEntity that = (OrdenClienteProductosEntity) o;

        if (ordenClienteIdOrdenCliente != that.ordenClienteIdOrdenCliente) return false;
        if (productosIdProductos != that.productosIdProductos) return false;
        if (detalleDelProducto != that.detalleDelProducto) return false;
        if (cantidadOrden != null ? !cantidadOrden.equals(that.cantidadOrden) : that.cantidadOrden != null)
            return false;
        if (precioFinal != null ? !precioFinal.equals(that.precioFinal) : that.precioFinal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ordenClienteIdOrdenCliente;
        result = 31 * result + productosIdProductos;
        result = 31 * result + detalleDelProducto;
        result = 31 * result + (cantidadOrden != null ? cantidadOrden.hashCode() : 0);
        result = 31 * result + (precioFinal != null ? precioFinal.hashCode() : 0);
        return result;
    }
}
