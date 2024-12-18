import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class ArbolAVL<T> {
    private NodoAVL<T> raiz;
    private Comparator<T> comparador;

    public ArbolAVL(Comparator<T> comparador) {
        this.raiz = null;
        this.comparador = comparador;
    }

    public void insertar(T valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private NodoAVL<T> insertarRecursivo(NodoAVL<T> nodo, T valor) {
        if (nodo == null) {
            return new NodoAVL<>(valor);
        }

        if (comparador.compare(valor, nodo.getValor()) < 0) {
            nodo.setIzq(insertarRecursivo(nodo.getIzq(), valor));
        } else if (comparador.compare(valor, nodo.getValor()) > 0) {
            nodo.setDer(insertarRecursivo(nodo.getDer(), valor));
        } else {
            return nodo;
        }

        actualizarAltura(nodo);

        return balancear(nodo);
    }

    public void enOrden() {
        enOrdenRecursivo(raiz);
    }

    private void enOrdenRecursivo(NodoAVL<T> nodo) {
        if (nodo != null) {
            enOrdenRecursivo(nodo.getIzq());
            System.out.println(nodo.getValor());
            enOrdenRecursivo(nodo.getDer());
        }
    }

    private NodoAVL<T> balancear(NodoAVL<T> nodo) {
        int balance = obtenerBalance(nodo);

        if (balance > 1) {
            if (obtenerBalance(nodo.getIzq()) < 0) {
                nodo.setIzq(rotarIzquierda(nodo.getIzq()));
            }
            return rotarDerecha(nodo);
        }

        if (balance < -1) {
            if (obtenerBalance(nodo.getDer()) > 0) {
                nodo.setDer(rotarDerecha(nodo.getDer()));
            }
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    private NodoAVL<T> rotarDerecha(NodoAVL<T> nodo) {
        NodoAVL<T> nuevaRaiz = nodo.getIzq();
        nodo.setIzq(nuevaRaiz.getDer());
        nuevaRaiz.setDer(nodo);

        actualizarAltura(nodo);
        actualizarAltura(nuevaRaiz);

        return nuevaRaiz;
    }

    private NodoAVL<T> rotarIzquierda(NodoAVL<T> nodo) {
        NodoAVL<T> nuevaRaiz = nodo.getDer();
        nodo.setDer(nuevaRaiz.getIzq());
        nuevaRaiz.setIzq(nodo);

        actualizarAltura(nodo);
        actualizarAltura(nuevaRaiz);

        return nuevaRaiz;
    }

    private int obtenerAltura(NodoAVL<T> nodo) {
        return nodo == null ? 0 : nodo.getAltura();
    }

    private void actualizarAltura(NodoAVL<T> nodo) {
        nodo.setAltura(1 + Math.max(obtenerAltura(nodo.getIzq()), obtenerAltura(nodo.getDer())));
    }

    private int obtenerBalance(NodoAVL<T> nodo) {
        return nodo == null ? 0 : obtenerAltura(nodo.getIzq()) - obtenerAltura(nodo.getDer());
    }

    public T buscar(T valor) {
        NodoAVL<T> encontrado = buscarRecursivo(raiz, valor);
        return encontrado == null ? null : encontrado.getValor();
    }

    private NodoAVL<T> buscarRecursivo(NodoAVL<T> nodo, T valor) {
        if (nodo == null || comparador.compare(valor, nodo.getValor()) == 0) {
            return nodo;
        }

        if (comparador.compare(valor, nodo.getValor()) < 0) {
            return buscarRecursivo(nodo.getIzq(), valor);
        } else {
            return buscarRecursivo(nodo.getDer(), valor);
        }
    }
    
    public void inOrden() {
        inOrdenAux(raiz);
    }

    private void inOrdenAux(NodoAVL<T> nodo) {
        if (nodo != null) {
            inOrdenAux(nodo.getIzq());
            System.out.println(nodo.getValor());
            inOrdenAux(nodo.getDer());
        }
    }
    
    public T buscarPorNombre(String nombreUsuario) {
        return buscarPorNombreRecursivo(raiz, nombreUsuario);
    }

    private T buscarPorNombreRecursivo(NodoAVL<T> nodo, String nombreUsuario) {
        if (nodo == null) {
            return null;
        }

        UsuarioPila usuarioActual = (UsuarioPila) nodo.getValor();
        String nombreActual = usuarioActual.getUsuario().getUsuario();

        if (nombreUsuario.equals(nombreActual)) {
            return nodo.getValor(); // Usuario encontrado
        } else if (nombreUsuario.compareTo(nombreActual) < 0) {
            return buscarPorNombreRecursivo(nodo.getIzq(), nombreUsuario);
        } else {
            return buscarPorNombreRecursivo(nodo.getDer(), nombreUsuario);
        }
    }
}
