package modelo;

public interface IDispositivo {
    void encender();
    void apagar();
    boolean estaEncendido();
    String getEstado();}