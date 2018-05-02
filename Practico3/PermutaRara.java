import java.util.ArrayList;
public class Permutaciones{
    
    //Funcion Factorial que es utilizada en parte del codigo
    public static Integer factorial (Integer numero) {
        if (numero==0)
            return 1;
        else
            return (numero * factorial(numero-1));
    }

    //Valida que dado una lista de posiciones de 8 reinas, ninguna amenaza a otra
    public static boolean esSolucion(ArrayList<Pair<Integer, Integer>> reinas) {
        for (int i=0; i<reinas.size(); i++){
            Pair<Integer,Integer> x = reinas.get(i);
            for (int j=i+1; j<reinas.size(); j++){
                Pair<Integer,Integer> y = reinas.get(j);
                if (x.getFirst()-y.getFirst() ==x.getSecond()-y.getSecond())
                    return false;   
            }        
        }
        return true;    
    }

    //Se genera una lista de soluciones, de las culaes vamos a sacar la correcta
    public static void obtenerSoluciones(String a, ArrayList<Integer> conjunto, ArrayList<ArrayList<Pair<Integer,Integer>>> soluciones) {
        //Caso Base de la recursion (conjunto con un solo elemento)
        if (conjunto.size()==1){ //Cada vez que entra al if tiene resuelta una permutacion
            String permutacion = a+conjunto.get(0); //Contiene una de las permutaciones posibles
            //Pasamos el string a un arreglo de enteros
            ArrayList<Pair<Integer,Integer>> permutaciones = new ArrayList<Pair<Integer,Integer>>(permutacion.length());
            //El for toma cada caracter del String, lo convierte a entero y lo pone en el arreglo en forma de par 
            for (int i=0;i<permutacion.length();i++){
                Integer n = Integer.parseInt(permutacion.substring(i,i+1));
                Pair<Integer,Integer> newPair = new Pair<Integer,Integer>(i+1,n); //(i=fila, a[i]=columna)
                permutaciones.add(newPair);
            }
            soluciones.add(permutaciones); //Añadimos la permutacion(lista de pares) a la lista de soluciones
        }
        //Aca se hace la recursion (Que aun no la entiendo pero funciona :-P )
        for (int i=0;i<conjunto.size();i++){
            Integer b = conjunto.remove(i);
            obtenerSoluciones (a+b, conjunto,soluciones);
            conjunto.add(i,b);
        }
    }

    //Retorna una lista de posiciones de reinas tal que ninguna reina amenaza a otra.
    public static ArrayList<Pair<Integer, Integer>> obtenerSolucion(ArrayList<ArrayList<Pair<Integer, Integer>>> listaSoluciones){
        ArrayList<Pair<Integer, Integer>> soluc = new ArrayList<Pair<Integer,Integer>>(1);
        for (int i=0; i<listaSoluciones.size(); i++){
            soluc = listaSoluciones.get(i);
            if (esSolucion(soluc)){
                return soluc;
            }
        }
        return soluc;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> conjunto =new ArrayList<Integer>(4);
        
        conjunto.add(1); conjunto.add(2); conjunto.add(3); conjunto.add(4);
        conjunto.add(5); conjunto.add(6); conjunto.add(7); conjunto.add(8);

        ArrayList<ArrayList<Pair<Integer,Integer>>> solucioness = new ArrayList<ArrayList<Pair<Integer,Integer>>>(factorial(conjunto.size()));
        obtenerSoluciones ("", conjunto, solucioness); //Obtenemos una lista de posibles soluciones
        //Imprimimos esta lista de posibles soluciones
        for (int i=0;i<solucioness.size() ;i++){
            ArrayList<Pair<Integer,Integer>> aux = solucioness.get(i);
            System.out.println();
            System.out.print((i+1)+" - "); //Para enumerar las todas las permutaciones
            for (int j=0;j<aux.size();j++ ) {
                System.out.print(aux.get(j).toString());  
            }    
        } System.out.println();

        ArrayList<Pair<Integer,Integer>> solucion = obtenerSolucion(solucioness); //Obtenemos la solucion al problema
        
        System.out.println("Solucion:");
        //Imprime todos los pares de la solucion
        for (int j=0; j<solucion.size(); j++){
            System.out.print(solucion.get(j).toString());  
        }    
        System.out.println();
    }
}