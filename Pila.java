import java.util.ArrayList;

public class Pila {
    private ArrayList<Object> arreglo;

    public Pila() {
        this.arreglo = new ArrayList<>();
    }

    public boolean estaVacia() {
        return this.arreglo.isEmpty();
    }

    public void push(Object valor) {
        this.arreglo.add(valor);
    }

    public Object pop() throws Exception {
        if (estaVacia()) {
            throw new Exception("Pila vacía");
        }
        return this.arreglo.remove(this.arreglo.size() - 1);
    }

    public Object verTope() throws Exception {
        if (estaVacia()) {
            throw new Exception("Pila vacía");
        }
        return this.arreglo.get(this.arreglo.size() - 1);
    }

    public int tamano() {
        return this.arreglo.size();
    }
}
