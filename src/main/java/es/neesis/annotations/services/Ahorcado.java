package es.neesis.annotations.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Service
public class Ahorcado implements IAhorcado {

    private final List<String> palabras = List.of("Buhardilla","Murmullo","Estribillo","Carril","Bisbiseo","Travesaño","Enigma","Susurro","Penumbra","Remolino");
    private int intentos = 8;

    private Scanner keyboard;

    private String palabraAdivinar = "";

    private String estado = "";

    public Ahorcado() {
        this.palabraAdivinar = elegirPalabra(this.palabras);
        this.estado = generarEstadoInicial(this.palabraAdivinar);
        keyboard = new Scanner(System.in);
    }

    @Override
    public String elegirPalabra(List<String> palabras){

        Random random = new Random();
        int indiceAleatorio = random.nextInt(palabras.size());

        return palabras.get(indiceAleatorio);

    }

    @Override
    public String generarEstadoInicial(String palabraAdivinar){

        StringBuilder estado = new StringBuilder();

        for(int i = 0; i < palabraAdivinar.length(); i++ ){
            estado.append("_");
        }

        return estado.toString();

    }
    @Override
    public String cambiarEstado(int i){
        char []  estadoArray = this.estado.toCharArray();
        estadoArray[i] = this.palabraAdivinar.charAt(i);
        this.estado = new String(estadoArray);
        return this.estado;
    }

    @Override
    public void verEstado(){
        System.out.println(this.estado);
    }

    @Override
    public void verIntentos(){
        System.out.println(this.intentos);
    }

    @Override
    public void restarIntentos(){
        this.intentos -= 1;
    }

    @Override
    public boolean comprobarCaracter(String c){
        boolean coincidencia = false;
        for (int i = 0; i < this.palabraAdivinar.length(); i++){
            if (Character.toString(this.palabraAdivinar.charAt(i)).equalsIgnoreCase(c)){
                coincidencia = true;
                cambiarEstado(i);
            }
        }
        return coincidencia;
    }

    @Override
    public boolean comprobarPalabra(String word) {
        if(word.equalsIgnoreCase(this.palabraAdivinar)){
            return true;
        }
        return false;
    }

    public void menu(){
        System.out.println("Bienvenido al ahorcado");
        System.out.println("Que quieres hacer?\n" +
                "1. Jugar\n" +
                "2. Salir");
    }

    public void game(){
        boolean partida = false;
        System.out.println(this.estado);
        while(!partida && this.intentos > 0){
            System.out.println("Inserta tu letra o palabra");
            String guess = keyboard.next();
            if (guess.length() == 1){
                if (!comprobarCaracter(guess)){
                    restarIntentos();
                }
            }else{
                if(!comprobarPalabra(guess)){
                    restarIntentos();
                }else{
                    System.out.println("Palabra correcta!!!");
                    System.out.println(guess);
                    this.estado = this.palabraAdivinar;
                    partida = true;
                }
            }

            if (comprobarPalabra(this.estado)){
                System.out.println("Palabra correcta!!!");
                verEstado();
                partida = true;
            }else{
                System.out.println("Estado de la palabra: ");
                verEstado();
                System.out.println("Intentos restantes: ");
                verIntentos();
            }


        }
    }
}
