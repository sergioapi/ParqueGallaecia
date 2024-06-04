/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGUI;
import pojos.Atraccion;
import gui.VAtraccion;

/**
 *
 * @author alumnogreibd
 */
public class GestionAtracciones {
    FachadaBaseDatos fbd;
     FachadaGUI fgui;

    public GestionAtracciones(FachadaGUI fgui, FachadaBaseDatos fbd) {
        this.fbd = fbd;
        this.fgui = fgui;
    }
    
        public void IniciarInterfazAtracciones(){
            fgui.abrirVentanaAtracciones();
        }
     
        public java.util.List<Atraccion> consultarCatalogoAtracciones(String nombre,Float alturaMin,Integer aforo){
            return fbd.consultarCatalogoAtracciones(nombre, alturaMin, aforo);
        }
        
        //abre la ventana para insertar atraccion
        public void nuevaAtraccion(VAtraccion va){
            fgui.abrirVentanaInsercionAtracciones(va);
        }
        
        //invoca al metodo para insertar una atraccion
         public void InsertarAtraccion(Atraccion a){
            fbd.insertarAtraccion(a);
        }
}
