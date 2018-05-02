public class ProductoEnteros{
	//Multiplicacion recursiva NO a la cola (cte =1)
	public static int multiplicaCte(int n, int m){
		if (m==0)
		    return 0;
		return (n + multiplicaCte(n,m-1));	
	}
	//Multiplicacion recursiva a la cola (cte =1)
	public static int multiplicaCteAux(int n, int m, int resultado){
		if (m==0)
			return resultado;
		resultado = resultado + n;
		return multiplicaCteAux(n,m-1,resultado);

	}
	//Multiplicacion recursiva (Factor cte = mitad)
	public static int multiplicaFactorCte(int n, int m){
		if(n==1)
			return m;
		else{
			if (n % 2 ==0)
				return multiplicaFactorCte(n/2,m*2);
			else
				return multiplicaFactorCte(n/2,m*2)+m;
		}
	}

	public static void main(String[] args) {
		 
		int n = 5;
		int m = 5;
		
		int producto = multiplicaCte(n,m);
		System.out.println(n+" x "+m+" = "+producto);
		
		int res = 0;
		int resultado = multiplicaCteAux(n,m,res);
		System.out.println(n+" x "+m+" = "+resultado);	

		resultado = multiplicaFactorCte(n,m);
		System.out.println(n+" x "+m+" = "+resultado);	

	}
}