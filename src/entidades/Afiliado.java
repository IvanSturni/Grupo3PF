package entidades;

public class Afiliado {
    private int id = -1;
    private int dni;
    private String nombre;
    private boolean activo;
   
    
    public Afiliado(int id, int dni, String nombre, boolean activo){
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.activo = activo;
    }
    
    public Afiliado(int dni, String nombre, boolean activo){
        this.dni = dni;
        this.nombre = nombre;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
}
