package Modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "\"Categorias\"", schema = "\"Proyecto\"", catalog = "Ecommerce")
public class Categorias_Beans implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "\"ID_Categorias\"", nullable = false)
    private int ID_Categorias;
    @Basic
    @Column(name = "\"Nombre\"", nullable = true, length = -1)
    private String Nombre;
    @Basic
    @Column(name = "\"Image_Name\"", nullable = true, length = -1)
    private String imageName;
    public Categorias_Beans(){

    }

    public Categorias_Beans(String Nombre){
        this.Nombre = Nombre;
    }

    public Categorias_Beans(int ID, String Nombre, String imageName){
        this.ID_Categorias = ID;
        this.Nombre = Nombre;
        this.imageName = imageName;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setID_Categorias(int ID_Categorias) {
        this.ID_Categorias = ID_Categorias;
    }

    public int getID_Categorias() {
        return this.ID_Categorias;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageName() {
        return imageName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Categorias_Beans{");
        sb.append("ID_Categorias=").append(ID_Categorias);
        sb.append(", Nombre='").append(Nombre).append('\'');
        sb.append(", imageName='").append(imageName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categorias_Beans that = (Categorias_Beans) o;

        if (ID_Categorias != that.ID_Categorias) return false;
        if (Nombre != null ? !Nombre.equals(that.Nombre) : that.Nombre != null) return false;
        if (imageName != null ? !imageName.equals(that.imageName) : that.imageName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ID_Categorias;
        result = 31 * result + (Nombre != null ? Nombre.hashCode() : 0);
        result = 31 * result + (imageName != null ? imageName.hashCode() : 0);
        return result;
    }

}
