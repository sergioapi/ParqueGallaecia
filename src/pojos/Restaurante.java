/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.sql.Time;
import java.util.List;
import pojos.Hostelero;

/**
 *
 * @author alumnogreibd
 */
public class Restaurante  {

    private String nombreEstablecimiento;
    private String ubicacion;
    private Integer aforo;
    private Time horaInicio;
    private Time horaFin;
    private java.util.List<String> empleados;
    private Float media_clientes;

    public Restaurante(String nombreEstablecimiento, String ubicacion, Integer aforo, Time horaInicio, Time horaFin) {
        this.nombreEstablecimiento = nombreEstablecimiento;
        this.ubicacion = ubicacion;
        this.aforo = aforo;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        empleados = new java.util.ArrayList<String>();
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
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
