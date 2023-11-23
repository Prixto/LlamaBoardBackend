package com.llamaboard.cliente.backend.apirest.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VotoRequest {
    Long usuarioId;
    Long cancionId;
    int voto;
}
