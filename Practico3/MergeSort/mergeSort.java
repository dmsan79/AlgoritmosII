public class mergeSort{
  public static void mergesort(int[] array, int inicio, int fin){
    if (fin > inicio){
      int mid = (inicio+fin)/2;
      mergesort(array,inicio,mid);
      mergesort(array,mid+1,fin);
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
    int[] a = {2,1,0,5,4,3};
    mergesort(a,0,a.length-1);
    for (int i=0; i<a.length; i++){
      System.out.print(a[i]);   
    }
    System.out.println();
  }
}