package model;

import java.sql.Time;
import java.sql.Date;

public class Consulta {
    private int id;
    private Date data;
    private Time hora;
    private Status status;
    private Paciente paciente;
    private Medico medico;
    private Diagnostico diagnostico;

    public Consulta(int id, Date data, Time hora, Status status, Paciente paciente, Medico medico, Diagnostico diagnostico) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.status = status;
        this.paciente = paciente;
        this.medico = medico;
        this.diagnostico = diagnostico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }
}
