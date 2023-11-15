package model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (nullable = false, unique = true)
    private String nome;
    @ManyToMany
    @JoinColumn(name = "Genero_id")
    private List<Genero> generos;
    @Column
    private Date lancamento;

    public Filme() {
    }

    public Filme(String nome, Date lancamento) {
        this.nome = nome;
        this.lancamento = lancamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public Date getLancamento() {
        return lancamento;
    }

    public void setLancamento(Date lancamento) {
        this.lancamento = lancamento;
    }
}
