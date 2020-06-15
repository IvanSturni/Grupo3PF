package entidades;

public class Prestador {
    private int id;
    private int dni;
    private String nombre;
    private Especialidad especialidad;
    private boolean avtivo;

    public Prestador(int id, int dni, String nombre, Especialidad especialidad, boolean avtivo) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.avtivo = avtivo;
    }

    public Prestador(int dni, String nombre, Especialidad especialidad, boolean avtivo) {
        this.dni = dni;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.avtivo = avtivo;
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

    public boolean isAvtivo() {
        return avtivo;
    }

    public void setAvtivo(boolean avtivo) {
        this.avtivo = avtivo;
    }
    
    
    
    
}
