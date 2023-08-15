public class AVLNode {
    public Veiculo veiculo;
    public int altura;
    public AVLNode esquerdo;
    public AVLNode direito;
    public int chave;

    public AVLNode(Veiculo veiculo) {
        this.veiculo = veiculo;
        this.altura = 1;
        this.chave = veiculo.placa.hashCode();
    }
}