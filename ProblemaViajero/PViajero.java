import java.util.ArrayList;
import java.util.*;
public class PViajero{
    ArrayList<Tupla> caminos;
    ArrayList<Tupla> calculo;
    ArrayList<String> imprimir;
    ArrayList<Integer> aristas;
    public static void main(String []args){
        PViajero problema = new PViajero();
        problema.elegirNumero();
    }

    public void elegirNumero(){
        System.out.println("\n------------------------------------Problema del viajero------------------------------------\n");
        System.out.println("   Eliga un numero");
        System.out.println("   ->1=Busqueda sin informacion: Costo Uniforme\n   ->2=Busqueda con informacion: Voraz o Avara\n   ->3=Busqueda con informacion: A*\n");
        Scanner in = new Scanner(System.in);
        int input=in.nextInt();
        if(input == 1){
            PViajero problema = new PViajero();
            problema.costoUniforme("Arad","Bucarest");
            problema.elegirNumero();
        }else{
            if(input == 2){
                PViajero problema = new PViajero();
                problema.VorazOAvara("Arad","Bucarest");
                problema.elegirNumero();
            }else{
                if(input==3){
                    PViajero problema = new PViajero();
                    problema.Aestrella("Arad","Bucarest");
                    problema.elegirNumero();
                }else{
                    input=in.nextInt();
                }
            }
        }
    }

    public PViajero(){
        caminos=new ArrayList<Tupla>();
        imprimir=new ArrayList<String>();
        calculo=new ArrayList<Tupla>();
        aristas=new ArrayList<Integer>();
        llenarDestinos();
    }

    public void costoUniforme(String origen, String destino){
        System.out.println("\n------------------------------------Algoritmo de Busqueda Costo Uniforme------------------------------------\n");
        imprimir.add("   Ciudad de donde se inicia :  "+origen);
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
                String seEscogio="        Se Escogio la ciudad de : " + origen+ " por su costo de traslado :" +actual.getArista();
                imprimir.add(seEscogio);

                ruta=ruta + actual.getArista();
                calculo.clear();
                aristas.clear();
                String linea1="   ";
                imprimir.add(linea1);
            }
            String lol=" ===> Se llego al destino : " + destino + " con un costo ruta de: " + ruta; 
            String lol1=" ==>Cantidad de ciudades que se tomo encuenta : "+rendimiento;
            imprimir.add(lol);imprimir.add(lol1);
        }else{
            imprimir.add("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡Error no exite la ciudad origen o destino. Por favor revise!!!!!!!!!!");
        }
        imprimirse();
    }

    public void Aestrella(String origen, String destino){
        System.out.println("\n------------------------------------Algoritmo de Busqueda A*------------------------------------\n");
        System.out.println("--->h(x)=Distancia linea recta de la ciudad actual a Bucarest\n-->g(x)=Distancia entre ciudades\n-->f(x)=h(x)+g(x)");
        imprimir.add("   Ciudad de donde se inicia :  "+origen);
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
                        aristas.add(actual.getArista()+actual.getDistanciaAlDestino());
                        int aux=actual.getArista()+actual.getDistanciaAlDestino();
                        String auz="             -->"+actual.getFin()+"  f(x): " +aux;
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
                int aux=actual.getArista()+actual.getDistanciaAlDestino();
                String seEscogio="        Se Escogio la ciudad de : " + origen+ " f(x) :" +aux;
                imprimir.add(seEscogio);

                ruta=ruta + actual.getArista();
                calculo.clear();
                aristas.clear();
                String linea1="   ";
                imprimir.add(linea1);
            }
            String lol=" ===> Se llego al destino : " + destino + " con un costo ruta de: " + ruta; 
            String lol1=" ==>Cantidad de ciudades que se tomo encuenta : "+rendimiento;
            imprimir.add(lol);imprimir.add(lol1);
        }else{
            imprimir.add("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡Error no exite la ciudad origen o destino. Por favor revise!!!!!!!!!!");
        }
        imprimirse();
    }

    public void VorazOAvara(String origen, String destino){
        System.out.println("\n------------------------------------Algoritmo de Busqueda Voraz o Avara------------------------------------\n");
        System.out.println("--->h(x)=Distancia linea recta de la ciudad actual a Bucarest\n");
        imprimir.add("   Ciudad de donde se inicia :  "+origen);
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
                        aristas.add(actual.getDistanciaAlDestino());
                        int aux=actual.getDistanciaAlDestino();
                        String auz="             -->"+actual.getFin()+"  h(x): " +aux;
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
                int aux=actual.getDistanciaAlDestino();
                String seEscogio="        Se Escogio la ciudad de : " + origen+ " h(x) :" +aux;
                imprimir.add(seEscogio);

                ruta=ruta + actual.getArista();
                calculo.clear();
                aristas.clear();
                String linea1="   ";
                imprimir.add(linea1);
            }
            String lol=" ===> Se llego al destino : " + destino + " con un costo ruta de: " + ruta; 
            String lol1=" ==>Cantidad de ciudades que se tomo encuenta : "+rendimiento;
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
        caminos.add(new Tupla("Arad","Zerind",75,374));
        caminos.add(new Tupla("Arad","Timisoara",115,329));
        caminos.add(new Tupla("Arad","Sibiu",140,253));

        caminos.add(new Tupla("Zerind","Oradea",71,380));

        caminos.add(new Tupla("Oradea","Sibiu",151,253));

        caminos.add(new Tupla("Sibiu","Fagaras",99,176));
        caminos.add(new Tupla("Sibiu","Rimnicu Vilcea",80,193));

        caminos.add(new Tupla("Rimnicu Vilcea","Pitesti",97,100));
        caminos.add(new Tupla("Rimnicu Vilcea","Cralova",146,160));

        caminos.add(new Tupla("Cralova","Pitesti",138,100));

        caminos.add(new Tupla("Pitesti","Bucarest",101,0));

        caminos.add(new Tupla("Fagaras","Bucarest",211,0));
    }

    public void imprimirse(){
        for(int i=0; i<imprimir.size(); i++){
            System.out.println(imprimir.get(i));
        }
    }
}
