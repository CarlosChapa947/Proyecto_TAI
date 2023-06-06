package Modelo;

import java.io.Serializable;
import java.util.LinkedList;

public class Carrito_Cliente_Beans implements Serializable {
    private int ID_Carrito, FK_Cliente;
    private String Status;
    public Carrito_Cliente_Beans(){

    }

    public Carrito_Cliente_Beans(String Status){
        this.Status = Status;
    }

    public Carrito_Cliente_Beans(int FK_Cliente, String Status){
        this.FK_Cliente = FK_Cliente;
        this.Status = Status;
    }

    public Carrito_Cliente_Beans(int ID_Carrito, int FK_Cliente, String Status){
        this.ID_Carrito = ID_Carrito;
        this.FK_Cliente = FK_Cliente;
        this.Status = Status;
    }

    public void setID_Carrito(int ID_Carrito) {
        this.ID_Carrito = ID_Carrito;
    }

    public int getID_Carrito() {
        return ID_Carrito;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getStatus() {
        return Status;
    }

    public void setFK_Cliente(int FK_Cliente) {
        this.FK_Cliente = FK_Cliente;
    }

    public int getFK_Cliente() {
        return FK_Cliente;
    }


}
