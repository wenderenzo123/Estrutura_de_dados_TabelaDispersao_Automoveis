
public class Servidor {
    private AVLTree arvoreVeiculos;

    public Servidor() {
        arvoreVeiculos = new AVLTree();
        inicializarVeiculos();
    }

    private void inicializarVeiculos() {
        // Adicionar 50 veículos à árvore
        for (int i = 10; i < 60; i++) {
            Veiculo veiculo = new Veiculo("ABC" + i, "0042" + i, "Condutor" + i, "Modelo" + i, "2023",2023);
            arvoreVeiculos.raiz = arvoreVeiculos.inserir(arvoreVeiculos.raiz, veiculo);
            
        }
    }

    public String cadastrarVeiculo(Veiculo veiculo) {
        arvoreVeiculos.raiz = arvoreVeiculos.inserir(arvoreVeiculos.raiz, veiculo);
        // exibir altura da arvore
        exibirAlturaArvore();
        return "Veículo cadastrado com sucesso.";
    }

    public void exibirAlturaArvore() {
        System.out.println("Altura da árvore de veículos: " + arvoreVeiculos.altura(arvoreVeiculos.raiz));
    }


    public void listarVeiculos() {
        //listar veiculos da arvore veiculos
        arvoreVeiculos.listarEmOrdem(arvoreVeiculos.raiz);
        exibirAlturaArvore();
    }

    public String alterarVeiculo(String placa, Veiculo novoVeiculo) {
        arvoreVeiculos.alterarVeiculo(placa, novoVeiculo);
        exibirAlturaArvore();
        return "Veículo alterado com sucesso.";
    }

    public String removerVeiculo(String placa) {
        Veiculo veiculo = arvoreVeiculos.buscarVeiculo(placa, arvoreVeiculos.raiz);
        arvoreVeiculos.remover(arvoreVeiculos.raiz, veiculo);
        quantidadeVeiculos();
        return "Veículo removido com sucesso.";
    }

    public int quantidadeVeiculos() {
        exibirAlturaArvore();
        return arvoreVeiculos.quantidadeVeiculos(arvoreVeiculos.raiz);
    }

    public static void main(String[] args) {
        Servidor servidor = new Servidor();
    }
}
