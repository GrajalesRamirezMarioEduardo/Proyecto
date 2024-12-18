public class Usuario {
    private String nombre;
    private String apellido;
    private String fecha;
    private char sexo;
    private String usuario;
    private int contraseña;
    private Pila comentarios;  
    
    public Usuario(String nombre, String apellido, String fecha, char sexo, String usuario, int contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.sexo = sexo;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.comentarios = new Pila();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getContraseña() {
        return contraseña;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    public void agregarComentario(String texto) {
        Comentario comentario = new Comentario(texto);
        comentarios.push(comentario);
    }

    public Pila getComentarios() {
        return comentarios;
    }

    @Override
    public String toString() {
        return "Usuario [" + nombre + " " + apellido + " " + fecha + " " + sexo
                + " " + usuario + " " + contraseña + "]";
    }
}
