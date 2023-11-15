package CRUD;

import jakarta.persistence.*;
import model.Clientes;
import model.Filme;
import model.Genero;
import model.Locacao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static CRUD.CRUDClientes.buscarPorCpf;
import static CRUD.CRUDFilmes.buscarPornome;

public class CRUDLocacao {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void main(String[] args) {
        //Date locacao = new Date(2023-1900, Calendar.NOVEMBER,15,13,29);
        //Date devolucao = new Date(2023-1900, Calendar.NOVEMBER,22,13,29);
        //CreateLocacao("Divertida mente","1111111",locacao,devolucao);
        DeletarLocacao(2);
        VerLocacoes();
    }

    public static void CreateLocacao(String nome, String cpf, Date locacao, Date devolucao){
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();

        try{
            Clientes clibuscado = buscarPorCpf(cpf,em);
            Filme filmebuscado = buscarPornome(nome,em);
            Locacao locacao1 = new Locacao(locacao,devolucao,clibuscado,filmebuscado);
            em.persist(locacao1);
        }catch (NoResultException e){
            System.out.println("Não foi possivel encontrar o Cliente e/ou Filme, tente novamente");
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void VerLocacoes(){
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        Query query = em.createQuery("select l from Locacao l");
        List<Locacao> locacaos = query.getResultList();
        for (Locacao l: locacaos) {
            System.out.println("ID: " + l.getId() + "; Data de Locacao: " + l.getData_locacao() + "; Data de Devolução: " + l.getDevolucao() + "; Filme: " + l.getId_filme().getNome() + "; Cliente: " + l.getId_clientes().getNome());
        }

        em.close();
        emf.close();
    }

    public static void LocacaoporCliente(String cpf) {
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();

        try {
            Clientes clibuscado = buscarPorCpf(cpf, em);
            Query query = em.createQuery("select l from Locacao l where l.id_clientes = :id");
            query.setParameter("id", clibuscado);
            List<Locacao> locacaos = query.getResultList();

            for (Locacao l: locacaos) {
                System.out.println("Data de Locacao: " + l.getData_locacao() + "; Data de Devolução: " + l.getDevolucao() + "; Filme: " + l.getId_filme().getNome());
            }
        } catch (NoResultException e) {
            System.out.println("Não foi possivel encontrar o Cliente o Filme, tente novamente");
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void DeletarLocacao(int id){
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();

        try{
            Locacao buscado = em.find(Locacao.class, id);
            em.remove(buscado);
        } catch (NoResultException e) {
            System.out.println("Não foi possivel encontrar o Filme em questão");
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
