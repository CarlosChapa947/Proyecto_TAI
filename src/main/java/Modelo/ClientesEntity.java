package Modelo;

import javax.persistence.*;

@Entity
@Table(name = "\"Clientes\"", schema = "\"Proyecto\"", catalog = "Ecommerce")
public class ClientesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "\"ID_Cliente\"", nullable = false)
    private int idCliente;
    @Basic
    @Column(name = "\"Nombre\"", nullable = true, length = -1)
    private String nombre;
    @Basic
    @Column(name = "\"Apellido_M\"", nullable = true, length = -1)
    private String apellidoM;
    @Basic
    @Column(name = "\"Apellido_P\"", nullable = true, length = -1)
    private String apellidoP;
    @Basic
    @Column(name = "\"Email\"", nullable = true, length = -1)
    private String email;
    @Basic
    @Column(name = "\"Clave\"", nullable = true, length = -1)
    private String clave;
    @Basic
    @Column(name = "\"Telefono\"", nullable = true, length = -1)
    private String telefono;
    @Basic
    @Column(name = "\"Direccion_Primaria\"", nullable = true)
    private Integer direccionPrimaria;

    public ClientesEntity (String Nombre, String ApellidoP, String ApellidoM, String Email, String Password){
        this.nombre = Nombre;
        this.apellidoP = ApellidoP;
        this.apellidoM = ApellidoM;
        this.email = Email;
        this.clave = Password;
        this.telefono = null;
    }

    public ClientesEntity() {

    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getDireccionPrimaria() {
        return direccionPrimaria;
    }

    public void setDireccionPrimaria(Integer direccionPrimaria) {
        this.direccionPrimaria = direccionPrimaria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientesEntity that = (ClientesEntity) o;

        if (idCliente != that.idCliente) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (apellidoM != null ? !apellidoM.equals(that.apellidoM) : that.apellidoM != null) return false;
        if (apellidoP != null ? !apellidoP.equals(that.apellidoP) : that.apellidoP != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (clave != null ? !clave.equals(that.clave) : that.clave != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        if (direccionPrimaria != null ? !direccionPrimaria.equals(that.direccionPrimaria) : that.direccionPrimaria != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCliente;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellidoM != null ? apellidoM.hashCode() : 0);
        result = 31 * result + (apellidoP != null ? apellidoP.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (clave != null ? clave.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (direccionPrimaria != null ? direccionPrimaria.hashCode() : 0);
        return result;
    }
}
