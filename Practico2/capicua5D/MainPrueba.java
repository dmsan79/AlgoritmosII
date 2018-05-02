import java.util.List;
import java.lang.Math;
import java.util.ArrayList;
public class MainPrueba{

    public static void main(String[] args) {
        
        //int num = 10;
        //String capicua = String.valueOf(num);
        //capicua = String.format("%05d", num);
    	//System.out.println(Integer.parseInt(capicua));

   		/*Capicua5D c = Capicua5D.zero();
    	while (c!=null){
    		System.out.println(c.toString());
    		c=c.siguiente();
    	}*/
    	List<ParCapicuas> listaPares = new ArrayList<ParCapicuas>();
       Capicua5D c1 = Capicua5D.zero(); //El 00000
       Capicua5D c2 = c1.siguiente();
       while(c2 != null){
          ParCapicuas p = new ParCapicuas(c1,c2);
          listaPares.add(p);
          c1=c2;
          c2=c2.siguiente();
       }
       for (int i=0;i<listaPares.size();i++ ) {
       	
       	 System.out.println((listaPares.get(i)).toString());
       }

       int distancia = 10000; //simulacion de infinito
        ParCapicuas solucion = null;
        for (int i=0; i<listaPares.size(); i++){
            ParCapicuas p = listaPares.get(i);
            int distAux = p.segundo().diferencia(p.primero());
            if (distAux<distancia){
                distancia = distAux;
                solucion = p;
            }
        }
        System.out.println("SOLUCION: "+solucion.toString() + " - Distancia:" + distancia);
    }
}