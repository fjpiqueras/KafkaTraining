package com.indizen.fjpiqueras.kafka.pojo;

import java.io.Serializable;
import java.util.List;

public class Empleado implements Serializable {

    private String dni;
    private String nombre;
    private String apellidos;
    private String email;
    private int telefono;
    private List<String> skills;
    private boolean estrella;

    public Empleado() {

    }

    public Empleado(String dni, String nombre, String apellidos, String email, int telefono, List<String> skills) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.skills = skills;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public void setEstrella(boolean estrella) {
        this.estrella = estrella;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", telefono=" + telefono +
                ", skills='" + skills.toString() + '\'' +
                ", estrella=" + estrella +
                '}';
    }
}
