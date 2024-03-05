package es.neesis.annotations.applications;

import es.neesis.annotations.services.Ahorcado;
import es.neesis.annotations.services.IAhorcado;
import org.springframework.stereotype.Component;

@Component
public class ConstructorApplication {

    private final IAhorcado ahorcado;

    public ConstructorApplication(){
        this.ahorcado = new Ahorcado();
    }

    public String cambiarEstado(int i){
        return ahorcado.cambiarEstado(i);
    }
    public void verEstado(){
        ahorcado.verEstado();
    }
    public void verIntentos(){
        ahorcado.verIntentos();
    }
    public void restarIntentos(){
        ahorcado.restarIntentos();
    }

    public boolean comprobarCaracter(String c){
        return ahorcado.comprobarCaracter(c);
    }

    public boolean comprobarPalabra(String word){
        return ahorcado.comprobarPalabra(word);
    }

    public void menu(){
        ahorcado.menu();
    }
    public void game(){
        ahorcado.game();
    }

}
