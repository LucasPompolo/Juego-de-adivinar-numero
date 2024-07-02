package juego;
import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException; //La consigna no lo pedia pero decidi agregar InputMismatchException para evitar que el jugador escriba una letra, me acorde q en el primer parcial lo pidio, trate de hacerlo pero tenia errores

public class AdivinaElNumero {
    private static final int MAX_INTENTOS = 5; //MAX_INTENTOS y RANGO son constantes q defienen cuantos intentos tiene el jugador para adivinar el numero, ambas pueden ser modificadas
    private static final int RANGO = 10;  //En el caso de RANGO esta en 10 para hacer pruebas rapidas
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(); //Aca se crea un numero aleatorio q el jugador debe adivinar
        int numeroAleatorio = random.nextInt(RANGO) + 1; //Comienza desde el 1 hasta donde se haya decidio en la constante RANGO
        int intentosRestantes = MAX_INTENTOS;
        boolean adivinado = false;  
        System.out.println("(っ◔◡◔)っ ADIVINA EL NUMERO"); //Desde aca empieza lo que el usuario va a ver en la consola, busque caritas caritas echas con caracteres en internet para q se vea un poco mejor la consola y no sea tan basica
        System.out.println("\nAcabo de elegir un numero del 1 al " + RANGO + ". Haber si podes adivinar cual es, desde ahora tenes " + MAX_INTENTOS + " intentos para tratar de adivinarlo.");
        while (intentosRestantes > 0 && !adivinado) {
            System.out.print("\nIngresa el numero que crees que elegi: ");
            try {
                int intento = scanner.nextInt();              
                if (intento == numeroAleatorio) {
                    System.out.println("\nFelicidades, encontraste el numero ＼(＾▽＾)／");
                    adivinado = true;
                }else if (intento < numeroAleatorio) {
                    System.out.println("\nEse numero es bajo (≖.≖) proba de nuevo.");
                }else {
                    System.out.println("\nEse numero es alto (⁀⊙﹏☉⁀) proba de nuevo.");
                }
                intentosRestantes--;                
                if (!adivinado) {
                    System.out.println("Te quedan " + intentosRestantes + " intentos restantes (ㆆ_ㆆ)");
                }
            }catch (InputMismatchException e) {
                System.out.println("\nDije numeros, no letras (͡•͜ʖ͡•)");
                System.out.println("Intenta de nuevo.");
                scanner.next(); 
            }
        }        
        if (!adivinado) { //Este es ultimo mensaje en caso de q el jugador no adivine el nuero
            System.out.println("\nParece que yo gano esta vez ʕ•́ᴥ•̀ʔ el numero era " + numeroAleatorio + " suerte pa la proxima.");
        }
        scanner.close();
    }}