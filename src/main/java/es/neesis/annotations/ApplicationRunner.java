package es.neesis.annotations;

import es.neesis.annotations.configuration.AppConfig;
import es.neesis.annotations.applications.ConstructorApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConstructorApplication constructorApplication = context.getBean(ConstructorApplication.class);
        constructorApplication.menu();

        int num = keyboard.nextInt();
        while (num == 1){
            constructorApplication.game();
            constructorApplication.menu();
            num = keyboard.nextInt();
            context = new AnnotationConfigApplicationContext(AppConfig.class);
            constructorApplication = context.getBean(ConstructorApplication.class);
        }
        System.out.println("Saliendo del juego!");

    }
}
