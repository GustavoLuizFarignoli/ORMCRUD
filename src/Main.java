import CRUD.CRUDClientes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner menu = new Scanner (System.in);

        System.out.print(" *********LocadoraPU*********\n\n");
        System.out.print(" ----------------------------\n");
        System.out.print("|  1. Menu Clientes         |\n");
        System.out.print("|  2. Menu Filmes           |\n");
        System.out.print("|  3. Menu Genero          |\n");
        System.out.print("|  4. Menu Locação         |\n");
        System.out.print(" ----------------------------\n");
        System.out.print("Escolha uma opção: ");

        int op = menu.nextInt();


        switch (op) {
            case 1:
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            default:
        }
    }
}