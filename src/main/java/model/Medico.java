package model;

import java.util.List;

public class Medico extends Usuario{
    private String especialidade;

    public Medico(int id, String nome, String email, String senha, Papel papel, String especialidade) {
        super(id, nome, email, senha, papel);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
