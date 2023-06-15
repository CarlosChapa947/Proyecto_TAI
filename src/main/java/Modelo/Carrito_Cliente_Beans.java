package Modelo;

import java.io.Serializable;
import java.util.LinkedList;
import javax.persistence.*;

@Entity
@Table(name = "\"Carrito_Cliente\"", schema = "\"Proyecto\"", catalog = "Ecommerce")
public class Carrito_Cliente_Beans implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "\"ID_Carrito\"", nullable = false)
    private int idCarrito;
    @Basic
    @Column(name = "\"FK_Cliente\"", nullable = true)
    private Integer fkCliente;
    @Basic
    @Column(name = "\"Status\"", nullable = true, length = -1)
    private String status;

    public Carrito_Cliente_Beans(){

    }

    public Carrito_Cliente_Beans(String Status){
        this.status = Status;
    }

    public Carrito_Cliente_Beans(int FK_Cliente, String Status){
        this.fkCliente = FK_Cliente;
        this.status = Status;
    }

    public Carrito_Cliente_Beans(int ID_Carrito, int FK_Cliente, String Status){
        this.idCarrito = ID_Carrito;
        this.fkCliente = FK_Cliente;
        this.status = Status;
    }

    public void setID_Carrito(int ID_Carrito) {
        this.idCarrito = ID_Carrito;
    }

    public int getID_Carrito() {
        return idCarrito;
    }

    public void setStatus(String status) {
        status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setFK_Cliente(int FK_Cliente) {
        this.fkCliente = FK_Cliente;
    }

    public int getFK_Cliente() {
        return fkCliente;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Carrito_Cliente_Beans that = (Carrito_Cliente_Beans) o;

        if (idCarrito != that.idCarrito) return false;
        if (fkCliente != null ? !fkCliente.equals(that.fkCliente) : that.fkCliente != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCarrito;
        result = 31 * result + (fkCliente != null ? fkCliente.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

}
