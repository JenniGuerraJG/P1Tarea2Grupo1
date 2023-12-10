
package com.mycompany.p1proyecto1grupo1;
import java.io.BufferedWriter; // escribir texto en un flujo de salida de caracteres (Writer) con un búfer.
import java.io.IOException; //representa una excepción de tipo E/S (Entrada/Salida). 
import java.util.Random; // generar números aleatorios
public class SelfserviceTerminals {
    public String name;  //modificadores de acceso de la clase madre
    public String lastname;
    public String identificacion;
    public int clavedeAcceso;
    public SelfserviceTerminals(String name, String lastname, String identificacion,  int clavedeAcceso) {
        this.name = name;
        this.lastname = lastname;
        this.identificacion = identificacion;
        this.clavedeAcceso = clavedeAcceso;
    }
    //  acceder y modificar los atributos (propiedades) de un objeto. Estos métodos permiten la encapsulación
    SelfserviceTerminals() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;             // Establecer un nuevo valor para un atributo (propiedad).
    }
    public String getLastname() {
        return lastname;             //Obtener el valor actual de un atributo (propiedad).
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public int getClavedeAcceso() {
        return clavedeAcceso;
    }
    public void setClavedeAcceso(int clavedeAcceso) {
        this.clavedeAcceso = clavedeAcceso;
    }    
    public void accessKey (){
        Random random = new Random();                                         //Obtener un numero random 
        clavedeAcceso = random.nextInt(1000000001) + 1000000000;
        System.out.println("Clave de acceso: " + clavedeAcceso);      
    }
    
    public void logoPastry(){
                System.out.println("                      -----------------------------------                ");
                System.out.println("                      -----------------------------------                ");
                System.out.println("                                     .---.");
                System.out.println("                                    /     \\");
                System.out.println("                                   |       |");
                System.out.println("                                    \\     /");        //logo de la pasteleria
                System.out.println("                                     '---'");
                System.out.println("                                     /\\_/\\ ");
                System.out.println("                                    ( o.o )");
                System.out.println("                                     > ^ < ");
                System.out.println("                                    /  |  \\ ");
                System.out.println("                                   |   |   | ");
                System.out.println("                                    \\ | | / ");
                System.out.println("                                     ( | ) ");
                System.out.println("                      ¡Delicias que alegran tu paladar!        ");
                System.out.println("                     -----------------------------------                ");
                System.out.println("                     -----------------------------------                ");
    }
    
     public void logoPastry2(BufferedWriter bufferedWriter) throws IOException {
    bufferedWriter.write("   -----------------------------------                ");
    bufferedWriter.newLine();
    bufferedWriter.write("   -----------------------------------                ");
    bufferedWriter.newLine();
    bufferedWriter.write("                 .---.");
    bufferedWriter.newLine();
    bufferedWriter.write("                /     \\");             //logo de la pasteleria con BufferedWriter
    bufferedWriter.newLine();                                          // buffer: zona de almacenamiento temporal
    bufferedWriter.write("               |       |");
    bufferedWriter.newLine();
    bufferedWriter.write("                \\     /");
    bufferedWriter.newLine();
    bufferedWriter.write("                 '---'");
    bufferedWriter.newLine();
    bufferedWriter.write("                /\\_/\\ ");
    bufferedWriter.newLine();
    bufferedWriter.write("               ( o.o )");
    bufferedWriter.newLine();
    bufferedWriter.write("                > ^ < ");
    bufferedWriter.newLine();
    bufferedWriter.write("               /  |  \\ ");
    bufferedWriter.newLine();
    bufferedWriter.write("              |   |   | ");
    bufferedWriter.newLine();
    bufferedWriter.write("              \\ | | / ");
    bufferedWriter.newLine();
    bufferedWriter.write("                ( | ) ");
    bufferedWriter.newLine();
    bufferedWriter.write("    ¡Delicias que alegran tu paladar!        ");
    bufferedWriter.newLine();
    bufferedWriter.write("   -----------------------------------                ");
    bufferedWriter.newLine();
    bufferedWriter.write("   -----------------------------------                ");
    bufferedWriter.newLine();
}
}
