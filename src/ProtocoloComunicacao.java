public class ProtocoloComunicacao {
    private Servidor servidor;

    public ProtocoloComunicacao() {
        servidor = new Servidor();
    }

    public String cadastrarVeiculo(Veiculo veiculo) {
        return servidor.cadastrarVeiculo(veiculo);
    }

    public void listarVeiculos() {
        servidor.listarVeiculos();
    }

    public String alterarVeiculo(String placa, Veiculo novoVeiculo) {
        return servidor.alterarVeiculo(placa, novoVeiculo);
    }

    public String removerVeiculo(String placa) {
        return servidor.removerVeiculo(placa);
    }

    public int quantidadeVeiculos() {
        return servidor.quantidadeVeiculos();
    }
}
