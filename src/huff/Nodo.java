package huff;


class Nodo extends Arbol {
    public final Arbol izq, der;
 
    public Nodo(Arbol l, Arbol r) {
        super(l.frequency + r.frequency);
        izq = l;
        der = r;
    }
}