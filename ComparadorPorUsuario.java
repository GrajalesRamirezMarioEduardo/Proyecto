import java.util.Comparator;

public class ComparadorPorUsuario implements Comparator<UsuarioPila> {
    @Override
    public int compare(UsuarioPila o1, UsuarioPila o2) {
        return o1.getUsuario().getUsuario().compareTo(o2.getUsuario().getUsuario());
    }
}
