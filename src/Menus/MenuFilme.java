package Menus;

import CRUD.CRUDClientes;
import CRUD.CRUDFilmes;
import jakarta.persistence.EntityManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MenuFilme {
    public static void menu() throws ParseException {
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
            int op = Integer.parseInt(menuFilme.nextLine());
            switch (op){
                case 1:
                    cadastrar();
                    break;
                case 2:
                    buscar();
                    break;
                case 3:
                    CRUDFilmes.LerTodosFilme();
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

    public static void cadastrar() throws ParseException {
        Scanner CadFilme = new Scanner(System.in);
        System.out.println("Digite o nome do filme a ser cadastrado: ");
        String nome = CadFilme.nextLine();
        System.out.println("Digite a data de lançamento do filme no formato 'dd/MM/yyyy' : ");
        String lancamento  = CadFilme.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date ano = formatter.parse(lancamento);

        CRUDFilmes.CreateFilme(nome, ano);
    }
    public static void buscar(){
        Scanner BscFilme = new Scanner(System.in);
        System.out.println("Digite o nome do filme a ser procurado: ");
        String nome = BscFilme.nextLine();

        CRUDFilmes.VisualizarFilme(nome);
    }

    public static void editar(){
        Scanner EdtFilme = new Scanner(System.in);
            System.out.println("Qual filme deseja editar: ");
            String nome = EdtFilme.nextLine();
            System.out.println("Digite o dia a ser alterado: ");
            int dia = Integer.parseInt(EdtFilme.nextLine());
            System.out.println("Digite o mês a ser alterado: ");
            int mes = Integer.parseInt(EdtFilme.nextLine());
            System.out.println("Digite o ano a ser alterado: ");
            int ano = Integer.parseInt(EdtFilme.nextLine());

            CRUDFilmes.UpdateLancamento(ano, mes, dia, nome);
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

        CRUDFilmes.VisualizarFilme(nome);
    }
}