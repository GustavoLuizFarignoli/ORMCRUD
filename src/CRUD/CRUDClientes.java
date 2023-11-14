package CRUD;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.Clientes;

public class CRUDClientes {
	private static EntityManagerFactory emf;
	private static EntityManager em;

	public static void main(String[] args) {
		// Createcliente("Mauro","1111111");
		Updatenome("Mauro","1111111");
	}
	public static void Createcliente(String nome, String cpf){
		Clientes cliente = new Clientes(nome,cpf);

		emf = Persistence.createEntityManagerFactory("LocadoraPU");
		em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static void LerTodosClientes(){
		emf = Persistence.createEntityManagerFactory("LocadoraPU");
		em = emf.createEntityManager();

		Query query = em.createQuery("select c from Clientes c");
		List<Clientes> clientes = query.getResultList();
		for (Clientes c: clientes) {
			System.out.println("Nome: " + c.getNome() + " / CPF: " + c.getCpf());
		}

		em.close();
		emf.close();
	}

	public static void VisualizarCliente(String cpf){
		emf = Persistence.createEntityManagerFactory("LocadoraPU");
		em = emf.createEntityManager();

		Clientes buscado = buscarPorCpf(cpf,em);

		System.out.println("Nome: " + buscado.getNome() + " / CPF: " + buscado.getCpf());

		em.close();
		emf.close();
	}

	public static void Updatenome(String nome, String cpf){
		emf = Persistence.createEntityManagerFactory("LocadoraPU");
		em = emf.createEntityManager();

		em.getTransaction().begin();

		Clientes clienteProcurado = buscarPorCpf(cpf, em);
		clienteProcurado.setNome(nome);

		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public static Clientes buscarPorCpf(String cpf, EntityManager em) {
		
		Query query = em.createQuery("select c from Clientes c where c.cpf = :cpf");
		query.setParameter("cpf", cpf);
		List<Clientes> clientes = query.getResultList();
				
		return (Clientes) query.getSingleResult();
		
	}
	
}
