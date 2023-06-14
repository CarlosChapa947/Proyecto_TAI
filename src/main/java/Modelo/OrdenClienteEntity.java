package Modelo;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "Orden_Cliente", schema = "Proyecto", catalog = "Ecommerce")
public class OrdenClienteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Orden_Cliente", nullable = false)
    private int idOrdenCliente;
    @Basic
    @Column(name = "Total", nullable = false, precision = 0)
    private double total;
    @Basic
    @Column(name = "Fecha_Ultima_A", nullable = true)
    private Time fechaUltimaA;
    @Basic
    @Column(name = "Num_Confirmacion", nullable = false)
    private int numConfirmacion;
    @Basic
    @Column(name = "Status", nullable = true, length = -1)
    private String status;
    @Basic
    @Column(name = "FK_Cliente_OC", nullable = true)
    private Integer fkClienteOc;
    @Basic
    @Column(name = "Direccion", nullable = true)
    private Integer direccion;
    @Basic
    @Column(name = "Detalles_Pago", nullable = true)
    private Integer detallesPago;

    public int getIdOrdenCliente() {
        return idOrdenCliente;
    }

    public void setIdOrdenCliente(int idOrdenCliente) {
        this.idOrdenCliente = idOrdenCliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Time getFechaUltimaA() {
        return fechaUltimaA;
    }

    public void setFechaUltimaA(Time fechaUltimaA) {
        this.fechaUltimaA = fechaUltimaA;
    }

    public int getNumConfirmacion() {
        return numConfirmacion;
    }

    public void setNumConfirmacion(int numConfirmacion) {
        this.numConfirmacion = numConfirmacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getFkClienteOc() {
        return fkClienteOc;
    }

    public void setFkClienteOc(Integer fkClienteOc) {
        this.fkClienteOc = fkClienteOc;
    }

    public Integer getDireccion() {
        return direccion;
    }

    public void setDireccion(Integer direccion) {
        this.direccion = direccion;
    }

    public Integer getDetallesPago() {
        return detallesPago;
    }

    public void setDetallesPago(Integer detallesPago) {
        this.detallesPago = detallesPago;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdenClienteEntity that = (OrdenClienteEntity) o;

        if (idOrdenCliente != that.idOrdenCliente) return false;
        if (Double.compare(that.total, total) != 0) return false;
        if (numConfirmacion != that.numConfirmacion) return false;
        if (fechaUltimaA != null ? !fechaUltimaA.equals(that.fechaUltimaA) : that.fechaUltimaA != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (fkClienteOc != null ? !fkClienteOc.equals(that.fkClienteOc) : that.fkClienteOc != null) return false;
        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;
        if (detallesPago != null ? !detallesPago.equals(that.detallesPago) : that.detallesPago != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idOrdenCliente;
        temp = Double.doubleToLongBits(total);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (fechaUltimaA != null ? fechaUltimaA.hashCode() : 0);
        result = 31 * result + numConfirmacion;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (fkClienteOc != null ? fkClienteOc.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (detallesPago != null ? detallesPago.hashCode() : 0);
        return result;
    }
}
