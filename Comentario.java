import java.util.Date;

public class Comentario {
    private String texto;
    private Date fecha;

    public Comentario(String texto) {
        this.texto = texto;
        this.fecha = new Date();
    }

    public String getTexto() {
        return texto;
    }

    public Date getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "[" + fecha + "] " + texto;
    }
}
