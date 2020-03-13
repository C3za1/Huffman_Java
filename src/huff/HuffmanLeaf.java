package huff;

class hoja extends Arbol {
    public final char value; // letra atribuida a una fila
 
    public hoja(int freq, char val) {
        super(freq);
        value = val;
    }

}