package CRUD;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import model.Filme;
import model.Genero;

import static CRUD.CRUDFilmes.buscarPornome;
import static CRUD.CRUDGeneros.findGenerobyname;

public class CRUDFilmeGen {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void main(String[] args) {
        AddGenero("Ação","Divertida Mente");
        RemoveGenero("Ação","Divertida Mente");
    }

    public static void CreateFilmGen (Filme filme, Genero genero, EntityManager em){

    }

    public static void AddGenero(String genero, String filme){
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();

        try{
            Filme filmebuscado = buscarPornome(filme,em);
            Genero generobuscado = findGenerobyname(genero,em);
            filmebuscado.getGeneros().add(generobuscado);
        } catch (NoResultException e){
            System.out.println("Não Foi possivel encontrar o Filme ou Gênero digitado tente novamente");
        }



        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void RemoveGenero(String genero, String filme){
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();

        try{
            Filme filmebuscado = buscarPornome(filme,em);
            Genero generobuscado = findGenerobyname(genero,em);
            filmebuscado.getGeneros().remove(generobuscado);
        } catch (NoResultException e){
            System.out.println("Não Foi possivel encontrar o Filme ou Gênero digitado tente novamente");
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
