package com.campusdual;

import java.time.LocalDate;
import java.util.ArrayList;

public class PostImagen extends Post {

    public String tituloImagen;
    public String dimensionesImagen;

    public PostImagen() {
    }

    public PostImagen(String tituloImagen, String dimensionesImagen) {
        this.tituloImagen = tituloImagen;
        this.dimensionesImagen = dimensionesImagen;
        this.setFechaCreacion(LocalDate.now());
    }

    public PostImagen(LocalDate fechaPost, String contenido, Usuario usuario, String tituloImagen, String dimensionesImagen) {
        super(fechaPost, contenido, usuario);
        this.tituloImagen = tituloImagen;
        this.dimensionesImagen = dimensionesImagen;
    }

    public String getTituloImagen() {
        return tituloImagen;
    }

    public void setTituloImagen(String tituloImagen) {
        this.tituloImagen = tituloImagen;
    }

    public String getDimensionesImagen() {
        return dimensionesImagen;
    }

    public void setDimensionesImagen(String dimensionesImagen) {
        this.dimensionesImagen = dimensionesImagen;
    }


}
