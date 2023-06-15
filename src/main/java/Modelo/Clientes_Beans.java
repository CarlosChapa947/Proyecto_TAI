package Modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "\"Clientes\"", schema = "\"Proyecto\"", catalog = "Ecommerce")
public class Clientes_Beans implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "\"ID_Cliente\"", nullable = false)
    private int ID_Clientes;
    @Basic
    @Column(name = "\"Nombre\"", nullable = true, length = -1)
    private String Nombre;
    @Basic
    @Column(name = "\"Apellido_M\"", nullable = true, length = -1)
    private String Apellido_M;
    @Basic
    @Column(name = "\"Apellido_P\"", nullable = true, length = -1)
    private String Apellido_P;
    @Basic
    @Column(name = "\"Email\"", nullable = true, length = -1)
    private String Email;
    @Basic
    @Column(name = "\"Clave\"", nullable = true, length = -1)
    private String Clave;
    @Basic
    @Column(name = "\"Telefono\"", nullable = true, length = -1)
    private String Telefono;
    @Basic
    @Column(name = "\"Direccion_Primaria\"", nullable = true)
    private Integer Direccion_Primaria;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clientes_Beans that = (Clientes_Beans) o;

        if (ID_Clientes != that.ID_Clientes) return false;
        if (Nombre != null ? !Nombre.equals(that.Nombre) : that.Nombre != null) return false;
        if (Apellido_M != null ? !Apellido_M.equals(that.Apellido_M) : that.Apellido_M != null) return false;
        if (Apellido_P != null ? !Apellido_P.equals(that.Apellido_P) : that.Apellido_P != null) return false;
        if (Email != null ? !Email.equals(that.Email) : that.Email != null) return false;
        if (Clave != null ? !Clave.equals(that.Clave) : that.Clave != null) return false;
        if (Telefono != null ? !Telefono.equals(that.Telefono) : that.Telefono != null) return false;
        if (Direccion_Primaria != null ? !Direccion_Primaria.equals(that.Direccion_Primaria) : that.Direccion_Primaria != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ID_Clientes;
        result = 31 * result + (Nombre != null ? Nombre.hashCode() : 0);
        result = 31 * result + (Apellido_M != null ? Apellido_M.hashCode() : 0);
        result = 31 * result + (Apellido_P != null ? Apellido_P.hashCode() : 0);
        result = 31 * result + (Email != null ? Email.hashCode() : 0);
        result = 31 * result + (Clave != null ? Clave.hashCode() : 0);
        result = 31 * result + (Telefono != null ? Telefono.hashCode() : 0);
        result = 31 * result + (Direccion_Primaria != null ? Direccion_Primaria.hashCode() : 0);
        return result;
    }

}
