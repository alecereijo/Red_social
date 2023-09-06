package com.campusdual;

import java.time.LocalDate;
import java.util.ArrayList;

public class PostVideo extends Post {

    public String tituloVideo;
    public int calidadVideo;
    public int duracionVideo;

    public PostVideo() {
    }

    public PostVideo(String tituloVideo, int calidadVideo, int duracionVideo) {
        this.tituloVideo = tituloVideo;
        this.calidadVideo = calidadVideo;
        this.duracionVideo = duracionVideo;
        this.setFechaCreacion(LocalDate.now());
    }

    public PostVideo(LocalDate fechaPost, String contenido, Usuario usuario, String tituloVideo, int calidadVideo, int duracionVideo) {
        super(fechaPost, contenido, usuario);
        this.tituloVideo = tituloVideo;
        this.calidadVideo = calidadVideo;
        this.duracionVideo = duracionVideo;
    }

    public String getTituloVideo() {
        return tituloVideo;
    }

    public void setTituloVideo(String tituloVideo) {
        this.tituloVideo = tituloVideo;
    }

    public int getCalidadVideo() {
        return calidadVideo;
    }

    public void setCalidadVideo(int calidadVideo) {
        this.calidadVideo = calidadVideo;
    }

    public int getDuracionVideo() {
        return duracionVideo;
    }

    public void setDuracionVideo(int duracionVideo) {
        this.duracionVideo = duracionVideo;
    }
}
