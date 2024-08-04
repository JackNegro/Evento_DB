package Logica;

import java.util.ArrayList;

public class Cliente extends Persona{
    private boolean TratoPreferencial;
    private ArrayList<Evento> eventosAnteriores;

    public Cliente(String nombre, String primerApellido, String segundoApellido, String direccion,
                   String telefono, String email,
                   boolean tratoPreferencial,
                   ArrayList<Evento> eventosAnteriores) {
        super(nombre, primerApellido, segundoApellido, direccion, telefono, email);
        setTratoPreferencial(tratoPreferencial);
        this.eventosAnteriores = new ArrayList<>();
    }

    public boolean isTratoPreferencial() {
        return TratoPreferencial;
    }

    public void setTratoPreferencial(boolean tratoPreferencial) {
        TratoPreferencial = tratoPreferencial;
    }

    public void addEvento(Evento e){
        eventosAnteriores.add(e);
    }

    public ArrayList<Evento> getEventosAnteriores() {
        return eventosAnteriores;
    }

}
