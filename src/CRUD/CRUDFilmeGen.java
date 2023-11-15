package CRUD;

import jakarta.persistence.*;
import model.Filme;
import model.Genero;
import model.Locacao;

import java.util.List;

import static CRUD.CRUDFilmes.buscarPornome;
import static CRUD.CRUDGeneros.findGenerobyname;

public class CRUDFilmeGen {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void main(String[] args) {
        AddGenero("Ação","Divertida Mente");
        RemoveGenero("Ação","Divertida Mente");
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

    public static void FilmeporGenero(String nome){
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();

        try{
            Genero generobuscado = findGenerobyname(nome,em);
            Query query = em.createQuery("select f from Filme f where f.generos = :id");
            query.setParameter("id", generobuscado);
            List<Filme> filmes = query.getResultList();

            for (Filme f: filmes) {
                System.out.println("Nome: " + f.getNome() + " / Lançamento: " + f.getLancamento());
            }
        } catch (NoResultException e){
            System.out.println("Não Foi possivel encontrar o Filme ou Gênero digitado tente novamente");
        }
    }
}
