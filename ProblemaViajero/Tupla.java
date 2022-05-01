/**
 * Write a description of class Tuplas here.
 * 
 * @author (Darwin Garcia) 
 * @version (30/04/2022)
 */
public class Tupla{
    private String inicio;
    private String fin;
    private int arista;

    public Tupla(String inicio, String fin, int arista){
        this.inicio=inicio;
        this.fin=fin;
        this.arista=arista;
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
}
