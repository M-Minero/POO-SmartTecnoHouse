package modelo;

public class Sensor extends Dispositivo {
    private String tipo; // Ejemplo: "Temperatura", "Presencia"
    private double valorLectura;

    public Sensor(String nombre, String ubicacion, String tipo) {
        super(nombre, ubicacion);
        this.tipo = tipo;
        this.valorLectura = 0.0;
    }

    public void actualizarLectura(double nuevoValor) {
        if (estaEncendido()) {
            this.valorLectura = nuevoValor;
        } else {
            System.out.println("El sensor " + nombre + " está apagado. No se puede actualizar.");
        }
    }

    @Override
    public String getEstado() {
        String estadoEnergia = estaEncendido() ? "Encendido" : "Apagado";
        return "[Sensor " + tipo + "] " + nombre + " en " + ubicacion +
                " - Estado: " + estadoEnergia + " - Lectura: " + valorLectura;
    }

    // Getters y Setters
    public String getTipo() { return tipo; }
    public double getValorLectura() { return valorLectura; }}