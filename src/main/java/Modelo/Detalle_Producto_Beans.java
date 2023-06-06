package Modelo;

import Datos.Detalle_ProductoDAO;

import java.io.Serializable;
import java.sql.SQLException;

public class Detalle_Producto_Beans implements Serializable {
    private int ID_Detalle_Producto;
    private String Color, Talla;

    public Detalle_Producto_Beans (){

    }

    public Detalle_Producto_Beans (int ID_Detalle_Producto){
        this.ID_Detalle_Producto = ID_Detalle_Producto;
    }

    public Detalle_Producto_Beans (String Color, String Talla){
        this.Color = Color;
        this.Talla = Talla;
    }

    public Detalle_Producto_Beans (int ID_Detalle_Producto, String Color, String Talla){
        this.ID_Detalle_Producto = ID_Detalle_Producto;
        this.Color = Color;
        this.Talla = Talla;
    }

    public void setID_Detalle_Producto(int ID_Detalle_Producto) {
        this.ID_Detalle_Producto = ID_Detalle_Producto;
    }

    public int getID_Detalle_Producto() {
        return ID_Detalle_Producto;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getColor() {
        return Color;
    }

    public void setTalla(String talla) {
        Talla = talla;
    }

    public String getTalla() {
        return Talla;
    }

    public String searchTalla(int ID_Detalle_Producto) throws SQLException {
        Detalle_ProductoDAO detalleDAO = new Detalle_ProductoDAO();
        Detalle_Producto_Beans detalle = detalleDAO.getDetalleProducto(ID_Detalle_Producto);
        detalleDAO.closeConn();
        return detalle.getTalla();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Detalle_Producto_Beans{");
        sb.append("ID_Detalle_Producto=").append(ID_Detalle_Producto);
        sb.append(", Color='").append(Color).append('\'');
        sb.append(", Talla='").append(Talla).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
