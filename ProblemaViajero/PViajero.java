import java.util.*;
/**
 * Write a description of class PViajero here.
 * 
 * @author (Darwin Garcia) 
 * @version (30/04/2022)
 */
public class PViajero{
    ArrayList<Tupla> caminos;
    ArrayList<Tupla> calculo;
    ArrayList<String> imprimir;
    ArrayList<Integer> aristas;
    public static void main(String []args){
        PViajero problema = new PViajero();
        problema.costoUniforme("Arad","Bucarest");
    }

    public PViajero(){
        caminos=new ArrayList<Tupla>();
        imprimir=new ArrayList<String>();
        calculo=new ArrayList<Tupla>();
        aristas=new ArrayList<Integer>();
        llenarDestinos();
    }

    public void costoUniforme(String origen, String destino){
        System.out.println("\n\n------------------------------------Algoritmo Costo Uniforme------------------------------------\n");
        if(existe(origen)==true && existe(destino)==true){
            Tupla actual;
            int menor;int ruta=0;int posMenor;int rendimiento=0;
            while(origen != destino){
                String ciudades="        Todas las posibles ciudades que puede visitar : ";
                imprimir.add(ciudades);
                for(int i=0; i<caminos.size(); i++){
                    actual=caminos.get(i);
                    if(origen==actual.getIncio()){
                        rendimiento=rendimiento+1;
                        calculo.add(actual);
                        aristas.add(actual.getArista());
                        String auz="             -->"+actual.getFin()+"  costo: " +actual.getArista();
                        imprimir.add(auz);
                    }
                }
                menor=aristas.get(0);
                posMenor=0;
                for(int j=0; j<aristas.size();j++){
                    if(aristas.get(j) < menor){
                        menor=aristas.get(j);
                        posMenor=j;
                    }
                }
                actual=calculo.get(posMenor);
                origen=actual.getFin();
                String seEscogio="        Se Escogio la ciudad de : " + origen;
                imprimir.add(seEscogio);

                ruta=ruta + actual.getArista();
                calculo.clear();
                aristas.clear();
                String linea1="   ";
                imprimir.add(linea1);
            }
            String lol=" ===> Se llego al destino : " + destino + " con un costo ruta de: " + ruta; 
            String lol1=" ==>Medida de rendimiento : "+rendimiento;
            imprimir.add(lol);imprimir.add(lol1);
        }else{
            imprimir.add("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡Error no exite la ciudad origen o destino. Por favor revise!!!!!!!!!!");
        }
        imprimirse();
    }

    public boolean existe(String prueba){
        boolean res=false;
        Tupla aux;
        for(int i=0;i<caminos.size();i++){
            aux=caminos.get(i);
            if(aux.getIncio()==prueba || aux.getFin()==prueba ){
                res=true;
                break;
            }
        }
        return res;
    }

    public void llenarDestinos(){
        caminos.add(new Tupla("Arad","Zerind",75));
        caminos.add(new Tupla("Arad","Timisoara",115));
        caminos.add(new Tupla("Arad","Sibiu",140));

        caminos.add(new Tupla("Zerind","Oradea",71));

        caminos.add(new Tupla("Oradea","Sibiu",151));

        caminos.add(new Tupla("Sibiu","Fagaras",99));
        caminos.add(new Tupla("Sibiu","Rimnicu Vilcea",80));

        caminos.add(new Tupla("Rimnicu Vilcea","Pitesti",97));
        caminos.add(new Tupla("Rimnicu Vilcea","Cralova",146));

        caminos.add(new Tupla("Cralova","Pitesti",138));

        caminos.add(new Tupla("Pitesti","Bucarest",101));

        caminos.add(new Tupla("Fagaras","Bucarest",211));
    }

    public void imprimirse(){
        for(int i=0; i<imprimir.size(); i++){
            System.out.println(imprimir.get(i));
            //System.out.println("destino= "+t.getDestino());
            //System.out.println("distancia= "+t.getDistancia());
        }
    }
}