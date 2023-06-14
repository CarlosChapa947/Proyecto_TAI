package Modelo;

import javax.persistence.*;

@Entity
@Table(name = "Carrito_Cliente", schema = "Proyecto", catalog = "Ecommerce")
public class CarritoClienteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Carrito", nullable = false)
    private int idCarrito;
    @Basic
    @Column(name = "FK_Cliente", nullable = true)
    private Integer fkCliente;
    @Basic
    @Column(name = "Status", nullable = true, length = -1)
    private String status;

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Integer getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Integer fkCliente) {
        this.fkCliente = fkCliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarritoClienteEntity that = (CarritoClienteEntity) o;

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
