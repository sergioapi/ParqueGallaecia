package pojos;

import java.sql.Date;

/**
 *
 * @author alumnogreibd
 */
public class Trabajador extends Empleado {

    public Trabajador(String DNI, String nombre) {
        super(DNI, nombre);
    }

    public Trabajador(String DNI, String nombre, String direccion, double salario, String telefono, Date fechaInicio, Date fechaNacemento, String formacion, int edad, int tiempoTrabajado) {
        super(DNI, nombre, direccion, salario, telefono, fechaInicio, fechaNacemento, formacion, edad, tiempoTrabajado);
    }

    public Trabajador(String DNI, String nombre, String direccion, double salario, String telefono, Date fechaInicio, Date fechaNacemento, String formacion) {
        super(DNI, nombre, direccion, salario, telefono, fechaInicio, fechaNacemento, formacion);
    }

}
