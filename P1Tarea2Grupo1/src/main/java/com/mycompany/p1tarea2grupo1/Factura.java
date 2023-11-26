
package com.mycompany.p1tarea2grupo1;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Factura {
    private String nombre;
    String apellido;
    public int diaEntrega;
    public int mesEntrega;
    private String correoElectronico;
    private String ciudad;
    private String direccion;
    private String telefono;
   

    public Factura(String nombre,String apellido, int diaEntrega, int mesEntrega, String correoElectronico, String ciudad, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.diaEntrega = diaEntrega;
        this.mesEntrega = mesEntrega;
        this.correoElectronico = correoElectronico;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
     public void Datosfactura(){
        System.out.println("""
                           ---------------------------------------------                         
                                                FACTURA                       
                          ---------------------------------------------------
                           Nombres :    """ + nombre + "  " + apellido +
                           "\nDia de entrega:      " + diaEntrega + 
                           "\nMes de entrega:      " + mesEntrega + " kg" +
                           "\nCorreo:    " + correoElectronico + 
                           "\nCiudad: " + ciudad +
                           "\nDireccion: " + direccion +
                           "\nTelefono: " + telefono);
    }
     
     public void CrearArchivoFactura (String nombreArchivo, double totalAPagar, String[] Productos, int[] CantidadesCompradas, double[] Precios) {
        File archivo = new File(nombreArchivo);
        try {
            if (archivo.createNewFile()) {
                FileWriter escritura = new FileWriter(archivo);
                escritura.write("Nombres :    " + nombre + "  " + apellido +
                        "\nDia de entrega:      " + diaEntrega +
                        "\nMes de entrega:      " + mesEntrega + " kg" +
                        "\nCorreo:    " + correoElectronico +
                        "\nCiudad: " + ciudad +
                        "\nDireccion: " + direccion +
                        "\nTelefono: " + telefono +
                        "\n\nResumen de la compra:");

                for (int i = 0; i < Productos.length; i++) {
                    if (CantidadesCompradas[i] > 0) {
                        escritura.write("\n" + Productos[i] + ": " + CantidadesCompradas[i] + " unidades - Total: $" + (CantidadesCompradas[i] * Precios[i]));
                    }
                }

                // Agregar la cantidad total al archivo
                escritura.write("\n\nTotal a pagar: $" + totalAPagar);

                escritura.close();
                System.out.println("El archivo se ha creado");
            } else {
                System.out.println("El archivo no se ha creado ");
            }
        } catch (IOException excepcion) {
            excepcion.printStackTrace(System.out);
        }
    }
     
     
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    


    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getDiaEntrega() {
        return diaEntrega;
    }

    public int getMesEntrega() {
        return mesEntrega;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDiaEntrega(int diaEntrega) {
        this.diaEntrega = diaEntrega;
    }

    public void setMesEntrega(int mesEntrega) {
        this.mesEntrega = mesEntrega;
    }

    
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    

}