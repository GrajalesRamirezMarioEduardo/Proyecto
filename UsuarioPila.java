public class UsuarioPila {
    private Usuario usuario;
    private Lista comentarios;
    

    public UsuarioPila(Usuario usuario) {
        this.usuario = usuario;
        this.comentarios = new Lista();
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public Lista getComentarios() {
        return this.comentarios;
    }

    public void agregarComentario(String comentario) {
        this.comentarios.agregarAdyacencia(comentario);
    }

    public void mostrarComentarios() {
        System.out.println("Comentarios de " + usuario.getUsuario() + ":");
        System.out.println(this.comentarios);
    }

    @Override
    public String toString() {
        return usuario.getUsuario();
    }
}
