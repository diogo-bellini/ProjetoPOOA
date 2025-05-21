package model;

public enum Status {
    CONFIRMADA,
    PENDENTE;

    public static Papel fromString(String papel) {
        return Papel.valueOf(papel.toUpperCase());
    }

    public String toDatabaseValue() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
