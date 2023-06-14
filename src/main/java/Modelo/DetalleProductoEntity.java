package Modelo;

import javax.persistence.*;

@Entity
@Table(name = "Detalle_Producto", schema = "Proyecto", catalog = "Ecommerce")
public class DetalleProductoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Detalle_Producto", nullable = false)
    private int idDetalleProducto;
    @Basic
    @Column(name = "Color", nullable = true, length = -1)
    private String color;
    @Basic
    @Column(name = "Talla", nullable = true, length = -1)
    private String talla;

    public int getIdDetalleProducto() {
        return idDetalleProducto;
    }

    public void setIdDetalleProducto(int idDetalleProducto) {
        this.idDetalleProducto = idDetalleProducto;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalleProductoEntity that = (DetalleProductoEntity) o;

        if (idDetalleProducto != that.idDetalleProducto) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (talla != null ? !talla.equals(that.talla) : that.talla != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDetalleProducto;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (talla != null ? talla.hashCode() : 0);
        return result;
    }
}
