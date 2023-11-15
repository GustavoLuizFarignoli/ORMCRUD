package CRUD;

import java.util.List;

import jakarta.persistence.*;
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

        try {
            Genero generoProcurado = findGenerobyname(nome,em);
            System.out.println("Este Gênero já está cadastrado");
        } catch (NoResultException e){
            em.persist(genero);
            System.out.println("Gênero Cadastrado com Sucesso");
        }

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
            System.out.println("Nome do Gênero: " + g.getNome() + " Id: " + g.getId());
        }

        em.close();
        emf.close();
    }

    public static void updateGenero(String nomeAtualizado, int id) {
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();

        try {
            Genero generoProcurado = em.find(Genero.class, id);
            generoProcurado.setNome(nomeAtualizado);
        } catch (NoResultException e){
            System.out.println("Não foi possivel encontrar o Gênero, tente novamente");
        }

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public static void deleteGenero(int id) {
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();

        try {
            Genero generoProcurado = em.find(Genero.class, id);
            em.remove(generoProcurado);
        } catch (NoResultException e){
            System.out.println("Não foi possivel encontrar o Gênero, tente novamente");
        }

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public static Genero findGeneroById(int id, EntityManager em) {

        return em.find(Genero.class, id);
    }

    public static Genero findGenerobyname(String nome, EntityManager em){
        Query query = em.createQuery("select g from Genero g where g.nome = :nome");
        query.setParameter("nome", nome);
        List<Genero> generos = query.getResultList();

        return (Genero) query.getSingleResult();
    }
}