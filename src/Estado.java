import java.util.HashMap;

public class Estado {

    Estado(){
    }

    Estado(String[] alfabeto) {
        for (String caminho: alfabeto){
            proximoEstado.put(caminho, new Estado());
        }
    }

    public Estado getProximoEstado(Object elemento){
       return  proximoEstado.get(elemento);
    }

    public void setProximoEstado(Object elemento, Estado estado){
        proximoEstado.put(elemento, estado);
    }

    public String id;
    public HashMap<Object, Estado> proximoEstado = new HashMap<Object, Estado>();

    public boolean ehFinal = false;

}
