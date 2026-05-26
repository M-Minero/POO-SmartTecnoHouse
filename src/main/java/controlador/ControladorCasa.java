package controlador;

import modelo.*;
import vista.VistaConsola;
import java.util.List;

public class ControladorCasa {
    private CasaInteligente modelo;
    private VistaConsola vista;

    public ControladorCasa(CasaInteligente modelo, VistaConsola vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 5);
    }

    private void procesarOpcion(int opcion) {
        List<IDispositivo> lista = modelo.getDispositivos();

        switch (opcion) {
            case 1:
                vista.mostrarMensaje("\n=== ESTADO DE LA CASA: " + modelo.getNombre() + " ===");
                if (lista.isEmpty()) vista.mostrarMensaje("No hay dispositivos registrados.");
                for (int i = 0; i < lista.size(); i++) {
                    vista.mostrarMensaje(i + ". " + lista.get(i).getEstado());
                }
                break;

            case 2:
                int idxEncender = vista.leerInt("Número del dispositivo a encender: ");
                if (validarIndice(idxEncender, lista)) {
                    lista.get(idxEncender).encender();
                    vista.mostrarMensaje("Dispositivo encendido con éxito.");
                }
                break;

            case 3:
                int idxApagar = vista.leerInt("Número del dispositivo a apagar: ");
                if (validarIndice(idxApagar, lista)) {
                    lista.get(idxApagar).apagar();
                    vista.mostrarMensaje("Dispositivo apagado con éxito.");
                }
                break;

            case 4:
                int idxModificar = vista.leerInt("Número del dispositivo a modificar: ");
                if (validarIndice(idxModificar, lista)) {
                    IDispositivo disp = lista.get(idxModificar);
                    if (disp instanceof Sensor) {
                        double valor = vista.leerDouble("Introduzca nueva lectura del sensor: ");
                        ((Sensor) disp).actualizarLectura(valor);
                    } else if (disp instanceof Actuador) {
                        int intensidad = vista.leerInt("Introduzca intensidad (0-100): ");
                        ((Actuador) disp).setIntensidad(intensidad);
                    }
                }
                break;

            case 5:
                vista.mostrarMensaje("Saliendo del sistema domótico...");
                break;

            default:
                vista.mostrarMensaje("Opción no válida.");
        }
    }

    private boolean validarIndice(int idx, List<IDispositivo> lista) {
        if (idx >= 0 && idx < lista.size()) return true;
        vista.mostrarMensaje("Índice de dispositivo no válido.");
        return false;
    }

    // Método MAIN: Punto de partida de toda la aplicación
    public static void main(String[] args) {
        // 1. Instanciar el modelo con datos de prueba iniciales
        CasaInteligente miCasa = new CasaInteligente("Smart TecnoHouse - Sede Central");
        miCasa.añadirDispositivo(new Sensor("Termómetro", "Salón", "Temperatura"));
        miCasa.añadirDispositivo(new Actuador("Foco LED", "Cocina"));
        miCasa.añadirDispositivo(new Sensor("Detector de presencia", "Pasillo", "Presencia"));

        // 2. Instanciar la vista
        VistaConsola miVista = new VistaConsola();

        // 3. Crear el controlador y arrancar
        ControladorCasa app = new ControladorCasa(miCasa, miVista);
        app.iniciar();
    }
}