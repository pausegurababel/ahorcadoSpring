package es.neesis.annotations.services;

import java.util.List;

public interface IAhorcado {

    String elegirPalabra(List<String> palabras);

    String generarEstadoInicial(String palabra);

    String cambiarEstado(int i);
    void verEstado();
    void verIntentos();

    void restarIntentos();

    boolean comprobarCaracter(String c);

    boolean comprobarPalabra(String word);

    void menu();

    void game();
}
