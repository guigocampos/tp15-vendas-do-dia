import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int opcao;

        do {
            try{
            exibirCabecalho();
            exibirMenu();

            opcao = scan.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("\nRegistrar venda");
                    break;

                case 2:
                    System.out.println("\nListar vendas");
                    break;

                case 3:
                    System.out.println("\nRelatorio");
                    break;

                case 0:
                    System.out.println("\nEncerrando...");
                    break;

                default:
                    System.out.println("\nOpcao invalida!");
            }
        }
        catch (Exception e) {
                System.out.println("Entrada invalida! Por favor, digite um numero.");
                scan.next();
                opcao = -1;
        }
        exibirRodape();
        
        } while (opcao != 0);

        scan.close();
    }

    public static void exibirCabecalho() {
        System.out.println("==============================");
        System.out.println("        VENDAS DO DIA");
        System.out.println("==============================\n");
    }

    public static void exibirMenu() {
        System.out.println("1 - Registrar venda");
        System.out.println("2 - Listar vendas");
        System.out.println("3 - Relatorio");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    public static void exibirRodape() {
        System.out.println("==============================\n");
    }
}