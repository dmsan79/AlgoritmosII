/**
 * Main class of the Java program. 
 * 
 */
import java.util.List;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("Soluciones al problema de los numeros capicuas de 5 digitos");
        for (ParCapicuas s : ProblemaCapicuas5D.obtenerSoluciones()) {
        	if (s.segundo().diferencia(s.primero())==11) {
            	System.out.println(s.toString() + " diferencia : " + s.segundo().diferencia(s.primero()));	
        	}
        }
    }
}