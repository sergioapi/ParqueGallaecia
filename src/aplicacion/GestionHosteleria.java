/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;
//cambio
import gui.FachadaGUI;
import baseDatos.FachadaBaseDatos;
import pojos.Restaurante;
import pojos.Visitante;
import pojos.Hotel;
import java.sql.Time;
import java.sql.Date;
import gui.VRestaurantes;
import gui.VHoteles;


/**
 *
 * @author alumnogreibd
 */
public class GestionHosteleria {
    FachadaGUI fgui;
    FachadaBaseDatos fbd;
    
    public GestionHosteleria(FachadaGUI fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }
    
    public void IniciarInterfazUsuarios(){
        fgui.abrirVentanaRestaurantes();
    }
        
    public java.util.List<Restaurante> obtenerRestaurantes(String nombre, Integer aforo, Time hora){
        return fbd.consultarRestauracion(nombre, aforo, hora);
    }
    
    public java.util.List<Restaurante> restauranteMasExitoso(Date fechaInicio, Date fechaFin){
        return fbd.restauranteMasExitoso(fechaInicio, fechaFin);
    }
    
    public void insertarRestaurante(Restaurante restaurante){
        fbd.insertarRestaurante(restaurante);
    }
    
    public void borrarRestaurante(String nombreRestaurante){
        fbd.borrarRestaurante(nombreRestaurante);
    }
    
    public void iniciarInterfazInsertarCliente(VRestaurantes vr, String nombreRestaurante){
        fgui.abrirVentanaInsertarCliente(vr, nombreRestaurante);
    }
    
    public void iniciarInterfazInsertarHuesped(VHoteles vh, String hotel){
        fgui.abrirVentanaInsertarHuesped(vh, hotel);
    }
    
    public void insertarCliente(Visitante cliente, String restaurante){
        fbd.insertarCliente(cliente, restaurante);
    }
    
    public void insertarHuesped(Visitante huesped, String hotel, Date fechaSalida){
        fbd.insertarHuesped(huesped, hotel, fechaSalida);
    }
    
    public void IniciarInterfazHoteles(){
        fgui.abrirVentanaHoteles();
    }
    
    public java.util.List<Hotel> obtenerHoteles(String nombre, Integer aforo, Integer estrellas){
        return fbd.consultarHoteles(nombre, aforo, estrellas);
    }
    
    public void insertarHotel(Hotel hotel){
        fbd.insertarHotel(hotel);
    }
    
    public void borrarHotel(String nombreHotel){
        fbd.borrarHotel(nombreHotel);
    }
    
    public void iniciarInterfazExito(VRestaurantes vr){
        fgui.abrirVentanaExitos(vr);
    }
    
}
