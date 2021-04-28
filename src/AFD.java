public class AFD {

    public Estado[] Estados;
    public Estado[] EstadosIniciais;
    public Estado[] EstadosFinais;
    public char alfa, beta;

    AFD(char alfa, char beta){
        this.alfa = alfa;
        this.beta = beta;
    }

    public void criarEstados(int quantidadeDeEstado) {

        Estados = new Estado[quantidadeDeEstado];
        for (int i = 0; i < Estados.length; i++) {
            Estados[i] = new Estado();
            Estados[i].id = "q"+i;
        }

    }

    public void criarEstadoIniciais(int quantidadeDeEstadoIniciais) {
        EstadosIniciais = new Estado[quantidadeDeEstadoIniciais];

    }

    public void criarEstadoFinais(int quantidadeDeEstadoFinais) {
        EstadosFinais = new Estado[quantidadeDeEstadoFinais];

    }

    public void selecionarEstadosIniciais(int[] numeroDosIniciais) {
        criarEstadoIniciais(numeroDosIniciais.length);

        for (int i = 0; i < numeroDosIniciais.length; i++) {

            EstadosIniciais[i] = Estados[numeroDosIniciais[i]];

        }
    }

    public void selecionarEstadosFinais(int[] numeroDosFinais) {
        criarEstadoFinais(numeroDosFinais.length);

        for (int i = 0; i < numeroDosFinais.length; i++) {

            EstadosFinais[i] = Estados[numeroDosFinais[i]];
            Estados[numeroDosFinais[i]].estadoFinal = true;
        }
    }

    public void montar(int estado1, char x, int estado2) {
        // EstadosDoAutomato[] , lado = EstadosDoAutomato[]
        // δ(q1, a) = q2,
        // δ(q1, b) = q1
        // δ(q2, a) = q3
        // δ(q2, b) = q3
        // δ(q3, a) = q2
        // δ(q3, b) = q1

        if (x == alfa) {
            Estados[estado1].esquerda = Estados[estado2];
        }
        if (x == beta) {
            Estados[estado1].direita = Estados[estado2];
        }


    }

    public String validar(String palavra) {
        boolean validado = false;

        for (int i = 0; i < EstadosIniciais.length; i++) {
            Estado raiz = EstadosIniciais[0];
            for (int j = 0; j < palavra.length(); j++) {
                if (palavra.charAt(j) == alfa) {
                    if ((raiz.esquerda) != null) {
                        raiz = raiz.esquerda;
                        if (raiz.estadoFinal == true) {
                            validado = true;
                        } else {
                            validado = false;
                        }
                    } else {
                        break;
                    }

                }
                if (palavra.charAt(j) == beta) {
                    if ((raiz.direita) != null) {
                        raiz = raiz.direita;
                        if (raiz.estadoFinal == true) {
                            validado = true;
                        } else {
                            validado = false;
                        }
                    } else {
                        break;
                    }

                }
            }
        }
        return validado + "";
    }

}
