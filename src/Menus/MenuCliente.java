package Menus;

import CRUD.CRUDClientes;

import java.util.Scanner;

public class MenuCliente {
    public static void menu(){
        boolean loop = true;
        Scanner menuCLT = new Scanner(System.in);
        do {
            System.out.println("""
                     ***********Cliente***********
                     -----------------------------
                     |  1. Cadastrar Cliente     |
                     |  2. Buscar Cliente        |
                     |  3. Visualizar Clientes   |
                     |  4. Editar Cliente        |
                     |  5. Deletar CLiente       |
                     |  6. Encerrar              |
                     -----------------------------
                    """);
            int op = Integer.parseInt(menuCLT.nextLine());
            System.out.print("Escolha uma opção: ");
            switch (op){
                case 1:
                    cadastrar();
                    break;
                case 2:
                    buscar();
                    break;
                case 3:
                    CRUDClientes.LerTodosClientes();
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
        Scanner CadCLT = new Scanner(System.in);
        System.out.println("Digite o nome do cliente a ser cadastrado: ");
        String nome = CadCLT.nextLine();
        System.out.println("Digite o CPF do cliente, utilizando apenas números: ");
        String cpf = CadCLT.nextLine();

        CRUDClientes.Createcliente(nome, cpf);
    }

    public static void buscar(){
        Scanner BscCLT = new Scanner(System.in);
        System.out.println("Digite o CPF do cliente, utilizando apenas números, a ser procurado: ");
        String cpf = BscCLT.nextLine();

        CRUDClientes.VisualizarCliente(cpf);
    }

    public static void editar(){
        Scanner EdtCLT = new Scanner(System.in);
        boolean loop = true;
        do {
            System.out.println("""
                    Selecione uma das seguintes opções: 
                        1. Editar nome
                        2. Adicionar telefone
                        3. Encerrar
                    """);
            System.out.print("Escolha uma opção: ");
            int op = Integer.parseInt(EdtCLT.nextLine());
            switch (op){
                case 1:
                    System.out.println("Digite o CPF do cliente ao qual será editado seu nome: ");
                    String cpf_nome = EdtCLT.nextLine();
                    System.out.println("Para qual nome será feito a troca: ");
                    String nome = EdtCLT.nextLine();

                    CRUDClientes.Updatenome(nome, cpf_nome);
                    break;
                case 2:
                    System.out.println("Digite o CPF do cliente ao que será adicionado o telefone: ");
                    String cpf_tele = EdtCLT.nextLine();
                    System.out.println("Digite o número de telefone a ser adicionado: ");
                    String telefone = EdtCLT.nextLine();

                    CRUDClientes.AddTelefone(telefone, cpf_tele);
                    break;
                case 3:
                    System.out.println("Voltando para o Menu - CLiente");
                    loop = false;
                    break;
            }
        }while (loop);
    }
    public static void deletar(){
        Scanner DelCLT = new Scanner(System.in);
        System.out.println("Digite o CPF do cliente a ser deletado: ");
        String cpf = DelCLT.nextLine();

        CRUDClientes.DeleteCliente(cpf);
    }
}