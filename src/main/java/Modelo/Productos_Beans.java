package Modelo;

import Datos.Productos_DAO;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedList;

public class Productos_Beans implements Serializable {
    private int ID_Productos, FK_Categoria;
    private double Precio_Unitario;
    private String Nombre, Descripcion, img;

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
}
