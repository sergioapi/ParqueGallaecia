/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import java.util.ArrayList;
import java.sql.Date;

import java.sql.Time;
import pojos.Atraccion;
import pojos.Espectaculo;
import pojos.Hotel;
import pojos.Restaurante;
import pojos.Visitante;
import pojos.Empleado;
/**
 *
 * @author alumnogreibd
 */
public class FachadaBaseDatos {

    private aplicacion.FachadaAplicacion fa;
    private java.sql.Connection conexion;
    private DAOHosteleria daoHosteleria;
    private DAOVisitantes daoVisitantes;
    private DAOAtracciones daoAtraccion;
    private DAOEmpleados daoEmpleados;

    public FachadaBaseDatos(aplicacion.FachadaAplicacion fa) {

        Properties configuracion = new Properties();
        this.fa = fa;
        FileInputStream arqConfiguracion;

        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            this.conexion = java.sql.DriverManager.getConnection("jdbc:" + gestor + "://"
                    + configuracion.getProperty("servidor") + ":"
                    + configuracion.getProperty("puerto") + "/"
                    + configuracion.getProperty("baseDatos"),
                    usuario);

        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());

        } catch (IOException i) {
            System.out.println(i.getMessage());

        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());

        }

        //creacion de DAOs (aquí todos)
        daoHosteleria = new DAOHosteleria(conexion, fa);
        daoVisitantes = new DAOVisitantes(conexion, fa);
        daoAtraccion = new DAOAtracciones(conexion, fa);
        daoEmpleados = new DAOEmpleados(conexion, fa);

    }
    
    public java.util.List<Restaurante> consultarRestauracion(String nombre, Integer aforo, Time hora){
        return daoHosteleria.consultarRestauracion(nombre, aforo, hora);
    }
    
    public java.util.List<Restaurante> restauranteMasExitoso(Date fechaInicio, Date fechaFin){
        return daoHosteleria.restauranteMasExitoso(fechaInicio, fechaFin);
    }
    
    public void insertarRestaurante(Restaurante restaurante){
        daoHosteleria.insertarRestaurante(restaurante);
    }
    
    public void borrarRestaurante(String nombreRestaurante){
        daoHosteleria.borrarRestaurante(nombreRestaurante);
    }
    
    public void insertarCliente(Visitante visitante, String restaurante){
        daoHosteleria.insertarCliente(visitante, restaurante);
    }
    
    public void insertarHuesped(Visitante visitante, String hotel, Date fechaSalida){
        daoHosteleria.insertarHuesped(visitante, hotel, fechaSalida);
    }
    
    public java.util.List<Hotel> consultarHoteles(String nombre, Integer aforo, Integer estrellas){
        return daoHosteleria.consultarHoteles(nombre, aforo, estrellas);
    }
    
    public void insertarHotel(Hotel hotel ){
        daoHosteleria.insertarHotel(hotel);
    }
    
    public void borrarHotel(String nombreHotel){
        daoHosteleria.borrarHotel(nombreHotel);
    }

    public ArrayList<Visitante> obtenerVisitantes(String nombre) {
        return daoVisitantes.consultarVisitantes(nombre);
    }

    public ArrayList<Visitante> obtenerVisitantes() {
        return daoVisitantes.consultarVisitantes();
    }

    public void insertarVisitante(Visitante visitante) {
        daoVisitantes.altaVisitante(visitante);
    }
    
    public void borrarVisitante(String dni) {
        daoVisitantes.bajaVisitante(dni);
    }

    public java.util.List<Atraccion> consultarCatalogoAtracciones(String nombre, Float alturaMin, Integer aforo) {
        return daoAtraccion.consultarCatalogoAtracciones(nombre, alturaMin, aforo);
    }

    public void insertarAtraccion(Atraccion a) {
        daoAtraccion.insertarAtraccion(a);
    }
    
    //empleados
    public void insertarEmpleado(Empleado e) {
        daoEmpleados.altaEmpregado(e);
    }
   

}
