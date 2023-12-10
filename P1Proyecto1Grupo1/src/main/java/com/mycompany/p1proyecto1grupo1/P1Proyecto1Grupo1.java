
package com.mycompany.p1proyecto1grupo1;
import java.io.FileNotFoundException; // se utiliza cuando se intenta abrir un archivo para lectura o escritura, pero el archivo no se encuentra en la ubicación especificada. 
import java.util.ArrayList;//representa una implementación de la interfaz List en Java.
import java.util.List; //define operaciones comunes para trabajar con listas, que son colecciones ordenadas de elementos.
import java.util.Scanner; //se utiliza para leer datos de diferentes fuentes, como la entrada estándar del teclado 

public class P1Proyecto1Grupo1 {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        P1Proyecto1Grupo1 C1 = new P1Proyecto1Grupo1(); //Instancia: acceder a variables de instancia o métodos no estáticos
        C1.cover();
        
    }
   
    public void  cover() {
        Scanner a = new Scanner (System.in);
    List <String> coverData = new ArrayList();
        coverData.add("Grupo: N. 1");
        coverData.add("Curso: 2DO A - ITIN");
        coverData.add("Fecha de entrega: 13/16/2023");
        coverData.add("Materia: POO");
        coverData.add("Tema: Pasteleria Online");
        coverData.add("Profesor: Ing. Veronica Martinez");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("U N I V E R S I D A D  D E  L A S  F U E R Z A S  A R M A D A S  ");
        System.out.println("                         E S P E                                 ");
        System.out.println("-----------------------------------------------------------------");
        for(int i=0; i<coverData.size(); i ++){
            System.out.println(coverData.get(i));
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println("               Caratula creada con colecciones                   ");
        int MenuPrincipal;
    do{
        System.out.println("-----------------------------------------------------------------");
        System.out.println("    P A S T E L E R I A  H U G O S  A L E G R I A  B A K E R Y   ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Ten una cordial bienvenida, ingresa la opcion que desees 1-2 c:  ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("                  1. REALIZA TU PEDIDO AQUI ");
        System.out.println("                  2. SALIR");
        MenuPrincipal = a.nextInt();
        a.nextLine(); 
        switch (MenuPrincipal){
            case 1:
                Customer C1 = new Customer ();
                C1.menuOrders();
                Bill F1 = new Bill();
                F1.askData();
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
