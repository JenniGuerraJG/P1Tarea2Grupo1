
package com.mycompany.p1proyecto1grupo1;
import java.io.BufferedReader; //leer texto de un flujo de entrada de caracteres
import java.io.FileReader; // leer caracteres de un archivo de texto.
import java.io.FileWriter;  //escribir caracteres en un archivo. FileWriter es útil para realizar operaciones de escritura en un archivo de texto.
import java.io.IOException; //anejar las excepciones relacionadas con operaciones de archivo y E/S.
import java.io.PrintWriter; //escribir texto formateado a un flujo de salida de caracteres. 
import java.util.Scanner;
public class Customer {
    Scanner a = new Scanner (System.in); //modificadores de acceso
    protected String [] products =  { "Croissant","Eclair","Baguette"};  //arreglos estaticos
    protected String [] code =  { "120022","174322","106752"};       
    protected double [] price = {1.20,4.00,3.50};
    private int [] quantityProducts; //arreglo dinamico
    protected double totalPrice;        
    public void menuOrders()  { 
        System.out.println("-----------------------------------------------------------------");
        System.out.println("                     B I E N V E N I D O  A  L A                 ");
        System.out.println("    P A S T E L E R I A  H U G O S  A L E G R I A  B A K E R Y   ");
        System.out.println("-----------------------------------------------------------------");
        SelfserviceTerminals ST = new SelfserviceTerminals();
        ST.logoPastry();
        System.out.println("Nuestros productos disponibles son:   ");
        for (int i = 0; i < products.length; i++) {        //imprension del arreglo estatico
            System.out.println(i + ") Productos: " + products[i] + " | Codigo: " + code[i] + " | Precio: $" + price[i]); 
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Los productos,codigos y  precios se estan almacenando en un arreglo: ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Digita la cantidad que desees de cada uno de 0 unidades a 20: ");
        System.out.println("-----------------------------------------------------------------");
        quantityProducts = new int[products.length]; //crea un nuevo array de enteros llamado quantityProducts con la misma longitud que el array existente products

        for (int i = 0; i < products.length; i++) {
            System.out.println(i + ") Productos: " + products[i]); //impresion del arreglo y pedir datos para llenar el arreglo quantityProducts
            quantityProducts[i] = a.nextInt();

            while (quantityProducts[i] < 0 || quantityProducts[i] > 20) {
                System.out.println("-----------------------------------------------------------------");
                System.out.println("                   ERROR INGRESE DE 0 A 20               ");
                System.out.println("-----------------------------------------------------------------");
                quantityProducts[i] = a.nextInt();
            }
            totalPrice += quantityProducts[i] * price[i];
        }
        productsOrderedCSV();
    }
    
  public void productsOrderedCSV() { //Generar un CSV
    String archive = "productsOrdered.csv";
    try {
        // Eliminar el contenido anterior del archivo CSV
        new FileWriter(archive, false).close();
        // Crear un nuevo contenido y escribirlo en el archivo CSV
        try (FileWriter fileWriter = new FileWriter(archive, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println("           ------------------      RAMEN CAT     --------------------------");
            printWriter.println("                            V e n d i n g  M a c h i n e   ");
            printWriter.println("          -----------------------------------------------------------------");
            printWriter.println("                        R E S U M E N  D E  L A  C O M P R A               ");
            printWriter.println("          -----------------------------------------------------------------");
            for (int i = 0; i < products.length; i++) {
                printWriter.println(products[i] + "," + " - Cantidad: " + "," + quantityProducts[i] + "," + " Precio unitario: $" + "," + price[i]);
            }

            printWriter.println("-----------------------------------------------------------------");
            printWriter.println("Total a pagar: $" + totalPrice);
        }

        System.out.println("-----------------------------------------------------------------");
        System.out.println("El archivo se creó en: " + archive);
        System.out.println("-----------------------------------------------------------------");

    } catch (IOException e) {
        e.printStackTrace();
    }

    try {
        FileReader fileReader = new FileReader("productsOrdered.csv"); //objeto se utilizará para leer caracteres del archivo.
        if (fileReader.ready()) { //Verifica si el FileReader está listo para realizar la lectura.  EL READY DEVUELVE UN true si, si
            BufferedReader lector = new BufferedReader(fileReader); // envuelve el FileReader. Esto mejora la eficiencia de lectura al proporcionar un búfer 
            String line;
            while ((line = lector.readLine()) != null) { //lee al archivo hasta que este vacio
                System.out.println(line);
            }
            System.out.println("El archivo productsOrdered.csv se leyó con éxito");  
        } else {

        }
    } catch (IOException e) {// Captura y maneja cualquier excepción de tipo IOException que pueda ocurrir durante la lectura del archivo
        e.printStackTrace();
    }
    confirmOrder();
}
    
public void confirmOrder() {
    System.out.println("-----------------------------------------------------------------");
    System.out.println("Desea confirmar la orden(s/n)?: ");
    System.out.println("-----------------------------------------------------------------");
    String SN = a.nextLine();
    SN = SN.toLowerCase();
    while (!SN.equals("s") && !SN.equals("n")) {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Solo s/n: ");
        System.out.println("-----------------------------------------------------------------");
        SN = a.nextLine();
        SN = SN.toLowerCase();
    }
    if (SN.equals("s")) {
        Bill F1 = new Bill();
        F1.askData();
    } else {
        System.out.println("Saliendo...");
        P1Proyecto1Grupo1 C1 = new P1Proyecto1Grupo1();
        C1.cover();
    }
}   
}
