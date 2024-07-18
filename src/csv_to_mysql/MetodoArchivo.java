package csv_to_mysql;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

public class MetodoArchivo {

    public static void crearArchivo(String rutaAndNombreArchivo) {
        File f = new File(rutaAndNombreArchivo);
        if (f.exists()) {
            System.out.println("File exists.");
            JOptionPane.showMessageDialog(null, "File exists.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                if (f.createNewFile()) {
                    System.out.println("");
                    JOptionPane.showMessageDialog(null, "File created succesfully.", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "File not created", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    

    public static void escribirArchivo(String rna, List<String> nombres_al) {
        File f;
        FileWriter fw;
        BufferedWriter bw;

        try {
            f = new File(rna);
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);

            for (String nombre : nombres_al) {
                bw.write(nombre + "\r\n"); //lo pone en "el area de preparacion"
            }
            bw.flush(); //Graba en disco
            System.out.println("File written " + rna);
            JOptionPane.showMessageDialog(null, "File written sucsefully: " + rna, "Information", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static List<String> obtenerListaNombresM(String rna) {
        List<String> masculino_al = new ArrayList<>();
        File f;
        FileReader fr;
        BufferedReader br;
        String row = "";

        try {
            f = new File(rna);
            fr = new FileReader(f);
            br = new BufferedReader(fr); //Preparacion

            while ((row = br.readLine()) != null) {
                if (row.equals("Nombres Femeninos:")) {
                    break;
                } else {
                    if (!row.equals("Nombres Masculinos:")) {
                        masculino_al.add(row);
                    }
                    continue;
                }
            }
        } catch (Exception e) {
            System.out.println("Error while writting file.");
            JOptionPane.showMessageDialog(null, "Error while writting file." + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return masculino_al;
    }

    public static List<String> obtenerListaNombresF(String rna) {
        List<String> femenino_al = new ArrayList<>();
        File f;
        FileReader fr;
        BufferedReader br;
        String row = "";

        try {
            f = new File(rna);
            fr = new FileReader(f);
            br = new BufferedReader(fr); //Preparacion

            boolean femeninoFound = false;
            while ((row = br.readLine()) != null) {
                if (row.equals("Nombres Femeninos:")) {
                    femeninoFound = true; // Start collecting female names
                    continue; // Skip the header
                }
                if (femeninoFound) {
                    femenino_al.add(row); // Add female name to the list
                }
            }
        } catch (IOException e) {
            System.out.println("Error while writting file.");
            JOptionPane.showMessageDialog(null, "Error while writting file." + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return femenino_al;
    }
    
    public static List<String> obtenerListaApellidos(String rna){
        List<String> apellido_al = new ArrayList<>();
        File f;
        FileReader fr;
        BufferedReader br;
        String row = "";
        
        try{
            f = new File(rna);
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            
            while((row = br.readLine()) != null){
                apellido_al.add(row);
            }
        }catch(IOException e){
            System.out.println("Error while writting file.");
            JOptionPane.showMessageDialog(null, "Error while writting file." + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return apellido_al;
    }
    
    public static List<String> crearPersonasUnicas(List<String> masculino_al, List<String> femenino_al, List<String> apellido_al, int numPersonas){
        List<String> personas_al = new ArrayList<>();
        Random random = new Random();
        
        while(personas_al.size() < numPersonas){
            String nombre;
            if(random.nextBoolean()){
               nombre = masculino_al.get(random.nextInt(masculino_al.size()));
            }else{
                nombre = femenino_al.get(random.nextInt(femenino_al.size()));
            }
            
            String apellido = apellido_al.get(random.nextInt(apellido_al.size()));
            String persona = nombre + " " + apellido;
            
            if(!personas_al.contains(persona)){
                personas_al.add(persona);
            }
        } 
        
        return personas_al;
    }
    
    //Obtener el numero de dias del mes
    public static String obtenerFechaNacimientoAleatorio(){
        String date = "";
        int randomYear = (int)(Math.random() * 21 + 1980);                  //1980 - 2000
        int randomMonth = (int)(Math.random() * 12 + 1);                    //1 - 12
        LocalDate diasMes = LocalDate.of(randomYear, randomMonth, 1);
        int randomDay = (int)(Math.random() * diasMes.lengthOfMonth() + 1); //1 - diasMes.lengthOfMonth();
        String zeroMonth = String.format("%02d", randomMonth);
        String zeroDay = String.format("%02d", randomDay);
        
        /* 
        //Otra forma de conseguir formatear la fecha con 0 es: 
        String zM = "";
        if(randomMonth < 10){
            zM = "0" + randomMonth;
        }else{
            zM = "" + randomMonth;
        }
        
        String zD = "";
        if(randomDay < 10){
            zD = "0" + randomDay;
        }else{
            zD = "" + randomDay;
        }*/
        
        date = randomYear + "-" + zeroMonth + "-" + zeroDay;
        
        return date;
        
        
        
        
        
        
    }
    
}

/*
Leyenda:

rna - rutaNombreArchivo

Crear 100 personas y darle aleatoriamente un nombre y un apellido.
podemos identificar si una persona es feminino o masculino en base al nombre.
 */
