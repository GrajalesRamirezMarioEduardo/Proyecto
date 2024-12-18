import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {
        List<Usuario> usuarios = Lector.cargarUsuarios("usuarios.csv");

        ArbolAVL<UsuarioPila> arbolUsuarios = new ArbolAVL<>(new ComparadorPorUsuario());
        Grafo grafoUsuarios = new Grafo();

        for (Usuario usuario : usuarios) {
            UsuarioPila usuarioPila = new UsuarioPila(usuario);
            arbolUsuarios.insertar(usuarioPila);
            grafoUsuarios.agregarNodo(usuarioPila);
        }

        Scanner leer = new Scanner(System.in);
        int opcion = 0;

        while (true) {
            System.out.println("1. Salir");
            System.out.println("2. Ver usuarios");
            System.out.println("3. Agregar comentario a un usuario");
            System.out.println("4. Ver comentarios de un usuario");
            System.out.println("5. Hacer amigos");
            System.out.println("6. Ver amigos de un usuario");
            System.out.println("7. agregar usuario");
            System.out.println("8. ver usuario");
            
            opcion = leer.nextInt();

            if (opcion == 1) {
                break;
            } else if (opcion == 2) {
                System.out.println("Usuarios:");
                arbolUsuarios.inOrden();
            } else if (opcion == 3) {
                System.out.print("Ingresa el nombre de usuario: ");
                leer.nextLine();
                String nombreUsuario = leer.nextLine();
                System.out.print("Ingresa la contraseña: ");
                int contrasena = leer.nextInt();

                UsuarioPila usuario = buscarUsuarioPorNombre(nombreUsuario, arbolUsuarios);

                if (usuario != null && usuario.getUsuario().getContraseña() == contrasena) {
                    System.out.print("Ingresa el comentario: ");
                    leer.nextLine();
                    String comentario = leer.nextLine();
                    usuario.agregarComentario(comentario);
                    System.out.println("Comentario agregado.");
                } else {
                    System.out.println("Usuario o contraseña incorrectos.");
                }
            } else if (opcion == 4) {
                System.out.print("Ingresa el nombre de usuario para ver sus comentarios: ");
                leer.nextLine();
                String nombreUsuario = leer.nextLine();
                UsuarioPila usuario = buscarUsuarioPorNombre(nombreUsuario, arbolUsuarios);

                if (usuario != null) {
                    System.out.println("Comentarios de " + usuario.getUsuario().getUsuario() + ":");
                    usuario.mostrarComentarios();
                } else {
                    System.out.println("Usuario no encontrado.");
                }
            } else if (opcion == 5) {
                System.out.print("Ingresa el nombre de usuario que quiere hacer un amigo: ");
                leer.nextLine(); 
                String usuario1 = leer.nextLine();
                System.out.print("Ingresa el nombre del usuario amigo: ");
                String usuario2 = leer.nextLine();

                UsuarioPila u1 = buscarUsuarioPorNombre(usuario1, arbolUsuarios);
                UsuarioPila u2 = buscarUsuarioPorNombre(usuario2, arbolUsuarios);

                if (u1 != null && u2 != null) {
                    grafoUsuarios.agregarArista(u1, u2);
                    grafoUsuarios.agregarArista(u2, u1);
                    System.out.println(usuario1 + " y " + usuario2 + " ahora son amigos.");
                } else {
                    System.out.println("Uno o ambos usuarios no existen.");
                }
            } else if (opcion == 6) {
                System.out.print("Ingresa el nombre de usuario para ver sus amigos: ");
                leer.nextLine();
                String nombreUsuario = leer.nextLine();
                UsuarioPila usuario = buscarUsuarioPorNombre(nombreUsuario, arbolUsuarios);

                if (usuario != null) {
                    System.out.println("Amigos de " + usuario.getUsuario().getUsuario() + ":");
                    Lista amigos = grafoUsuarios.getListaAdyacente(usuario);
                    System.out.println(amigos);
                } else {
                    System.out.println("Usuario no encontrado.");
                }
            }else if(opcion == 7){
                leer.nextLine();
                System.out.print("Nombre: ");
                String nombre = leer.nextLine();
                System.out.print("Apellido: ");
                String apellido = leer.nextLine();
                System.out.print("Fecha de nacimiento (dd/mm/aaaa): ");
                String fechaNacimiento = leer.nextLine();
                System.out.print("Género (M/F): ");
                char genero = leer.next().charAt(0);
                leer.nextLine();
                System.out.print("Usuario: ");
                String usuario = leer.nextLine();
                System.out.print("Contraseña: ");
                int contrasena = leer.nextInt();

                Usuario nuevoUsuario = new Usuario(nombre, apellido, fechaNacimiento, genero, usuario, contrasena);
                UsuarioPila usuarioPila = new UsuarioPila(nuevoUsuario);

                arbolUsuarios.insertar(usuarioPila);
                grafoUsuarios.agregarNodo(usuarioPila);
                System.out.println("Usuario agregado.");
            }else if(opcion == 8){
                leer.nextLine();
                System.out.print("Ingresa el nombre del usuario a buscar: ");
                String nombreBuscar = leer.nextLine();

                UsuarioPila usuarioEncontrado = (UsuarioPila) arbolUsuarios.buscarPorNombre(nombreBuscar);

                if (usuarioEncontrado != null) {
                    System.out.println("Usuario encontrado: " + usuarioEncontrado.getUsuario());
                } else {
                    System.out.println("Usuario no encontrado.");
                }
            } else if (opcion == 4) {
                System.out.println("Usuarios en orden:");
                arbolUsuarios.inOrden();
            } else {
                System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }

        leer.close();
    }

    private static UsuarioPila buscarUsuarioPorNombre(String nombreUsuario, ArbolAVL<UsuarioPila> arbol) {
        return arbol.buscar(new UsuarioPila(new Usuario("", "", "", 'M', nombreUsuario, 0)));
    }
}
