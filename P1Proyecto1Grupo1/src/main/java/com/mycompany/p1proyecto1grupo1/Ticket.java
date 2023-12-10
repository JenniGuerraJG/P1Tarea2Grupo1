
package com.mycompany.p1proyecto1grupo1;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
public class Ticket extends SelfserviceTerminals{
      private String codeTicket;
    private LocalDateTime date; 
    //Constructor
    public Ticket(String codeTicket, LocalDateTime date, String name, String lastname, String identificacion, int clavedeAcceso) {
        super(name, lastname, identificacion, clavedeAcceso);
        this.codeTicket = codeTicket;
        this.date = date;
    }
    Ticket() {
       this.date = LocalDateTime.now();  
    }
    //Obtener fecha y hora actual
    public LocalDateTime getPurchaseDateTime() {
        return date;
    }
    //Crear un archivo y escribir en el 
    public void createFile() {
        try {
            FileWriter fileWriter = new FileWriter("Ticket.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Frente Ticket");
            bufferedWriter.newLine();
            bufferedWriter.write("========================");
            bufferedWriter.newLine();
            bufferedWriter.write("Hoy es: " + getDate());
            bufferedWriter.newLine();
            bufferedWriter.write("HUGOS ALEGRIA BAKERY");
            bufferedWriter.newLine();
            bufferedWriter.write("Su ticket es el N°");
            bufferedWriter.newLine();
            bufferedWriter.write("------------------------");
            bufferedWriter.newLine();
            bufferedWriter.write("          "+generateTicket());
            bufferedWriter.newLine();
            bufferedWriter.write("------------------------");
            bufferedWriter.newLine();
            bufferedWriter.write("Su clave de acceso es: " + getClavedeAcceso());
            bufferedWriter.newLine();
            bufferedWriter.write("Gracias por su compra :D");
            bufferedWriter.newLine();
            bufferedWriter.write("Hora de impresion " + getHour());
            bufferedWriter.newLine();
            bufferedWriter.write("========================");
            bufferedWriter.newLine();
            bufferedWriter.write("Espalda Ticket");
            bufferedWriter.newLine();
            logoPastry2(bufferedWriter);
            bufferedWriter.newLine();
            bufferedWriter.close();
            System.out.println("Ticket de retiro generado");
        } catch (IOException e) {
        }
    }
    //Leer el archivo que fue creado antes 
    public void readFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
            System.out.println("El archivo se creo en Ticket.txt y se leyó con éxito");
        } catch(IOException e) {
        }
    }
    //Separa para obtener solo la fecha actual en un formato especifico
     public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        return getPurchaseDateTime().format(formatter);
    }
     //Separa para obtener solo la hora actual en un formato especifico
     public String getHour() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return getPurchaseDateTime().format(formatter);
    }
     // Genera el numero de ticket el cual debe tener dos letras y dos numeros 
     public String generateTicket() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        char letra1 = letras.charAt(random.nextInt(letras.length()));
        char letra2 = letras.charAt(random.nextInt(letras.length()));
        int numero1 = random.nextInt(90) + 10;
        codeTicket = String.format("%c%c%d", letra1, letra2, numero1);
        return codeTicket;
    }

}
