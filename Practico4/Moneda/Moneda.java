import java.util.*;

public class Moneda{

	public static int sumaArreglo(List<Integer> xs, int inicio, int fin){
		int acum=0;
		for (int i=inicio; i<fin+1; i++)
			acum=acum+xs.get(i);
		return acum;

	}
	public static void dividir (List<Integer> xs , int inicio, int fin){
		if (inicio<fin){
			int mid = (inicio+fin)/2;
			int sumaLeft = sumaArreglo(xs,inicio,mid);
			int sumaRight = sumaArreglo(xs,mid+1,fin);

			if (sumaLeft>sumaRight)
				dividir(xs,inicio,mid);
			else
				dividir(xs,mid+1,fin);
		}
		else
			System.out.println("Moneda: "+ xs.get(inicio)+" - Posicion: "+inicio);
	}

	public static void main(String[] args) {
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(0);
		lista.add(1);
		lista.add(0);
		lista.add(0);
		lista.add(0);
		lista.add(0);
		lista.add(0);
		lista.add(0);

		dividir(lista,0,7);
	}
}