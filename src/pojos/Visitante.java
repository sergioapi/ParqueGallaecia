package pojos;

import java.sql.Date;

/**
 *
 * @author alumnogreibd
 */
public class Visitante {

    private String DNI;
    private String nombre;
    private String nacionalidad;
    private String telefono;
    private Date fechaNacimiento;
    private float altura;
    private int edad;

    public Visitante(String DNI, String nombre, String nacionalidad, String telefono, Date fechaNacimiento, float altura, int edad) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.altura = altura;
        this.edad = edad;
    }

    public Visitante(String DNI, String nombre, String nacionalidad, String telefono, Date fechaNacimiento, float altura) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.altura = altura;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
