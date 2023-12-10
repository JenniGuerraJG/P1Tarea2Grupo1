
package com.mycompany.p1proyecto1grupo1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONObject; //De las librerias JSON: Se utilizan para trabajar con datos en formato JSON, tanto para analizar JSON proveniente de una fuente externa como para construir y generar JSON.
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class Bill extends SelfserviceTerminals {
    Scanner scanner = new Scanner(System.in);
        private String telephone;
        private String mail;
        private String address;
        private double total;
    public Bill(String telephone, String mail, String address, double total, String name, String lastname, String identificacion, int clavedeAcceso) {
        super(name, lastname, identificacion, clavedeAcceso);
        this.telephone = telephone;
        this.mail = mail;
        this.address = address;
        this.total = total;
    }
    Bill() {
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public void askData() {        
       System.out.println("           ------------------      RAMEN CAT     --------------------------");
       System.out.println("                            V e n d i n g  M a c h i n e   ");
       System.out.println("          -----------------------------------------------------------------");
       System.out.println("                      D A T O S  P A R A  L A  F A C T U R A               ");
       System.out.println("          -----------------------------------------------------------------");
       System.out.println("          Ingrese nombre del cliente: ");
       name = scanner.nextLine();
       name = name.toLowerCase();
       System.out.println("          Ingrese apellido del cliente: ");
       lastname = scanner.nextLine();
       lastname = lastname.toLowerCase();
       System.out.println("          Ingrese cedula del cliente: ");
       identificacion = scanner.nextLine();
        while (identificacion.length() != 10 || !identificacion.matches("\\d+")) {
        System.out.println("ERROR, INGRESE UN NUMERO DE CEDULA VÁLIDO CON 10 DIGITOS:");
        identificacion = scanner.nextLine();
        scanner.nextLine(); }
        do {
            System.out.println("      Ingrese telefono del cliente: ");
            telephone = scanner.nextLine();
        } while (!telephone.matches("09\\d{8}") || telephone.length() != 10);
         System.out.println("          Ingrese direccion del cliente: ");
        address = scanner.nextLine();
        address = address.toLowerCase();
        System.out.println("           ------------------      RAMEN CAT     --------------------------");
        System.out.println("                            V e n d i n g  M a c h i n e   ");
        System.out.println("          -----------------------------------------------------------------");
        System.out.println("                                 F A C T U R A               ");
        System.out.println("          -----------------------------------------------------------------");
        invoicePrintingJSON();
        SelfserviceTerminals ST = new SelfserviceTerminals();
        ST.logoPastry();
        Ticket T1 = new Ticket();
        T1.createFile();
        T1.readFile("Ticket.txt"); 
        P1Proyecto1Grupo1 C1 = new P1Proyecto1Grupo1(); //Instancia: acceder a variables de instancia o métodos no estáticos
        C1.cover();
    }
    
  public void invoicePrintingJSON() {
    String archivoJSON = "FacturaCliente.json";
    // Crear un objeto JSON
    JSONObject jsonCliente = new JSONObject();
    jsonCliente.put("Nombre", name);
    jsonCliente.put("Apellido", lastname);
    jsonCliente.put("Cedula", identificacion);
    jsonCliente.put("Telefono", telephone);
    jsonCliente.put("Direccion", address);
    jsonCliente.put("Clase de acceso", clavedeAcceso);
    // Ruta del archivo JSON    
    try (FileWriter fileWriter = new FileWriter(archivoJSON)) {
        // Escribir el objeto JSON en el archivo
        fileWriter.write(jsonCliente.toJSONString());
        System.out.println("Archivo JSON creado correctamente en ." + archivoJSON);
    } catch (IOException e) {
        e.printStackTrace();
    }
    readJSONFile();
}

public void readJSONFile() {
    String archivoJSON = "FacturaCliente.json";
    try (FileReader fileReader = new FileReader(archivoJSON)) {
        JSONParser jsonParser = new JSONParser();
        JSONObject clienteJSON = (JSONObject) jsonParser.parse(fileReader); // Parsear el JSON desde el archivo
        // Obtener los valores del JSON
        String name = (String) clienteJSON.get("Nombre");
        String lastname = (String) clienteJSON.get("Apellido");
        String identificacion = (String) clienteJSON.get("Cedula");
        String telephone = (String) clienteJSON.get("Telefono");
        String address = (String) clienteJSON.get("Direccion");
        // Imprimir los valores leídos
        System.out.println("\n Leído desde el JSON FacturaCliente.json:");
        System.out.println("Nombre: " + name);
        System.out.println("Apellido: " + lastname);
        System.out.println("Identificación: " + identificacion);
        System.out.println("Teléfono: " + telephone);
        System.out.println("Dirección: " + address);
    } catch (IOException | ParseException e) {
        e.printStackTrace();
    }
}
}


    



       
        
  
    
