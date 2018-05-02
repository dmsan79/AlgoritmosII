import java.util.ArrayList;
import java.util.List;
/*ENCARAMOS ESTE PROBLEMA DANDO POR CIERTO QUE M=1 YA QUE NO PUEDE TOMAR OTRO VALOR EN LA SUMA
  PARA REDUCIR UN POCO EL NUMERO DE COMBINACIONES, SI NO LOS PROCESOS SON MUY COSTOSOS*/

public class Money{
	//Ninguna letra puede valer 1 ya que "m" ya tiene asignado este valor
	public static List<String> send(){
		//Lista de listas de combinaciones de numeros para send
		List<String> combinacionSend = new ArrayList<String>();
		//For anidados que generan todas las combinaciones de valores para send
		for (int s=2; s<10; s++){ 
			for (int e=2; e<10; e++){
				for (int n=2; n<10; n++){
					for (int d=2; d<10; d++){
						if (s!=e && s!=n && s!=d && e!=n && e!=d && n!=d) {
							//String con la combinacion
							String aux = Integer.toString(s)+Integer.toString(e)+Integer.toString(n)+Integer.toString(d);
							//Añadimos el string de todas la combinaciones
							combinacionSend.add(aux); 
						}
					}//w	
				}//k
			}//j
		}//i
		return combinacionSend;
	}
	//m si o si debe valer 1
	public static List<String> more(){
		//Lista de combinaciones de numeros para send
		List<String> combinacionMore = new ArrayList<String>();
		//For anidados que generan todas las combinaciones de valores para send
		for (int m=1; m<2; m++){ //m tiene que se 1 si o si
			for (int o=0; o<10; o++){
				for (int r=0; r<10; r++){
					for (int e=0; e<10; e++){
						if (m!=o && m!=r && m!=e && o!=r && o!=e && r!=e) {
							//String con la combinacion
							String aux = Integer.toString(m)+Integer.toString(o)+Integer.toString(r)+Integer.toString(e);
							//Añadimos el string de todas la combinaciones
							combinacionMore.add(aux); 
						}
					}//w	
				}//k
			}//j
		}//i
		return combinacionMore;
	}
	//m si o si debe valer 1
	public static List<String> money(){
		//Lista de combinaciones de numeros para send
		List<String> combinacionMoney = new ArrayList<String>();
		//For anidados que generan todas las combinaciones de valores para send
		for (int m=1; m<2; m++){ //m tiene que se 1 si o si
			for (int o=0; o<10; o++){
				for (int n=0; n<10; n++){
					for (int e=0; e<10; e++){
						for (int y=0; y<10; y++){
							if (m!=o && m!=n && m!=e && m!=y && o!=n && o!=e && o!=y && n!=e && n!=y && e!=y){
								//String con la combinacion
								String aux = Integer.toString(m)+Integer.toString(o)+Integer.toString(n)+Integer.toString(e)+Integer.toString(y);
								//Añadimos el string de todas la combinaciones
								combinacionMoney.add(aux); 
							}
						}
					}//w	
				}//k
			}//j
		}//i
		return combinacionMoney;
	}

	public static List<Pair<String,String>> sumasValidas(){
		List<String> send = send();
		List<String> more = more();
		//Lista con los pares (send,more) que pueden ser solucion del problema (son 6468)
		List<Pair<String,String>> res = new ArrayList<Pair<String,String>>();

		for (int i=0; i<send.size(); i++){
			for (int j=0; j<more.size() ; j++){

				String s = send.get(i);
				String m = more.get(j);
				//Ya se que ninguna letra tiene el mismo valor que m 
				if (s.charAt(0)!= m.charAt(1) && s.charAt(0)!= m.charAt(2) && s.charAt(0)!= m.charAt(3) &&
					s.charAt(1)!= m.charAt(1) && s.charAt(1)!= m.charAt(2) && s.charAt(1)== m.charAt(3) &&
					s.charAt(2)!= m.charAt(1) && s.charAt(2)!= m.charAt(2) && s.charAt(2)!= m.charAt(3) &&
					s.charAt(3)!= m.charAt(1) && s.charAt(3)!= m.charAt(2) && s.charAt(3)!= m.charAt(3) &&
					Integer.parseInt(s)+Integer.parseInt(m)>9999) {

						Pair<String,String> par = new Pair<String,String>(s,m);
						res.add(par);
				}//if				
			}//j
		}//i
		return res;
	}//sumasValidas

	public static void main(String[] args){
		
		List<String> money = money();

		List<Pair<String,String>> psol = sumasValidas();

		for (int i=0; i<psol.size(); i++){
			Pair<String,String> p = psol.get(i);
			for (int j=0; j<money.size(); j++){
				String s = p.getFirst();
				String m = p.getSecond();
				String M = money.get(j);

				if (m.charAt(1) == M.charAt(1) && s.charAt(2) == M.charAt(2) && s.charAt(1) == M.charAt(3) &&
					M.charAt(4)!= s.charAt(0) && M.charAt(4)!= s.charAt(1) && M.charAt(4)!= s.charAt(2) &&
					M.charAt(4)!= s.charAt(3) && M.charAt(4)!= m.charAt(1) && M.charAt(4)!= m.charAt(2) &&
					Integer.parseInt(s)+Integer.parseInt(m)==Integer.parseInt(M)) {
					
					System.out.println("Resultado: "+s+" + "+m+" = "+M);

				}//if
			}//j
		}//i
	}//main

}//Money