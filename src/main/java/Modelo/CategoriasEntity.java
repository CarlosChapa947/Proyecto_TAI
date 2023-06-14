package Modelo;

import javax.persistence.*;

@Entity
@Table(name = "\"Categorias\"", schema = "\"Proyecto\"", catalog = "Ecommerce")
public class CategoriasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "\"ID_Categorias\"", nullable = false)
    private int idCategorias;
    @Basic
    @Column(name = "\"Nombre\"", nullable = true, length = -1)
    private String nombre;
    @Basic
    @Column(name = "\"Image_Name\"", nullable = true, length = -1)
    private String imageName;

    public int getIdCategorias() {
        return idCategorias;
    }

    public void setIdCategorias(int idCategorias) {
        this.idCategorias = idCategorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoriasEntity that = (CategoriasEntity) o;

        if (idCategorias != that.idCategorias) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (imageName != null ? !imageName.equals(that.imageName) : that.imageName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCategorias;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (imageName != null ? imageName.hashCode() : 0);
        return result;
    }
}
