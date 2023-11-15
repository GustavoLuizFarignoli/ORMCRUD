package Menus;

import CRUD.CRUDClientes;
import CRUD.CRUDGeneros;

import java.util.Scanner;

public class MenuGenero {
    public static void menu(){
        boolean loop = true;
        Scanner menuGNR = new Scanner(System.in);
        do {
            System.out.println("""
                         ************Gênero***********
                         -----------------------------
                         |  1. Criar Gênero          |
                         |  2. Listar Gêneros        |
                         |  3. Editar Gênero         |
                         |  4. Deletar Gênero        |
                         |  5. Encerrar              |
                         -----------------------------
                        """);
            System.out.print("Escolha uma opção: ");
            int op = menuGNR.nextInt();
            switch (op){
                case 1:
                    criar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    editar();
                    break;
                case 4:
                    deletar();
                    break;
                case 5:
                    System.out.println("Encerrando programa...");
                    loop = false;
                    break;
            }
        } while (loop);
    }

    public static void criar(){
        System.out.println("******Criar Gênero*******");
        Scanner CrtGNR = new Scanner(System.in);
        System.out.println("Digite qual gênero será adicionado: ");
        String nome = CrtGNR.nextLine();
        CrtGNR.close();

        CRUDGeneros.createGenero(nome);
    }

    public static void listar(){
        System.out.println("******Listando Gêneros*******");
        CRUDGeneros.listAllGeneros();
    }

    public static void editar(){
        Scanner EdtGNR = new Scanner(System.in);
        System.out.println("******Editar Gênero*******");
        System.out.println("Qual o ID do gênero que será alterado: ");
        int id = Integer.parseInt(EdtGNR.nextLine());
        System.out.println("Qual será o novo nome do gênero: ");
        String nome = EdtGNR.nextLine();
        EdtGNR.close();

        CRUDGeneros.updateGenero(nome, id);
    }

    public static void deletar(){
        System.out.println("******Remover Gênero*******");
        Scanner DelGNR = new Scanner(System.in);
        System.out.print("Informe o ID do filme: ");
        int id = DelGNR.nextInt();
        DelGNR.close();

        CRUDGeneros.deleteGenero(id);
    }
}
