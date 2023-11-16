package Menus;
import CRUD.CRUDTelefones;

import java.util.Scanner;
public class MenuTelefone {


    public static void menu() {
        Scanner menu = new Scanner(System.in);
        boolean loop = true;
        do {
            System.out.println("""
                     **************Telefone*************
                     -----------------------------------
                     |  1. Criar Telefone              |
                     |  2. Listar Telefones            |
                     |  3. Obter telefone do cliente   |
                     |  4. Ver Telefone                |
                     |  5. Vincular cliente            |
                     |  6. Desvincular cliente         |
                     |  7. Remover Telefone            |
                     |  8. Encerrar                    |
                     -----------------------------------
                    """);
            System.out.print("Escolha uma opção: ");
            int op = Integer.parseInt(menu.nextLine());
            switch (op) {
                case 1:
                    criar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    obterCliente();
                    break;
                case 4:
                    obterTelefone();
                    break;
                case 5:
                    vincularCliente();
                    break;
                case 6:
                    desvincularCliente();
                    break;
                case 7:
                    remover();
                    break;
                case 8:
                    System.out.println("Encerrando Programa...");
                    loop = false;
                    break;
                default:
                    System.out.println("Insira um valor válido!");
                    break;
            }
        } while (loop);
    }

    public static void criar() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("**********Criar Telefone*********");
        System.out.print("Informe o número do telefone: ");
        String numero = teclado.next();

        CRUDTelefones.CreateTelefones(numero);
        }

    public static void listar(){
        System.out.println("**********Listar Telefones*********");
        CRUDTelefones.LerTodosTelefones();
    }

    public static void obterCliente(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("**********Obter Cliente*********");
        System.out.print("Informe o CPF do cliente: ");
        String cpf = teclado.next();

        CRUDTelefones.LerTelefonesCliente(cpf);
    }

    public static void obterTelefone(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("**********Obter Telefone*********");
        System.out.print("Informe o número do telefone: ");
        String numero = teclado.nextLine();
        System.out.println("NUmero " + numero);

        CRUDTelefones.VisualizarTelefone(numero);
    }

    public static void vincularCliente(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("**********Vincular Cliente*********");
        System.out.print("Informe o número do telefone: ");
        String numero = teclado.next();
        System.out.print("Informe o CPF do cliente: ");
        String cpf = teclado.next();

        CRUDTelefones.AddClienteId(numero, cpf);
    }

    public static void desvincularCliente(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("**********Desvincular Cliente*********");
        System.out.print("Informe o número do telefone: ");
        String numero = teclado.next();

        CRUDTelefones.RemoveClienteId(numero);
    }

    public static void remover(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("**********Remover Telefone*********");
        System.out.print("Informe o número do telefone: ");
        String numero = teclado.next();

        CRUDTelefones.DeleteTelefone(numero);
    }
}

