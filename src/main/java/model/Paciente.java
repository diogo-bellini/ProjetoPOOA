package model;

import java.util.List;

public class Paciente extends Usuario{

    public Paciente(int id, String nome, String email, String senha, Papel papel, List<Consulta> consultas) {
        super(id, nome, email, senha, papel);
    }
}
