package modelo;

import java.util.ArrayList;
import java.util.List;

public class CasaInteligente {
    private String nombre;
    private List<IDispositivo> dispositivos;

    public CasaInteligente(String nombre) {
        this.nombre = nombre;
        this.dispositivos = new ArrayList<>();
    }

    public void añadirDispositivo(IDispositivo d) {
        dispositivos.add(d);
    }

    public List<IDispositivo> getDispositivos() {
        return dispositivos;
    }

    public String getNombre() {
        return nombre;
    }
}