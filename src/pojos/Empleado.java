/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.sql.Date;

/**
 *
 * @author alumnogreibd
 */
public abstract class Empleado {

    private String DNI;
    private String nombre;
    private String direccion;
    private double salario;
    private String telefono;
    private Date fechaInicio;
    private Date fechaNacemento;
    private String formacion;
    private int edad;
    private int tiempoTrabajado;
    private String sector;

    public Empleado(String DNI, String nombre) {
        this.DNI = DNI;
        this.nombre = nombre;
    }

    public Empleado(String DNI, String nombre, String direccion, double salario, String telefono, Date fechaInicio, Date fechaNacemento, String formacion, int edad, int tiempoTrabajado) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.salario = salario;
        this.telefono = telefono;
        this.fechaInicio = fechaInicio;
        this.fechaNacemento = fechaNacemento;
        this.formacion = formacion;
        this.edad = edad;
        this.tiempoTrabajado = tiempoTrabajado;
    }

    public Empleado(String DNI, String nombre, String direccion, double salario, String telefono, Date fechaInicio, Date fechaNacemento, String formacion) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.salario = salario;
        this.telefono = telefono;
        this.fechaInicio = fechaInicio;
        this.fechaNacemento = fechaNacemento;
        this.formacion = formacion;
    }

    public Empleado(String DNI, String nombre, String telefono, String sector) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.telefono = telefono;
        this.sector = sector;
    }

    public Empleado(String DNI, String nombre, String direccion, double salario, String telefono, Date fechaInicio, Date fechaNacemento, String formacion, String sector) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.salario = salario;
        this.telefono = telefono;
        this.fechaInicio = fechaInicio;
        this.fechaNacemento = fechaNacemento;
        this.formacion = formacion;
        this.sector = sector;
    }

    public Empleado(String DNI, String nombre, String direccion, double salario, String telefono, Date fechaInicio, Date fechaNacemento, String formacion, int edad, int tiempoTrabajado, String sector) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.salario = salario;
        this.telefono = telefono;
        this.fechaInicio = fechaInicio;
        this.fechaNacemento = fechaNacemento;
        this.formacion = formacion;
        this.edad = edad;
        this.tiempoTrabajado = tiempoTrabajado;
        this.sector = sector;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaNacemento() {
        return fechaNacemento;
    }

    public void setFechaNacemento(Date fechaNacemento) {
        this.fechaNacemento = fechaNacemento;
    }

    public String getFormacion() {
        return formacion;
    }

    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTiempoTrabajado() {
        return tiempoTrabajado;
    }

    public void setTiempoTrabajado(int tiempoTrabajado) {
        this.tiempoTrabajado = tiempoTrabajado;
    }

}
