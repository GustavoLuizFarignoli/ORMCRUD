package Menus;

import CRUD.CRUDClientes;
import CRUD.CRUDFilmes;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class MenuFilme {
    public static void menu(){
        boolean loop = true;
        Scanner menuFilme = new Scanner(System.in);
        do {
            System.out.println("""
                     ************Filme************
                     -----------------------------
                     |  1. Cadastrar Filme     |
                     |  2. Buscar Filme        |
                     |  3. Visualizar Filmes   |
                     |  4. Editar Lançamento   |
                     |  5. Deletar Filme       |
                     |  6. Encerrar            |
                     -----------------------------
                    """);
            int op = menuFilme.nextInt();
            switch (op){
                case 1:
                    cadastrar();
                    break;
                case 2:
                    buscar();
                    break;
                case 3:
                    visualizar();
                    break;
                case 4:
                    editar();
                    break;
                case 5:
                    deletar();
                    break;
                case 6:
                    System.out.println("Encerrando programa...");
                    loop = false;
                    break;
            }
        } while (loop);
    }

    public static void cadastrar(){
        Scanner CadFilme = new Scanner(System.in);
        System.out.println("Digite o nome do filme a ser cadastrado: ");
        String nome = CadFilme.nextLine();
        System.out.println("Digite a data de lançamento do filme: ");
        String lancamento  = CadFilme.nextLine();
        CadFilme.close();

        CRUDClientes.Createcliente(nome, lancamento);
    }
    public static void buscar(){
        Scanner BscFilme = new Scanner(System.in);
        System.out.println("Digite o nome do filme a ser procurado: ");
        String nome = BscFilme.nextLine();
        BscFilme.close();

        CRUDFilmes.buscarPornome(nome, null);
    }

    public static void editar(){
        Scanner EdtFilme = new Scanner(System.in);
        boolean loop = true;
        do {
            System.out.println("""
                    Selecione uma das seguintes opções:
                        1. Editar data de lançamento
                        2. Encerrar
                    """);
            System.out.print("Escolha uma opção: ");
            int op = EdtFilme.nextInt();
            switch (op){
                case 1:
                    System.out.println("Qual filme deseja editar: ");
                    String nome = EdtFilme.nextLine();
                    System.out.println("Digite o dia a ser alterado: ");
                    int dia = EdtFilme.nextInt();
                    System.out.println("Digite o mês a ser alterado: ");
                    int mes = EdtFilme.nextInt();
                    System.out.println("Digite o ano a ser alterado: ");
                    int ano = EdtFilme.nextInt();
                    EdtFilme.close();

                    CRUDFilmes.UpdateLancamento(dia, mes, ano, nome);
                    break;
                case 2:
                    System.out.println("Voltando para o Menu - Filme");
                    loop = false;
                    break;
            }
        }while (loop);
    }
    public static void deletar(){
        Scanner DelFilme = new Scanner(System.in);
        System.out.println("Digite o nome do filme a ser deletado: ");
        String nome = DelFilme.nextLine();

        CRUDFilmes.DeleteFilme(nome);
    }

    public static void visualizar() {
        Scanner VilFilme = new Scanner(System.in);
        System.out.print("Digite o nome do filme a ser visualizado: ");
        String nome = VilFilme.next();
        VilFilme.close();

        CRUDFilmes.VisualizarFilme(nome);
    }
}