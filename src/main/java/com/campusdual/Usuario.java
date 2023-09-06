package com.campusdual;

import java.util.ArrayList;

public class Usuario {
    private RedSocial redSocial;
    public String nombreUsuario;
    private ArrayList<Post> listaPosts;
    private ArrayList<Usuario> seguidores;
    private ArrayList<Comentarios> listaComentarios;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, ArrayList<Post> listaPosts) {
        this.nombreUsuario = nombreUsuario;
        this.listaPosts = listaPosts;
    }

    public Usuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.listaPosts = new ArrayList<>();
        this.seguidores = new ArrayList<>();
        this.listaComentarios = new ArrayList<>();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public ArrayList<Post> getListaPosts() {
        return listaPosts;
    }

    public void setListaPosts(ArrayList<Post> listaPosts) {
        this.listaPosts = listaPosts;
    }

    public RedSocial getRedSocial() {
        return redSocial;
    }

    public void setRedSocial(RedSocial redSocial) {
        this.redSocial = redSocial;
    }

    public ArrayList<Usuario> getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(ArrayList<Usuario> seguidores) {
        this.seguidores = seguidores;
    }

    public void agregarPost(Post post) {
        listaPosts.add(post);
    }
    public void agregarComentario(Comentarios nuevoComentario) {
        listaComentarios.add(nuevoComentario);
    }

    public void dejarDeSeguirUsuario(Usuario usuario) {
        seguidores.remove(usuario);
    }
    public void seguirUsuario(Usuario usuarioAseguir) {
        // Verificar si el usuario ya está siguiendo al usuarioAseguir
        if (!seguidores.contains(usuarioAseguir)) {
            // Agregar usuarioAseguir a la lista de usuarios seguidos
            seguidores.add(usuarioAseguir);
            System.out.println("Ahora estás siguiendo a " + usuarioAseguir.getNombreUsuario());
        } else {
            System.out.println("Ya estás siguiendo a " + usuarioAseguir.getNombreUsuario());
        }
    }
    public ArrayList<Comentarios> getListaComentarios() {
        return listaComentarios;
    }
}
