package CRUD;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.Genero;

public class CRUDGeneros {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void main(String[] args) {
        createGenero("Ação");
        createGenero("Comédia");

        listAllGeneros();
    }

    public static void createGenero(String nome) {
        Genero genero = new Genero(nome);

        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(genero);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public static void listAllGeneros() {
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        Query query = em.createQuery("select g from Genero g");
        List<Genero> generos = query.getResultList();

        for (Genero g : generos) {
            System.out.println("Nome do Gênero: " + g.getNome());
        }

        em.close();
        emf.close();
    }

    public static void updateGenero(String nomeAtualizado, Long id) {
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();

        Genero generoProcurado = em.find(Genero.class, id);
        generoProcurado.setNome(nomeAtualizado);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public static void deleteGenero(Long id) {
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();

        Genero generoProcurado = em.find(Genero.class, id);
        em.remove(generoProcurado);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public static Genero findGeneroById(Long id) {
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        Genero generoProcurado = em.find(Genero.class, id);

        em.close();
        emf.close();

        return generoProcurado;
    }
}