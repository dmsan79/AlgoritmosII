public class inversion{
  private static int cant; //Creamos variable global para almacenar cantidad de inversiones
  public static void inversiones(int[] array, int inicio, int fin){
    
    if (fin > inicio){
      int mid = (inicio+fin)/2;
      inversiones(array,inicio,mid);
      inversiones(array,mid+1,fin);
      merge(array,inicio,mid,fin);
    }
  }
  public static void merge(int a[],int inicio, int m, int fin){
      int [] b = new int[a.length];
      for (int w=inicio; w<=fin; w++){
          b[w]=a[w];
      }
      int i, j, k;
      i=inicio; k=inicio; j=m+1; 
      //copia el siguiente elemento más grande
      while (i<=m && j<=fin){ 
          if (b[i]<=b[j]){
              a[k]=b[i];
              i++;
          }else{
              //unico cambio con respecto al mergesort
              for (int u=1;u<=m+1-i;u++) {
                cant++;
              }
              //--------------------------------------
              a[k]=b[j];
              j++;
            }
          k++;
      }
      //copia los elementos restantes de la primera mitad (si los hay)
      while (i<=m){
          a[k]=b[i];
          k++;
          i++;
      } 
  }
  public static void main(String[] args){
    cant=0; //Inicilizamos varible global
    int[] a = {5,2,1,0,8};
    System.out.print("Original: ");
    for (int i=0; i<a.length; i++){
      System.out.print(a[i]);   
    }
    System.out.println();
    inversiones(a,0,a.length-1);
    System.out.print("Ordenado: ");
    for (int i=0; i<a.length; i++){
      System.out.print(a[i]);   
    }
    System.out.println();
    System.out.println("Inversiones: "+cant);
  }
}