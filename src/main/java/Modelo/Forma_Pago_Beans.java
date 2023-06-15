package Modelo;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;


@Entity
@Table(name = "\"Forma_Pago\"", schema = "\"Proyecto\"", catalog = "Ecommerce")
public class Forma_Pago_Beans implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "\"ID_Forma_Pago\"", nullable = false)
    private int ID_Forma_Pago;
    @Basic
    @Column(name = "\"FK_Cliente_FP\"", nullable = true)
    private Integer FK_Cliente_FP;
    @Basic
    @Column(name = "\"Tipo_Pago\"", nullable = false, length = -1)
    private String Tipo_Pago;
    @Basic
    @Column(name = "\"Proveedor\"", nullable = false, length = -1)
    private String Proveedor;
    @Basic
    @Column(name = "\"Num_Cuenta\"", nullable = false, length = -1)
    private String Num_Cuenta;
    @Basic
    @Column(name = "\"Expiracion\"", nullable = false)
    private Date Expiracion;


    public Forma_Pago_Beans(){

    }

    public Forma_Pago_Beans(int FK_Cliente_FP, String num_Cuenta, String tipo_Pago, String proveedor, Date expiracion){
        this.FK_Cliente_FP = FK_Cliente_FP;
        this.Num_Cuenta = num_Cuenta;
        this.Tipo_Pago = tipo_Pago;
        this.Proveedor = proveedor;
        this.Expiracion = expiracion;
    }

    public Forma_Pago_Beans(int ID_Forma_Pago, int FK_Cliente_FP, String num_Cuenta, String tipo_Pago, String proveedor, Date expiracion){
        this.ID_Forma_Pago = ID_Forma_Pago;
        this.FK_Cliente_FP = FK_Cliente_FP;
        this.Num_Cuenta = num_Cuenta;
        this.Tipo_Pago = tipo_Pago;
        this.Proveedor = proveedor;
        this.Expiracion = expiracion;
    }

    public void setID_Forma_Pago(int ID_Forma_Pago) {
        this.ID_Forma_Pago = ID_Forma_Pago;
    }

    public int getID_Forma_Pago() {
        return ID_Forma_Pago;
    }

    public void setFK_Cliente_FP(int FK_Cliente_FP) {
        this.FK_Cliente_FP = FK_Cliente_FP;
    }

    public int getFK_Cliente_FP() {
        return FK_Cliente_FP;
    }

    public void setNum_Cuenta(String num_Cuenta) {
        Num_Cuenta = num_Cuenta;
    }

    public String getNum_Cuenta() {
        return Num_Cuenta;
    }

    public void setTipo_Pago(String tipo_Pago) {
        Tipo_Pago = tipo_Pago;
    }

    public String getTipo_Pago() {
        return Tipo_Pago;
    }

    public void setProveedor(String proveedor) {
        Proveedor = proveedor;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setExpiracion(Date expiracion) {
        Expiracion = expiracion;
    }

    public Date getExpiracion() {
        return Expiracion;
    }

    @Override
    public String toString() {
        return "Forma_Pago_Beans{" + "ID_Forma_Pago=" + ID_Forma_Pago +
                ", FK_Cliente_FP=" + FK_Cliente_FP +
                ", Num_Cuenta=" + Num_Cuenta +
                ", Tipo_Pago='" + Tipo_Pago + '\'' +
                ", Proveedor='" + Proveedor + '\'' +
                ", Expiracion=" + Expiracion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Forma_Pago_Beans that = (Forma_Pago_Beans) o;

        if (ID_Forma_Pago != that.ID_Forma_Pago) return false;
        if (FK_Cliente_FP != null ? !FK_Cliente_FP.equals(that.FK_Cliente_FP) : that.FK_Cliente_FP != null) return false;
        if (Tipo_Pago != null ? !Tipo_Pago.equals(that.Tipo_Pago) : that.Tipo_Pago != null) return false;
        if (Proveedor != null ? !Proveedor.equals(that.Proveedor) : that.Proveedor != null) return false;
        if (Num_Cuenta != null ? !Num_Cuenta.equals(that.Num_Cuenta) : that.Num_Cuenta != null) return false;
        if (Expiracion != null ? !Expiracion.equals(that.Expiracion) : that.Expiracion != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = ID_Forma_Pago;
        result = 31 * result + (FK_Cliente_FP != null ? FK_Cliente_FP.hashCode() : 0);
        result = 31 * result + (Tipo_Pago != null ? Tipo_Pago.hashCode() : 0);
        result = 31 * result + (Proveedor != null ? Proveedor.hashCode() : 0);
        result = 31 * result + (Num_Cuenta != null ? Num_Cuenta.hashCode() : 0);
        result = 31 * result + (Expiracion != null ? Expiracion.hashCode() : 0);
        return result;
    }
}
