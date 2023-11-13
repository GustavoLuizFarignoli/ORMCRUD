package model;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String nome;

    @Column (nullable = false, unique = true)
    private String cpf;
    @OneToMany (mappedBy = "id_cliente")
    private List<Telefones> telefone = new ArrayList<Telefones>();

    public Clientes() {
    }

    public Clientes(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
