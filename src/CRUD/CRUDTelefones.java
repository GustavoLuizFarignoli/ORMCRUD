package CRUD;

import jakarta.persistence.*;
import model.Clientes;
import model.Telefones;

import java.util.List;

import static CRUD.CRUDClientes.buscarPorCpf;

public class CRUDTelefones {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    public static void main(String[] args) {
        LerTelefonesCliente("1111111");
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
            System.out.println("Id: " + t.getId() + " Número: " + t.getNumero());
        }

        em.close();
        emf.close();
    }
    public static void LerTelefonesCliente(String cpf){
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        try{
            Clientes clibuscado = buscarPorCpf(cpf, em);

            Query query = em.createQuery("select t from Telefones t where t.id_cliente = :cliente");
            query.setParameter("cliente", clibuscado);
            List<Telefones> telefones = query.getResultList();
            for (Telefones t: telefones) {
                System.out.println("Id: " + t.getId() + " Número: " + t.getNumero());
            }

        } catch (NoResultException e) {
            System.out.println("Não foi possivel encontrar o Cliente em questão");
        }

        em.close();
        emf.close();
    }

    public static void VisualizarTelefone(String numero){
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        try{
            Telefones buscado = buscarPorNumero(numero,em);
            System.out.println("Id: " + buscado.getId() + " Número: " + buscado.getNumero());
        } catch (NoResultException e) {
            System.out.println("Não foi possivel encontrar o Telefone em questão");
        }

        em.close();
        emf.close();
    }

    public static void AddClienteId (String numero, String cpf){
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();

        try{
            Telefones telebuscado = buscarPorNumero(numero,em);
            Clientes clibuscado = buscarPorCpf(cpf, em);
            telebuscado.setId_cliente(clibuscado);
        } catch (NoResultException e) {
            System.out.println("Não foi possivel encontrar o Telefone ou Cliente em questão");
        }



        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void RemoveClienteId (String numero){
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();

        try{
            Telefones buscado = buscarPorNumero(numero,em);
            buscado.setId_cliente(null);
        } catch (NoResultException e) {
            System.out.println("Não foi possivel encontrar o Telefone em questão");
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void DeleteTelefone(String numero){
        emf = Persistence.createEntityManagerFactory("LocadoraPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();

        try{
            Telefones buscado = buscarPorNumero(numero,em);
            em.remove(buscado);
        } catch (NoResultException e) {
            System.out.println("Não foi possivel encontrar o Telefone em questão");
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static Telefones buscarPorNumero(String numero, EntityManager em) throws NoResultException {

        Query query = em.createQuery("select t from Telefones t where t.numero = :numero");
        query.setParameter("numero", numero);
        List<Telefones> telefones = query.getResultList();

        return (Telefones) query.getSingleResult();

    }


}
