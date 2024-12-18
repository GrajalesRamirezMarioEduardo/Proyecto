public class NodoAVL<T> {
    private NodoAVL<T> izq;
    private NodoAVL<T> der;
    private T valor;
    private int altura;

    public NodoAVL(T valor) {
        this.valor = valor;
        this.izq = null;
        this.der = null;
        this.altura = 1;
    }

    public void setIzq(NodoAVL<T> izq) {
        this.izq = izq;
    }

    public void setDer(NodoAVL<T> der) {
        this.der = der;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public NodoAVL<T> getIzq() {
        return this.izq;
    }

    public NodoAVL<T> getDer() {
        return this.der;
    }

    public T getValor() {
        return this.valor;
    }

    public int getAltura() {
        return this.altura;
    }
}
