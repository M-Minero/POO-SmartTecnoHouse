package vista;

import java.util.Scanner;

public class VistaConsola {
    private Scanner scanner;

    public VistaConsola() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n--- SMART TECNOHOUSE ---");
        System.out.println("1. Mostrar estado de los dispositivos");
        System.out.println("2. Encender un dispositivo");
        System.out.println("3. Apagar un dispositivo");
        System.out.println("4. Modificar intensidad de actuador / lectura de sensor");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public int leerOpcion() {
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, introduzca un número válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        scanner.nextLine(); // Limpiar el búfer
        return scanner.nextLine();
    }

    public double leerDouble(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.print("Valor numérico inválido. Intente de nuevo: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public int leerInt(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Entero inválido. Intente de nuevo: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}