package uts.java.proyectobd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//Asocia la clase a una tabla de la BD
@Entity
public class Proveedor {
    //Atributos similares a la BD

    @Id // LLave primaria de la BD
    private int nit;

    @Column(name="ciudad")
    private String ciudad;
    private String direccion;
    private String nombre;
    private String telefono;

    //Constructores
    public Proveedor() {
    }

    public Proveedor(int nit, String ciudad, String direccion, String nombre, String telefono) {
        this.nit = nit;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    //Getters & Setters
    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //toString
    @Override
    public String toString() {
        return "Proveedor [nit=" + nit + ", ciudad=" + ciudad + ", direccion=" + direccion + ", nombre=" + nombre
                + ", telefono=" + telefono + "]";
    }
}