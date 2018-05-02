import java.util.List;
import java.util.ArrayList;

public class mergeSort{

  //Generamos la lista de puntos (Solo ponemos 10 puntos)
  public static List<Point> generateListPoints (int size){
    List<Point> pts = new ArrayList<Point>();
    for (int i=0; i<size; i++){
      int x = (int) (Math.random()*10 + 0);
      int y = (int) (Math.random()*10 + 0);
      Point p = new Point(x,y);
      pts.add(p);
    }
    return pts;
  }
  //Mostramos lista de puntos
  public static void showListPoints(List<Point> pts){
    for (int i=0; i<pts.size(); i++){
      Point p = pts.get(i);
      System.out.println("("+p.getX()+","+p.getY()+")");
    }
  }

  public static void mergesort(List<Point> array, int inicio, int fin, String coordenada){
    if (fin > inicio){
      int mid = (inicio+fin)/2;
      mergesort(array,inicio,mid,coordenada);
      mergesort(array,mid+1,fin,coordenada);
      merge(array,inicio,mid,fin,coordenada);
    }
  }
  public static void merge(List<Point> a,int inicio, int m, int fin, String coord){
      List<Point> b = new ArrayList<Point>(a.size());
      for (int w=inicio; w<=fin; w++){
          b.add(w,a.get(w));
      }
     	int i, j, k;
      i=inicio; k=inicio; j=m+1; 
      if (coord == "x" || coord=="X"){
        //copia el siguiente elemento más grande
        while (i<=m && j<=fin){ 
            if (b.get(i).getX()<=b.get(j).getX()){
                a.add(k,b.get(i));
                i++;
            }else{
                a.add(k, b.get(j));
                j++;
              }
            k++;
        }
        //copia los elementos restantes de la primera mitad (si los hay)
        while (i<=m){  
            a.add(k,b.get(i));
            k++;
            i++;
        } 
      }
      else{
        //copia el siguiente elemento más grande
        while (i<=m && j<=fin){ 
            if (b.get(i).getY()<=b.get(j).getY()){
                a.add(k,b.get(i));
                i++;
            }else{
                a.add(k, b.get(j));
                j++;
              }
            k++;
        }
        //copia los elementos restantes de la primera mitad (si los hay)
        while (i<=m){  
            a.add(k,b.get(i));
            k++;
            i++;
        } 
      }
  }
  public static void main(String[] args){
    List<Point> pts = generateListPoints(10);
    showListPoints(pts);
    mergesort(pts,0,9,"Y");
  }
}