package Modelo;

import java.io.Serializable;

public class Direcciones_Beans implements Serializable {
    private int ID_Direcciones, Direccion_C;
    private String Codigo_Postal, Direccion;
    public Direcciones_Beans(){

    }

    public Direcciones_Beans(int Direccion_C, String Codigo_Postal, String Direccion){
        this.Direccion_C = Direccion_C;
        this.Codigo_Postal = Codigo_Postal;
        this.Direccion = Direccion;
    }

    public Direcciones_Beans(int ID_Direcciones ,int Direccion_C, String Codigo_Postal, String Direccion){
        this.ID_Direcciones = ID_Direcciones;
        this.Direccion_C = Direccion_C;
        this.Codigo_Postal = Codigo_Postal;
        this.Direccion = Direccion;
    }

    public void setID_Direcciones(int ID_Direcciones) {
        this.ID_Direcciones = ID_Direcciones;
    }

    public int getID_Direcciones() {
        return ID_Direcciones;
    }

    public void setDireccion_C(int direccion_C) {
        Direccion_C = direccion_C;
    }

    public int getDireccion_C() {
        return Direccion_C;
    }

    public void setCodigo_Postal(String codigo_Postal) {
        Codigo_Postal = codigo_Postal;
    }

    public String getCodigo_Postal() {
        return Codigo_Postal;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getDireccion() {
        return Direccion;
    }

    @Override
    public String toString() {
        return "Direcciones_Beans{" + "ID_Direcciones=" + ID_Direcciones +
                ", Direccion_C=" + Direccion_C +
                ", Codigo_Postal='" + Codigo_Postal + '\'' +
                ", Direccion='" + Direccion + '\'' +
                '}';
    }
}
