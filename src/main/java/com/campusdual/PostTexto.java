package com.campusdual;

import java.time.LocalDate;

public class PostTexto extends Post {
    public String texto;

    public PostTexto() {
    }

    public PostTexto(String textoComentario) {
        this.texto = textoComentario;
        this.setFechaCreacion(LocalDate.now());
    }

    public PostTexto(LocalDate fechaPost, String contenido, Usuario usuario, String textoComentario) {
        super(fechaPost, contenido, usuario);
        this.texto = textoComentario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
