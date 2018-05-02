import java.util.List;
import java.util.ArrayList;
/**
 * Clase que resuelve el problema de los numeros capicuas.
 * <p>
 * Una solucion a este problema consiste en un par (a,b) tal que a y b son numeros capicuas de 5 digitos tal que no exista
 * otro par (c,d) de numeros capicuas de 5 digitos tal que |c - d| < |a - b|.
 * 
*/
public class ProblemaCapicuas5D {
    
    /**
     * @return todas las soluciones posibles al problema que plantea esta clase
     */ 
    public static List<ParCapicuas> obtenerSoluciones() {
       
       List<ParCapicuas> listaPares = new ArrayList<ParCapicuas>();
       Capicua5D c1 = Capicua5D.zero(); //El 00000
       Capicua5D c2 = c1.siguiente();   //El siguiente
       /*Me genera todas los pares (cada uno con su siguiente), formar una lista de todos los capicuas con todos los
       capicuas no tiene sentido ya que el la distancia menor de va a dar con el alctual capicua y su siguiente*/
       while(c2 != null){
          ParCapicuas p = new ParCapicuas(c1,c2); //Creo el par
          listaPares.add(p); //lo añado a la lista
          c1=c2;  
          c2=c2.siguiente(); //(c1,c2) - (c2,c3) - ...
       }
       return listaPares;
    }
    /**
    * @return una solucion al problema que plantea esta clase
    */ 
    public static ParCapicuas obtenerSolucion(){
        List<ParCapicuas> soluciones=obtenerSoluciones();
        int distancia = 10000; //simulacion de infinito
        ParCapicuas solucion = null;
        for (int i=0; i<soluciones.size(); i++){
            ParCapicuas p = soluciones.get(i);
            int distAux = p.primero().diferencia(p.segundo());
            if (distAux<distancia){
                distancia = distAux;
                solucion = p;
            }
        }
        return solucion;
    }
}