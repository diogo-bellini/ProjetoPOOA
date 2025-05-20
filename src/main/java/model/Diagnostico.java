package model;

import java.util.List;

public class Diagnostico{
    private int id;
    private String descricao;
    private Consulta consulta;
    private List<Prescricao> prescricoes;

    public Diagnostico(int id, String descricao, Consulta consulta, List<Prescricao> prescricoes) {
        this.id = id;
        this.descricao = descricao;
        this.consulta = consulta;
        this.prescricoes = prescricoes;
    }

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
