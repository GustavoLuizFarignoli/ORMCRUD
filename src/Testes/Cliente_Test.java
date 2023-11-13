package Testes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Clientes;
import model.Telefones;

import java.util.ArrayList;
import java.util.List;

public class Cliente_Test {
    public static void main(String[] args) {
        //Vai criar a tabela automaticamente e inserir o registro
        //Se a tabela ja estiver criada vai apenas inserir o registro nela
        Telefones telefone = new Telefones("41 99119-2408");
        Clientes cliente = new Clientes("Gustavo","08992748974");
        cliente.getTelefone().add(telefone);
        telefone.setId_cliente(cliente);

        //Vai validar a conexao com o banco no arquivo persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LocadoraPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(cliente);
        em.persist(telefone);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
