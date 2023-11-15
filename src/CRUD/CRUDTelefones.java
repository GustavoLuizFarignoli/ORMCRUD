package CRUD;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.Clientes;
import model.Telefones;

import java.util.List;

public class CRUDTelefones {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    public static void main(String[] args) {
        CreateTelefones("991192406");
    }

    public static void CreateTelefones(String numero){
        Telefones telefone = new Telefones(numero);

        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(telefone);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

    public static void LerTodosTelefones(){
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        Query query = em.createQuery("select t from Telefones t");
        List<Telefones> telefones = query.getResultList();
        for (Telefones t: telefones) {
            System.out.println("Número: " + t.getNumero());
        }

        em.close();
        emf.close();
    }


}
