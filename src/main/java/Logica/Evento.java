package Logica;

import java.sql.*;

public class Evento {
    private String nombre;
    private String tipo;
    //revisar esto se puede usar toString() para las fechas/hora pero no estoy seguro
    private String fecha;
    private Time horaInicio;
    private Time horaFin;
    private String ubicacion;
    private int numInvitados;
    private String conceptoDecoracion;
    private Empleado responsable;

    public Evento(String nombre, String tipo, String fecha, Time horaInicio,
                  Time horaFin, String ubicacion, int numInvitados,
                  String conceptoDecoracion, Empleado responsable) {
        setFecha(fecha);
        setNombre(nombre);
        setTipo(tipo);
        setHoraInicio(horaInicio);
        setHoraFin(horaFin);
        setConceptoDecoracion(conceptoDecoracion);
        setNumInvitados(numInvitados);
        setResponsable(responsable);
        setUbicacion(ubicacion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getNumInvitados() {
        return numInvitados;
    }

    public void setNumInvitados(int numInvitados) {
        this.numInvitados = numInvitados;
    }

    public String getConceptoDecoracion() {
        return conceptoDecoracion;
    }

    public void setConceptoDecoracion(String conceptoDecoracion) {
        this.conceptoDecoracion = conceptoDecoracion;
    }

    public Empleado getResponsable() {
        return responsable;
    }

    public void setResponsable(Empleado responsable) {
        this.responsable = responsable;
    }
}
