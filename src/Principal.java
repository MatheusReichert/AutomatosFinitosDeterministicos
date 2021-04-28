public class Principal {


    public static void main(String[] args) {


        AFD teste = new AFD('0', '1');

        teste.criarEstados(4);

        int[] EstadosFinais = {2};
        teste.selecionarEstadosFinais(EstadosFinais);

        int[] EstadosIniciais = {0};
        teste.selecionarEstadosIniciais(EstadosIniciais);

        //δ(q0,1) = q1
        //δ(q1, 0) = q2
        //δ(q1, 1) = q1
        //δ(q2, 0) = q2
        //δ(q2, 1) = q1



        teste.montar(0, '1', 1);
        teste.montar(1, '0', 2);
        teste.montar(1, '1', 1);
        teste.montar(2, '0', 2);
        teste.montar(2, '1', 1);



        System.out.println(teste.validar("01111111"));



    }

}
