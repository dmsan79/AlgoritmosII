import javax.swing.JOptionPane;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class NearPoint{
	//Generamos la lista de puntos (Solo ponemos 10 puntos)
	public static List<Point> generateListPoints (int size){
		List<Point> pts = new ArrayList<Point>();
		for (int i=0; i<size; i++){
			float x = (float) Math.random()*size + 0;
			float y = (float) Math.random()*size + 0;
			Point p = new Point(x,y);
			pts.add(p);
		}
		return pts;
	}
	//Mostramos lista de puntos
	public static void showListPoints(List<Point> pts){
		DecimalFormat formato = new DecimalFormat("0.0");
		for (int i=0; i<pts.size(); i++){
			Point p = pts.get(i);
			System.out.println("("+formato.format(p.getX())+" ; "+formato.format(p.getY())+")");
		}
	}
	//Copiamos lista de puntos en PX(ordenada por x) y PY(ordenada por y)
	public static void sortPx(List<Point> pts, List<Point> ptsX){
		//Copiamos pts en ptsX y ptsY
		for (int i=0; i<pts.size(); i++)
			ptsX.add(pts.get(i));
		
		//Ordenamos ptsX (Hacer mas eficiente, con mergeSort o quickSort)
		for (int i=0; i<ptsX.size(); i++){
            int index = i;
            for (int j=i+1; j<ptsX.size(); j++){
                if (ptsX.get(j).getX() < ptsX.get(index).getX()) 
                    index = j;
            }
            Point min = ptsX.get(index);  
            ptsX.set(index,ptsX.get(i));
            ptsX.set(i, min);
        }
	}
	//Metodo que divide y conquista (calcula el punto mas cercano de la izquierda y la derecha)
	public static List<Point> mergeSort(List<Point> pX, int inicio, int fin){
		//Si son mas de 3 aplicamos divide y venceras
		if((fin-inicio)>2){
			int mid = (inicio+fin)/2;
			List<Point> dleft = mergeSort(pX,inicio,mid);
			List<Point> dright = mergeSort(pX,mid+1,fin);

			double dl =  Math.hypot(dleft.get(1).getX()-dleft.get(0).getX(), dleft.get(1).getY()-dleft.get(0).getY());
			double dr =  Math.hypot(dright.get(1).getX()-dright.get(0).getX(), dright.get(1).getY()-dright.get(0).getY());
			double dleftRight = Math.min(dl,dr);
			
			List<Point> dcenter = merge(pX,inicio,mid,fin,dleftRight);
			
			if (dcenter==null){
				if (dl<dr) return dleft;
	            else return dright;
			}
			else{
				double dc = Math.hypot(dcenter.get(1).getX()-dcenter.get(0).getX(), dcenter.get(1).getY()-dcenter.get(0).getY());
				if (dc<dleftRight)
					return dcenter;
				else if(dr < dl) return dright;
					 else return dleft;
			}			
		}
		//Si los puntos son 3 o menos lo resolvemos por fuerza bruta
		else{
			double distMin=1000; //Simula infinito
			double distAux;  //Distancias Paraciales
			Point x = new Point(); //Para almacenar los dos
			Point y = new Point(); //puntos mas cercanos
			List<Point> nearpoint = new ArrayList<Point>(2); //Lista con el resultado(2 puntos)
			//2 for anidados para calcular la distancia entre todos los puntos y elegir la menor (FB)
			for (int i=inicio; i<fin; i++){
				for (int j=i+1; j<=fin; j++){
					Point p1 = pX.get(i);	
					Point p2 = pX.get(j);
					distAux =  Math.hypot(p2.getX()-p1.getX(), p2.getY()-p1.getY());
					if(distAux<distMin){
						distMin=distAux;
						x=p1; y=p2;
					}
				}
			}
			nearpoint.add(x); 
			nearpoint.add(y);
			//Retornamos la lista con los 2 puntos mas cercanos
			return nearpoint;
		}
	}
	//Metodo que convina (calcula la distania minima entre los puntos divididos por la linea media)
	public static List<Point> merge(List<Point> pX, int inicio, int mid, int fin, double d){
		//Lista de puntos que estan a una distania menor que "d" de "l (mitad)"
		List<Point> paux = new ArrayList<Point>();
		double medio = pX.get(mid).getX(); //recta media (x=algo)
		for (int i=inicio; i<=fin; i++){
			if(Math.abs(pX.get(i).getX() - pX.get(mid).getX()) <= d)
				paux.add(pX.get(i));
		}
		//Significa que en el medio hay una posible distancia minima
		if (paux.size()>1) {
			//Por terema estos puntos no pueden ser mas de 6
			List<Point> dcenterMin = new ArrayList<Point>(2); //Puntos mas cercanos entre la linea media
			//Ahora debemos hallar la distancia minima entre esos puntos
			double dmin = 1000; //infinito
			Point x = new Point();
			Point y = new Point();
			for (int i=0; i<paux.size()-1; i++){
				for (int j=i+1; j<paux.size(); j++){
					Point a = paux.get(i);
					Point b = paux.get(j);
					double dminAux = Math.hypot(a.getX()-b.getX(), a.getY()-b.getY());
					if (dminAux<dmin){
						dmin=dminAux;
						x=a;
						y=b;
					}
				}
			}
			dcenterMin.add(x);
			dcenterMin.add(y);
			return dcenterMin;
		}
		//En el centro no hay posibilidad de una distancia minima
		else
			return null;
	}

	//Metodo MAIN
	public static void main(String[] args){

		List<Point> puntos = generateListPoints(10);
		List<Point> puntosX = new ArrayList<Point>();

		sortPx(puntos, puntosX);
		System.out.println("Lista Ordenada por X:");
		showListPoints(puntosX);
		
		List<Point> p = mergeSort(puntosX,0,9);
		System.out.println("Puntos mas cercanos:");
		showListPoints(p);
	}
}