package Logica;
import java.util.ArrayList;

public class Empresa {
    private String direccion;
    private String nombre;
    private String telefono;
    private Empleado DirectprG;
    private Empleado GerenteR;
    private Empleado SecretarioS;
    private ArrayList<Contrato> contratoes;
    private ArrayList<Empleado> empleados;

    public Empresa(String direccion, String nombre, String telefono,
                   Empleado directprG, Empleado gerenteR,
                   Empleado secretarioS) {
        setDireccion(direccion);
        setNombre(nombre);
        setTelefono(telefono);
        contratoes = new ArrayList<>();
        empleados = new ArrayList<>();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Empleado getDirectprG() {
        return DirectprG;
    }

    public void setDirectprG(Empleado directprG) {
        DirectprG = directprG;
    }

    public Empleado getGerenteR() {
        return GerenteR;
    }

    public void setGerenteR(Empleado gerenteR) {
        GerenteR = gerenteR;
    }

    public Empleado getSecretarioS() {
        return SecretarioS;
    }

    public void setSecretarioS(Empleado secretarioS) {
        SecretarioS = secretarioS;
    }

    public ArrayList<Contrato> getContratoes() {
        return contratoes;
    }

    public void setContratoes(ArrayList<Contrato> contratoes) {
        this.contratoes = contratoes;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }
}
