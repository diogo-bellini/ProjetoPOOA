package model;

import java.util.List;

public class Diagnostico{
    private String descricao;
    private Consulta consulta;
    private List<Prescricao> prescricoes;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}
