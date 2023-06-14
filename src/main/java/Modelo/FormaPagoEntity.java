package Modelo;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Forma_Pago", schema = "Proyecto", catalog = "Ecommerce")
public class FormaPagoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Forma_Pago", nullable = false)
    private int idFormaPago;
    @Basic
    @Column(name = "FK_Cliente_FP", nullable = true)
    private Integer fkClienteFp;
    @Basic
    @Column(name = "Tipo_Pago", nullable = false, length = -1)
    private String tipoPago;
    @Basic
    @Column(name = "Proveedor", nullable = false, length = -1)
    private String proveedor;
    @Basic
    @Column(name = "Num_Cuenta", nullable = false, length = -1)
    private String numCuenta;
    @Basic
    @Column(name = "Expiracion", nullable = false)
    private Date expiracion;

    public int getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(int idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public Integer getFkClienteFp() {
        return fkClienteFp;
    }

    public void setFkClienteFp(Integer fkClienteFp) {
        this.fkClienteFp = fkClienteFp;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public Date getExpiracion() {
        return expiracion;
    }

    public void setExpiracion(Date expiracion) {
        this.expiracion = expiracion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FormaPagoEntity that = (FormaPagoEntity) o;

        if (idFormaPago != that.idFormaPago) return false;
        if (fkClienteFp != null ? !fkClienteFp.equals(that.fkClienteFp) : that.fkClienteFp != null) return false;
        if (tipoPago != null ? !tipoPago.equals(that.tipoPago) : that.tipoPago != null) return false;
        if (proveedor != null ? !proveedor.equals(that.proveedor) : that.proveedor != null) return false;
        if (numCuenta != null ? !numCuenta.equals(that.numCuenta) : that.numCuenta != null) return false;
        if (expiracion != null ? !expiracion.equals(that.expiracion) : that.expiracion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFormaPago;
        result = 31 * result + (fkClienteFp != null ? fkClienteFp.hashCode() : 0);
        result = 31 * result + (tipoPago != null ? tipoPago.hashCode() : 0);
        result = 31 * result + (proveedor != null ? proveedor.hashCode() : 0);
        result = 31 * result + (numCuenta != null ? numCuenta.hashCode() : 0);
        result = 31 * result + (expiracion != null ? expiracion.hashCode() : 0);
        return result;
    }
}
