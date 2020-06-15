package entidades;

import java.time.LocalDate;

public class Orden {
    private int id = -1;
    private Afiliado afiliado;
    private Horario horario;
    private boolean efectivo;
    private LocalDate fechaAtencion;
    private LocalDate fechaCreacion;
    private boolean activa;

    public Orden(int id, Afiliado afiliado, Horario horario, boolean efectivo, LocalDate fechaAtencion, LocalDate fechaCreacion, boolean activa) {
        this.id = id;
        this.afiliado = afiliado;
        this.horario = horario;
        this.efectivo = efectivo;
        this.fechaAtencion = fechaAtencion;
        this.fechaCreacion = fechaCreacion;
        this.activa = activa;
    }

    public Orden(Afiliado afiliado, Horario horario, boolean efectivo, LocalDate fechaAtencion, LocalDate fechaCreacion, boolean activa) {
        this.afiliado = afiliado;
        this.horario = horario;
        this.efectivo = efectivo;
        this.fechaAtencion = fechaAtencion;
        this.fechaCreacion = fechaCreacion;
        this.activa = activa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public boolean isEfectivo() {
        return efectivo;
    }

    public void setEfectivo(boolean efectivo) {
        this.efectivo = efectivo;
    }

    public LocalDate getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(LocalDate fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
    @Override
    public String toString(){
        return "[" + fechaAtencion.toString() + "] " + horario.toString();
    }
}
