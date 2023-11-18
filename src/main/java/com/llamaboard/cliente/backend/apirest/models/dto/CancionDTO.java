package com.llamaboard.cliente.backend.apirest.models.dto;

import com.llamaboard.cliente.backend.apirest.models.entity.Cancion;
import com.llamaboard.cliente.backend.apirest.models.entity.Genero;
import lombok.Data;

@Data
public class CancionDTO {

    Long id;
    String nombre;
    String artista;
    String duracion;
    Genero genero;

    public CancionDTO(Cancion cancion, Genero genero) {
        this.id = cancion.getId();
        this.nombre = cancion.getNombre();
        this.artista = cancion.getArtista();
        this.duracion = cancion.getDuracion();
        this.genero = genero;
    }
}
