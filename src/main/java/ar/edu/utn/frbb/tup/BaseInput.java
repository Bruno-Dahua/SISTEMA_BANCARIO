package ar.edu.utn.frbb.tup;

import java.util.Scanner;
public class BaseInput {
    
    protected static Scanner scanner = new Scanner(System.in);

    protected static void clearScreen(){
        System.out.println("\033^[H\033[2J");
        System.out.flush();
    }

    protected static void esperarEnter(){
        System.out.println("Preciona Enter para continuar...");
        scanner.nextLine();
    }
}
