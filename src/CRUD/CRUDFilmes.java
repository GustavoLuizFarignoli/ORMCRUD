package CRUD;

import jakarta.persistence.*;
import model.Clientes;
import model.Filme;
import model.Genero;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CRUDFilmes {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void main(String[] args) {
        // POR ALGUM MOTIVO ESQUISITO O DATE ADICIONA 1900 ANO ENTÃO TEM PASSAR X-1900 COMO PARAMETRO, EX PARA TER 2018 TEM QUE FAZER Date data = new Date(2018-1900, Calendar.JUNE,18);
        Date data = new Date(2018-1900, Calendar.JUNE,18);
        CreateFilme("Divertida Mente",data);
        //UpdateLancamento(2022,12,24,"Divertida MENTE");
        //DeleteFilme("Triste mente");
    }

    public static void CreateFilme(String nome, Date lancamento){
        Filme filme = new Filme(nome, lancamento);

        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(filme);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void LerTodosFilme(){
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        Query query = em.createQuery("select f from Filme f");
        List<Filme> filmes = query.getResultList();
        for (Filme f: filmes) {
            System.out.println("Nome: " + f.getNome() + " / Lançamento: " + f.getLancamento());
        }

        em.close();
        emf.close();
    }

    public static void VisualizarFilme(String nome){
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        try{
            Filme buscado = buscarPornome(nome,em);
            System.out.println("Nome: " + buscado.getNome() + " / Lançamento: " + buscado.getLancamento());
        } catch (NoResultException e){
            System.out.println("Não Foi possivel encontrar o filme");
        }

        em.close();
        emf.close();
    }

    public static void UpdateLancamento(int ano, int mes, int dia, String nome){
        Date date = new Date(ano-1900,mes-1,dia);

        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();

        try{
            Filme buscado = buscarPornome(nome,em);
            buscado.setLancamento(date);
        } catch (NoResultException e) {
            System.out.println("Não foi possivel encontrar o Filme em questão");
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void DeleteFilme(String nome){
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();

        try{
            Filme buscado = buscarPornome(nome,em);
            em.remove(buscado);
        } catch (NoResultException e) {
            System.out.println("Não foi possivel encontrar o Filme em questão");
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }


    public static Filme buscarPornome(String nome, EntityManager em) throws NoResultException{

        Query query = em.createQuery("select f from Filme f where f.nome = :nome");
        query.setParameter("nome", nome);
        List<Filme> filmes = query.getResultList();

        return (Filme) query.getSingleResult();
    }
}
