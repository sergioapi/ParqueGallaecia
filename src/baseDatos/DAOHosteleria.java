/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import java.sql.Connection;
//cambio
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import pojos.Restaurante;
import pojos.Visitante;
import pojos.Hotel;
import aplicacion.FachadaAplicacion;
import java.time.LocalDate;

/**
 *
 * @author alumnogreibd
 */
public class DAOHosteleria extends AbstractDAO{

    public DAOHosteleria (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    

    public java.util.List<Restaurante> consultarRestauracion(String nombre, Integer aforo, Time hora){
        java.util.List<Restaurante> resultado = new java.util.ArrayList<Restaurante>();
        Restaurante restauranteActual;
        Connection con;
        PreparedStatement stmRestauracion=null;
        ResultSet rsRestauracion;
        PreparedStatement stmTrabajadores=null;
        ResultSet rsTrabajadores;

        con=this.getConexion();

        
        String consulta = "select * " +
                            "from restaurantes as r "+
                            "where nombreestablecimiento like ? ";
        if (aforo != null)
            consulta = consulta + " and aforo >= ? ";
        if (hora!=null){
            consulta = consulta + "and ? >= horainicio " +
                                   "and ? <= horafin ";
        }
        try  {
         stmRestauracion=con.prepareStatement(consulta);
         stmRestauracion.setString(1, "%"+nombre+"%");
         if(aforo!=null){
             stmRestauracion.setInt(2, aforo.intValue());
         }
         if(hora!=null){
             if(aforo != null){
                stmRestauracion.setTime(3, hora);
                stmRestauracion.setTime(4, hora);
             }
             else if(aforo == null){
                stmRestauracion.setTime(2, hora);
                stmRestauracion.setTime(3, hora);
             }
         }
         rsRestauracion=stmRestauracion.executeQuery();
        while (rsRestauracion.next())
        {
            restauranteActual = new Restaurante(rsRestauracion.getString("nombreestablecimiento"), rsRestauracion.getString("ubicacion"),
                                      rsRestauracion.getInt("aforo"), rsRestauracion.getTime("horainicio"),
                                      rsRestauracion.getTime("horafin"));
            try {
            stmTrabajadores = con.prepareStatement("select nombre "+
                                              "from hosteleros h "+
                                              "where restaurante = ? ");
            stmTrabajadores.setString(1, restauranteActual.getNombreEstablecimiento());
            rsTrabajadores=stmTrabajadores.executeQuery();
            while (rsTrabajadores.next())
            {
                //hay que hacer método y arrayList de trabajadores en la clase Restaurante
                 restauranteActual.addEmpleado(rsTrabajadores.getString("nombre"));
            }
            }catch (SQLException e){
              System.out.println(e.getMessage());
              //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            } finally {
              stmTrabajadores.close();
            }
            resultado.add(restauranteActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmRestauracion.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    
     //consulta para saber el restaurante que tuvo más afluencia entre dos fechas concretas
     //lo hacemos con una lista por si pudiese darse el caso de que hubiese más de uno (empate)
     public java.util.List<Restaurante> restauranteMasExitoso(Date fechaInicio, Date fechaFin){
        java.util.List<Restaurante> resultado = new java.util.ArrayList<Restaurante>();
        Restaurante restauranteActual;
        Connection con;
        PreparedStatement stmRestauracion=null;
        ResultSet rsRestauracion;

        con=this.getConexion();
        
        String consulta = "select r.nombreestablecimiento, count(*)/cast(cast(? as date) - cast(? as date) as float) as num_medio_clientes_al_dia " +
                            "from restaurantes r, comer c " +
                            "where r.nombreestablecimiento = c.establecimiento " +
                            "	and c.fecha >= ? " +
                            "	and c.fecha <= ? " +
                            "group by r.nombreestablecimiento " +
                            "having count(*)>=all(select count(*) " +
                            "					from restaurantes r2, comer c2 " +
                            "					where r2.nombreestablecimiento = c2.establecimiento " +
                            "						and c2.fecha >= ? " +
                            "						and c2.fecha <= ?" +
                            "					group by r2.nombreestablecimiento) ";
        try  {
         stmRestauracion=con.prepareStatement(consulta);
         stmRestauracion.setDate(1, fechaFin);
         stmRestauracion.setDate(2, fechaInicio);
         stmRestauracion.setDate(3, fechaInicio);
         stmRestauracion.setDate(4, fechaFin);
         stmRestauracion.setDate(5, fechaInicio);
         stmRestauracion.setDate(6, fechaFin);
         rsRestauracion=stmRestauracion.executeQuery();
        while (rsRestauracion.next())
        {
            restauranteActual = new Restaurante(rsRestauracion.getString("nombreestablecimiento"), null, null, null, null);
            restauranteActual.setMedia_clientes(rsRestauracion.getFloat("num_medio_clientes_al_dia"));
            resultado.add(restauranteActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmRestauracion.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
     
     
     public void insertarRestaurante(Restaurante restaurante){
        Connection con;
        PreparedStatement stmRestaurante=null;

        con=super.getConexion();

        try {
        stmRestaurante=con.prepareStatement("INSERT INTO restaurantes "+
                                      "values (?,?,?,?,?)");
        stmRestaurante.setString(1, restaurante.getNombreEstablecimiento());
        stmRestaurante.setString(2, restaurante.getUbicacion());
        stmRestaurante.setInt(3, restaurante.getAforo().intValue());
        stmRestaurante.setTime(4, restaurante.getHoraInicio());
        stmRestaurante.setTime(5,restaurante.getHoraFin());
        stmRestaurante.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmRestaurante.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
     
     public void borrarRestaurante(String nombreRestaurante){
        Connection con;
        PreparedStatement stmRestaurante=null;

        con=super.getConexion();

        try {
        stmRestaurante=con.prepareStatement("delete from restaurantes where nombreestablecimiento = ?");
        stmRestaurante.setString(1, nombreRestaurante);
        stmRestaurante.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmRestaurante.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
     
     public void insertarCliente(Visitante c, String restaurante){
         Connection con;
        PreparedStatement stmVisitante=null;
        PreparedStatement stmComer=null;

        con=super.getConexion();

        try {
        stmVisitante=con.prepareStatement("INSERT INTO visitantes "+
                                      "values (?,?,?,?,?,?)");
        stmVisitante.setString(1, c.getDNI());
        stmVisitante.setString(2, c.getNombre());
        stmVisitante.setString(3, c.getNacionalidad());
        stmVisitante.setString(4, c.getTelefono());
        stmVisitante.setDate(5,c.getFechaNacimiento());
        stmVisitante.setFloat(6,c.getAltura());
        stmVisitante.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmVisitante.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        LocalDate fechaJava = LocalDate.now();
        Date fechaSql = Date.valueOf(fechaJava);
        try {
        stmComer=con.prepareStatement("INSERT INTO comer "+
                                      "values (?,?,?)");
        stmComer.setDate(1, fechaSql);
        stmComer.setString(2, c.getDNI());
        stmComer.setString(3, restaurante);
        stmComer.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmComer.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
     }
     
     //consulta para saber los clientes que acudieron a un restaurante en una fecha concreta
     //obtenemos el dni,  nombre y número de teléfono para poder enviar publicidad personalizada
     public java.util.List<Visitante> clientesRestaurante(Restaurante restaurante, Date fecha){
        java.util.List<Visitante> resultado = new java.util.ArrayList<Visitante>();
        Visitante visitanteActual;
        Connection con;
        PreparedStatement stmVisitantes=null;
        ResultSet rsVisitantes;

        con=this.getConexion();
        
        String consulta = "select v.nome, v.telefono" +
                            "from restaurantes r , comer c, visitantes v" +
                            "where r.nombreestablecimiento = c.establecimiento" +
                            "	and c.visitante = v.dni" +
                            "	and r.nombreestablecimiento = ?" +
                            "	and c.fecha = ?";
        try  {
         stmVisitantes=con.prepareStatement(consulta);
         stmVisitantes.setString(1, restaurante.getNombreEstablecimiento());
         stmVisitantes.setDate(2, fecha);
         rsVisitantes=stmVisitantes.executeQuery();
        while (rsVisitantes.next())
        {
            visitanteActual = new Visitante(rsVisitantes.getString("dni"), rsVisitantes.getString("nome"), null, rsVisitantes.getString("telefono"), null, 0, 0);
            resultado.add(visitanteActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmVisitantes.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
     
     
     //se pasan los argumentos que puede introducir el usuario para buscar
     public java.util.List<Hotel> consultarHoteles(String nombre, Integer aforo, Integer estrellas){
        java.util.List<Hotel> resultado = new java.util.ArrayList<Hotel>();
        Hotel hotelActual;
        Connection con;
        PreparedStatement stmHoteles=null;
        ResultSet rsHoteles;
        PreparedStatement stmTrabajadores=null;
        ResultSet rsTrabajadores;
        con=this.getConexion();
        
        String consulta = "select * " +
                            "from hoteles h "+
                            "where nombreestablecimiento like ?";
        if (aforo != null){
            consulta = consulta + " and aforo >= ? ";
        }
        //if (estrellas!=null){
            consulta = consulta +  "and estrellas = ? ";
        //}
        try  {
         stmHoteles=con.prepareStatement(consulta);
         stmHoteles.setString(1, "%"+nombre+"%");
         if(aforo!=null){
             stmHoteles.setInt(2, aforo.intValue());
         }
         if(estrellas!=null){
             if(aforo!=null){
                 stmHoteles.setInt(3, estrellas.intValue());
             }
             else{
                 stmHoteles.setInt(2, estrellas.intValue());
             }
             
         }
         rsHoteles=stmHoteles.executeQuery();
        while (rsHoteles.next())
        {
            hotelActual = new Hotel(rsHoteles.getString("nombreestablecimiento"), rsHoteles.getString("ubicacion"),
                                      rsHoteles.getInt("aforo"), rsHoteles.getInt("estrellas"));
            try {
            stmTrabajadores = con.prepareStatement("select nombre "+
                                              "from hosteleros h "+
                                              "where hotel = ?");
            stmTrabajadores.setString(1, hotelActual.getNombreEstablecimiento());
            rsTrabajadores=stmTrabajadores.executeQuery();
            while (rsTrabajadores.next())
            {
                //hay que hacer método y arrayList de trabajadores en la clase Hotel
                 hotelActual.addEmpleado(rsTrabajadores.getString("nombre"));
            }
            }catch (SQLException e){
              System.out.println(e.getMessage());
              //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            } finally {
              stmTrabajadores.close();
            }
            resultado.add(hotelActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmHoteles.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
     
     
     //consulta para saber el restaurante que tuvo más afluencia entre dos fechas concretas
     //lo hacemos con una lista por si pudiese darse el caso de que hubiese más de uno (empate)
     public java.util.List<Hotel> hotelMasExitoso(Date fechaInicio, Date fechaFin){
        java.util.List<Hotel> resultado = new java.util.ArrayList<Hotel>();
        Hotel hotelActual;
        Connection con;
        PreparedStatement stmHoteles=null;
        ResultSet rsHoteles;

        con=this.getConexion();
        
        String consulta = "select h.nombreestablecimiento, count(*)/cast(cast('2024-06-10' as date) - cast('2023-11-22'as date) as float) as num_medio_clientes_al_dia" +
                           "from hoteles h, alojarse a" +
                           "where h.nombreestablecimiento = a.hotel " +
                           "	and a.fechallegada >= '2023-11-22' " +
                           "	and a.fechallegada <= '2024-06-10'" +
                           "group by h.nombreestablecimiento" +
                           "having count(*)>=all(select count(*)" +
                           "					from hoteles h2, alojarse a2" +
                           "					where h2.nombreestablecimiento = a2.hotel" +
                           "						and a2.fechallegada >= '2023-11-22' " +
                           "						and a2.fechallegada <= '2024-06-10'" +
                           "					group by h2.nombreestablecimiento)";
        try  {
         stmHoteles=con.prepareStatement(consulta);
         stmHoteles.setDate(1, fechaFin);
         stmHoteles.setDate(2, fechaInicio);
         stmHoteles.setDate(3, fechaInicio);
         stmHoteles.setDate(4, fechaFin);
         stmHoteles.setDate(5, fechaInicio);
         stmHoteles.setDate(6, fechaFin);
         rsHoteles=stmHoteles.executeQuery();
        while (rsHoteles.next())
        {
            hotelActual = new Hotel(rsHoteles.getString("nombreestablecimiento"), null, null, null);
            hotelActual.setMedia_clientes(rsHoteles.getFloat("num_medio_clientes_al_dia"));
            resultado.add(hotelActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmHoteles.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }     
     
     
     public void insertarHotel(Hotel hotel){
        Connection con;
        PreparedStatement stmHotel=null;

        con=super.getConexion();

        try {
        stmHotel=con.prepareStatement("INSERT INTO hoteles "+
                                      "values (?,?,?,?)");
        stmHotel.setString(1, hotel.getNombreEstablecimiento());
        stmHotel.setString(2, hotel.getUbicacion());
        stmHotel.setInt(3, hotel.getAforo().intValue());
        stmHotel.setInt(4, hotel.getEstrellas().intValue());

        stmHotel.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmHotel.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
     
     public void borrarHotel(String nombre){
        Connection con;
        PreparedStatement stmHotel=null;

        con=super.getConexion();

        try {
        stmHotel=con.prepareStatement("delete from hoteles where nombreestablecimiento = ?");
        stmHotel.setString(1, nombre);
        stmHotel.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmHotel.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
     
     public void insertarHuesped(Visitante c, String hotel, Date fechaSalida){
         Connection con;
        PreparedStatement stmVisitante=null;
        PreparedStatement stmAlojarse=null;

        con=super.getConexion();

        try {
        stmVisitante=con.prepareStatement("INSERT INTO visitantes "+
                                      "values (?,?,?,?,?,?)");
        stmVisitante.setString(1, c.getDNI());
        stmVisitante.setString(2, c.getNombre());
        stmVisitante.setString(3, c.getNacionalidad());
        stmVisitante.setString(4, c.getTelefono());
        stmVisitante.setDate(5,c.getFechaNacimiento());
        stmVisitante.setFloat(6,c.getAltura());
        stmVisitante.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmVisitante.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        LocalDate fechaJava = LocalDate.now();
        Date fechaSql = Date.valueOf(fechaJava);
        try {
        stmAlojarse=con.prepareStatement("INSERT INTO alojarse "+
                                      "values (?,?,?, ?)");
        //se considera fecha de llegada el dia en que se hizo la inserción
        stmAlojarse.setDate(1, fechaSql);
        stmAlojarse.setString(2, c.getDNI());
        stmAlojarse.setString(3, hotel);
        stmAlojarse.setDate(4, fechaSalida);
        stmAlojarse.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmAlojarse.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
     }
     
     
}
