package CRUD;

import java.util.List;

import jakarta.persistence.*;
import model.Clientes;
import model.Telefones;

import static CRUD.CRUDTelefones.CreateTelefones;
import static CRUD.CRUDTelefones.buscarPorNumero;

public class CRUDClientes {
	private static EntityManagerFactory emf;
	private static EntityManager em;

	public static void main(String[] args) {
		//Createcliente("Mauro","1111111");
		AddTelefone("991192406","1111111");
		//AddTelefone("991192407","1111113");
	}
	public static void Createcliente(String nome, String cpf){
		Clientes cliente = new Clientes(nome,cpf);

		emf = Persistence.createEntityManagerFactory("LocadoraPU");
		em = emf.createEntityManager();

		em.getTransaction().begin();

		try {
			Clientes buscado = buscarPorCpf(cpf,em);
			System.out.println("Este cliente já está cadastrado");
		} catch (NoResultException e){
			em.persist(cliente);
			System.out.println("Cliente Cadastrado com Sucesso");

		}

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

		try{
			Clientes buscado = buscarPorCpf(cpf,em);
			System.out.println("Nome: " + buscado.getNome() + " / CPF: " + buscado.getCpf());
		} catch (NoResultException e) {
			System.out.println("Não foi possivel encontrar o Cliente em questão");
		}

		em.close();
		emf.close();
	}

	public static void Updatenome(String nome, String cpf){
		emf = Persistence.createEntityManagerFactory("LocadoraPU");
		em = emf.createEntityManager();

		em.getTransaction().begin();

		try{
			Clientes clienteProcurado = buscarPorCpf(cpf, em);
			clienteProcurado.setNome(nome);
		} catch (NoResultException e) {
			System.out.println("Não foi possivel encontrar o Cliente em questão");
		}

		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static void AddTelefone (String numero, String cpf){
		emf = Persistence.createEntityManagerFactory("LocadoraPU");
		em = emf.createEntityManager();

		em.getTransaction().begin();

		try {
			Telefones telebuscado = buscarPorNumero(numero,em);
			System.out.println("Este Telefone já está cadastro");
		} catch (NoResultException e) {
			CreateTelefones(numero);
			Telefones telebuscado = null;
			try {
				telebuscado = buscarPorNumero(numero, em);
				Clientes clibuscado = buscarPorCpf(cpf, em);
				telebuscado.setId_cliente(clibuscado);
				clibuscado.getTelefone().add(telebuscado);
			} catch (NoResultException e2) {
				System.out.println("Não foi possivel encontrar o Cliente em questão");
				em.remove(telebuscado);
			}
		}

		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static void DeleteCliente(String cpf){
		emf = Persistence.createEntityManagerFactory("LocadoraPU");
		em = emf.createEntityManager();

		em.getTransaction().begin();

		try{
			Clientes clienteProcurado = buscarPorCpf(cpf, em);
			em.remove(clienteProcurado);
		} catch (NoResultException e) {
			System.out.println("Não foi possivel encontrar o Cliente em questão");
		}

		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public static Clientes buscarPorCpf(String cpf, EntityManager em) throws NoResultException {
		
		Query query = em.createQuery("select c from Clientes c where c.cpf = :cpf");
		query.setParameter("cpf", cpf);
		List<Clientes> clientes = query.getResultList();
				
		return (Clientes) query.getSingleResult();
		
	}
	
}
