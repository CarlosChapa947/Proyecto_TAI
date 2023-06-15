package Modelo;

import Datos.Productos_DAO;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.persistence.*;

@Entity
@Table(name = "\"Productos\"", schema = "\"Proyecto\"", catalog = "Ecommerce")
public class Productos_Beans implements Serializable {
    @Basic
    @Id
    @Column(name = "\"ID_Productos\"", nullable = false)
    private int ID_Productos;

    @Basic
    @Column(name = "\"Categoria\"", nullable = false)
    private int FK_Categoria;

    @Basic
    @Column(name = "\"Nombre\"", nullable = false)
    private String Nombre;
    @Basic
    @Column(name = "\"Precio_Unitario\"", nullable = true)
    private double Precio_Unitario;

    @Basic
    @Column(name = "\"Descripcion\"", nullable = true)
    private String Descripcion;

    @Basic
    @Column(name = "\"Image_Name\"", nullable = true)
    private String img;

    public Productos_Beans() {

    }

    public Productos_Beans(int FK_Categoria, double Precio_Unitario, String Nombre, String Descripcion, String img) {
        this.FK_Categoria = FK_Categoria;
        this.Precio_Unitario = Precio_Unitario;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.img = img;
    }

    public Productos_Beans(int ID_Productos, int FK_Categoria, double Precio_Unitario, String Nombre, String Descripcion, String img) {
        this.ID_Productos = ID_Productos;
        this.FK_Categoria = FK_Categoria;
        this.Precio_Unitario = Precio_Unitario;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.img = img;
    }

    public int getID_Productos() {
        return ID_Productos;
    }

    public void setID_Productos(int ID_Productos) {
        this.ID_Productos = ID_Productos;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getFK_Categoria() {
        return FK_Categoria;
    }

    public void setFK_Categoria(int FK_Categoria) {
        this.FK_Categoria = FK_Categoria;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public double getPrecio_Unitario() {
        return Precio_Unitario;
    }

    public void setPrecio_Unitario(double precio_Unitario) {
        Precio_Unitario = precio_Unitario;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public LinkedList<Productos_Beans> getProductosinCarrito(LinkedList<Carrito_Cliente_Productos_Beans> carrito) throws SQLException {
        Productos_DAO productosDao = new Productos_DAO();
        LinkedList<Productos_Beans> productsList = new LinkedList<>();
        for (Carrito_Cliente_Productos_Beans i : carrito) {
            productsList.add(productosDao.getProducto(i.getID_Producto()));
        }
        productosDao.closeConn();
        return productsList;
    }

    public Productos_Beans getProducto(int ID_Productos) throws SQLException {
        Productos_DAO productosDao = new Productos_DAO();
        Productos_Beans temp = productosDao.getProducto(ID_Productos);
        productosDao.closeConn();
        return temp;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Productos_Beans{");
        sb.append("ID_Productos=").append(ID_Productos);
        sb.append(", FK_Categoria=").append(FK_Categoria);
        sb.append(", Precio_Unitario=").append(Precio_Unitario);
        sb.append(", Nombre='").append(Nombre).append('\'');
        sb.append(", Descripcion='").append(Descripcion).append('\'');
        sb.append(", img='").append(img).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Productos_Beans that = (Productos_Beans) o;

        if (ID_Productos != that.ID_Productos) return false;
        if (Double.compare(that.Precio_Unitario, Precio_Unitario) != 0) return false;
        if (FK_Categoria != that.FK_Categoria) return false;
        if (Nombre != null ? !Nombre.equals(that.Nombre) : that.Nombre != null) return false;
        if (Descripcion != null ? !Descripcion.equals(that.Descripcion) : that.Descripcion != null) return false;
        if (img != null ? !img.equals(that.img) : that.img != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = ID_Productos;
        temp = Double.doubleToLongBits(Precio_Unitario);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + FK_Categoria;
        result = 31 * result + (Nombre != null ? Nombre.hashCode() : 0);
        result = 31 * result + (Descripcion != null ? Descripcion.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        return result;
    }
}
