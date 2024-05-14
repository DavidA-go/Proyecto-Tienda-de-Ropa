package uts.java.practica1.models;

public class Estudiante {
    private int cedula;
    private String nombre;
    private String correo;

    public int getCedula() {
        return cedula;
    }
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    @Override
    public String toString() {
        return "Estudiante [cedula=" + cedula + ", nombre=" + nombre + ", correo=" + correo + "]";
    }
}