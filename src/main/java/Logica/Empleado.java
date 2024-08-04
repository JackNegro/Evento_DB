package Logica;

public class Empleado extends Persona{
    private String cargo;
    private String departamento;

    public Empleado(String nombre, String primerApellido,
                    String segundoApellido, String direccion,
                    String telefono, String email, String cargo, String departamento) {
        super(nombre, primerApellido, segundoApellido, direccion, telefono, email);
        setCargo(cargo);
        setDepartamento(departamento);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
