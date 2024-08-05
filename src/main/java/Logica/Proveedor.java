package Logica;

public class Proveedor extends Persona{
    String codeServicio;

    public Proveedor(String code, String nombre, String primerApellido,
                     String segundoApellido,
                     String direccion, String telefono,
                     String email, String codeServicio) {
        super(code,nombre, primerApellido, segundoApellido, direccion, telefono, email);
        setServicio(codeServicio);
    }

    public String getServicio() {
        return codeServicio;
    }

    public void setServicio(String  codeServicio) {
        this.codeServicio = codeServicio;
    }
}
