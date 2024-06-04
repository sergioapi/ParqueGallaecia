/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.util.List;

/**
 *
 * @author alumnogreibd
 */
public class Hotel {

    private String nombreEstablecimiento;
    private String ubicacion;
    private Integer aforo;
    private Integer estrellas;
    private java.util.List<String> empleados;
    private Float media_clientes;

    public Hotel(String nombreEstablecimiento, String ubicacion, Integer aforo, Integer estrellas) {
        this.nombreEstablecimiento = nombreEstablecimiento;
        this.ubicacion = ubicacion;
        this.aforo = aforo;
        this.estrellas = estrellas;
        empleados = new java.util.ArrayList<String>();
    }

    public String getNombreEstablecimiento() {
        return nombreEstablecimiento;
    }

    public void setNombreEstablecimiento(String nombreEstablecimiento) {
        this.nombreEstablecimiento = nombreEstablecimiento;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getAforo() {
        return aforo;
    }

    public void setAforo(Integer aforo) {
        this.aforo = aforo;
    }

    public Integer getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }
    
    public List<String> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<String> empleados) {
        this.empleados = empleados;
    }
    
    public void addEmpleado(String empleado){
        this.empleados.add(empleado);
    }

    public Float getMedia_clientes() {
        return media_clientes;
    }

    public void setMedia_clientes(Float media_clientes) {
        this.media_clientes = media_clientes;
    }

}
