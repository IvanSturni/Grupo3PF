package entidades;

public class Prestador {
    private int id = -1;
    private int dni;
    private String nombre;
    private Especialidad especialidad;
    private boolean activo;

    public Prestador(int id, int dni, String nombre, Especialidad especialidad, boolean activo) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.activo = activo;
    }

    public Prestador(int dni, String nombre, Especialidad especialidad, boolean activo) {
        this.dni = dni;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public String toString(){
        return "(" + dni + ") " + nombre;
    }
}
