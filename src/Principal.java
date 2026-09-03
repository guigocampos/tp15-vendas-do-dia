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
        System.out.println("5 - Melhor vendedor do dia");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    public static void exibirRodape() {
        System.out.println("==============================");
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

    // percorre os vetores paralelos e soma o valor de todas as vendas
    // realizadas pelo vendedor informado como parametro
    public static double calcularTotalVendedor(String vendedor) {
        double total = 0;
        for (int i=0;i < totalVendas; i++) {
            if (nomeVendedor[i].equals(vendedor)) {
                total += valorVenda[i];
        }
    }
    return total;
}

    public static double calcularComissao(double totalVendido) {
        if (totalVendido < 0) {
            return 0;
    }
    return totalVendido * 0.05;
}

    public static void relatorioComissoes() {
        if (totalVendas == 0) {
            System.out.println("Nenhuma venda registrada ainda.");
        return;
    }

    System.out.println("\n--- Relatorio de comissoes ---");
    System.out.printf("%-15s %15s %15s%n", "Vendedor", "Total vendido", "Comissao");
    for (int i = 0; i < totalVendas; i++) {
        double total = calcularTotalVendedor(nomeVendedor[i]);
        double comissao = calcularComissao(total);
        System.out.printf("%-15s R$ %12.2f R$ %12.2f%n",
                nomeVendedor[i], total, comissao);
    }
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
        if (totalVendas == 0) {
            System.out.println("Nenhuma venda registrada ainda.");
            return;
        }

        String vendedorMelhor = nomeVendedor[0];
        double maiorTotal = calcularTotalVendedor(nomeVendedor[0]);

        for (int i = 1; i < totalVendas; i++) {
            double total = calcularTotalVendedor(nomeVendedor[i]);

            if (total > maiorTotal) {
                maiorTotal = total;
                vendedorMelhor = nomeVendedor[i];
            }
        }

        System.out.println("\n===== MELHOR VENDEDOR =====");
        System.out.println("Vendedor: " + vendedorMelhor);
        System.out.printf("Total vendido: R$ %.2f%n", maiorTotal);
        System.out.println("===========================");
    }
}
