import java.lang.*; //Para funcion min class Math
public class sumaMinima{
  public static int sumaminima(int[] array, int inicio, int fin){
    int resultado=0;
    if (fin > inicio){
      int mid = (inicio+fin)/2;
      int partLeft = sumaminima(array,inicio,mid);
      int partRight = sumaminima(array,mid+1,fin);
      int mitad = merge(array,inicio,mid,fin);
      resultado = Math.min(Math.min(partRight,partLeft), mitad); 
    }
    return resultado;
  }

  public static int merge(int a[],int inicio, int mid, int fin){
      int left=0;           //Incidice para segmento suma minima parte izquierda (left-mid)
      int right=0;          //Incidice para segmento suma minima parte derecha (mid+1-rght)
      int sumaMinimaLeft=0; //Suma minima parte izquierda
      int suma=0;           //Resultados temporales de la suma
      //Obtenemos la suma minima de la parte izquierda
      for (int i=mid; i>=0; i--){
        suma=suma+a[i];
        if (suma<sumaMinimaLeft){
          sumaMinimaLeft=suma;
          left=i;   //Actualizamos subsegmento (left-mid) de suma minima parte izquierda
        }
      }
      int sumaMinimaRight=0; //Suma minima parte derecha
      suma=0;
      //Obtenemos suma minima parte derecha
      for (int j=mid+1; j<=fin; j++){
        suma=suma+a[j];
        if (suma<sumaMinimaRight){
          sumaMinimaRight=suma;
          right=j;
        }
      }

      suma=0;
      //Sumo los valores que quedan al medio
      for (int w=left; w<=right; w++){
        suma=suma+a[w];
      }
      int sumaMinimaCenter=suma; //Suma minima del centro
      
      int min = Math.min(Math.min(sumaMinimaRight,sumaMinimaLeft), sumaMinimaCenter);
      return min;
  }

  public static void main(String[] args){
    int[] arreglo = {-20,1,2,3,-80};
    
    System.out.println();
    System.out.print("Lista: ");
    for (int i=0; i<arreglo.length; i++)
      System.out.print("|"+arreglo[i]);
    System.out.println("|");
    System.out.println();
    
    int sumamin = sumaminima(arreglo,0,5);
    System.out.println("Suma Minima = "+sumamin);
  }
}