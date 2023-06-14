package Modelo;

import javax.persistence.*;

@Entity
@Table(name = "Direcciones", schema = "Proyecto", catalog = "Ecommerce")
public class DireccionesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Direcciones", nullable = false)
    private int idDirecciones;
    @Basic
    @Column(name = "FK_Direccion_C", nullable = true)
    private Integer fkDireccionC;
    @Basic
    @Column(name = "Codigo_Postal", nullable = false, length = -1)
    private String codigoPostal;
    @Basic
    @Column(name = "Direccion", nullable = false, length = -1)
    private String direccion;

    public int getIdDirecciones() {
        return idDirecciones;
    }

    public void setIdDirecciones(int idDirecciones) {
        this.idDirecciones = idDirecciones;
    }

    public Integer getFkDireccionC() {
        return fkDireccionC;
    }

    public void setFkDireccionC(Integer fkDireccionC) {
        this.fkDireccionC = fkDireccionC;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DireccionesEntity that = (DireccionesEntity) o;

        if (idDirecciones != that.idDirecciones) return false;
        if (fkDireccionC != null ? !fkDireccionC.equals(that.fkDireccionC) : that.fkDireccionC != null) return false;
        if (codigoPostal != null ? !codigoPostal.equals(that.codigoPostal) : that.codigoPostal != null) return false;
        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDirecciones;
        result = 31 * result + (fkDireccionC != null ? fkDireccionC.hashCode() : 0);
        result = 31 * result + (codigoPostal != null ? codigoPostal.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        return result;
    }
}
