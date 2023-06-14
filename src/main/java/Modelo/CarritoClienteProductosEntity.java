package Modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Carrito_Cliente_Productos", schema = "Proyecto", catalog = "Ecommerce")
public class CarritoClienteProductosEntity implements Serializable {
    @Basic
    @Id
    @Column(name = "Carrito_Cliente_ID_Carrito", nullable = false)
    private int carritoClienteIdCarrito;
    @Basic
    @Id
    @Column(name = "Productos_ID_Productos", nullable = false)
    private int productosIdProductos;
    @Basic
    @Column(name = "Detalle_Del_Producto", nullable = false)
    private int detalleDelProducto;
    @Basic
    @Column(name = "Cantidad", nullable = false)
    private int cantidad;
    @Basic
    @Column(name = "Precio_Carrito", nullable = false)
    private int precioCarrito;
    private static final long serialVersionUID = 1L;

    public int getCarritoClienteIdCarrito() {
        return carritoClienteIdCarrito;
    }

    public void setCarritoClienteIdCarrito(int carritoClienteIdCarrito) {
        this.carritoClienteIdCarrito = carritoClienteIdCarrito;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioCarrito() {
        return precioCarrito;
    }

    public void setPrecioCarrito(int precioCarrito) {
        this.precioCarrito = precioCarrito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarritoClienteProductosEntity that = (CarritoClienteProductosEntity) o;

        if (carritoClienteIdCarrito != that.carritoClienteIdCarrito) return false;
        if (productosIdProductos != that.productosIdProductos) return false;
        if (detalleDelProducto != that.detalleDelProducto) return false;
        if (cantidad != that.cantidad) return false;
        if (precioCarrito != that.precioCarrito) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = carritoClienteIdCarrito;
        result = 31 * result + productosIdProductos;
        result = 31 * result + detalleDelProducto;
        result = 31 * result + cantidad;
        result = 31 * result + precioCarrito;
        return result;
    }
}
