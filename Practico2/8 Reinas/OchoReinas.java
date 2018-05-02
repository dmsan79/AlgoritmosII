import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/* Esta clase representa el problema de las ocho reinas.
 * Dado un tablero de ajedrez hay que encontrar todas las formas de ubicar ocho reinas tal que ninguna amenace a otra. */ 

public class OchoReinas {

    /* Obtiene una solucion al problema de las ocho reinas.
     * @return una lista de posiciones de reinas tal que ninguna reina amenaza a otra */ 
    public static List<Pair<Integer, Integer>> obtenerSolucion(){
        List<List<Pair<Integer, Integer>>> permutacionesPares=obtenerSoluciones();
        List<Pair<Integer, Integer>> solucion = new ArrayList<Pair<Integer,Integer>>();
        for (int i=0; i<permutacionesPares.size(); i++){
            solucion = permutacionesPares.get(i);
            if (esSolucion(solucion))
                return solucion;
        }
        return solucion;
    }
    
    /* Obtiene todas las soluciones al problema de las ocho reinas.
     * @return una coleccion de soluciones */
    public static List<List<Pair<Integer, Integer>>> obtenerSoluciones() {
        //Lista con todas las permutaciones de 8 elementos
        List<List<Integer>> permutaciones = new ArrayList<List<Integer>>();
        //8 for anidados que generan todas las permutaciones
        for (int a=1;a<9;a++){
            for (int b=1;b<9;b++){
                for (int c=1;c<9;c++){
                    for (int d=1;d<9;d++){
                        for (int e=1;e<9;e++){
                            for (int f=1;f<9;f++){
                                for (int g=1;g<9;g++){
                                    for (int h=1;h<9;h++){
                                        //Si no hay repetidos agrego la permutacion a la lista
                                        if (a!=b && a!=c && a!=d && a!=e && a!=f && a!=g && a!=h
                                        && b!=c && b!=d && b!=e && b!=f && b!=g && b!=h
                                        && c!=d && c!=e && c!=f && c!=g && c!=h
                                        && d!=e && d!=f && d!=g && d!=h
                                        && e!=f && e!=g && e!=h
                                        && f!=g && f!=h
                                        && g!=h){ 
                                            //Creo lista que es permutacion correspondiete
                                            List<Integer> aux = new ArrayList<Integer>();
                                            aux.add(a);aux.add(b);aux.add(c);aux.add(d);
                                            aux.add(e);aux.add(f);aux.add(g);aux.add(h);
                                            //Aniado la permutacion a la lista general de permutaciones
                                            permutaciones.add(aux); 
                                        }//if
                                    }//h
                                }//g
                            }//f
                        }//e
                    }//d
                }//c
            }//b
        }//a
        //Creo la lista de lista de pares que voy a retornar
        List<List<Pair<Integer,Integer>>> permutacionesPares = new ArrayList<List<Pair<Integer,Integer>>>();
        for (int i=0; i<permutaciones.size(); i++){
            //Tomo cada permutacione generada anteriormente
            List<Integer> aux = permutaciones.get(i);
            //La transformo a una lista de pares
            List<Pair<Integer,Integer>> listPair = new ArrayList<Pair<Integer,Integer>>();
            //Para cada elemento (que son 8) formo un par con su indice(fila) y valor(columna)
            for (int j=0; j<aux.size(); j++) {
                //Creo el par
                Pair<Integer,Integer> newPair = new Pair<Integer,Integer>(j+1,aux.get(j)); //(i=fila, a[i]=columna)
                //Lo aniado a la lista de pares
                listPair.add(newPair);
            }//end for 2
            //Aniado la lista de pares creadas a la lista de listas de pares
            permutacionesPares.add(listPair);
        }//end for 1
        return permutacionesPares;
    }//obtenerSoluciones
    
    /* Valida que dado una lista de posiciones de 8 reinas, ninguna amenaza a otra 
     * @return {true} si hay 8 reinas y ninguna se amenaza a otra,{false} si la cant de reinas es !=8 o si existe alguna reina que amenaza a otra*/
    public static boolean esSolucion(List<Pair<Integer, Integer>> reinas) {
        //Para cada lista de pares
        for (int i=0; i<reinas.size(); i++){
            Pair<Integer,Integer> x = reinas.get(i); //Obtengo el par correspondiente (el 1, el 2 ...)
            //Lo comparo con los pares siguientes a el
            for (int j=i+1; j<reinas.size(); j++){
                Pair<Integer,Integer> y = reinas.get(j); //Obtengo el siguiente
                //verifico si se toquen diagonalmente
                if (x.getFirst()-y.getFirst() ==x.getSecond()-y.getSecond()) 
                    return false;   
            }        
        }
        return true;    
    }
    
    //METODO MAIN PARA PROBAR LOS METODOS EN MI COMPUTADORA
    public static void main(String[] args) {
        
        List<List<Pair<Integer,Integer>>> solucioness = new ArrayList<List<Pair<Integer,Integer>>>();
        solucioness=obtenerSoluciones(); //Obtenemos una lista de posibles soluciones
        //Imprimimos esta lista de posibles soluciones
        for (int i=0;i<solucioness.size() ;i++){
            List<Pair<Integer,Integer>> aux = solucioness.get(i);
            System.out.println();
            System.out.print((i+1)+" - "); //Para enumerar las todas las permutaciones
            for (int j=0;j<aux.size();j++ ) {
                System.out.print(aux.get(j).toString());  
            }    
        } 
        System.out.println();

        List<Pair<Integer,Integer>> solucion = obtenerSolucion(); //Obtenemos la solucion al problema
        System.out.println("Solucion:");
        //Imprime todos los pares de la solucion
        for (int j=0; j<solucion.size(); j++)
            System.out.print(solucion.get(j).toString());   
        System.out.println();
    }
}