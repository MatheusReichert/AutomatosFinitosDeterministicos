public class Principal {


    public static void main(String[] args) {

        //alfabeto
        String[] alfabeto = {"a", "b"};
        AFD teste = new AFD(alfabeto);

        teste.criarEstados(3);

        int[] EstadosFinais = {2};
        teste.selecionarEstadosFinais(EstadosFinais);

        teste.selecionarEstadoIniciail(1);

        /*
        δ(q1, a) = q2
        δ(q1,b) = q1
        δ(q2, a) = q3
        δ(q2, b) = q3
        δ(q3,a) = q2
        δ(q3,b) = q1
*/
        teste.montar(1, 'a', 2);
        teste.montar(1, 'b', 1);
        teste.montar(2, 'a', 3);
        teste.montar(2, 'b', 3);
        teste.montar(3, 'a', 2);
        teste.montar(3, 'b', 1);

        System.out.println(teste.estadosPercorrido("a"));
        System.out.println(teste.validar("a"));

        System.out.println(teste.estadosPercorrido("aaa"));
        System.out.println(teste.validar("aaa"));

        System.out.println(teste.estadosPercorrido("aaaaaaba"));
        System.out.println(teste.validar("aaaaaaba"));


    }
}