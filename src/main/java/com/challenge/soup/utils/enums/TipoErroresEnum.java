package com.challenge.soup.utils.enums;

public enum TipoErroresEnum {
    ERROR_INTERNO_SERVIDOR(500, "Error interno del servidor"),
    ERROR_ORDENAMIENTO(400, "Error durante el ordenamiento"),
    ERROR_DATOS_INVALIDOS(422, "Datos de entrada inválidos");

    private final int codigo;
    private final String mensaje;

    TipoErroresEnum(int codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }
}
