package aplicacion;

import gui.FachadaGUI;
import baseDatos.FachadaBaseDatos;
import java.util.ArrayList;
import pojos.Visitante;
import pojos.Restaurante;
import pojos.Hotel;
import pojos.Atraccion;
import pojos.Empleado;
import java.sql.Time;
import gui.VAtraccion;
import gui.VRestaurantes;
import gui.VHoteles;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author alumnogreibd
 */
public class FachadaAplicacion {

    FachadaGUI fgui;
    FachadaBaseDatos fbd;
    GestionHosteleria gh;
    GestionAtracciones ga;
    GestionVisitantes gv;

    public FachadaAplicacion() {
        fgui = new FachadaGUI(this);
        fbd = new FachadaBaseDatos(this);
        gh = new GestionHosteleria(fgui, fbd);
        ga = new GestionAtracciones(fgui, fbd);
        gv = new GestionVisitantes(fgui, fbd);
    }

    public static void main(String[] args) {
        FachadaAplicacion fa;

        fa = new FachadaAplicacion();
        fa.iniciaInterfazUsuario();
    }

    public void iniciaInterfazUsuario() {
        fgui.abrirVentanaPrincipal();
    }

    
    public void iniciarInterfazRestaurantes(){
        gh.IniciarInterfazUsuarios();
    }
    
    public java.util.List<Restaurante> obtenerRestaurantes(String nombre, Integer aforo, Time hora){
        return gh.obtenerRestaurantes(nombre, aforo, hora);
    }
    
    public java.util.List<Restaurante> restauranteMasExitoso(Date fechaInicio, Date fechaFin){
        return gh.restauranteMasExitoso(fechaInicio, fechaFin);
    }
    
    public void insertarRestaurante(Restaurante restaurante){
        gh.insertarRestaurante(restaurante);
    }
    
    public void borrarRestaurante(String nombreRestaurante){
        gh.borrarRestaurante(nombreRestaurante);
    }
    
    public void iniciarInterfazHoteles(){
        gh.IniciarInterfazHoteles();
    }
    
    public java.util.List<Hotel> obtenerHoteles(String nombre, Integer aforo, Integer estrellas){
        return gh.obtenerHoteles(nombre, aforo, estrellas);
    }
    
    public void insertarHotel(Hotel hotel){
        gh.insertarHotel(hotel);
    }
    
    public void borrarHotel(String nombreHotel){
        gh.borrarHotel(nombreHotel);
    }
    
    public void iniciarInterfazExito(VRestaurantes vr){
        gh.iniciarInterfazExito(vr);
    }
    
    public void iniciarInterfazInsertarCliente(VRestaurantes vr, String nombreRestaurante){
        gh.iniciarInterfazInsertarCliente(vr, nombreRestaurante);
    }
    
    public void iniciarInterfazInsertarHuesped(VHoteles vh, String hotel){
        gh.iniciarInterfazInsertarHuesped(vh, hotel);
    }
    
    public void insertarCliente(Visitante visitante, String restaurante){
        gh.insertarCliente(visitante,  restaurante);
    }
    
    public void insertarHuesped(Visitante visitante, String hotel, Date fechaSalida){
        gh.insertarHuesped(visitante, hotel, fechaSalida);
    }

    //busca atracciones

    public List<Atraccion> consultarCatalogoAtracciones(String nombre, Float alturaMin, Integer aforo) {
        return ga.consultarCatalogoAtracciones(nombre, alturaMin, aforo);
    }

        public void IniciarInterfazAtracciones() {
        ga.IniciarInterfazAtracciones();
    }
    
    //abre la ventana Insertar Atraccion
    public void nuevaAtraccion(VAtraccion va) {
        ga.nuevaAtraccion(va);
    }

    //Inserta una Atraccion
    public void insertaAtraccion(Atraccion a) {
        ga.InsertarAtraccion(a);
    }
    

    public void muestraExcepcion(String e) {
        fgui.muestraExcepcion(e);
    }
    
    
    //VISITANTES
    public void iniciarInterfazVisitantes() {
        fgui.abrirVentanaVisitantes();
    }
    
    public ArrayList<Visitante> obtenerVisitantes(String nombre) {
        return fbd.obtenerVisitantes(nombre);
    }

    public ArrayList<Visitante> obtenerVisitantes() {
        return fbd.obtenerVisitantes();
    }

    public void insertarVisitante(Visitante visitante) {
        fbd.insertarVisitante(visitante);
    }
    
    public void borrarVisitante(String dni) {
        fbd.borrarVisitante(dni);
    }

    
    //EMPLEADOS
    public void iniciarInterfazEmpleados(){
        fgui.abrirVentanaEmpleados();
    }
    
    public void insertarEmpleado(Empleado e) {
        fbd.insertarEmpleado(e);
    }
    

}

    

