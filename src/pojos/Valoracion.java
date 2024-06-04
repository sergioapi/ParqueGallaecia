/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.util.Date;

/**
 *
 * @author alumnogreibd
 */
public class Valoracion {

    private int id;
    private String nombreAtraccion;
    private String usuario;
    private int puntuacion;
    private String comentario;
    private Date fecha;

    public Valoracion(int id, String nombreAtraccion, String usuario, int puntuacion, String comentario, Date fecha) {
        this.id = id;
        this.nombreAtraccion = nombreAtraccion;
        this.usuario = usuario;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public String getNombreAtraccion() {
        return nombreAtraccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public Date getFecha() {
        return fecha;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNombreAtraccion(String nombreAtraccion) {
        this.nombreAtraccion = nombreAtraccion;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    
    

}
