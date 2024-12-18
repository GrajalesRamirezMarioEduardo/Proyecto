public class Grafo {
    private NodoGrafo primero;
    private NodoGrafo ultimo;

    public Grafo() {
        this.primero = null;
        this.ultimo = null;
    }

    public boolean estaVacio() {
        return this.primero == null && this.ultimo == null;
    }

    public boolean existeVertice(Object dato) {
        if (estaVacio()) return false;
        NodoGrafo actual = primero;
        while (actual != null) {
            if (actual.getDato().toString().equals(dato.toString()))
                return true;
            actual = actual.getSiguiente();
        }
        return false;
    }

    public boolean agregarArista(Object origen, Object destino) {
        if (!existeVertice(origen) || !existeVertice(destino)) {
            System.out.println("No se puede agregar la arista, uno de los usuarios no existe.");
            return false;
        }

        NodoGrafo actual = primero;
        while (!actual.getDato().toString().equals(origen.toString())) {
            actual = actual.getSiguiente();
        }
        actual.getListaAdyacencia().agregarAdyacencia(destino);
        return true;
    }

    public boolean agregarNodo(Object dato) {
        if (existeVertice(dato))
            return false;
        NodoGrafo nodo = new NodoGrafo(dato);
        if (estaVacio()) {
            this.primero = nodo;
            this.ultimo = nodo;
            return true;
        }
        this.ultimo.setSiguiente(nodo);
        this.ultimo = nodo;
        return true;
    }

    public Lista getListaAdyacente(Object dato) {
        NodoGrafo actual = primero;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return actual.getListaAdyacencia();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public String toString() {
        String cadena = "";
        NodoGrafo actual = primero;
        while (actual != null) {
            cadena += actual.getDato().toString() + "->" + actual.getListaAdyacencia().toString() + "\n";
            actual = actual.getSiguiente();
        }
        return cadena;
    }
}
