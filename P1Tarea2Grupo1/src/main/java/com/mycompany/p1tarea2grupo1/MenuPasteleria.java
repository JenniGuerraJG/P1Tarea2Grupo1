
package com.mycompany.p1tarea2grupo1;
import java.util.*;

public class MenuPasteleria {
    public  double TotalAPagar = 0.0;
    public void CartaPasteles(){
           Scanner scanner = new Scanner(System.in);
        String[] Productos = {"Pastel de chocolate ", "Pasteles de cumpleanios", "Tortas mojadas", "Croissant"};
        int[] CantidadesCompradas = new int[Productos.length]; 
        double[] Precios = {10.0, 12.0, 15.0, 3.0};
       
        int NumeroProducto;
        System.out.println("----------------------------------------------------------------------");
        System.out.println(" M E N U: P A S T E L E R I A  H U G O S  A L E G R I A  B A K E R Y  ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Selecciona la cantidad de producto que desee:                      c: ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Se mostraran los productos con un arreglo unidimensional              ");
        System.out.println("----------------------------------------------------------------------");
        for (int i = 0; i < Productos.length; i++) {
            System.out.print(i+")");
            System.out.println(Productos[i]);
        }
       
        System.out.println("Ingrese la cantidad del producto que va a comprar(no puede ser mayor a 5): ");
        System.out.println("Si no desea seleccione 0 ");
        
        for (int i = 0; i < Productos.length; i++) {
            System.out.print(i+")");
            System.out.print(Productos[i]+": ");
            NumeroProducto = scanner.nextInt();
            
            while(NumeroProducto<0 || NumeroProducto>5){
                System.out.print("La cantidad de producto no es valida, intente nuevamente (0 - 5): ");
                NumeroProducto = scanner.nextInt();
            }
            CantidadesCompradas[i] = NumeroProducto;
            TotalAPagar += NumeroProducto * Precios[i];
            System.out.println("------------------------------------------------------");         
        }
        

        System.out.println("Total a pagar: $" + TotalAPagar);
        
        String nombre;
        String apellido;
        int diaEntrega;
        int mesEntrega;
        String correoElectronico;
        String ciudad;
        String direccion;
        String telefono;

        Scanner entrada = new Scanner(System.in);

        System.out.println("---------------------------------------------------");
        System.out.println("                     FACTURA                       ");
        System.out.println("---------------------------------------------------");
        System.out.println("INGRESE SU NOMBRE");
        nombre = entrada.nextLine();
        nombre = nombre.toUpperCase();

        System.out.println("INGRESE SU APELLIDO");
        apellido = entrada.nextLine();
        apellido = apellido.toUpperCase();

        System.out.println("INGRESE MES DE ENTREGA 1-12");
        mesEntrega = entrada.nextInt();
        while (mesEntrega <= 0 || mesEntrega > 12) {
            System.out.println("ERROR SOLO INGRESE DE 1-12");
            mesEntrega = entrada.nextInt();
        }

        System.out.println("INGRESE DIA DE ENTREGA 1-31");
        diaEntrega = entrada.nextInt();
        while (diaEntrega <= 0 || diaEntrega > 31) {
            System.out.println("ERROR SOLO INGRESE DE 1-31");
            diaEntrega = entrada.nextInt();
        }

        if ((mesEntrega == 4 || mesEntrega == 6 || mesEntrega == 9 || mesEntrega == 11) && diaEntrega > 30) {
            System.out.println("ERROR, EN " + mesEntrega + " SOLO HAY 30 DÍAS. INGRESE UN DÍA VÁLIDO (1-30):");
            diaEntrega = entrada.nextInt();
        } else if (mesEntrega == 2 && diaEntrega > 29) {
            System.out.println("ERROR, EN FEBRERO SOLO HAY 29 DÍAS. INGRESE UN DÍA VÁLIDO (1-29):");
            diaEntrega = entrada.nextInt();
        }

        // Consumir el carácter de nueva línea
        entrada.nextLine();
        
        System.out.println("INGRESE SU CORREO DE GMAIL ponga el @gmail.com");
        correoElectronico = entrada.nextLine();
        if (!correoElectronico.toLowerCase().endsWith("@gmail.com")) {
            System.out.println("ERROR, EL CORREO DEBE SER UNA DIRECCIÓN DE GMAIL. ASEGÚRESE DE TERMINAR CON @gmail.com");
            correoElectronico = entrada.nextLine();
            System.exit(0);
        }
         entrada.nextLine();
        System.out.println("INGRESE LA CIUDAD DE ENVIO RECUERDE QUE SOLO HAY ENVIOS A SD, VALLE HERMOSO Y LUZ DE AMERICA");
        ciudad = entrada.nextLine();
        if (!(ciudad.equalsIgnoreCase("SD") || ciudad.equalsIgnoreCase("VALLE HERMOSO") || ciudad.equalsIgnoreCase("LUZ DE AMERICA"))) {
            System.out.println("ERROR, LA CIUDAD DE ENVÍO DEBE SER SD, VALLE HERMOSO O LUZ DE AMERICA");
            ciudad = entrada.nextLine();
            System.exit(0);
        }
         entrada.nextLine();
        System.out.println("INGRESE LA DIRECCION");
        direccion = entrada.nextLine();

        System.out.println("INGRESE SU NUMERO DE TELEFONO SOLO 10 DIGITOS");
        telefono = entrada.nextLine();
        while (telefono.length() != 10 || !telefono.matches("\\d+")) {
        System.out.println("ERROR, INGRESE UN NUMERO DE TELEFONO VÁLIDO CON 10 DIGITOS:");
        telefono = entrada.next();
        System.out.println("Resumen de la compra:");

        for (int i = 0; i < Productos.length; i++) {
            if (CantidadesCompradas[i] > 0) {
                System.out.println(Productos[i] + ": " + CantidadesCompradas[i] + " unidades - Total: $" + (CantidadesCompradas[i] * Precios[i]));
            }
        } 
            }
        Factura F1 = new Factura(nombre,apellido, diaEntrega,mesEntrega,correoElectronico,ciudad,direccion,telefono);
        F1.Datosfactura ();
        F1.CrearArchivoFactura("Factura.txt", TotalAPagar, Productos, CantidadesCompradas, Precios);
        
     

}
}
