package Logica;

public class Empresa {
    private String code;
    private String direccion;
    private String nombre;
    private String telefono;
    private String DirectorG;
    private String GerenteR;
    private String  SecretarioS;

    public Empresa(String code, String direccion, String nombre, String telefono,
                   String directorG,String gerenteR,String secretarioS) {
        setCode(code);
        setDireccion(direccion);
        setNombre(nombre);
        setTelefono(telefono);
        setDirectorG(directorG);
        setGerenteR(gerenteR);
        setSecretarioS(secretarioS);
    }

    public String getCode(){
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
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


    ////////////////////////////////////////////////////////////////////////////////
    public String getDirectorG() {
        return DirectorG;
    }

    public void setDirectorG(String directorG) {
        DirectorG = directorG;
    }

    public String getGerenteR() {
        return GerenteR;
    }

    public void setGerenteR(String gerenteR) {
        GerenteR = gerenteR;
    }

    public String getSecretarioS() {
        return SecretarioS;
    }

    public void setSecretarioS(String secretarioS) {
        SecretarioS = secretarioS;
    }

}
