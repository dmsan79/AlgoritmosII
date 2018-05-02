import java.lang.*;
public class SubsecuenciaComun{
		
		public static String subComun(String first, String second, int i, int j){
			if (i==first.length() || j==second.length()) {
				return "";
			}else{
				if (first.charAt(i)==second.charAt(j))
					//Concatenamos elem y llamamos recursivamente si él en ambos String
					return first.charAt(i) + subComun(first,second,i+1,j+1);
				else{
					String a = subComun(first,second,i,j+1); //Sacamos elemento de Second
					String b = subComun(first,second,i+1,j); //Sacammos elemento de First
					//Nos quedamos con la subsecuencia comun mayor y la retornamos
					if (a.length()>b.length())
						return a;
					else 
						return b;
				}
			}
		}//subComun

		public static void main(String[] args) {
			String primero ="martin";
			String segundo ="daniotti";
			int i = 0;
			int j = 0;
			System.out.println("- "+ primero + " - "+segundo);
			System.out.println("SubsecuenciaComun: " + subComun(primero,segundo,i,j));
	    }
	
}