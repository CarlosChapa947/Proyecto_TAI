package Modelo;

import java.io.Serializable;
import java.sql.Timestamp;
public class Orden_Cliente_Beans implements Serializable {
    private int ID_Orden_Cliente, FK_Cliente_O, Num_Confirmacion, FK_Direccion, Detalle_Pago;
    private double Total;
    private String Status;
    private Timestamp Fecha;
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
}
