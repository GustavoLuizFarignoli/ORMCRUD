package model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column (nullable = false)
    private Date data_locacao;
    @Column (nullable = false)
    private Date devolucao;
    @ManyToOne
    @JoinColumn (name = "Cliente_id")
    private Clientes id_clientes;
    @ManyToOne
    @JoinColumn (name = "Filme_id")
    private Filme id_filme;

    public Locacao() {
    }

    public Locacao(Date data_locacao, Date devolucao, Clientes id_clientes, Filme id_filme) {
        this.data_locacao = data_locacao;
        this.devolucao = devolucao;
        this.id_clientes = id_clientes;
        this.id_filme = id_filme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_locacao() {
        return data_locacao;
    }

    public void setData_locacao(Date data_locacao) {
        this.data_locacao = data_locacao;
    }

    public Date getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Date devolucao) {
        this.devolucao = devolucao;
    }

    public Clientes getId_clientes() {
        return id_clientes;
    }

    public void setId_clientes(Clientes id_clientes) {
        this.id_clientes = id_clientes;
    }

    public Filme getId_filme() {
        return id_filme;
    }

    public void setId_filme(Filme id_filme) {
        this.id_filme = id_filme;
    }
}
