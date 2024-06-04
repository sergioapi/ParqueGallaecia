/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.time.LocalTime;

/**
 *
 * @author alumnogreibd
 */
public class Espectaculo {

    private String nome;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String tematica;
    private String descricion;
    private String ubicacion;
    private double precio;

    public Espectaculo(String nome, LocalTime horaInicio, LocalTime horaFin, String tematica, String descricion, String ubicacion, double precio) {
        this.nome = nome;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.tematica = tematica;
        this.descricion = descricion;
        this.ubicacion = ubicacion;
        this.precio = precio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
