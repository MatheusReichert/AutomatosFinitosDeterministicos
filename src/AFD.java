import java.util.ArrayList;

public class AFD {

    public Estado[] estados;
    public Estado estadoInicial;
    public Estado[] estadosFinais;
    public String[] alfabeto;

    AFD(String[] alfabeto){
       this.alfabeto = alfabeto;
    }

    public void criarEstados(int quantidadeDeEstado) {

        estados = new Estado[quantidadeDeEstado];
        for (int i = 0; i < estados.length; i++) {
            estados[i] = new Estado();
            
            int ids = i+1;
            estados[i].id = "q" + ids;
        }

    }

    public void selecionarEstadoIniciail(int idDoEstadoInicial) {
        estadoInicial = new Estado();
        estadoInicial = estados[idDoEstadoInicial - 1];
    }

    public void criarEstadosFinais(int quantidadeDeEstadoFinais) {
        estadosFinais = new Estado[quantidadeDeEstadoFinais];
    }

    public void selecionarEstadosFinais(int[] numeroDosFinais) {
        criarEstadosFinais(numeroDosFinais.length);

        for (int i = 0; i < numeroDosFinais.length; i++) {
            estadosFinais[i] = estados[numeroDosFinais[i] - 1];
            estados[numeroDosFinais[i]- 1 ].ehFinal = true;
        }

    }

    public void montar(int estadoAtual, Object elemento, int proximoEstado) {
        // EstadosDoAutomato[] , lado = EstadosDoAutomato[]
        // δ(q1, a) = q2,
        // δ(q1, b) = q1
        // δ(q2, a) = q3
        // δ(q2, b) = q3
        // δ(q3, a) = q2
        // δ(q3, b) = q1
        estados[estadoAtual - 1].setProximoEstado(elemento, estados[ proximoEstado - 1]);

    }

    public String validar(String palavra) {
        boolean aceito = false;
        Estado estadoAtual = estadoInicial;

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

    public ArrayList<String> estadosPercorrido(String palavra) {

        ArrayList<String> caminho = new ArrayList<String>();
        Estado estadoAtual = estadoInicial;
        caminho.add(estadoInicial.id);

        char[] palavraArray = new char[palavra.length()];

        for(int i=0; i < palavra.length(); i++){
            palavraArray[i]= palavra.charAt(i);
        }


        for (int i = 0; i < palavra.length(); i++) {
            if(estadoAtual.getProximoEstado(palavraArray[i]) != null){
                estadoAtual = estadoAtual.getProximoEstado(palavraArray[i]);
                caminho.add(estadoAtual.id);
            }
        }
        return  caminho;
    }

}
