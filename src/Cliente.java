import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        ProtocoloComunicacao protocolo = new ProtocoloComunicacao();
        Servidor servidor = new Servidor();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu de Opções:");
            System.out.println("1. Cadastrar veículo");
            System.out.println("2. Listar veículos");
            System.out.println("3. Alterar veículo");
            System.out.println("4. Remover veículo");
            System.out.println("5. Acessar a quantidade de veículos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    Veiculo veiculo = new Veiculo();
                    System.out.print("Digite a placa do veículo: ");
                    veiculo.placa = scanner.nextLine();
                    System.out.print("Digite o renavam do veículo: ");
                    veiculo.renavam = scanner.nextLine();
                    System.out.print("Digite o nome do condutor do veículo: ");
                    veiculo.nomeCondutor = scanner.nextLine();
                    System.out.print("Digite o CPF do condutor do veículo: ");
                    veiculo.cpfCondutor = scanner.nextLine();
                    System.out.print("Digite o modelo do veículo: ");
                    veiculo.modelo = scanner.nextLine();
                    System.out.print("Digite o ano de fabricação do veículo: ");
                    veiculo.dataFabricacao = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    System.out.println(protocolo.cadastrarVeiculo(veiculo));
                    break;
                case 2:
                    protocolo.listarVeiculos();
                    break;
                case 3:
                    Veiculo novoVeiculo = new Veiculo();
                    System.out.print("Digite a placa do veículo: ");
                    novoVeiculo.placa = scanner.nextLine();
                    System.out.print("Digite o novo renavam do veículo: ");
                    novoVeiculo.renavam = scanner.nextLine();
                    System.out.print("Digite o novo nome do condutor do veículo: ");
                    novoVeiculo.nomeCondutor = scanner.nextLine();
                    System.out.print("Digite o novo CPF do condutor do veículo: ");
                    novoVeiculo.cpfCondutor = scanner.nextLine();
                    System.out.print("Digite o novo modelo do veículo: ");
                    novoVeiculo.modelo = scanner.nextLine();
                    System.out.print("Digite o novo ano de fabricação do veículo: ");
                    novoVeiculo.dataFabricacao = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    System.out.println(protocolo.alterarVeiculo(novoVeiculo.placa, novoVeiculo));
                    break;
                case 4:
                    System.out.print("Digite a placa do veículo: ");
                    String placa = scanner.nextLine();
                    System.out.println(protocolo.removerVeiculo(placa));
                    break;
                case 5:
                    System.out.println("Quantidade de veículos: " + protocolo.quantidadeVeiculos());
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
