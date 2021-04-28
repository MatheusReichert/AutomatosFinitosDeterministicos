public class Estado {

    Estado(){

    }
    Estado(Estado esquerda, Estado direita) {
        this.esquerda = esquerda;
        this.direita= direita;
    }

    public String id;
    public Estado esquerda;
    public Estado direita;
    public boolean estadoFinal = false;
}
