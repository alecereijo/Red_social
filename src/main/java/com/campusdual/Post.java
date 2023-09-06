package com.campusdual;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Post extends RedSocial{

    private LocalDate fechaPost;
    private String contenido;
    private Usuario usuario;
    private ArrayList<Comentarios> listaComentarios;
    public Post() {
    }

    public Post(LocalDate fechaPost, String contenido, Usuario usuario) {
        this.fechaPost = fechaPost;
        this.contenido = contenido;
        this.usuario = usuario;
        this.listaComentarios = new ArrayList<>();
    }

    public LocalDate getFechaCreacion() {
        return fechaPost;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaPost = fechaCreacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFechaPost() {
        return fechaPost;
    }

    public void setFechaPost(LocalDate fechaPost) {
        this.fechaPost = fechaPost;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void eliminarComentario(Comentarios comentario) {
        if (listaComentarios != null) {
            if (listaComentarios.contains(comentario)) {
                listaComentarios.remove(comentario);
                System.out.println("Comentario eliminado con éxito.");
            } else {
                System.out.println("El comentario no existe en este post.");
            }
        } else {
            System.out.println("La lista de comentarios es nula.");
        }
    }
}
