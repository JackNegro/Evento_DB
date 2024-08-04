package Logica;

import java.util.Date;

public class Contrato {
    private Evento evento;
    private Servicio servicio;
    private float precioNegociado;
    private Date cronogramaPago;
    private String condiciones;

    public Contrato(Evento evento, Servicio servicio, float precioNegociado,
                    Date cronogramaPago, String condiciones) {
        setEvento(evento);
        setServicio(servicio);
        setPrecioNegociado(precioNegociado);
        setCondiciones(condiciones);
        setCronogramaPago(cronogramaPago);
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public float getPrecioNegociado() {
        return precioNegociado;
    }

    public void setPrecioNegociado(float precioNegociado) {
        this.precioNegociado = precioNegociado;
    }

    public Date getCronogramaPago() {
        return cronogramaPago;
    }

    public void setCronogramaPago(Date cronogramaPago) {
        this.cronogramaPago = cronogramaPago;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }
}
