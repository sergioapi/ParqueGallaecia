package pojos;

import java.sql.Date;

/**
 *
 * @author alumnogreibd
 */
public class Hostelero extends Empleado {

    public Hostelero(String DNI, String nombre) {
        super(DNI, nombre);
    }

    public Hostelero(String DNI, String nombree, String direccion, double salario, String telefono, Date fechaInicio, Date fechaNacemento, String formacion, int edad, int tiempoTrabajado) {
        super(DNI, nombree, direccion, salario, telefono, fechaInicio, fechaNacemento, formacion, edad, tiempoTrabajado);
    }

    public Hostelero(String DNI, String nombree, String direccion, double salario, String telefono, Date fechaInicio, Date fechaNacemento, String formacion) {
        super(DNI, nombree, direccion, salario, telefono, fechaInicio, fechaNacemento, formacion);
    }

}
