/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huff;

import java.util.PriorityQueue;

/**
 *
 * @author cesar
 */
public class Principal 
{
     public static Arbol ConsArbol(int[] charFreqs) {
//crea una fila de prioridad en orden de frecuencia   	
        PriorityQueue<Arbol> arbls = new PriorityQueue<Arbol>();
 //crea las filas para cada letra       
        for (int i = 0; i < charFreqs.length; i++){
            if (charFreqs[i] > 0)
//inserta los elementos
        arbls.offer(new hoja(charFreqs[i], (char)i)); 
            
        }
//recorre los elementos de la fila       
        while (arbls.size() > 1) {
    //poll=retorna o aproxima en la fila       
            Arbol a = arbls.poll(); 
            Arbol b = arbls.poll(); 
//en forma binaria
            arbls.offer(new Nodo(a, b)); 
        }
        
    return arbls.poll();
    
    } 
//parametros de entrada y salida
     //enode es el texto original
    public static String code(Arbol tree, String encode){
    	assert tree != null;
    	
    	String codText = "";
        for (char c : encode.toCharArray()){
        	codText+=(getCodes(tree, new StringBuffer(),c));
        }
    	return codText; 
    }
//decodifica a string
    public static String descod(Arbol tree, String encode) {
    	assert tree != null;
    	
    	String descodText="";
    	Nodo node = (Nodo)tree;
    	for (char code : encode.toCharArray()){
// cuando el ciclo for igual a 0 del lado izquierdo   		
            if (code == '0'){ 
    		    if (node.izq instanceof hoja) { 
                        //retorna el valor de la fila
    		    	descodText += ((hoja)node.izq).value;  
                        //retorna para la raiz
	                node = (Nodo)tree;
	    		}else{
                                //continua rrecorriendo para el lado izquierdo
	    			node = (Nodo) node.izq;  
	    		}
    		}
                else 
// cuando el ciclo for igual a 0 del lado derecho            
             if (code == '1'){ 
    		    if (node.der instanceof hoja) {
                        //retorna el valor de la fila
    		    	descodText += ((hoja)node.der).value; 
                        //retorna para la raiz
	                node = (Nodo)tree; 
	    		}else{
                                //continua rrecorriendo para el lado izquierdo
	    			node = (Nodo) node.der; 
	    		}
    		}
    	} 
        //Retorna el texto decodificado
    	return descodText; 
    }    
//METODO PARA RECORRER Y MOSTRAR LA TABLA
    //prefix - texto codificado com 0 o en 1
    public static void printCodes(Arbol tree, StringBuffer prefijo) {
        assert tree != null;
        
        if (tree instanceof hoja) {
            hoja leaf = (hoja)tree;
            //Imprime la lista
            System.out.println(leaf.value + "\t" + leaf.frequency + "\t\t" + prefijo);
 
        } else if (tree instanceof Nodo) {
            Nodo node = (Nodo)tree;
 
            
            
            prefijo.append('0');
            printCodes(node.izq, prefijo);
            prefijo.deleteCharAt(prefijo.length()-1);
 
            prefijo.append('1');
            printCodes(node.der, prefijo);
            prefijo.deleteCharAt(prefijo.length()-1);
        }
    }
    
 //metodo para retornar el codigo compactado el una letra w
    public static String getCodes(Arbol tree, StringBuffer prefix, char w) {
        assert tree != null;
        
        if (tree instanceof hoja) {
            hoja leaf = (hoja)tree;
            //retorna el texto compactado 
            if (leaf.value == w ){
            	return prefix.toString();
            }
            
            } 
           else 
            
            if (tree instanceof Nodo) {
            Nodo node = (Nodo)tree;
 
            //recorre a izquierda
            prefix.append('0');
            String left = getCodes(node.izq, prefix, w);
            prefix.deleteCharAt(prefix.length()-1);
 
            //recorre a derecha
            prefix.append('1');
            String right = getCodes(node.der, prefix,w);
            prefix.deleteCharAt(prefix.length()-1);
            
            if (left==null) return right; else return left;
        }
		return null;
    }
}
