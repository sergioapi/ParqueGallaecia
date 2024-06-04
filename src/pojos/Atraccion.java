package pojos;

import java.util.Objects;

/**
 *
 * @author alumnogreibd
 */
public class Atraccion {

    private String nombre;
    private Integer aforo;
    private Float alturaMin;
    private Float costeMantenimiento;
    private String ubicacion;
    private String descripcion;

    public Atraccion(String nombre, Integer aforo, Float alturaMin, Float costeMantenimiento, String ubicacion, String descripcion) {
        this.nombre = nombre;
        this.aforo = aforo;
        this.alturaMin = alturaMin;
        this.costeMantenimiento = costeMantenimiento;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public Float getAlturaMin() {
        return alturaMin;
    }

    public void setAlturaMin(Float alturaMin) {
        this.alturaMin = alturaMin;
    }

    public Float getCosteMantenimiento() {
        return costeMantenimiento;
    }

    public void setCosteMantenimiento(Float costeMantenimiento) {
        this.costeMantenimiento = costeMantenimiento;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Atraccion other = (Atraccion) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

}
