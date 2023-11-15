package Menus;
import java.text.ParseException;
import java.util.Scanner;
public class MenuPrincipal {
    public static void menu() throws ParseException {
        Scanner menu = new Scanner (System.in);
        boolean loop = true;
        do {
            System.out.println("""
                     *********LocadoraPU**********
                     -----------------------------
                     |  1. Menu Clientes         |
                     |  2. Menu Filmes           |
                     |  3. Menu Genero           |
                     |  4. Menu Locação          |
                     |  5. Menu Telefones        |
                     |  6. Encerrar              |
                     -----------------------------
                    """);
            System.out.print("Escolha uma opção: ");
            int op = Integer.parseInt(menu.nextLine());
                switch (op) {
                case 1:
                    MenuCliente.menu();
                    break;
                case 2:
                    MenuFilme.menu();
                    break;
                case 3:
                    MenuGenero.menu();
                    break;
                case 4:
                    MenuLocacao.menu();
                    break;
                case 5:
                    MenuTelefone.menu();
                    break;
                case 6:
                    System.out.println("Encerrando programa...");
                    loop = false;
                    break;
                default:
                    System.out.println("Insira um valor válido!");
                    break;
            }
        } while (loop);
    }
}
