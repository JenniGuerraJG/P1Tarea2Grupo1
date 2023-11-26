package com.mycompany.p1tarea2grupo1;
import java.util.Scanner;

public class P1Tarea2Grupo1 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String Caratula [][] = new String [3][2];
        Caratula [0][0] = ("Grupo: N. 1");
        Caratula [0][1] = ("Curso: 2DO A - ITIN");
        Caratula [1][0] = ("Fecha de entrega: 13/16/2023");
        Caratula [1][1] = ("Materia: POO");
        Caratula [2][0] = ("Tema: Pasteleria Online");
        Caratula [2][1] = ("Profesor: Ing. Veronica Martinez");
        
        System.out.println("-----------------------------------------------------------------");
        System.out.println("U N I V E R S I D A D  D E  L A S  F U E R Z A S  A R M A D A S  ");
        System.out.println("                         E S P E                                 ");
        System.out.println("-----------------------------------------------------------------");
        for (int i = 0; i < Caratula.length; i++) {
            for (int j = 0; j < Caratula[i].length; j++) {
                System.out.println(Caratula[i][j]);
            }
        }
        int MenuPrincipal;
        System.out.println("-----------------------------------------------------------------");
        System.out.println("          Caratula creada con un arreglo bidimensional           ");
        do{
        System.out.println("-----------------------------------------------------------------");
        System.out.println("    P A S T E L E R I A  H U G O S  A L E G R I A  B A K E R Y   ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Ten una cordial bienvenida, ingresa la opcion que desees 1-2 c:  ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("1. INGRESAR AL MENU");
        System.out.println("2. SALIR");
        MenuPrincipal = entrada.nextInt();
        switch (MenuPrincipal){
            case 1:
                MenuPasteleria menu = new MenuPasteleria();
                    menu.CartaPasteles();
                break;
            case 2:
            System.out.println("------------------      LA PASTELERIA  --------------------------");
            System.out.println("    P A S T E L E R I A  H U G O S  A L E G R I A  B A K E R Y   ");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("      Te da las gracias por tu visita, vuelve pronto :D          ");
            System.out.println("-----------------------------------------------------------------");
                break;
            default: 
                System.out.println("-----------------------------------------------------------------");
                System.out.println("                 LA OPCION QUE ELEGISTE ES ERRONEA               ");
                System.out.println("-----------------------------------------------------------------");
                System.out.println("                  Ingresa una opcion del 1 al 2                  ");
                System.out.println("-----------------------------------------------------------------");
                break;
        }
  
        }while(MenuPrincipal != 2); 
        
    }

   
}