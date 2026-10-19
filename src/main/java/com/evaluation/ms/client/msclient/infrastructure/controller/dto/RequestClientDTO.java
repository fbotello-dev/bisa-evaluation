package com.evaluation.ms.client.msclient.infrastructure.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestClientDTO {
    @NotNull(message = "Nombres es requerido")
    @NotBlank(message = "Nombres es requerido")
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    @NotBlank(message = "El correo es requerido")
    @Email(message = "El correo es invalido")
    private String documento;
    private String correo;
}
