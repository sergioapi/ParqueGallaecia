/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pojos.Atraccion;
import pojos.Bono;
import pojos.Espectaculo;
import pojos.Hotel;
import pojos.Restaurante;
import pojos.Empleado;
import java.sql.Time;

/**
 *
 * @author alumnogreibd
 */
public class DAOEmpleados extends AbstractDAO {

    public DAOEmpleados(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Empleado altaEmpregado(Empleado empleado) {
        Connection con;
        PreparedStatement psVisitante = null;

        con = super.getConexion();

        try {
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            psVisitante = con.prepareStatement("insert into Empleado(dni, nombre, calle, numero, cp, localidad, salario, telefono, fechaInicio, fechaNacimiento, formacion) values (?, ?, ?, ?, ?, ?)");
            psVisitante.setString(1, empleado.getDNI());
            psVisitante.setString(2, empleado.getNombre());
            /*
            psVisitante.setString(3, empleado.getDireccion().getRua()); 
            psVisitante.setInt(4, empleado.getDireccion().getNumero());
            psVisitante.setString(5, empleado.getDireccion().getCp());
            psVisitante.setString(6, empleado.getDireccion().getLocalidade());
            */
             psVisitante.setString(8, empleado.getDireccion());
            psVisitante.setDouble(7, empleado.getSalario());
            psVisitante.setString(8, empleado.getTelefono());
            psVisitante.setDate(9, empleado.getFechaInicio());
            psVisitante.setDate(10, empleado.getFechaNacemento());
            psVisitante.setString(11, empleado.getFormacion());
            psVisitante.setString(12, empleado.getFormacion());

            psVisitante.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                psVisitante.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return empleado;
    }

    public Empleado bajaEmpleado(Empleado empleado) {
        Connection con;
        PreparedStatement psVisitante = null;

        con = super.getConexion();

        try {
            psVisitante = con.prepareStatement("delete from Empleado where dni = ?");
            psVisitante.setString(1, empleado.getDNI());
            psVisitante.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                psVisitante.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return null;
    }

    // falta
    public ArrayList<Empleado> consultarEmpleado(Empleado empleado){
        Connection con;
        PreparedStatement psVisitante = null;

        con = super.getConexion();

        try {
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            psVisitante = con.prepareStatement("insert into Empleado(dni, nombre, calle, numero, cp, localidad, salario, telefono, fechaInicio, fechaNacimiento, formacion) values (?, ?, ?, ?, ?, ?)");
            psVisitante.setString(1, empleado.getDNI());
            psVisitante.setString(2, empleado.getNombre());
            /*
            psVisitante.setString(3, empleado.getDireccion().getRua()); 
            psVisitante.setInt(4, empleado.getDireccion().getNumero());
            psVisitante.setString(5, empleado.getDireccion().getCp());
            psVisitante.setString(6, empleado.getDireccion().getLocalidade());
            */
             psVisitante.setString(8, empleado.getDireccion());
            psVisitante.setDouble(7, empleado.getSalario());
            psVisitante.setString(8, empleado.getTelefono());
            psVisitante.setDate(9, empleado.getFechaInicio());
            psVisitante.setDate(10, empleado.getFechaNacemento());
            psVisitante.setString(11, empleado.getFormacion());
            psVisitante.setString(12, empleado.getFormacion());

            psVisitante.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                psVisitante.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return null;
    }
    
    // Falta
    public ArrayList<Empleado> consultarSector(Empleado empleado){
        Connection con;
        PreparedStatement psVisitante = null;

        con = super.getConexion();

        try {
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            psVisitante = con.prepareStatement("insert into Empleado(dni, nombre, calle, numero, cp, localidad, salario, telefono, fechaInicio, fechaNacimiento, formacion) values (?, ?, ?, ?, ?, ?)");
            psVisitante.setString(1, empleado.getDNI());
            psVisitante.setString(1, empleado.getDNI());
            psVisitante.setString(2, empleado.getNombre());
            /*
            psVisitante.setString(3, empleado.getDireccion().getRua()); 
            psVisitante.setInt(4, empleado.getDireccion().getNumero());
            psVisitante.setString(5, empleado.getDireccion().getCp());
            psVisitante.setString(6, empleado.getDireccion().getLocalidade());
            */
             psVisitante.setString(8, empleado.getDireccion());
            psVisitante.setDouble(7, empleado.getSalario());
            psVisitante.setString(8, empleado.getTelefono());
            psVisitante.setDate(9, empleado.getFechaInicio());
            psVisitante.setDate(10, empleado.getFechaNacemento());
            psVisitante.setString(11, empleado.getFormacion());

            psVisitante.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                psVisitante.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return null;
    }
}