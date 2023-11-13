package model;

import jakarta.persistence.*;

@Entity
public class Telefones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (nullable = false, unique = true)
    private String numero;
    @ManyToOne
    @JoinColumn (name = "Cliente_id")
    private Clientes id_cliente;

    public Telefones(String numero) {
        this.numero = numero;
    }

    public Telefones() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Clientes getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Clientes id_cliente) {
        this.id_cliente = id_cliente;
    }
}
