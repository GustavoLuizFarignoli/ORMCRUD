package Menus;

import CRUD.CRUDLocacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MenuLocacao {
    public static void menu(){
        boolean loop = true;
        Scanner menuCLT = new Scanner(System.in);
        do {
            System.out.println("""
                     ***********Locação*********
                     ---------------------------
                     |  1. Cadastrar Locação   |
                     |  2. Listar Locações     |
                     |  3. Buscar por CPF      |
                     |  4. Editar Locação      |
                     |  5. Deletar Locação     |
                     |  6. Encerrar            |
                     ---------------------------
                    """);
            int op = Integer.parseInt(menuCLT.nextLine());
            switch (op){
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    buscarPorCpf();
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
        Scanner teclado = new Scanner(System.in);
        System.out.println("*****Cadastrar Locação*****");
        System.out.print("Informe o CPF do cliente: ");
        String cpf = teclado.next();
        System.out.print("Informe o nome do filme: ");
        String nome = teclado.next();

        Date dataLocacao = new Date();
        Calendar calDataAtual = Calendar.getInstance();
        calDataAtual.setTime(dataLocacao);
        int ano = calDataAtual.get(Calendar.YEAR);
        calDataAtual.set(Calendar.YEAR, ano);
        dataLocacao = calDataAtual.getTime();

        System.out.print("Informe a data de devolução no formato dd/MM/yyyy: ");
        String inputData = teclado.next();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataDevolucao = null;

        try{
            dataDevolucao = formato.parse(inputData);
            Calendar calDataDevolucao = Calendar.getInstance();
            calDataDevolucao.setTime(dataDevolucao);
            int year = calDataDevolucao.get(Calendar.YEAR);
            calDataDevolucao.set(Calendar.YEAR, year);
            dataDevolucao = calDataDevolucao.getTime();
        } catch (ParseException ex){
            System.out.println("Formato de data inválido. Certifique-se de inserir a data de devolução no formato dd/MM/yyyy!");
        }

        CRUDLocacao.CreateLocacao(nome, cpf, dataLocacao, dataDevolucao);
    }

    public static void listar(){
        System.out.println("*****Listar Locações*****");
        CRUDLocacao.VerLocacoes();
    }

    public static void buscarPorCpf(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("*****Obter Locações do Cliente*****");
        System.out.print("Informe o CPf do cliente: ");
        String cpf = teclado.next();

        CRUDLocacao.LocacaoporCliente(cpf);
    }

    public static void editar(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("*****Editar Locação*****");
        System.out.print("Informe o ID da locação: ");
        int id = Integer.parseInt(teclado.nextLine());

        System.out.print("Informe a nova data de devolução no formato dd/MM/yyyy: ");
        String inputData = teclado.next();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataDevolucao = null;

        try {
            dataDevolucao = formato.parse(inputData);
            Calendar calDataDevolucao = Calendar.getInstance();
            calDataDevolucao.setTime(dataDevolucao);
            int year = calDataDevolucao.get(Calendar.YEAR);
            calDataDevolucao.set(Calendar.YEAR, year);
            dataDevolucao = calDataDevolucao.getTime();
            CRUDLocacao.EditarLocacao(id, dataDevolucao);
        } catch (ParseException ex){
            System.out.println("Formato inválido, certifique-se de informar a data de devolução no formato dd/MM/yyyy!");
        }
    }

    public static void deletar(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("*****Remover Locação*****");
        System.out.print("Informe o ID da locação: ");
        int id = Integer.parseInt(teclado.nextLine());

        CRUDLocacao.DeletarLocacao(id);
    }
}
