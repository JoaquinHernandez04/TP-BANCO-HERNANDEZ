package ar.edu.utn.frbb.tup;
public class Cliente {
    private int DNI;
    private String nombre;
    private String apellido;
    private String direccion;

    public Cliente(int DNI, String nombre, String apellido, String direccion) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public int getDni() {
        return this.DNI;
    }

    public void setDni(int DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
