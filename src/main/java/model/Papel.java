package model;

public enum Papel {
    MEDICO,
    PACIENTE,
    ADMIN;

    public static Papel fromString(String papel) {
        return Papel.valueOf(papel.toUpperCase());
    }
}
