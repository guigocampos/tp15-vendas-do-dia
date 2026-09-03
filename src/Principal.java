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
        System.out.println("\n==============================");
        System.out.println("Obrigado por utilizar o sistema!");
        System.out.println("==============================\n");
    }


    //Dev 1

    public static void registrarVenda(Scanner scan) {
        if(totalVendas < CAPACIDADE){
            System.out.print("Digite o nome do vendedor: ");
            nomeVendedor[totalVendas] = scan.nextLine().trim();
            if(nomeVendedor[totalVendas].isEmpty()){
                System.out.println("Erro: nome vazio!\n");
                return;
            }
            System.out.print("Digite o valor da venda: ");
            valorVenda[totalVendas] = scan.nextDouble();
            if(valorVenda[totalVendas] <= 0){
                System.out.println("Erro: valor da venda deve ser maior que zero!\n");
                return;
            }
            scan.nextLine();

            System.out.print("Digite a forma de pagamento (dinheiro, cartao, pix): ");
            formaPagamento[totalVendas] = scan.nextLine().trim();
            if(formaPagamento[totalVendas].isEmpty()){
                System.out.println("Erro: forma de pagamento vazia!\n");
                return;
            }
            else if (!formaPagamento[totalVendas].equalsIgnoreCase("dinheiro")
                    && !formaPagamento[totalVendas].equalsIgnoreCase("cartao")
                    && !formaPagamento[totalVendas].equalsIgnoreCase("cartão")
                    && !formaPagamento[totalVendas].equalsIgnoreCase("pix")) {
                System.out.println("Erro: forma de pagamento invalida!\n");
                return;
            }

            totalVendas++;
            System.out.println("\nVenda registrada com sucesso!");
        } else {
            System.out.println("Capacidade máxima de vendas atingida!\n");
        }
    }

    public static void listarVendas() {
        for(int i = 0; i < totalVendas; i++){
            System.out.println("\nVenda " + (i + 1) + ":");
            System.out.println("Vendedor: " + nomeVendedor[i]);
            System.out.println("Valor: R$" + valorVenda[i]);
            System.out.println("Forma de pagamento: " + formaPagamento[i] + "\n");
        }
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
        return 0;
    }

    public static double calcularTicketMedio() {
        return 0;
    }

    public static void relatorioResumoDia() {

    }

    public static void melhorVendedor() {

    }
}