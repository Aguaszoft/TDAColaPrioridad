public class Nodo {
    public int dato;
    public int prioridad;
    public Nodo siguiente;

    public Nodo(int dato, int prioridad) {
        this.dato = dato;
        this.prioridad = prioridad;
        this.siguiente = null;
    }
}