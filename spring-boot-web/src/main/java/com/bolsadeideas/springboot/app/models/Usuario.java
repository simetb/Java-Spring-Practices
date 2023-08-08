package com.bolsadeideas.springboot.app.models;

public class Usuario {

    private String email;
    private String nombre;
    private String apellido;

    public Usuario() {
    }

    public Usuario(String email, String nombre, String apellido) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
