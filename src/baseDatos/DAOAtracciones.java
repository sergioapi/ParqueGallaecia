package baseDatos;

import java.sql.Connection;
import pojos.Atraccion;
import pojos.Empleado;
import pojos.Empleado;

import pojos.Visitante;
import java.util.HashMap;
import java.util.Set;
import pojos.Valoracion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashSet;

/**
 *
 * @author alumnogreibd
 */
public class DAOAtracciones extends AbstractDAO {

    //constructor
    public DAOAtracciones(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    //metodos
    public void insertarAtraccion(Atraccion a){
        Connection con;
        PreparedStatement stmAtraccion=null;

        con=super.getConexion();

        try {
        stmAtraccion=con.prepareStatement("INSERT INTO atracciones "+
                                      "values (?,?,?,?,?,?)");
        stmAtraccion.setString(1, a.getNombre());
        stmAtraccion.setInt(2, a.getAforo());
        stmAtraccion.setFloat(3, a.getAlturaMin());
        stmAtraccion.setFloat(4, a.getCosteMantenimiento());
        stmAtraccion.setString(5, a.getUbicacion());
        stmAtraccion.setString(6, a.getDescripcion());

        stmAtraccion.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmAtraccion.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    public void eliminarAtraccion(String nombre){
        Connection con;
        PreparedStatement stmAtraccion=null;

        con=super.getConexion();

        try {
        stmAtraccion=con.prepareStatement("delete from atracciones where nombre = ?");
        stmAtraccion.setString(1, nombre);
        stmAtraccion.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmAtraccion.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

    

    public ArrayList<Atraccion> consultarAtracciones() {
        final String AtraccionCons = "SELECT * FROM atraccions";
        PreparedStatement atraccion = null;
        Connection con = this.getConexion();
        ArrayList<Atraccion> atracciones = new ArrayList<>();

        try {
            atraccion = con.prepareStatement(AtraccionCons);
            ResultSet rs = atraccion.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int aforo = rs.getInt("aforo");
                Float alturaMin = rs.getFloat("alturaMin");
                Float custoMantenimiento = rs.getFloat("custoMantenimiento");
                String ubicacion = rs.getString("ubicacion");
                String descripcion = rs.getString("descripcion");

                Atraccion atraccionActual = new Atraccion(nombre, aforo, alturaMin, custoMantenimiento, ubicacion, descripcion);
                atracciones.add(atraccionActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (atraccion != null) {
                try {
                    atraccion.close();
                } catch (SQLException ex) {
                    System.out.println("Imposible cerrar cursores");
                }
            }
        }

        return atracciones;
    }

    public java.util.List<Atraccion> consultarCatalogoAtracciones(String nombre, Float alturaMin, Integer aforo) {
        java.util.List<Atraccion> resultado = new java.util.ArrayList<Atraccion>();
        Atraccion atraccionActual = null;
        Connection con = this.getConexion();
        if (con == null) {
            System.out.println("Error de conexión: no se puede conectar a la base de datos.");
            return null; // o lanzar una excepción, imprimir un mensaje de error, etc.
        }
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        String consulta = "select * "
                + "from atracciones as l "
                + "where nombre like ? ";

        if (alturaMin != null) {
            consulta = consulta + " and alturamin <= ? ";
        }

        if (aforo != null) {
            consulta = consulta + " and aforo>=? ";
        }

        try {
            stmCatalogo = con.prepareStatement(consulta);
            stmCatalogo.setString(1, "%" + nombre + "%");
            if (alturaMin != null) {
                stmCatalogo.setFloat(2, alturaMin);
            }
            if (aforo != null) {
                if(alturaMin!=null){
                    stmCatalogo.setInt(3, aforo);
                }
                else{
                    stmCatalogo.setInt(2, aforo);
                }
            }
            rsCatalogo = stmCatalogo.executeQuery();
            while (rsCatalogo.next()) {
                String nombreCons = rsCatalogo.getString("nombre");
                int aforoCons = rsCatalogo.getInt("aforo");
                Float alturaMinCons = rsCatalogo.getFloat("alturamin");
                Float costeMantenimiento = rsCatalogo.getFloat("costemantenimiento");
                String ubicacion = rsCatalogo.getString("ubicacion");
                String descripcion = rsCatalogo.getString("descripcion");

                atraccionActual = new Atraccion(nombreCons, aforoCons, alturaMinCons, costeMantenimiento, ubicacion, descripcion);
                resultado.add(atraccionActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                stmCatalogo.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public HashMap<String, Double> consultarAtraccionesMasExitosas() {
        final String AtraccionCons = "SELECT atraccion, AVG(puntuacion) AS promedio_valoracion "
                + "FROM valoracion "
                + "GROUP BY atraccion "
                + "ORDER BY promedio_valoracion DESC";
        final String Atraccionget = "Select * from Atraccion where nombre =?";
        PreparedStatement valoraciones = null;
        PreparedStatement atraccion;
        Connection con = this.getConexion();
        HashMap<String, Double> atraccionesMasExitosas = new HashMap<>();

        try {
            valoraciones = con.prepareStatement(AtraccionCons);
            ResultSet rs = valoraciones.executeQuery();

            while (rs.next()) {
                String nombreAtraccion = rs.getString("atraccion");
                double promedio = rs.getDouble("promedio_valoracion");
                System.out.println(nombreAtraccion + ": " + promedio);

                //ahora obtenemos la atraccion
                /*atraccion = con.prepareStatement(Atraccionget);
            atraccion.setString(1, nombreAtraccion);
            ResultSet rsAtraccion = atraccion.executeQuery();
            if(rsAtraccion.next()){
                String nombre = rsAtraccion.getString("nombre");
            int aforo = rsAtraccion.getInt("aforo");
            double alturaMin = rsAtraccion.getDouble("alturaMin");
            double custoMantenimiento = rsAtraccion.getDouble("custoMantenimiento");
            String ubicacion = rsAtraccion.getString("ubicacion");
            String descripcion = rsAtraccion.getString("descripcion");

            Atraccion atraccionActual = new Atraccion(nombre, aforo, alturaMin, custoMantenimiento, ubicacion, descripcion);
            
            }*/
                atraccionesMasExitosas.put(nombreAtraccion, promedio);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (valoraciones != null) {
                try {
                    valoraciones.close();
                } catch (SQLException ex) {
                    System.out.println("Imposible cerrar cursores");
                }
            }
        }
        return atraccionesMasExitosas;
    }

    public ArrayList<Valoracion> consultarValoracionesAtraccion(String nombre) {
        final String consultaAtraccion = "SELECT * FROM atraccions WHERE nombre = ?";
        final String consultaValoracion = "SELECT * FROM valoracion WHERE atraccion = ?";
        PreparedStatement stmtAtraccion = null;
        PreparedStatement stmtValoracion = null;
        Connection con = this.getConexion();
        ArrayList<Valoracion> valoraciones = new ArrayList<>();

        try {
            // Consultar la atracción correspondiente al nombre
            stmtAtraccion = con.prepareStatement(consultaAtraccion);
            stmtAtraccion.setString(1, nombre);
            ResultSet rsAtraccion = stmtAtraccion.executeQuery();

            Atraccion atraccion = null;
            if (rsAtraccion.next()) {
                String nombre_atraccion = rsAtraccion.getString("nombre");
                Integer aforo = rsAtraccion.getInt("aforo");
                Float alturaMin = rsAtraccion.getFloat("alturaMin");
                Float custoMantenimiento = rsAtraccion.getFloat("custoMantenimiento");
                String ubicacion = rsAtraccion.getString("ubicacion");
                String descripcion = rsAtraccion.getString("descripcion");

                atraccion = new Atraccion(nombre_atraccion, aforo, alturaMin, custoMantenimiento, ubicacion, descripcion);
            }

            // Consultar las valoraciones de la atracción
            stmtValoracion = con.prepareStatement(consultaValoracion);
            stmtValoracion.setString(1, nombre);
            ResultSet rsValoracion = stmtValoracion.executeQuery();

            while (rsValoracion.next()) {
                int id = rsValoracion.getInt("id");
                String usuario = rsValoracion.getString("usuario");
                int puntuacion = rsValoracion.getInt("puntuacion");
                String comentario = rsValoracion.getString("comentario");
                Date fecha = rsValoracion.getDate("fecha");

                Valoracion valoracionActual = new Valoracion(id, atraccion.getNombre(), usuario, puntuacion, comentario, fecha);
                valoraciones.add(valoracionActual);

                System.out.println("Usuario: " + usuario);
                System.out.println("Puntuación: " + puntuacion);
                System.out.println("Comentario: " + comentario);
                System.out.println("Fecha: " + fecha);
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (stmtAtraccion != null) {
                try {
                    stmtAtraccion.close();
                } catch (SQLException ex) {
                    System.out.println("Imposible cerrar cursores");
                }
            }
            if (stmtValoracion != null) {
                try {
                    stmtValoracion.close();
                } catch (SQLException ex) {
                    System.out.println("Imposible cerrar cursores");
                }
            }
        }
        return valoraciones;
    }

    public HashMap<Atraccion, Set<Visitante>> consultarVisitantesdeAtracciones(Date fecha) {
        String consulta = "SELECT a.*, v.* "
                + "FROM atraccions a "
                + "JOIN ir i ON a.nombre = i.atraccion "
                + "JOIN visitantes v ON i.visitante = v.dni "
                + "WHERE i.dataVisita = ? "
                + "ORDER BY a.nombre;";

        HashMap<Atraccion, Set<Visitante>> visitantesPorAtraccion = new HashMap<>();
        Connection con = this.getConexion();
        try {
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setDate(1, fecha);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                Integer aforo = rs.getInt("aforo");
                Float alturaMin = rs.getFloat("alturaMin");
                Float custoMantenimiento = rs.getFloat("custoMantenimiento");
                String ubicacion = rs.getString("ubicacion");
                String descripcion = rs.getString("descripcion");
                Atraccion atraccion = new Atraccion(nombre, aforo, alturaMin, custoMantenimiento, ubicacion, descripcion);

                Visitante visitante = new Visitante(rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("nacionalidade"),
                        rs.getString("telefono"),
                        rs.getDate("dataNacemento"),
                        rs.getInt("altura"));

                Set<Visitante> visitantes = visitantesPorAtraccion.computeIfAbsent(atraccion, k -> new HashSet<>());
                visitantes.add(visitante);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return visitantesPorAtraccion;
    }

    public ArrayList<Empleado> consultarTrabajadores(String nombre_Atraccion) {
        final String consulta = "SELECT * FROM traballadoresParque WHERE nombreAtraccion = ?";
        PreparedStatement stmt = null;
        Connection con = this.getConexion();
        ArrayList<Empleado> trabajadores = new ArrayList();
        try {
            stmt = con.prepareStatement(consulta);
            stmt.setString(1, nombre_Atraccion);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String rua = rs.getString("rua");
                int numero = rs.getInt("numero");
                String cp = rs.getString("cp");
                String localidade = rs.getString("localidade");
                double salario = rs.getDouble("salario");
                String telefono = rs.getString("telefono");
                Date dataInicio = rs.getDate("dataInicio");
                Date dataNacemento = rs.getDate("dataNacemento");
                String formacion = rs.getString("formacion");
                String nombreAtraccion = rs.getString("nombreAtraccion");
                String nombreEspectaculo = rs.getString("nombreEspectaculo");

                //Empregado.Direccion dir;
                //dir = new Empleado.Direccion(rua, numero, cp, localidade);
                //Traballador trabajadorActual = new Trabajador(dni,nombre,new Empleado.Direccion(rua, numero, cp, localidade),salario,telefono,dataInicio,dataNacemento,formacion,
                //nombreAtraccion,nombreEspectaculo);
                System.out.println("DNI: " + dni);
                System.out.println("Nombre: " + nombre);
                System.out.println("Dirección: " + rua + " " + numero + ", " + cp + " " + localidade);
                System.out.println("Salario: " + salario);
                System.out.println("Teléfono: " + telefono);
                System.out.println("Fecha de inicio: " + dataInicio);
                System.out.println("Fecha de nacimiento: " + dataNacemento);
                System.out.println("Formación: " + formacion);
                System.out.println("Nombre de atracción: " + nombreAtraccion);
                System.out.println("Nombre de espectáculo: " + nombreEspectaculo);
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.out.println("Imposible cerrar cursores");
                }
            }
        }
        return trabajadores;
    }

    public void insertarVisita(Date fechaVisita, String dniVisitante, String nombreAtraccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = this.getConexion();
            String sql1 = "SELECT * FROM visitantes WHERE dni = ?";
            stmt = conn.prepareStatement(sql1);
            stmt.setString(1, dniVisitante);
            rs = stmt.executeQuery();
            if (!rs.next()) {
                throw new SQLException("El visitante no existe en la base de datos");
            }
            String sql2 = "SELECT * FROM atracciones WHERE nombre = ?";
            stmt = conn.prepareStatement(sql2);
            stmt.setString(1, nombreAtraccion);
            rs = stmt.executeQuery();
            if (!rs.next()) {
                throw new SQLException("La atracción no existe en la base de datos");
            }
            String sql3 = "INSERT INTO ir (fechaVisita, visitante, atraccion) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql3);
            stmt.setDate(1, fechaVisita);
            stmt.setString(2, dniVisitante);
            stmt.setString(3, nombreAtraccion);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.out.println("Imposible cerrar cursores");
                }
            }

        }
    }

}
