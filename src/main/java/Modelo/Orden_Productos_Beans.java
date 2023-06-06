package Modelo;

import java.io.Serializable;

public class Orden_Productos_Beans implements Serializable {
    private int ID_Orden, ID_Producto, Detalle_Del_Producto, Cantidad;
    private double Precio_Final;

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
}
