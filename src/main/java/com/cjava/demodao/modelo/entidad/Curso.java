package com.cjava.demodao.modelo.entidad;

import javax.persistence.*;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="numeroCreditos")
    private int numerocreditos;

    public Curso(){

    }

    public Curso(Long id, String nombre, int numerocreditos) {
        this.id = id;
        this.nombre = nombre;
        this.numerocreditos = numerocreditos;
    }

    public Curso(String nombre, int numeroCreditos) {
        this.nombre = nombre;
        this.numerocreditos = numeroCreditos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumerocreditos() {
        return numerocreditos;
    }

    public void setNumerocreditos(int numerocreditos) {
        this.numerocreditos = numerocreditos;
    }
}
