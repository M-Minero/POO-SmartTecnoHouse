package modelo;

public abstract class Dispositivo implements IDispositivo {
    protected String nombre;
    protected String ubicacion;
    protected boolean encendido;

    public Dispositivo(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.encendido = false; // Por defecto inician apagados
    }

    @Override
    public void encender() {
        this.encendido = true;
    }

    @Override
    public void apagar() {
        this.encendido = false;
    }

    @Override
    public boolean estaEncendido() {
        return this.encendido;
    }

    // Métodos Getters y Setters
    public String getNombre() { return nombre; }
    public String getUbicacion() { return ubicacion; }}