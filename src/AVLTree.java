public class AVLTree {
    AVLNode raiz;

    public AVLTree() {
        this.raiz = null;
    }

    public int altura(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return node.altura;
    }

    public int fatorBalanceamento(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return altura(node.esquerdo) - altura(node.direito);
    }

    public AVLNode inserir(AVLNode node, Veiculo veiculo) {
        if (node == null) {
            return new AVLNode(veiculo);
        }
    
        if (veiculo.placa.hashCode() < node.chave) {
            node.esquerdo = inserir(node.esquerdo, veiculo);
        } else if (veiculo.placa.hashCode() > node.chave) {
            node.direito = inserir(node.direito, veiculo);
        } else {
            return node;
        }

        // Atualizar a altura do nó atual.
        node.altura = 1 + Math.max(altura(node.esquerdo), altura(node.direito));

        // Realizar o balanceamento e retornar o novo nó raiz.
        return balancear(node, veiculo);
    }

    public AVLNode balancear(AVLNode node, Veiculo veiculo) {
        // Calcular o fator de balanceamento do nó atual.
        int fatorBalanceamento = fatorBalanceamento(node);
 
        // Se o nó estiver desbalanceado, então existem 4 casos possíveis.
        // Caso 1: Rotação simples à esquerda.
        if (fatorBalanceamento > 1 && veiculo.placa.compareTo(node.esquerdo.veiculo.placa) < 0) {
            return rotacaoDireita(node);
        }

        // Caso 2: Rotação simples à direita.
        if (fatorBalanceamento < -1 && veiculo.placa.compareTo(node.direito.veiculo.placa) > 0) {
            return rotacaoEsquerda(node);
        }

        // Caso 3: Rotação dupla à esquerda.
        if (fatorBalanceamento > 1 && veiculo.placa.compareTo(node.esquerdo.veiculo.placa) > 0) {
            node.esquerdo = rotacaoEsquerda(node.esquerdo);
            return rotacaoDireita(node);
        }

        // Caso 4: Rotação dupla à direita.
        if (fatorBalanceamento < -1 && veiculo.placa.compareTo(node.direito.veiculo.placa) < 0) {
            node.direito = rotacaoDireita(node.direito);
            return rotacaoEsquerda(node);
        }

        return node;
    }

    public AVLNode remover(AVLNode node, Veiculo veiculo) {
        if (node == null) {
            return null;
        }

        if (veiculo.placa.compareTo(node.veiculo.placa) < 0) {
            node.esquerdo = remover(node.esquerdo, veiculo);
        } else if (veiculo.placa.compareTo(node.veiculo.placa) > 0) {
            node.direito = remover(node.direito, veiculo);
        } else {
            if (node.esquerdo == null || node.direito == null) {
                AVLNode novoFilho = (node.esquerdo != null) ? node.esquerdo : node.direito;
                if (novoFilho == null) {
                    return null;
                } else {
                    node = novoFilho;
                }
            } else {
                AVLNode sucessor = encontrarSucessor(node.direito);
                node.veiculo = sucessor.veiculo;
                node.direito = remover(node.direito, sucessor.veiculo);
            }
        }

        node.altura = 1 + Math.max(altura(node.esquerdo), altura(node.direito));

        return balancear(node, veiculo);
    }

    private AVLNode encontrarSucessor(AVLNode node) {
        if (node == null) {
            return null;
        }
        while (node.esquerdo != null) {
            node = node.esquerdo;
        }
        return node;
    }

    private AVLNode rotacaoEsquerda(AVLNode y) {
        AVLNode x = y.direito;
        AVLNode T2 = x.esquerdo;

        // Realizar a rotação
        x.esquerdo = y;
        y.direito = T2;

        // Atualizar alturas
        y.altura = 1 + Math.max(altura(y.esquerdo), altura(y.direito));
        x.altura = 1 + Math.max(altura(x.esquerdo), altura(x.direito));

        return x; // Retorna a nova raiz após a rotação
    }

    private AVLNode rotacaoDireita(AVLNode x) {
        AVLNode y = x.esquerdo;
        AVLNode T2 = y.direito;

        // Realizar a rotação
        y.direito = x;
        x.esquerdo = T2;

        // Atualizar alturas
        x.altura = 1 + Math.max(altura(x.esquerdo), altura(x.direito));
        y.altura = 1 + Math.max(altura(y.esquerdo), altura(y.direito));

        return y; // Retorna a nova raiz após a rotação
    }

    public void listarEmOrdem(AVLNode node) {
        //listar com a chave
        if (node != null) {
            listarEmOrdem(node.esquerdo);
            System.out.println("Chave: " + node.chave);
            System.out.println("Placa: " + node.veiculo.placa);
            System.out.println("Renavam: " + node.veiculo.renavam);
            System.out.println("Condutor: " + node.veiculo.nomeCondutor);
            System.out.println("Modelo: " + node.veiculo.modelo);
            System.out.println("Ano de Fabricação: " + node.veiculo.dataFabricacao);
            System.out.println("------------------------");
            listarEmOrdem(node.direito);
        }
        
    }

    // public Veiculo buscarVeiculo(String placa, AVLNode node) {
    //     if (node == null) {
    //         return null;
    //     }

    //     if (placa.compareTo(node.veiculo.placa) < 0) {
    //         return buscarVeiculo(placa, node.esquerdo);
    //     } else if (placa.compareTo(node.veiculo.placa) > 0) {
    //         return buscarVeiculo(placa, node.direito);
    //     } else {
    //         return node.veiculo;
    //     }
    // }

    public Veiculo buscarVeiculo(String placa, AVLNode node) {
        if (node == null) {
            return null;
        }
    
        if (placa.hashCode() < node.chave) {
            return buscarVeiculo(placa, node.esquerdo);
        } else if (placa.hashCode() > node.chave) {
            return buscarVeiculo(placa, node.direito);
        } else {
            return node.veiculo;
        }
    }

    public Veiculo buscarRenavam(String renavam, AVLNode node) {
        if (node == null) {
            return null;
        }

        if (renavam.compareTo(node.veiculo.renavam) < 0) {
            return buscarRenavam(renavam, node.esquerdo);
        } else if (renavam.compareTo(node.veiculo.renavam) > 0) {
            return buscarRenavam(renavam, node.direito);
        } else {
            return node.veiculo;
        }
    }

    public Veiculo alterarVeiculo(String placa, Veiculo novoVeiculo) {
        Veiculo veiculo = buscarVeiculo(placa, raiz);
        if (veiculo != null) {
            remover(raiz, veiculo);
            inserir(raiz, novoVeiculo);
        }
        return veiculo;
    }

    public int quantidadeVeiculos(AVLNode node) {
        if (node == null) {
            return 0;
        }
        
        int qtdEsquerdo = quantidadeVeiculos(node.esquerdo);
        int qtdDireito = quantidadeVeiculos(node.direito);
        
        return 1 + qtdEsquerdo + qtdDireito;
    }
}
