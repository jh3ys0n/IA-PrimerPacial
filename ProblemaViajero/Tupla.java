public class Tupla{
    private String inicio;
    private String fin;
    private int arista;
    private int distanciaAlDestino;

    public Tupla(String inicio, String fin, int arista,int distanciaAlDestino){
        this.inicio=inicio;
        this.fin=fin;
        this.arista=arista;
        this.distanciaAlDestino=distanciaAlDestino;
    }

    public String getIncio(){
        return inicio;
    }

    public String getFin(){
        return fin;
    }

    public int getArista(){
        return arista;
    }

    public int getDistanciaAlDestino(){
        return distanciaAlDestino;
    }
}