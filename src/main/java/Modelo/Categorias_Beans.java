package Modelo;

import java.io.Serializable;

public class Categorias_Beans implements Serializable {
    private int ID_Categorias;
    private String Nombre, imageName;

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
}
