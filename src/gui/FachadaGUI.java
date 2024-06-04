
package gui;

/**
 *
 * @author alumnogreibd
 */
public class FachadaGUI {

    aplicacion.FachadaAplicacion fa;
    VPrincipal vp;

    public FachadaGUI(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
        this.vp = new VPrincipal(fa);
    }

    public void abrirVentanaPrincipal() {
        vp.setVisible(true);
    }

    public void muestraExcepcion(String txtExcepcion) {
       /* VAviso va;

        va  = new VAviso(vp, true, txtExcepcion);
        va.setVisible(true);*/
    }
    
    public void abrirVentanaRestaurantes(){
        VRestaurantes vr;
        vr = new VRestaurantes(vp, fa);
        vr.setVisible(true);
    }
    
    public void abrirVentanaHoteles(){
        VHoteles vh;
        
        vh = new VHoteles(vp, fa);
        vh.setVisible(true);
    }
    
    public void abrirVentanaExitos(VRestaurantes vr){
        VÉxitos ve;
        
        ve = new VÉxitos(vr, fa);
        ve.setVisible(true);
    }
    
    public void abrirVentanaInsertarCliente(VRestaurantes vr, String nombreRestaurante){
        VInsertarCliente vic;
        
        vic = new VInsertarCliente(vr, fa, nombreRestaurante);
        vic.setVisible(true);
    }
    
    public void abrirVentanaInsertarHuesped(VHoteles vh, String hotel){
        VInsertarHuesped vih;
        
        vih = new VInsertarHuesped(vh, fa,hotel);
        vih.setVisible(true);
    }
    
    public void abrirVentanaAtracciones() {
        VAtraccion va;
        
        va  = new VAtraccion(vp, fa);
        va.setVisible(true);
    }

    public void abrirVentanaInsercionAtracciones(VAtraccion va) {
        VInsertarAtraccion vInsA;
        vInsA = new VInsertarAtraccion(va,fa );
        vInsA.setVisible(true);
    }
    
    public void abrirVentanaVisitantes() {
        VVisitantes vv;
        vv = new VVisitantes(fa, vp);
        vv.setVisible(true);
    }
    
    public void abrirVentanaEmpleados() {
        VEmpleado vEmpl;
        vEmpl = new VEmpleado(fa, vp);
        vEmpl.setVisible(true);
    }
}
