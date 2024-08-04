package Logica;

public class Proveedor extends Persona{
    Servicio servicio;

    public Proveedor(String nombre, String primerApellido,
                     String segundoApellido,
                     String direccion, String telefono,
                     String email, Servicio servicio) {
        super(nombre, primerApellido, segundoApellido, direccion, telefono, email);
        setServicio(servicio);
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
