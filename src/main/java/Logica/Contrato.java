package Logica;

import java.util.Date;

public class Contrato {
    private String codeEvento;
    private String codeServicio;
    private float precioNegociado;
    private Date cronogramaPago;
    private String condiciones;

    public Contrato(String  codeEvento, String codeServicio, float precioNegociado,
                    Date cronogramaPago, String condiciones) {
        setEvento(codeEvento);
        setServicio(codeServicio);
        setPrecioNegociado(precioNegociado);
        setCondiciones(condiciones);
        setCronogramaPago(cronogramaPago);
    }

    public String getEvento() {
        return codeEvento;
    }

    public void setEvento(String  codeEvento) {
        this.codeEvento = codeEvento;
    }

    public String getServicio() {
        return codeServicio;
    }

    public void setServicio(String  servicio) {
        this.codeServicio = codeServicio;
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
