import java.util.HashMap;
import java.util.ArrayList;

public class Fibonacci{
	//Tupla que contiene (n,fib(n))
	private static HashMap<Integer,Integer> results = new HashMap<Integer,Integer>();
	//Lista que contiene (fib(n-1),fib(n))
	private static ArrayList<Integer> memo = new ArrayList<Integer>(2); 
	
	//Metodo Recursivo que calcula fib(n)
	public static int fibAux(int n){
		if (n<0) throw new IllegalArgumentException("undefined for negative numbers");
		else{
 			//Si no esta lo agrego al hashmap
 			if (!results.containsKey(n))
 				if (n<=1) 
 					results.put(n, 1);
 				else
 					results.put(n, fib2(n-1)+fib2(n-2));
 		}
 		//Si esta en el hasmap lo retorno
 		return results.get(n);
 	}
 	
 	//Fibonaccio sin recurision
	public static int fib(int n){
		int res=0;
		for (int i=0; i<=n; i++){
			if(i<=1)
				memo.add(i,1);
			else{
				res=memo.get(0)+memo.get(1);
				memo.set(0,memo.get(1));
				memo.set(1,res);
			}
		}
		return memo.get(1);
	}

 	//Metodo Main
	public static void main(String[] args){	
		int n = 6;
		int resu = fib2(n);
		System.out.println("fib("+n+") = "+resu);
	}
}