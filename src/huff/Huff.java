
package huff;

public class Huff {

    public static void main(String[] args) 
    {
        Principal p=new Principal();
//insertamos la palabra        
    String palabra = "hhuffzzaaal";  
        
//metodo para considerar, no tener mas de 256 caracteres diferentes      
        int[] cf = new int[256];
        
        for (char c : palabra.toCharArray())
            cf[c]++;
       
        Arbol Arbol = p.ConsArbol(cf);
        
 //manda los resultados de los caracteres, el num de veces q se repite la palabra y el codigo     
        System.out.println("----------HUFFMAN----------");
         
        String cod = p.code(Arbol,palabra);
  
 //muestra la palabra       
        System.out.println("PALABRA");
        System.out.println(p.descod(Arbol,cod));
        

//muestra la tabla        
        System.out.println("S�MBOLO\tQUANTIDADE\tHUFFMANDIGO");
        p.printCodes(Arbol, new StringBuffer());
        
        
//manda el codigo      
        System.out.println("CODIGO");
        System.out.println(cod);     
    }
}
