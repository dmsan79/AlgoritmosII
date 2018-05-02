public class Combinatoria{
	//Solucion clasica (Muy ineficiente)
	public static int combinatoriaClasica(int n, int k){
		if (k==0)
			return 1;
		else if (n==0)
				return 0;
			else
				return combinatoriaClasica(n-1,k-1) + combinatoriaClasica(n-1,k);
	}
	//Solucion utilizando memoria dinamica
	public static int combinatoriaMD(int n, int k){
		int [][] comb = new int [(n-k+1)][k+1];
		for (int i=0; i<=(n-k); i++){
			for (int j=0; j<=k; j++){
				if(i==0||j==0)
					comb[i][j]=1;
				else
					comb[i][j]=comb[i-1][j] + comb[i][j-1];
			}
		}
		return comb[n-k][k];
	}
	//Solucion con Memorizations
	public static int CombinatoriaM(int n, int k){
		return 0;
	}

	public static void main(String[] args) {
		int n=4;
		int k=3;
		System.out.println("Combinatoria ("+n+","+k+"): "+combinatoriaClasica(n,k));
		System.out.println("CombinatoriaMD ("+n+","+k+"): "+combinatoriaMD(n,k));
	}
}