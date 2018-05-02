/**
 * Clase Capicua5D.
 * <p>
 * Representa un numero capicua de 5 digitos.
 * <p>
 * Cualquier numero de menos de 5 digitos (por ejemplo 88) puede verse como uno de 5 digitos donde los faltantes son 0 (por ejemplo 00088).
 * Pero en estos casos se deben tener en cuenta los 0's al determinar si es capicua (00088 no lo es, aunque 88 si lo es).
*/
public class Capicua5D {

    private String capicua; 
    public Capicua5D (String capic){
        this.capicua=capic;
    }
    
    /**
     * Obtiene el siguiente capicua de 5 digitos sin cambiar esta instancia. 
     * @return el siguiente capicua de 5 digitos o {@code null} si no existe otro.
    */
    public Capicua5D siguiente() {
        
        String actualS = this.capicua;
        int actualI = Integer.parseInt(actualS);
        for (int i=actualI+1; i<100000; i++){
            if (validar(i))
                return new Capicua5D(String.format("%05d",i));
                
        }
        return null;
    }
    
    /**
     * Retorna la diferencia entera entre este capicua y otro.
     * <p>
     * @param otro  :   otro capicua con el cual obtener la diferencia  :   {@code Capicua5D}
     * @return {@code |valorEntero() - otro.valorEntero()|}
     * @throws IllegalArgumentException : si {@code otro} es {@code null} o no es un numero capicua 
    */
    public int diferencia(Capicua5D otro) throws IllegalArgumentException {
        if (otro==null|| validar(otro.valorEntero())==false)
            throw new IllegalArgumentException("Argumento no valido");
        else
            return this.valorEntero() - otro.valorEntero();
    }
    
    /**
     * @return el valor entero que representa este numero capicua   :   {@code int} 
    */
    public int valorEntero() {
        return Integer.parseInt(this.capicua); //Solo lo convierto a entero
    }
    
    /**
     * @return un capicua cuyo valor entero sea 0   :   {@code Capicua5D} 
    */
    public static Capicua5D zero() {
        return new Capicua5D("0");
    }
    
    /**
     * @param num   :   el numero entero a validar  :   {@code int}
     * @return {@code true} sii {@code num} tine hasta 5 digitos (se completan con 0 no significativos) y es capicua.
    */
    public static boolean validar(int num) {
        
        String capicua = String.valueOf(num); //Convierto el int a string
        
        if(capicua.length()>5) //Tiene mas de 5 digitos
            return false;      //No nos interesa
        else if (capicua.length()<5){  //Tiene menos de 5 digitos
            
            capicua=String.format("%05d",num); //Le ponemos los 0 correspondientes

            //Luego verificamos si es capicua
            if (capicua.charAt(0)==capicua.charAt(4) && capicua.charAt(1)==capicua.charAt(3)) 
                return true;
            else
                return false;
                
            }else{ //Tiene 5 digitos
                if (capicua.charAt(0)==capicua.charAt(4) && capicua.charAt(1)==capicua.charAt(3))
                    return true;
                else
                    return false;
            }
    }
    
    /**
     * @return una instancia de Capicua5D, solo si {@code num} es un numero de 5 digitos capicua.
    */
    public static Capicua5D aPartirDe(int num) {
        if (validar(num))
            return new Capicua5D(String.format("%05d",num));
        else
            return null; //O supongo que el int del parametro ya es capicua? si no que retorno?    
    }
    
    @Override
    public String toString() {
        return String.format("%05d", valorEntero());
    }
}