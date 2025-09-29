package cl.ucn.comercio.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="producto")
public class Producto {

    @Id
    @Column(name = "producto_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int serialNumber;
    String marca;
    int anho;

    int tamanho;


    public int getAño() {
        return anho;
    }

    public void setAño(int anho) {
        this.anho = anho;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


}
