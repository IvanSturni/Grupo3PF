package entidades;

import java.time.*;

public class Horario {
    private int id = -1;
    private Prestador prestador;
    private DayOfWeek dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Horario(int id, Prestador prestador, DayOfWeek dia, LocalTime horaInicio, LocalTime horaFin) {
        this.id = id;
        this.prestador = prestador;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Horario(Prestador prestador, DayOfWeek dia, LocalTime horaInicio, LocalTime horaFin) {
        this.prestador = prestador;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    public DayOfWeek getDia() {
        return dia;
    }

    public void setDia(DayOfWeek dia) {
        this.dia = dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
    
    @Override
    public String toString(){
        return dia.name() + ": " + horaInicio.toString() + " - " + horaFin.toString();
    }
}
