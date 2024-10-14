import javax.swing.*;
public class ColaPrioridad {
 public   Nodo frente;

    public ColaPrioridad() {
        frente=null;
    }

    // Método para encolar (agregar de acuerdo a prioridad) un valor entero
    public void encolar(int dato, int prioridad, JTextArea textArea) {
        Nodo nuevoNodo = new Nodo(dato, prioridad);
        if (estaVacia() || prioridad < frente.prioridad) {
            // Insertar al frente si la cola está vacía o si tiene mayor prioridad
            nuevoNodo.siguiente = frente;
            frente = nuevoNodo;
        } else {
            // Buscar el lugar correcto para insertar según la prioridad
            Nodo actual = frente;
            while (actual.siguiente != null && actual.siguiente.prioridad <= prioridad) {
                actual = actual.siguiente;
            }
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
        }
        actualizarTextArea(textArea);
    }

    // Método para desencolar (eliminar del frente) el valor con mayor prioridad
    public int desencolar(JTextArea textArea) {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La cola está vacía.");
            return -1;
        }
        int dato = frente.dato;
        frente = frente.siguiente;
        actualizarTextArea(textArea);
        return dato;
    }

    // Método para verificar si la cola está vacía
    public boolean estaVacia() {
        return frente == null;
    }

    // Método para mostrar la cola en el JTextArea
    public void mostrarCola(JTextArea textArea) {
        if (estaVacia()) {
            textArea.setText("La cola está vacía.");
        } else {
            StringBuilder colaStr = new StringBuilder();
            Nodo actual = frente;
            while (actual != null) {
                colaStr.append("Valor: ").append(actual.dato)
                        .append(", Prioridad: ").append(actual.prioridad).append("\n");
                actual = actual.siguiente;
            }
            textArea.setText(colaStr.toString());
        }
    }

    // Método para actualizar el JTextArea cada vez que cambia la cola
    private void actualizarTextArea(JTextArea textArea) {
        mostrarCola(textArea);
    }
}
