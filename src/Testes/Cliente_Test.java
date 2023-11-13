package Testes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Clientes;

public class Cliente_Test {
    public static void main(String[] args) {
        //Vai criar a tabela automaticamente e inserir o registro
        //Se a tabela ja estiver criada vai apenas inserir o registro nela
        Clientes cliente = new Clientes("123",null);

        //Vai validar a conexao com o banco no arquivo persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LocadoraPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
