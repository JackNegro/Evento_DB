package Logica;

import java.util.ArrayList;

public class Cliente extends Persona{
    private boolean TratoPreferencial;

    public Cliente(String code,String nombre, String primerApellido, String segundoApellido, String direccion,
                   String telefono, String email, boolean tratoPreferencial) {
        super(code,nombre, primerApellido, segundoApellido, direccion, telefono, email);
        setTratoPreferencial(tratoPreferencial);
    }

    public boolean isTratoPreferencial() {
        return TratoPreferencial;
    }

    public void setTratoPreferencial(boolean tratoPreferencial) {
        TratoPreferencial = tratoPreferencial;
    }

}
