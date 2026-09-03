import java.util.Scanner;

public class Principal {

    static final int CAPACIDADE = 50;

    static String[] nomeVendedor = new String[CAPACIDADE];
    static double[] valorVenda = new double[CAPACIDADE];
    static String[] formaPagamento = new String[CAPACIDADE];

    static int totalVendas = 0;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int opcao = -1;

        do {
            try{
            exibirCabecalho();
            exibirMenu();

            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {

                case 1:
                    registrarVenda(scan); // Dev 1
                    break;

                case 2:
                    listarVendas(); // Dev 1
                    break;

                case 3:
                    relatorioComissoes(); 
                    break;

                case 4:
                    relatorioResumoDia();
                    break;

                case 5:
                    melhorVendedor(); 
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }

        }
        catch (Exception e) {
            System.out.println("Erro, digite a entrada corretamente!");
            scan.nextLine();
        }
        exibirRodape();

        } while (opcao != 0);

        scan.close();
    }

    public static void exibirCabecalho() {
        System.out.println("==============================");
        System.out.println("        VENDAS DO DIA");
        System.out.println("==============================");
    }

    public static void exibirMenu() {
        System.out.println("1 - Registrar venda");
        System.out.println("2 - Listar vendas");
        System.out.println("3 - Relatorio de comissoes");
        System.out.println("4 - Resumo do dia");
        System.out.println("5 - Melhor vendedor");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    public static void exibirRodape() {
        System.out.println("==============================");
    }


    //Dev 1

    public static void registrarVenda(Scanner scan) {

    }

    public static void listarVendas() {

    }

    // Dev 2

    public static double calcularTotalVendedor(String vendedor) {
        return 0;
    }

    public static double calcularComissao(double totalVendido) {
        return 0;
    }

    public static void relatorioComissoes() {

    }

    // Dev 3

    public static double calcularTotalDia() {
        double total = 0;

        for (int i = 0; i < totalVendas; i++) {
            total += valorVenda[i];
        }
        return total;
    }

    public static double calcularTicketMedio() {
        if (totalVendas == 0) {
            return 0;
        }
        return calcularTotalDia() / totalVendas;
    }

    public static void relatorioResumoDia() {
    System.out.println("\n===== RESUMO DO DIA =====");
    System.out.printf("Total vendido: R$ %.2f%n", calcularTotalDia());
    System.out.println("Quantidade de vendas: " + totalVendas);
    System.out.printf("Ticket medio: R$ %.2f%n", calcularTicketMedio());
    System.out.println("=========================");
}

    public static void melhorVendedor() {

    }
}