import java.util.*;

public class OchoFichas{
            static boolean bandera=false;
            static ArrayList<Integer> matrix= new ArrayList<Integer>(8);
            public static void main(String [] arrg){
              Scanner in = new Scanner(System.in);
              
              for(int i=0;i<9;i++){
                    int input=in.nextInt();
                    matrix.add(input);
                }
              while(bandera==false){
                    validarArray(matrix);
                    if(bandera==true){
                      System.out.println("esta es la respuesta");
                      break;
                    }
                    else{
                         System.out.println("esta noooooooo es la respuesta");
                    }
                    System.out.println("------------EXPANDIR-----------");
                    expandir(matrix);
                  // bandera=true;
              }
              
              /*for(int j=0;j<2;j++){
                    validarArray(matrix);
                    if(bandera==true){
                      System.out.println("esta es la respuesta");
                      break;
                    }
                    else{
                         System.out.println("esta noooooooo es la respuesta");
                    }
                    expandir(matrix);
                   //bandera=true;
                }
              */
              
            }
            public static void validarArray(ArrayList<Integer> matrix){
                  for(int i=0;i<8;i++){
                      
                      if(matrix.get(i)!=i+1){  
                          bandera=false;
                          break;
                        }
                        else{
                            bandera=true;
                        }
                        
                       
                  }
                  
            }
            public static void expandir(ArrayList<Integer> matrix){
                   int res=-1;
                   ArrayList<ArrayList<Integer>> voraz=new ArrayList<ArrayList<Integer>>();
                   for(int i=0;i<9;i++){
                       if(matrix.get(i)==0){
                           res=i;
                           break;
                        }
                    }
                   
                   imprimir(matrix);
                   switch (res+1) {
                      case 1:
                        System.out.println("------------------------");
                    
                        ArrayList<Integer> derecha=new ArrayList<Integer>();
                        derecha.addAll(matrix);
                        derecha.set(0,matrix.get(1));
                        derecha.set(1,0);
                        imprimir(derecha);
                        
                        System.out.println("------------------------");
                        
                        ArrayList<Integer> abajo=new ArrayList<Integer>();
                        abajo.addAll(matrix);
                        abajo.set(0,matrix.get(3));
                        abajo.set(3,0);
                        imprimir(abajo);
                        
                        voraz.add(derecha);
                        voraz.add(abajo);
                        break;
                      case 2:
                        System.out.println("------------------------");
                        
                        ArrayList<Integer> derechaCase2=new ArrayList<Integer>();
                        derechaCase2.addAll(matrix);
                        derechaCase2.set(1,matrix.get(2));
                        derechaCase2.set(2,0);
                        imprimir(derechaCase2);
                        
                        System.out.println("------------------------");
                        
                        ArrayList<Integer> izquierdaCase2=new ArrayList<Integer>();
                        izquierdaCase2.addAll(matrix);
                        izquierdaCase2.set(1,matrix.get(0));
                        izquierdaCase2.set(0,0);
                        imprimir(izquierdaCase2);
                        
                        System.out.println("------------------------");
                        
                        ArrayList<Integer> abajoCase2=new ArrayList<Integer>();
                        abajoCase2.addAll(matrix);
                        abajoCase2.set(1,matrix.get(4));
                        abajoCase2.set(4,0);
                        imprimir(abajoCase2);
                        
                        voraz.add(derechaCase2);
                        voraz.add(izquierdaCase2);
                        voraz.add(abajoCase2);
                        break;
                      case 3:
                        System.out.println("------------------------");
                        
                        ArrayList<Integer> izquierdaCase3=new ArrayList<Integer>();
                        izquierdaCase3.addAll(matrix);
                        izquierdaCase3.set(2,matrix.get(1));
                        izquierdaCase3.set(1,0);
                        imprimir(izquierdaCase3);
                        
                        System.out.println("------------------------");
                        
                        ArrayList<Integer> abajoCase3=new ArrayList<Integer>();
                        abajoCase3.addAll(matrix);
                        abajoCase3.set(2,matrix.get(5));
                        abajoCase3.set(5,0);
                        imprimir(abajoCase3);
                        
                        voraz.add(izquierdaCase3);
                        voraz.add(abajoCase3);
                        break;
                      case 4:
                        System.out.println("------------------------");
                        
                        ArrayList<Integer> derechaCase4=new ArrayList<Integer>();
                        derechaCase4.addAll(matrix);
                        derechaCase4.set(3,matrix.get(4));
                        derechaCase4.set(4,0);
                        imprimir(derechaCase4);
                        
                        System.out.println("------------------------");
                        
                        ArrayList<Integer> arribaCase4=new ArrayList<Integer>();
                        arribaCase4.addAll(matrix);
                        arribaCase4.set(3,matrix.get(0));
                        arribaCase4.set(0,0);
                        imprimir(arribaCase4);
                        
                        System.out.println("------------------------");
                        
                        ArrayList<Integer> abajoCase4=new ArrayList<Integer>();
                        abajoCase4.addAll(matrix);
                        abajoCase4.set(3,matrix.get(6));
                        abajoCase4.set(6,0);
                        imprimir(abajoCase4);
                        
                        voraz.add(derechaCase4);
                        voraz.add(arribaCase4);
                        voraz.add(abajoCase4);
                        break;  
                      case 5:
                        System.out.println("------------------------");
                        
                        ArrayList<Integer> derechaCase5=new ArrayList<Integer>();
                        derechaCase5.addAll(matrix);
                        derechaCase5.set(4,matrix.get(5));
                        derechaCase5.set(5,0);
                        imprimir(derechaCase5);
                        
                        System.out.println("------------------------");
                        
                        ArrayList<Integer> izquierdaCase5=new ArrayList<Integer>();
                        izquierdaCase5.addAll(matrix);
                        izquierdaCase5.set(4,matrix.get(3));
                        izquierdaCase5.set(3,0);
                        imprimir(izquierdaCase5);
                        
                        System.out.println("------------------------");
                        
                        ArrayList<Integer> arribaCase5=new ArrayList<Integer>();
                        arribaCase5.addAll(matrix);
                        arribaCase5.set(4,matrix.get(1));
                        arribaCase5.set(1,0);
                        imprimir(arribaCase5);
                        
                        System.out.println("------------------------");
                        
                        ArrayList<Integer> abajoCase5=new ArrayList<Integer>();
                        abajoCase5.addAll(matrix);
                        abajoCase5.set(4,matrix.get(7));
                        abajoCase5.set(7,0);
                        imprimir(abajoCase5);
                        
                        voraz.add(derechaCase5);
                        voraz.add(izquierdaCase5);
                        voraz.add(arribaCase5);
                        voraz.add(abajoCase5);
                        break;
                      case 6:
                        System.out.println("------------------------");
                        
                        ArrayList<Integer> arribaCase6=new ArrayList<Integer>();
                        arribaCase6.addAll(matrix);
                        arribaCase6.set(5,matrix.get(2));
                        arribaCase6.set(2,0);
                        imprimir(arribaCase6);
                        
                        System.out.println("------------------------");
                        
                        ArrayList<Integer> abajoCase6=new ArrayList<Integer>();
                        abajoCase6.addAll(matrix);
                        abajoCase6.set(5,matrix.get(8));
                        abajoCase6.set(8,0);
                        imprimir(abajoCase6);
                        
                        System.out.println("------------------------");
                        
                        ArrayList<Integer> izquierdaCase6=new ArrayList<Integer>();
                        izquierdaCase6.addAll(matrix);
                        izquierdaCase6.set(5,matrix.get(4));
                        izquierdaCase6.set(4,0);
                        imprimir(izquierdaCase6);
                        
                        voraz.add(arribaCase6);
                        voraz.add(abajoCase6);
                        voraz.add(izquierdaCase6);
                        break;
                      case 7:
                        System.out.println("------------------------");
                        
                        ArrayList<Integer> arribaCase7=new ArrayList<Integer>();
                        arribaCase7.addAll(matrix);
                        arribaCase7.set(6,matrix.get(3));
                        arribaCase7.set(3,0);
                        imprimir(arribaCase7);
                        
                        System.out.println("------------------------");
                        
                        ArrayList<Integer> derechaCase7=new ArrayList<Integer>();
                        derechaCase7.addAll(matrix);
                        derechaCase7.set(6,matrix.get(7));
                        derechaCase7.set(7,0);
                        imprimir(derechaCase7);
                        
                        voraz.add(arribaCase7);
                        voraz.add(derechaCase7);
                        break;
                      case 8: 
                        System.out.println("------------------------"); 
                        
                        ArrayList<Integer> arribaCase8=new ArrayList<Integer>();
                        arribaCase8.addAll(matrix);
                        arribaCase8.set(7,matrix.get(4));
                        arribaCase8.set(4,0);
                        imprimir(arribaCase8);
                        
                        System.out.println("------------------------");
                        
                        ArrayList<Integer> derechaCase8=new ArrayList<Integer>();
                        derechaCase8.addAll(matrix);
                        derechaCase8.set(7,matrix.get(8));
                        derechaCase8.set(8,0);
                        imprimir(derechaCase8);
                        
                        System.out.println("------------------------");
                        
                        ArrayList<Integer> izquierdaCase8=new ArrayList<Integer>();
                        izquierdaCase8.addAll(matrix);
                        izquierdaCase8.set(7,matrix.get(6));
                        izquierdaCase8.set(6,0);
                        imprimir(izquierdaCase8);
                        
                        voraz.add(arribaCase8);
                        voraz.add(derechaCase8);
                        voraz.add(izquierdaCase8);
                        break;  
                      case 9:
                        System.out.println("------------------------");
                      
                        ArrayList<Integer> arribaCase9=new ArrayList<Integer>();
                        arribaCase9.addAll(matrix);
                        arribaCase9.set(8,matrix.get(5));
                        arribaCase9.set(5,0);
                        imprimir(arribaCase9);
                        
                        
                        System.out.println("------------------------");
                        
                        ArrayList<Integer> izquierdaCase9=new ArrayList<Integer>();
                        izquierdaCase9.addAll(matrix);
                        izquierdaCase9.set(8,matrix.get(7));
                        izquierdaCase9.set(7,0);
                        imprimir(arribaCase9);
                        
                        voraz.add(arribaCase9);
                        voraz.add(izquierdaCase9);
                        break;  
                    }
                     res=-1;
                    int ResultadoVorasMenos=ResultadoVorasMenos(voraz);
                    matrix.clear();
                    matrix.addAll(voraz.get(ResultadoVorasMenos));
                    System.out.println(matrix.toString());
            }
            
            public static int ResultadoVorasMenos(ArrayList<ArrayList<Integer>> res){
                int resNumero=0;
                int bandera=1;
                int menor=100000;
                int indice=-1;
                ArrayList<Integer> listaDeFichasFueraDeSitio=new ArrayList<Integer>();
                for(int i=0;i<res.size();i++){
                      for(int j=0;j<res.get(i).size()-1;j++){
                            //System.out.println("#######> "+res.get(i).get(j)+"___"+bandera);  
                            if(res.get(i).get(j)!=bandera){
                                    
                                resNumero++;
                             }
                            
                                
                            bandera++;
                        }
                      //  System.out.println("21212>cantidad de desobucados "+resNumero);  
                      if(resNumero<menor){
                          menor=resNumero;
                          indice=i;
                          
                        //  System.out.println(":::::::::::::::::::> numeroMenor:"+menor+"----------indice  "+indice);
                        }
                      bandera=1;
                      resNumero=0;
                    }
                 System.out.println("Menor cantidad de Fichas mal posicionadas: "+menor);    
                return indice;
            }
            
            public static void imprimir(ArrayList<Integer> matriz){
                for(int i=0;i<matriz.size();i++){
                    System.out.print("|  "+matriz.get(i)+"  |");
                    if(i==2 || i==5){
                        System.out.println();
                    }
                    
                }
                System.out.println();
            }
 }
