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

}
