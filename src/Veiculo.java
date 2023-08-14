public class Veiculo {
    public String placa;
    public String renavam;
    public String nomeCondutor;
    public String cpfCondutor;
    public String modelo;
    public int dataFabricacao;

    public Veiculo(String placa, String renavam, String nomeCondutor, String cpfCondutor, String modelo, int dataFabricacao) {
        this.placa = placa;
        this.renavam = renavam;
        this.nomeCondutor = nomeCondutor;
        this.cpfCondutor = cpfCondutor;
        this.modelo = modelo;
        this.dataFabricacao = dataFabricacao;
    }

    public Veiculo() {
    }
}