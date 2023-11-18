package com.llamaboard.cliente.backend.apirest.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Time;

@Data
@Entity
@Table(name = "canciones")
public class Cancion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    String artista;
    String duracion;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;



    @Serial
    private static final long serialVersionUID = 1L;
}
