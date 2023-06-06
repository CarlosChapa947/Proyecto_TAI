package Modelo;

import java.io.Serializable;

public class Clientes_Beans implements Serializable {
    private int ID_Clientes, Direccion_Primaria;
    private String Nombre, Apellido_P, Apellido_M, Telefono, Email, Clave;
    public Clientes_Beans(){

    }

    public Clientes_Beans (String Nombre, String ApellidoP, String ApellidoM, String Email, String Password){
        this.Nombre = Nombre;
        this.Apellido_P = ApellidoP;
        this.Apellido_M = ApellidoM;
        this.Email = Email;
        this.Clave = Password;
        this.Telefono = null;
    }

    public Clientes_Beans (int Direccion_Primaria, String Nombre, String Apellido_P, String Apellido_M,
                           String Telefono, String Email, String Clave){
        this.Direccion_Primaria = Direccion_Primaria;
        this.Nombre = Nombre;
        this.Apellido_P = Apellido_P;
        this.Apellido_M = Apellido_M;
        this.Telefono = Telefono;
        this.Email = Email;
        this.Clave = Clave;
    }

    public Clientes_Beans (int ID_Clientes, int Direccion_Primaria, String Nombre, String Apellido_P, String Apellido_M,
                           String Telefono, String Email, String Clave){
        this.ID_Clientes = ID_Clientes;
        this.Direccion_Primaria = Direccion_Primaria;
        this.Nombre = Nombre;
        this.Apellido_P = Apellido_P;
        this.Apellido_M = Apellido_M;
        this.Telefono = Telefono;
        this.Email = Email;
        this.Clave = Clave;
    }

    public void setID_Clientes(int ID_Clientes) {
        this.ID_Clientes = ID_Clientes;
    }

    public int getID_Clientes() {
        return ID_Clientes;
    }

    public void setDireccion_Primaria(int direccion_Primaria) {
        Direccion_Primaria = direccion_Primaria;
    }

    public int getDireccion_Primaria() {
        return Direccion_Primaria;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setApellido_P(String apellido_P) {
        Apellido_P = apellido_P;
    }

    public String getApellido_P() {
        return Apellido_P;
    }

    public void setApellido_M(String apellido_M) {
        Apellido_M = apellido_M;
    }

    public String getApellido_M() {
        return Apellido_M;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public void setClave(String clave) {
        Clave = clave;
    }

    public String getClave() {
        return Clave;
    }

    @Override
    public String toString() {
        return "Clientes_Beans{" + "ID_Clientes=" + ID_Clientes +
                ", Direccion_Primaria=" + Direccion_Primaria +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido_P='" + Apellido_P + '\'' +
                ", Apellido_M='" + Apellido_M + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
