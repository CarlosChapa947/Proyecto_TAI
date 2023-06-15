package Modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "\"Direcciones\"", schema = "\"Proyecto\"", catalog = "Ecommerce")
public class Direcciones_Beans implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "\"ID_Direcciones\"", nullable = false)
    private int ID_Direcciones;
    @Basic
    @Column(name = "\"FK_Direccion_C\"", nullable = true)
    private Integer Direccion_C;
    @Basic
    @Column(name = "\"Codigo_Postal\"", nullable = false, length = -1)
    private String Codigo_Postal;
    @Basic
    @Column(name = "\"Direccion\"", nullable = false, length = -1)
    private String Direccion;

    public Direcciones_Beans(){

    }

    public Direcciones_Beans(int Direccion_C, String Codigo_Postal, String Direccion){
        this.Direccion_C = Direccion_C;
        this.Codigo_Postal = Codigo_Postal;
        this.Direccion = Direccion;
    }

    public Direcciones_Beans(int ID_Direcciones ,int Direccion_C, String Codigo_Postal, String Direccion){
        this.ID_Direcciones = ID_Direcciones;
        this.Direccion_C = Direccion_C;
        this.Codigo_Postal = Codigo_Postal;
        this.Direccion = Direccion;
    }

    public void setID_Direcciones(int ID_Direcciones) {
        this.ID_Direcciones = ID_Direcciones;
    }

    public int getID_Direcciones() {
        return ID_Direcciones;
    }

    public void setDireccion_C(int direccion_C) {
        Direccion_C = direccion_C;
    }

    public int getDireccion_C() {
        return Direccion_C;
    }

    public void setCodigo_Postal(String codigo_Postal) {
        Codigo_Postal = codigo_Postal;
    }

    public String getCodigo_Postal() {
        return Codigo_Postal;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getDireccion() {
        return Direccion;
    }

    @Override
    public String toString() {
        return "Direcciones_Beans{" + "ID_Direcciones=" + ID_Direcciones +
                ", Direccion_C=" + Direccion_C +
                ", Codigo_Postal='" + Codigo_Postal + '\'' +
                ", Direccion='" + Direccion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direcciones_Beans that = (Direcciones_Beans) o;

        if (ID_Direcciones != that.ID_Direcciones) return false;
        if (Direccion_C != null ? !Direccion_C.equals(that.Direccion_C) : that.Direccion_C != null) return false;
        if (Codigo_Postal != null ? !Codigo_Postal.equals(that.Codigo_Postal) : that.Codigo_Postal != null) return false;
        if (Direccion != null ? !Direccion.equals(that.Direccion) : that.Direccion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ID_Direcciones;
        result = 31 * result + (Direccion_C != null ? Direccion_C.hashCode() : 0);
        result = 31 * result + (Codigo_Postal != null ? Codigo_Postal.hashCode() : 0);
        result = 31 * result + (Direccion != null ? Direccion.hashCode() : 0);
        return result;
    }
}
