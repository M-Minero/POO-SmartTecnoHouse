package modelo;

public class Actuador extends Dispositivo {
    private int intensidad; // Rango de 0 a 100

    public Actuador(String nombre, String ubicacion) {
        super(nombre, ubicacion);
        this.intensidad = 0;
    }

    public void setIntensidad(int nuevaIntensidad) {
        if (!estaEncendido()) {
            System.out.println("El actuador " + nombre + " está apagado. Enciéndalo primero.");
            return;
        }
        if (nuevaIntensidad >= 0 && nuevaIntensidad <= 100) {
            this.intensidad = nuevaIntensidad;
        } else {
            System.out.println("La intensidad debe estar entre 0 y 100.");
        }
    }

    @Override
    public void apagar() {
        super.apagar();
        this.intensidad = 0; // Al apagar, la intensidad vuelve a cero
    }

    @Override
    public String getEstado() {
        String estadoEnergia = estaEncendido() ? "Encendido" : "Apagado";
        return "[Actuador] " + nombre + " en " + ubicacion +
                " - Estado: " + estadoEnergia + " - Intensidad: " + intensidad + "%";
    }

    // Getter
    public int getIntensidad() { return intensidad; }
}