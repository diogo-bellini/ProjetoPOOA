package model;

import java.sql.Date;
import java.sql.Time;

public class Prescricao{
    private int id;
    private String medicamento;
    private String dosagem;
    private String frequencia;
    private Date data;
    private Time hora;
    private Diagnostico diagnostico;

    public Prescricao(int id, String medicamento, String dosagem, String frequencia, Date data, Time hora, Diagnostico diagnostico) {
        this.id = id;
        this.medicamento = medicamento;
        this.dosagem = dosagem;
        this.frequencia = frequencia;
        this.data = data;
        this.hora = hora;
        this.diagnostico = diagnostico;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }
}
