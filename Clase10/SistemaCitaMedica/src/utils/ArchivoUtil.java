package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Cita;

public class ArchivoUtil {

    public static void guardarCita(Cita cita) {
        try {
            FileWriter archivo = new FileWriter("citas.txt", true);
            archivo.write(cita.getCodigo() + ";" +
                          cita.getNombrePaciente() + ";" + 
                          cita.getCedula() + ";" + 
                          cita.getTelefono() + ";" + 
                          cita.getNombreMedico() + ";" + 
                          cita.getEspecialidadMedico() + ";" + 
                          cita.getFecha() + ";" +
                          cita.getHora() + ";" +
                          cita.getMotivoConsulta() + ";" + 
                          cita.getEstado() + "\n");
            archivo.close();
            System.out.println("Paquete guardado en el archivo");
        }
        catch (Exception e) {
            System.out.println("Error al guardar la cita: " + e.getMessage());
        }
    }

    public static ArrayList<Cita> leerListaCitas() {
        ArrayList<Cita> citas = new ArrayList<>();

        try {
            FileReader archivo = new FileReader("citas.txt");
            BufferedReader lector = new BufferedReader(archivo);

            String linea;

            while((linea = lector.readLine()) != null) {
                String[] partes = linea.split(";");

                if (partes.length == 10) {
                    Cita cita = new Cita(partes[0], partes[1], partes[2], partes[3], partes[4], 
                                         partes[5], partes[6], partes[7], partes[8], partes[9]);

                    citas.add(cita);
                }
            }

            lector.close();
            archivo.close();
        }
        catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
        return citas;
    }
}
