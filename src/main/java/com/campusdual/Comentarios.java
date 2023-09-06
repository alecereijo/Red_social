package com.campusdual;

import java.time.LocalDate;

public class Comentarios extends RedSocial {
    public String textoComentario;
    public LocalDate fechaComentario;
    public Usuario propietarioComentario;  // Con este atributo representamos el propietario del comentario
    private Post post;

    public Comentarios() {
    }

    public Comentarios(String textoComentario, Usuario propietarioComentario,Post post) {
        this.textoComentario = textoComentario;
        this.fechaComentario = LocalDate.now();
        this.propietarioComentario = propietarioComentario;
        this.post = post;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getTextoComentario() {
        return textoComentario;
    }

    public void setTextoComentario(String textoComentario) {
        this.textoComentario = textoComentario;
    }

    public LocalDate getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(LocalDate fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public Usuario getPropietarioComentario() {
        return propietarioComentario;
    }

    public void setPropietarioComentario(Usuario propietarioComentario) {
        this.propietarioComentario = propietarioComentario;
    }
}
