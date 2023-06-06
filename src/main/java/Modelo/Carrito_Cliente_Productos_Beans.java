package Modelo;

import java.io.Serializable;

public class Carrito_Cliente_Productos_Beans implements Serializable {
    private int ID_Producto, ID_Carrito_Cliente, Detalle_Del_Producto,  Cantidad;
    private Double Precio_Carrito;
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
}
