package CRUD;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Filme;

import static CRUD.CRUDFilmes.buscarPornome;

public class CRUDFilmeGen {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    public static void AddGenero(String genero, String filme){
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();

        Filme filmebuscado = buscarPornome(filme,em);
        //função de buscar o genero  Genero generobuscado = buscargenero(genero,em)
        //filmebuscado.getGeneros().add(generobuscado);
        //função de criar linha da tabela de relacionamento CreateFilmGen(filmebuscado,generobuscado);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void DeleteGenero(String genero, String filme){
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();

        Filme filmebuscado = buscarPornome(filme,em);
        //função de buscar o genero  Genero generobuscado = buscargenero(genero,em)
        //filmebuscado.getGeneros().remove(generobuscado);
        //função de deletar linha da tabela de relacionamento DeleteFilmGen(filmebuscado,generobuscado);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
