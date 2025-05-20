package model;

import java.util.List;

public class Medico extends Usuario{
    private String especialidade;
    private List<Consulta> consultas;

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
