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
import pojos.Visitante;

/**
 *
 * @author alumnogreibd
 */
public class DAOVisitantes extends AbstractDAO {

    public DAOVisitantes(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Visitante altaVisitante(Visitante visitante) {
        Connection con;
        PreparedStatement psVisitante = null;

        con = super.getConexion();

        try {
            psVisitante = con.prepareStatement("insert into Visitantes(dni, nome, nacionalidade, telefono, dataNacemento, altura) values (?, ?, ?, ?, ?, ?)");
            psVisitante.setString(1, visitante.getDNI());
            psVisitante.setString(2, visitante.getNombre());
            psVisitante.setString(3, visitante.getNacionalidad());
            psVisitante.setString(4, visitante.getTelefono());
            psVisitante.setDate(5, visitante.getFechaNacimiento());
            psVisitante.setFloat(6, visitante.getAltura());
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

        return visitante;
    }

    public Visitante bajaVisitante(String dni) {
        Connection con;
        PreparedStatement psVisitante = null;

        con = super.getConexion();

        try {
            psVisitante = con.prepareStatement("delete from Visitantes where dni = ?");
            psVisitante.setString(1, dni);
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

    public ArrayList<Visitante> consultarVisitantes() {

        Connection con;
        PreparedStatement psVisitante = null;
        ResultSet rsVisitante;
        Visitante resultado = null;
        ArrayList<Visitante> listaResultado = new ArrayList();
        con = super.getConexion();

        try {
            psVisitante = con.prepareStatement("select * from Visitantes");
            rsVisitante = psVisitante.executeQuery();

            while (rsVisitante.next()) {

                resultado = new Visitante(rsVisitante.getString("dni"), rsVisitante.getString("nome"), rsVisitante.getString("nacionalidade"), rsVisitante.getString("telefono"), rsVisitante.getDate("datanacemento"), rsVisitante.getFloat("altura"));
                listaResultado.add(resultado);
            }
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

        return listaResultado;
    }

    public ArrayList<Visitante> consultarVisitantes(String nombre) {

        Connection con;
        PreparedStatement psVisitante = null;
        ResultSet rsVisitante;
        Visitante resultado = null;
        ArrayList<Visitante> listaResultado = new ArrayList();
        con = super.getConexion();

        try {
            psVisitante = con.prepareStatement("select v.* from Visitantes v where v.nome like ?");
            psVisitante.setString(1, "%" + nombre + "%");
            rsVisitante = psVisitante.executeQuery();

            while (rsVisitante.next()) {

                resultado = new Visitante(rsVisitante.getString("dni"), rsVisitante.getString("nome"), rsVisitante.getString("nacionalidade"), rsVisitante.getString("telefono"), rsVisitante.getDate("datanacemento"), rsVisitante.getFloat("altura"));
                listaResultado.add(resultado);
            }
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

        return listaResultado;
    }

    public ArrayList<Visitante> consultarNacionalidades() {

        return null;
    }

    public ArrayList<Atraccion> consultarAtraccionesAltura(Visitante visitante) {
        Connection con;
        PreparedStatement psVisitante = null;
        ResultSet rsVisitante;
        Atraccion resultado = null;
        ArrayList<Atraccion> listaResultado = new ArrayList();
        con = super.getConexion();

        try {
            psVisitante = con.prepareStatement("select nombre, aforo, alturaMin, costeMantenimiento, ubicacion, descripcion from Atraccion where alturaMin < ?");
            psVisitante.setDouble(1, visitante.getAltura());
            rsVisitante = psVisitante.executeQuery();
            while (rsVisitante.next()) {
                resultado = new Atraccion(rsVisitante.getString("nombre"), rsVisitante.getInt("aforo"), rsVisitante.getFloat("alturaMin"), rsVisitante.getFloat("costeMantenimiento"), rsVisitante.getString("ubicacion"), rsVisitante.getString("descripcion"));
                listaResultado.add(resultado);
            }
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

        return listaResultado;
    }

    public ArrayList<Atraccion> consultarAtraccionesVisitadas(Visitante visitante) {
        Connection con;
        PreparedStatement psVisitante = null;
        ResultSet rsVisitante;
        Atraccion resultado = null;
        ArrayList<Atraccion> listaResultado = new ArrayList();
        con = super.getConexion();

        try {
            psVisitante = con.prepareStatement("select a.nombre, a.aforo, a.alturaMin, a.costeMantenimiento, a.ubicacion, a.descripcion from Atraccion a inner join ir i on a.nombre = i.atraccion where i.visitante = ?");
            psVisitante.setString(1, visitante.getDNI());
            rsVisitante = psVisitante.executeQuery();
            while (rsVisitante.next()) {
                resultado = new Atraccion(rsVisitante.getString("nombre"), rsVisitante.getInt("aforo"), rsVisitante.getFloat("alturaMin"), rsVisitante.getFloat("costeMantenimiento"), rsVisitante.getString("ubicacion"), rsVisitante.getString("descripcion"));
                listaResultado.add(resultado);
            }
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

        return listaResultado;
    }

    
    public ArrayList<Hotel> consultarHotelesVisitados(Visitante visitante) {
        Connection con;
        PreparedStatement psVisitante = null;
        ResultSet rsVisitante;
        Hotel resultado = null;
        ArrayList<Hotel> listaResultado = new ArrayList();
        con = super.getConexion();

        try {
            psVisitante = con.prepareStatement("select h.nombreEstablecimiento, h.ubicacion, h.aforo, h.estrellas from Hotel h inner join alojarse a on h.nombreEstablecimiento = a.establecimiento where a.visitante = ?");
            psVisitante.setString(1, visitante.getDNI());
            rsVisitante = psVisitante.executeQuery();
            while (rsVisitante.next()) {
                resultado = new Hotel(rsVisitante.getString("nomeEstablecimiento"), rsVisitante.getString("ubicacion"), rsVisitante.getInt("aforo"), rsVisitante.getInt("estrellas"));
                listaResultado.add(resultado);
            }
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

        return listaResultado;
    }

    public ArrayList<Restaurante> consultarRestaurantesVisitados(Visitante visitante) {
        Connection con;
        PreparedStatement psVisitante = null;
        ResultSet rsVisitante;
        Restaurante resultado = null;
        ArrayList<Restaurante> listaResultado = new ArrayList();
        con = super.getConexion();

        try {
            psVisitante = con.prepareStatement("select r.nombreEstablecimiento, r.ubicacion, r.aforo, r.horaIncio, r.horaFin from Restaurante e inner join comer c on r.nombreEstablecimiento = c.establecimiento where c.visitante = ?");
            psVisitante.setString(1, visitante.getDNI());
            rsVisitante = psVisitante.executeQuery();
            while (rsVisitante.next()) {
                resultado = new Restaurante(rsVisitante.getString("nombre"), rsVisitante.getString("ubicacion"), rsVisitante.getInt("aforo"), rsVisitante.getTime("horaIncio"), rsVisitante.getTime("horaFin"));
                listaResultado.add(resultado);
            }
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

        return listaResultado;
    }

    public ArrayList<Bono> consultarBonos() {

        return null;
    }
}
