package model;

import jakarta.persistence.*;


import java.util.List;

@Entity
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "Cliente_id")
    private int id;
    @Column
    private String cpf;
    @OneToMany (mappedBy = "id_cliente")
    private List<Telefones> telefone;

    public Clientes() {
    }

    public Clientes(String cpf, List<Telefones> telefone) {
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Telefones> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Telefones> telefone) {
        this.telefone = telefone;
    }
}
