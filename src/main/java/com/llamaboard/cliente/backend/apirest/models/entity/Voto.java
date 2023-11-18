package com.llamaboard.cliente.backend.apirest.models.entity;

import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
@Data
@Entity
@Table(name = "votos")
public class Voto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "cancion_id")
    private Cancion canción;

    @Column(nullable = false)
    private int voto;


    @Serial
    private static final long serialVersionUID = 4L;
}
