package Logica;

public class Servicio {
    private String code;
    private String nombre;
    private String descripcion;
    private String categoria;
    private float precio;
    private String tipoServicio;

    public Servicio(String code, String nombre, String descripcion, String categoria,
                    float precio, String tipoServicio) {
        setCode(code);
        setNombre(nombre);
        setDescripcion(descripcion);
        setCategoria(categoria);
        setPrecio(precio);
        setTipoServicio(tipoServicio);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

}
