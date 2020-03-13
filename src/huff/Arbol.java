package huff;

abstract class Arbol implements Comparable<Arbol> {
    public final int frequency;
    //
    public Arbol(int freq) { 
    	frequency = freq; 
    }
    

    @Override
    public int compareTo(Arbol tree) {
        return frequency - tree.frequency;
    }
}