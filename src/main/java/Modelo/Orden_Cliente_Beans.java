package Modelo;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name = "\"Orden_Cliente\"", schema = "\"Proyecto\"", catalog = "Ecommerce")
public class Orden_Cliente_Beans implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "\"ID_Orden_Cliente\"", nullable = false)
    private int ID_Orden_Cliente;
    @Basic
    @Column(name = "\"Total\"", nullable = false, precision = 0)
    private double Total;
    @Basic
    @Column(name = "\"Fecha_Ultima_A\"", nullable = true)
    private Timestamp Fecha;
    @Basic
    @Column(name = "\"Num_Confirmacion\"", nullable = false)
    private int Num_Confirmacion;
    @Basic
    @Column(name = "\"Status\"", nullable = true, length = -1)
    private String Status;
    @Basic
    @Column(name = "\"FK_Cliente_OC\"", nullable = true)
    private Integer FK_Cliente_O;
    @Basic
    @Column(name = "\"Direccion\"", nullable = true)
    private Integer FK_Direccion;
    @Basic
    @Column(name = "\"Detalles_Pago\"", nullable = true)
    private Integer Detalle_Pago;

    public Orden_Cliente_Beans(){

    }

    public Orden_Cliente_Beans(int FK_Cliente_O, int Num_confirmacion, int FK_Direccion, double Total,
                               String Status, Timestamp Fecha, int Detalle_Pago){
        this.FK_Cliente_O = FK_Cliente_O;
        this.Num_Confirmacion = Num_confirmacion;
        this.FK_Direccion = FK_Direccion;
        this.Total = Total;
        this.Status = Status;
        this.Fecha = Fecha;
        this.Detalle_Pago = Detalle_Pago;
    }

    public Orden_Cliente_Beans(int ID_Orden_Cliente, int FK_Cliente_O, int Num_confirmacion, int FK_Direccion, double Total,
                               String Status, Timestamp Fecha, int Detalle_Pago){
        this.ID_Orden_Cliente = ID_Orden_Cliente;
        this.FK_Cliente_O = FK_Cliente_O;
        this.Num_Confirmacion = Num_confirmacion;
        this.FK_Direccion = FK_Direccion;
        this.Total = Total;
        this.Status = Status;
        this.Fecha = Fecha;
        this.Detalle_Pago = Detalle_Pago;
    }

    public void setID_Orden_Cliente(int ID_Orden_Cliente) {
        this.ID_Orden_Cliente = ID_Orden_Cliente;
    }

    public int getID_Orden_Cliente() {
        return ID_Orden_Cliente;
    }

    public void setFK_Cliente_O(int FK_Cliente_O) {
        this.FK_Cliente_O = FK_Cliente_O;
    }

    public int getFK_Cliente_O() {
        return FK_Cliente_O;
    }

    public void setFK_Direccion(int FK_Direccion) {
        this.FK_Direccion = FK_Direccion;
    }

    public int getFK_Direccion() {
        return FK_Direccion;
    }

    public void setNum_Confirmacion(int num_Confirmacion) {
        Num_Confirmacion = num_Confirmacion;
    }

    public int getNum_Confirmacion() {
        return Num_Confirmacion;
    }

    public void setTotal(double total) {
        Total = total;
    }

    public double getTotal() {
        return Total;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getStatus() {
        return Status;
    }

    public void setFecha(Timestamp fecha) {
        Fecha = fecha;
    }

    public Timestamp getFecha() {
        return Fecha;
    }

    public void setDetalle_Pago(int detalle_Pago) {
        Detalle_Pago = detalle_Pago;
    }

    public int getDetalle_Pago() {
        return Detalle_Pago;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Orden_Cliente_Beans{");
        sb.append("ID_Orden_Cliente=").append(ID_Orden_Cliente);
        sb.append(", FK_Cliente_O=").append(FK_Cliente_O);
        sb.append(", Num_Confirmacion=").append(Num_Confirmacion);
        sb.append(", FK_Direccion=").append(FK_Direccion);
        sb.append(", Detalle_Pago=").append(Detalle_Pago);
        sb.append(", Total=").append(Total);
        sb.append(", Status='").append(Status).append('\'');
        sb.append(", Fecha=").append(Fecha);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orden_Cliente_Beans that = (Orden_Cliente_Beans) o;

        if (ID_Orden_Cliente != that.ID_Orden_Cliente) return false;
        if (Double.compare(that.Total, Total) != 0) return false;
        if (Num_Confirmacion != that.Num_Confirmacion) return false;
        if (Fecha != null ? !Fecha.equals(that.Fecha) : that.Fecha != null) return false;
        if (Status != null ? !Status.equals(that.Status) : that.Status != null) return false;
        if (FK_Cliente_O != null ? !FK_Cliente_O.equals(that.FK_Cliente_O) : that.FK_Cliente_O != null) return false;
        if (FK_Direccion != null ? !FK_Direccion.equals(that.FK_Direccion) : that.FK_Direccion != null) return false;
        if (Detalle_Pago != null ? !Detalle_Pago.equals(that.Detalle_Pago) : that.Detalle_Pago != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = ID_Orden_Cliente;
        temp = Double.doubleToLongBits(Total);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (Fecha != null ? Fecha.hashCode() : 0);
        result = 31 * result + Num_Confirmacion;
        result = 31 * result + (Status != null ? Status.hashCode() : 0);
        result = 31 * result + (FK_Cliente_O != null ? FK_Cliente_O.hashCode() : 0);
        result = 31 * result + (FK_Direccion != null ? FK_Direccion.hashCode() : 0);
        result = 31 * result + (Detalle_Pago != null ? Detalle_Pago.hashCode() : 0);
        return result;
    }
}
