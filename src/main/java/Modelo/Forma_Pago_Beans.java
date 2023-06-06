package Modelo;

import java.io.Serializable;
import java.sql.Date;

public class Forma_Pago_Beans implements Serializable {
    private int ID_Forma_Pago, FK_Cliente_FP;
    private String Tipo_Pago, Proveedor, Num_Cuenta;
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
}
