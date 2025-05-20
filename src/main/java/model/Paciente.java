package model;

import java.util.List;

public class Paciente extends Usuario{
    private List<Consulta> consultas;

    public Paciente(int id, String nome, String email, String senha, String papel, List<Consulta> consultas) {
        super(id, nome, email, senha, papel);
        this.consultas = consultas;
    }
}
