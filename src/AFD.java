public class AFD {

    public Estado[] Estados;
    public Estado EstadoInicial;
    public Estado[] EstadosFinais;
    public String[] alfabeto;

    AFD(String[] alfabeto){
       this.alfabeto = alfabeto;
    }

    public void criarEstados(int quantidadeDeEstado) {

        Estados = new Estado[quantidadeDeEstado];
        for (int i = 0; i < Estados.length; i++) {
            Estados[i] = new Estado();
            Estados[i].id = Integer.toString(i+1);
        }

    }

    public void selecionarEstadoIniciail(int idDoEstadoInicial) {
        EstadoInicial = new Estado();
        EstadoInicial = Estados[idDoEstadoInicial - 1];
    }

    public void criarEstadosFinais(int quantidadeDeEstadoFinais) {
        EstadosFinais = new Estado[quantidadeDeEstadoFinais];
    }

    public void selecionarEstadosFinais(int[] numeroDosFinais) {
        criarEstadosFinais(numeroDosFinais.length);

        for (int i = 0; i < numeroDosFinais.length; i++) {
            EstadosFinais[i] = Estados[numeroDosFinais[i] - 1];
            Estados[numeroDosFinais[i]- 1 ].ehFinal = true;
        }

    }

    public void montar(int estado1, Object elemento, int estado2) {
        // EstadosDoAutomato[] , lado = EstadosDoAutomato[]
        // δ(q1, a) = q2,
        // δ(q1, b) = q1
        // δ(q2, a) = q3
        // δ(q2, b) = q3
        // δ(q3, a) = q2
        // δ(q3, b) = q1
        Estados[estado1-1].setProximoEstado(elemento, Estados[estado2-1]);

    }

    public String validar(String palavra) {
        boolean aceito = false;
        Estado estadoAtual = EstadoInicial;

        char[] palavraArray = new char[palavra.length()];

        for(int i=0; i < palavra.length(); i++){
            palavraArray[i]= palavra.charAt(i);
        }


        for (int i = 0; i < palavra.length(); i++) {
            if(estadoAtual.getProximoEstado(palavraArray[i]) != null){
                estadoAtual = estadoAtual.getProximoEstado(palavraArray[i]);
                aceito = estadoAtual.ehFinal;
            }
        }
        return aceito + "";
    }

}
