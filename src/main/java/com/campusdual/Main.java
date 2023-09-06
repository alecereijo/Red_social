package com.campusdual;

import com.campusdual.util.Input;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Usuario usuarioActual = null;
        Scanner cubrir = new Scanner(System.in);
        RedSocial _redSocial = new RedSocial();



        //Creamos el menu con el que va a interactuar el usuario
        int salir = 1;
        do {
            System.out.println("¿Qué prefieres hacer? \n1 Añadir un nuevo usuario \n2 Añadir un nuevo post \n3 Añadir un nuevo comentario " +
                    "\n4 Dejar de seguir a un usuario \n5 Comenzar a seguir a un usuario \n6 Eliminar a un usuario \n7 Eliminar un post " +
                    "\n8 Eliminar un comentario \n9 Listar todos los post \n10 Listar comentarios \n11 Mostrar el numero de comentarios de un post");
            int menuUsuario = cubrir.nextInt();
            cubrir.nextLine();
            switch (menuUsuario) {
                case 1:
                    System.out.println("Ingresa tu nombre para crear un usuario: ");
                    String nombreUsuario = cubrir.nextLine();
                    //instancio la clase usuario enviando por parametros nombreUsuario
                    Usuario nuevoUsuario = new Usuario(nombreUsuario);
                    _redSocial.agregarUsuario(nuevoUsuario);
                    usuarioActual = nuevoUsuario;
                    System.out.println("¡Usuario creado con éxito!");
                    System.out.println("Usuarios en la lista");
                    for (Usuario usuario : _redSocial.getListaUsuarios()) {
                        System.out.println(usuario.getNombreUsuario());
                    }
                    break;
                case 2:
                    System.out.println("Selecciona el tipo de post:");
                    System.out.println("1. Texto");
                    System.out.println("2. Imagen");
                    System.out.println("3. Video");
                    int tipoPost = cubrir.nextInt();
                    cubrir.nextLine();

                    // Muestro la lista de usuarios numerados para que se pueda seleccionar
                    System.out.println("Selecciona el usuario al que deseas asociar el post:");

                    for (int i = 0; i < _redSocial.getListaUsuarios().size(); i++) {
                        Usuario usuario = _redSocial.getListaUsuarios().get(i);
                        System.out.println((i + 1) + ". " + usuario.getNombreUsuario());
                    }

                    int numeroUsuarioElegido = cubrir.nextInt();

                    //Compruebo que el numero esta dentro de los limites validos
                    if (numeroUsuarioElegido >= 1 && numeroUsuarioElegido <= _redSocial.getListaUsuarios().size()) {

                        Usuario usuarioElegido = _redSocial.getListaUsuarios().get(numeroUsuarioElegido - 1);
                        if (tipoPost == 1) {
                            //System.out.println("Ingresa el texto del post:");
                            String textoPost = Input.string("Ingresa el texto del post:");
                            PostTexto nuevoPostTexto = new PostTexto(textoPost);
                            nuevoPostTexto.setUsuario(usuarioElegido);
                            usuarioElegido.agregarPost(nuevoPostTexto);//Agrego el post al usuario
                            _redSocial.agregarPost(nuevoPostTexto);//Agrego el post a la red social
                            System.out.println("¡Post de texto creado con éxito!");
                        } else if (tipoPost == 2) {
                            System.out.println("Ingresa el título de la imagen:");
                            String tituloImagen = Input.string();

                            System.out.println("Ingresa las dimensiones de la imagen:");
                            String dimensionesImagen = Input.string();
                            PostImagen nuevoPostImagen = new PostImagen(tituloImagen,dimensionesImagen);
                            nuevoPostImagen.setUsuario(usuarioElegido);
                            usuarioElegido.agregarPost(nuevoPostImagen);//Agrego el post al usuario
                            _redSocial.agregarPost(nuevoPostImagen);//Agrego el post a la red social
                            System.out.println("¡Post de imagen creado con éxito!");
                        } else if (tipoPost == 3) {
                            System.out.println("Ingresa el título del video:");
                            String tituloVideo = Input.string();

                            System.out.println("Ingresa la calidad del video:");
                            int calidadVideo = Input.integer();
                            cubrir.nextLine();
                            System.out.println("Ingresa la duración del video:");
                            int duracionVideo = Input.integer();
                            cubrir.nextLine();

                            PostVideo nuevoPostVideo = new PostVideo(tituloVideo, calidadVideo, duracionVideo);
                            nuevoPostVideo.setUsuario(usuarioElegido);
                            usuarioElegido.agregarPost(nuevoPostVideo);//Agrego el post al usuario
                            _redSocial.agregarPost(nuevoPostVideo);//Agrego el post a la red social
                            System.out.println("¡Post de video creado con éxito!");
                        }
                        System.out.println("Listado de post");
                        for (int i = 0; i < _redSocial.getListaPosts().size(); i++) {
                            Post post = _redSocial.getListaPosts().get(i);
                            System.out.println((i + 1) + ".\nFecha: " + post.getFechaCreacion());
                            System.out.println("Propietario: " + post.getUsuario().getNombreUsuario());


                            // Verifico el tipo de post y mostro los detalles específicos de cada uno
                            if (post instanceof PostTexto) {
                                PostTexto postTexto = (PostTexto) post;
                                System.out.println("Tipo de Post: Texto");
                                System.out.println("Contenido de Texto: " + postTexto.getTexto());
                            } else if (post instanceof PostImagen) {
                                PostImagen postImagen = (PostImagen) post;
                                System.out.println("Tipo de Post: Imagen");
                                System.out.println("Título de Imagen: " + postImagen.tituloImagen);
                                System.out.println("Dimensiones de Imagen: " + postImagen.dimensionesImagen);
                            } else if (post instanceof PostVideo) {
                                PostVideo postVideo = (PostVideo) post;
                                System.out.println("Tipo de Post: Video");
                                System.out.println("Título de Video: " + postVideo.getTituloVideo());
                                System.out.println("Calidad de Video: " + postVideo.getCalidadVideo() + "p");
                                System.out.println("Duración de Video: " + postVideo.getDuracionVideo() + " segundos");
                            }

                        }

                    } else {
                        System.out.println("Número de usuario no válido.");
                    }
                        break;
                case 3:
                    System.out.println("Selecciona el post al que deseas agregar un comentario:");
                    //Muestro la lista de post numerados para que se pueda seleccionar
                    System.out.println("Listado de post");
                    for (int i = 0; i < _redSocial.getListaPosts().size(); i++) {
                        Post post = _redSocial.getListaPosts().get(i);
                        System.out.println((i + 1) + ".\nFecha: " + post.getFechaCreacion());
                        System.out.println("Propietario: " + post.getUsuario().getNombreUsuario());


                        // Verifico el tipo de post y mostro los detalles específicos de cada uno
                        if (post instanceof PostTexto) {
                            PostTexto postTexto = (PostTexto) post;
                            System.out.println("Tipo de Post: Texto");
                            System.out.println("Contenido de Texto: " + postTexto.getTexto());
                        } else if (post instanceof PostImagen) {
                            PostImagen postImagen = (PostImagen) post;
                            System.out.println("Tipo de Post: Imagen");
                            System.out.println("Título de Imagen: " + postImagen.tituloImagen);
                            System.out.println("Dimensiones de Imagen: " + postImagen.dimensionesImagen);
                        } else if (post instanceof PostVideo) {
                            PostVideo postVideo = (PostVideo) post;
                            System.out.println("Tipo de Post: Video");
                            System.out.println("Título de Video: " + postVideo.getTituloVideo());
                            System.out.println("Calidad de Video: " + postVideo.getCalidadVideo() + "p");
                            System.out.println("Duración de Video: " + postVideo.getDuracionVideo() + " segundos");
                        }

                    }

                    int numeroPostElegido = Input.integer();

                    //Compruebo que el numero introducido esta dentro de los limites validos
                    if (numeroPostElegido >= 1 && numeroPostElegido <= _redSocial.getListaPosts().size()) {
                        Post postElegido = _redSocial.getListaPosts().get(numeroPostElegido - 1);

                        System.out.println("Selecciona el propietario del comentario:");
                        //Muestro la lista de usuarios numerados
                        for (int i = 0; i < _redSocial.getListaUsuarios().size(); i++) {
                            Usuario usuario = _redSocial.getListaUsuarios().get(i);
                            System.out.println((i + 1) + ". " + usuario.getNombreUsuario());
                        }
                        int numeroUsuarioElegidoComentario = Input.integer();


                        if (numeroUsuarioElegidoComentario >= 1 && numeroUsuarioElegidoComentario <= _redSocial.getListaUsuarios().size()) {
                            Usuario propietarioComentario = _redSocial.getListaUsuarios().get(numeroUsuarioElegidoComentario - 1);

                            System.out.println("Ingresa el texto del comentario:");
                            String textoComentario = Input.string();

                            // Creamos el comentario y lo añadimos al post y al propietario
                            Comentarios nuevoComentario = new Comentarios(textoComentario, propietarioComentario, postElegido);
                            postElegido.agregarComentario(nuevoComentario);
                            propietarioComentario.agregarComentario(nuevoComentario);

                            _redSocial.agregarComentario(nuevoComentario);
                            usuarioActual.agregarComentario(nuevoComentario);
                            System.out.println("¡Comentario creado con éxito!");

                            System.out.println("Comentarios en el Post " + (numeroPostElegido) + ":");
                            ArrayList<Comentarios> comentariosDelPost = postElegido.getListaComentarios();
                            for (int i = 0; i < comentariosDelPost.size(); i++) {
                                Comentarios comentario = comentariosDelPost.get(i);
                                System.out.println("Comentario " + (i + 1) + ": " + comentario.getTextoComentario());
                                System.out.println("Usuario: " + comentario.getPropietarioComentario().getNombreUsuario());
                            }

                        } else {
                            System.out.println("Número de usuario no válido.");
                        }
                    } else {
                        System.out.println("Número de post no válido.");
                    }
                    break;
                case 4:
                    System.out.println("Usuarios seguidos por " + usuarioActual.getNombreUsuario() + ":");
                    ArrayList<Usuario> seguidos = usuarioActual.getSeguidores();
                    for (int i = 0; i < seguidos.size(); i++) {
                        Usuario seguido = seguidos.get(i);
                        System.out.println((i + 1) + ". " + seguido.getNombreUsuario());
                    }
                    if (seguidos.isEmpty()) {
                        System.out.println("No estás siguiendo a ningún usuario en este momento.");
                    } else {
                        System.out.println("Ingrese el número del usuario al que desea dejar de seguir:");
                        int numeroUsuarioDejarDeSeguir = Input.integer();

                        if (numeroUsuarioDejarDeSeguir >= 1 && numeroUsuarioDejarDeSeguir <= seguidos.size()) {
                            Usuario usuarioDejarDeSeguir = seguidos.get(numeroUsuarioDejarDeSeguir - 1);
                            // Dejar de seguir al usuario
                            usuarioActual.dejarDeSeguirUsuario(usuarioDejarDeSeguir);
                            System.out.println("Dejaste de seguir a " + usuarioDejarDeSeguir.getNombreUsuario() + ".");
                            System.out.println("Usuarios seguidos actualmente por " + usuarioActual.getNombreUsuario() + ":");
                            for (Usuario seguido : usuarioActual.getSeguidores()) {
                                System.out.println("- " + seguido.getNombreUsuario());
                            }
                        } else {
                            System.out.println("Número de usuario no válido.");
                        }
                    }

                    break;
                case 5:
                    System.out.println("Lista de Usuarios:");
                    for (int i = 0; i < _redSocial.getListaUsuarios().size(); i++) {
                        Usuario usuario = _redSocial.getListaUsuarios().get(i);
                        System.out.println((i + 1) + ". " + usuario.getNombreUsuario());
                    }
                    System.out.println("Ingrese el número del usuario al que desea comenzar a seguir:");
                    int numeroUsuarioSeguir = Input.integer();

                    if (numeroUsuarioSeguir >= 1 && numeroUsuarioSeguir <= _redSocial.getListaUsuarios().size()) {
                        Usuario usuarioSeguir = _redSocial.getListaUsuarios().get(numeroUsuarioSeguir - 1);

                        if (usuarioActual != usuarioSeguir) {
                            // Seguir al usuario
                            usuarioActual.seguirUsuario(usuarioSeguir);
                            //Mostramos la lista de a quien estamos siguiendo
                            System.out.println("Usuarios seguidos por " + usuarioActual.getNombreUsuario() + ":");
                            for (Usuario seguido : usuarioActual.getSeguidores()) {
                                System.out.println("- " + seguido.getNombreUsuario());
                            }
                        } else {
                            System.out.println("No puedes seguirte a ti mismo.");
                        }
                    } else {
                        System.out.println("Número de usuario no válido.");
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el número del usuario que desea eliminar:");
                    for (int i = 0; i < _redSocial.getListaUsuarios().size(); i++) {
                        Usuario usuario = _redSocial.getListaUsuarios().get(i);
                        System.out.println((i + 1) + ". " + usuario.getNombreUsuario());
                    }
                    int numeroUsuarioEliminar = Input.integer();
                    if (numeroUsuarioEliminar >= 1 && numeroUsuarioEliminar <= _redSocial.getListaUsuarios().size()) {
                        Usuario usuarioEliminar = _redSocial.getListaUsuarios().get(numeroUsuarioEliminar - 1);

                        // Eliminamos al usuario de la lista de usuarios
                        _redSocial.getListaUsuarios().remove(usuarioEliminar);


                        //Eliminamos los posts relacionados con este usuario
                        ArrayList<Post> postsDelUsuario = usuarioEliminar.getListaPosts();
                        for (Post post : postsDelUsuario) {
                            _redSocial.getListaPosts().remove(post);
                        }

                        //Eliminamos los comentarios relacionados con este usuario
                        ArrayList<Comentarios> comentariosDelUsuario = usuarioEliminar.getListaComentarios();
                        for (Comentarios comentario : comentariosDelUsuario) {
                            _redSocial.getListaComentarios().remove(comentario);
                        }

                        //Elimina al usuario de las listas de seguidores de otros usuarios
                        for (Usuario otroUsuario : _redSocial.getListaUsuarios()) {
                            otroUsuario.dejarDeSeguirUsuario(usuarioEliminar);
                        }

                        System.out.println("Usuario eliminado con éxito.");

                        System.out.println("Usuarios restantes:");
                        for (int i = 0; i < _redSocial.getListaUsuarios().size(); i++) {
                            Usuario usuario = _redSocial.getListaUsuarios().get(i);
                            System.out.println((i + 1) + ". " + usuario.getNombreUsuario());
                        }
                    } else {
                        System.out.println("Número de usuario no válido.");
                    }
                    break;
                case 7:
                    System.out.println("Ingrese el número del post que desea eliminar:");
                    for (int i = 0; i < _redSocial.getListaPosts().size(); i++) {
                        Post post = _redSocial.getListaPosts().get(i);

                        System.out.println((i + 1) + ".\nFecha: " + post.getFechaCreacion());
                        System.out.println("Propietario: " + post.getUsuario().getNombreUsuario());

                        if (post instanceof PostTexto) {
                            PostTexto postTexto = (PostTexto) post;
                            System.out.println("Tipo de Post: Texto");
                            System.out.println("Contenido de Texto: " + postTexto.getTexto());
                        } else if (post instanceof PostImagen) {
                            PostImagen postImagen = (PostImagen) post;
                            System.out.println("Tipo de Post: Imagen");
                            System.out.println("Título de Imagen: " + postImagen.tituloImagen);
                            System.out.println("Dimensiones de Imagen: " + postImagen.dimensionesImagen);
                        } else if (post instanceof PostVideo) {
                            PostVideo postVideo = (PostVideo) post;
                            System.out.println("Tipo de Post: Video");
                            System.out.println("Título de Video: " + postVideo.getTituloVideo());
                            System.out.println("Calidad de Video: " + postVideo.getCalidadVideo() + "p");
                            System.out.println("Duración de Video: " + postVideo.getDuracionVideo() + " segundos");
                        }

                    }
                    int numeroPostEliminar = Input.integer();

                    if (numeroPostEliminar >= 1 && numeroPostEliminar <= _redSocial.getListaPosts().size()) {
                        Post postEliminar = _redSocial.getListaPosts().get(numeroPostEliminar - 1);

                        // Eliminamos el post de la red social
                        _redSocial.eliminarPost(postEliminar);

                        System.out.println("Post eliminado con éxito.");
                    } else {
                        System.out.println("Número de post no válido.");
                    }
                    break;
                case 8:
                    System.out.println("Seleccione el post del que desea eliminar un comentario:");
                    for (int i = 0; i < _redSocial.getListaPosts().size(); i++) {
                        Post post = _redSocial.getListaPosts().get(i);

                        System.out.println((i + 1) + ".\nFecha: " + post.getFechaCreacion());
                        System.out.println("Propietario: " + post.getUsuario().getNombreUsuario());

                        if (post instanceof PostTexto) {
                            PostTexto postTexto = (PostTexto) post;
                            System.out.println("Tipo de Post: Texto");
                            System.out.println("Contenido de Texto: " + postTexto.getTexto());
                        } else if (post instanceof PostImagen) {
                            PostImagen postImagen = (PostImagen) post;
                            System.out.println("Tipo de Post: Imagen");
                            System.out.println("Título de Imagen: " + postImagen.tituloImagen);
                            System.out.println("Dimensiones de Imagen: " + postImagen.dimensionesImagen);
                        } else if (post instanceof PostVideo) {
                            PostVideo postVideo = (PostVideo) post;
                            System.out.println("Tipo de Post: Video");
                            System.out.println("Título de Video: " + postVideo.getTituloVideo());
                            System.out.println("Calidad de Video: " + postVideo.getCalidadVideo() + "p");
                            System.out.println("Duración de Video: " + postVideo.getDuracionVideo() + " segundos");
                        }

                    }
                    int numeroPostEliminarComentario = Input.integer();
                    if (numeroPostEliminarComentario >= 1 && numeroPostEliminarComentario <= _redSocial.getListaPosts().size()) {
                        Post postEliminarComentario = _redSocial.getListaPosts().get(numeroPostEliminarComentario - 1);

                        // Muestra los comentarios del post seleccionado junto con el nombre del autor
                        System.out.println("Seleccione el número del comentario que desea eliminar:");
                        for (int i = 0; i < postEliminarComentario.getListaComentarios().size(); i++) {
                            Comentarios comentario = postEliminarComentario.getListaComentarios().get(i);
                            System.out.println((i + 1) + ". " + comentario.getTextoComentario() + " (Autor: " + comentario.getPropietarioComentario().getNombreUsuario() + ")");
                        }


                        int numeroComentarioEliminar = Input.integer();

                        if (numeroComentarioEliminar >= 1 && numeroComentarioEliminar <= postEliminarComentario.getListaComentarios().size()) {
                            Comentarios comentarioEliminar = postEliminarComentario.getListaComentarios().get(numeroComentarioEliminar - 1);

                            // Verificar si el comentario seleccionado pertenece al usuario actual
                            if (comentarioEliminar.getPropietarioComentario() == usuarioActual) {
                                // Elimina el comentario del post
                                postEliminarComentario.eliminarComentario(comentarioEliminar);
                                System.out.println("Comentario eliminado con éxito.");
                            } else {
                                System.out.println("No tiene permiso para eliminar este comentario, ya que no es suyo.");
                            }
                        } else {
                            System.out.println("Número de comentario no válido.");
                        }
                    } else {
                        System.out.println("Número de post no válido.");
                    }
                    break;
                case 9:
                    System.out.println("Listado de post");
                    for (int i = 0; i < _redSocial.getListaPosts().size(); i++) {
                        Post post = _redSocial.getListaPosts().get(i);

                        System.out.println((i + 1) + ".\nFecha: " + post.getFechaCreacion());
                        System.out.println("Propietario: " + post.getUsuario().getNombreUsuario());

                        if (post instanceof PostTexto) {
                            PostTexto postTexto = (PostTexto) post;
                            System.out.println("Tipo de Post: Texto");
                            System.out.println("Contenido de Texto: " + postTexto.getTexto());
                        } else if (post instanceof PostImagen) {
                            PostImagen postImagen = (PostImagen) post;
                            System.out.println("Tipo de Post: Imagen");
                            System.out.println("Título de Imagen: " + postImagen.tituloImagen);
                            System.out.println("Dimensiones de Imagen: " + postImagen.dimensionesImagen);
                        } else if (post instanceof PostVideo) {
                            PostVideo postVideo = (PostVideo) post;
                            System.out.println("Tipo de Post: Video");
                            System.out.println("Título de Video: " + postVideo.getTituloVideo());
                            System.out.println("Calidad de Video: " + postVideo.getCalidadVideo() + "p");
                            System.out.println("Duración de Video: " + postVideo.getDuracionVideo() + " segundos");
                        }

                    }
                    break;
                case 10:
                    if (usuarioActual != null) {
                        ArrayList<Comentarios> comentariosUsuario = usuarioActual.getListaComentarios();
                        System.out.println("Listado de comentarios");
                        if (comentariosUsuario.isEmpty()) {
                            System.out.println("No has hecho ningún comentario aún.");
                        } else {
                            for (int i = 0; i < comentariosUsuario.size(); i++) {
                                Comentarios comentario = comentariosUsuario.get(i);
                                System.out.println((i + 1) + ". " + comentario.getTextoComentario());
                            }
                        }
                    } else {
                        System.out.println("Debes seleccionar un usuario antes de ver sus comentarios.");
                    }

                    break;
                case 11:
                    System.out.println("Listado de comentarios en los posts:");
                    ArrayList<Post> listaPosts = _redSocial.getListaPosts();
                    for (int i = 0; i < listaPosts.size(); i++) {
                        Post post = listaPosts.get(i);
                        ArrayList<Comentarios> comentariosDelPost = post.getListaComentarios();

                        System.out.println("Comentarios en el Post " + (i + 1) + ":");
                        if (comentariosDelPost.isEmpty()) {
                            System.out.println("No hay comentarios en este post.");
                        } else {
                            for (int j = 0; j < comentariosDelPost.size(); j++) {
                                Comentarios comentario = comentariosDelPost.get(j);
                                System.out.println("Comentario " + (j + 1) + ": " + comentario.getTextoComentario());
                                System.out.println("Usuario: " + comentario.getPropietarioComentario().getNombreUsuario());
                            }
                        }
                    }
                    break;

            }
        } while (salir != 0);
    }

}
