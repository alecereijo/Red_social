package com.campusdual;

import java.util.ArrayList;

public class RedSocial {

    public ArrayList<Usuario> listaUsuarios;
    public ArrayList<Post> listaPosts;
    public ArrayList<Comentarios> listaComentarios;

    public RedSocial() {
        listaUsuarios = new ArrayList<>();
        listaPosts = new ArrayList<>();
        listaComentarios = new ArrayList<>();
    }

    public RedSocial(ArrayList<Usuario> listaUsuarios, ArrayList<Post> listaPosts, ArrayList<Comentarios> listaComentarios) {
        this.listaUsuarios = listaUsuarios;
        this.listaPosts = listaPosts;
        this.listaComentarios = listaComentarios;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Post> getListaPosts() {
        return listaPosts;
    }

    public void setListaPosts(ArrayList<Post> listaPosts) {
        this.listaPosts = listaPosts;
    }

    public ArrayList<Comentarios> getListaComentarios() {
        return listaComentarios;
    }
    public void setListaComentarios(ArrayList<Comentarios> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    //Metodo para añadir usuarios a nuestra lista
    public void agregarUsuario(Usuario usuario){
        listaUsuarios.add(usuario);
    }
    public void agregarPost(Post post) {
        listaPosts.add(post);
    }
    public void agregarComentario(Comentarios comentario) {
        listaComentarios.add(comentario);
    }
    public void eliminarPost(Post post) {
        // Elimina el post de la lista de posts de la red social
        listaPosts.remove(post);

        // Elimina los comentarios asociados al post
        ArrayList<Comentarios> comentariosAEliminar = new ArrayList<>();
        for (Comentarios comentario : listaComentarios) {
            if (comentario.getPost().equals(post)) {
                comentariosAEliminar.add(comentario);
            }
        }
        listaComentarios.removeAll(comentariosAEliminar);
    }
}
