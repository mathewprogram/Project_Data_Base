package csv_to_mysql;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JOptionPane;

public class ProbandoTreeset {
    public static void main(String[] args) {
        versionLeerArchivos();
    }
    
    public static void versionLeerArchivos(){
        //Llenar un arrayList con los nombre(hombre y mujer)
        List<String> names_al = new ArrayList<>();
        List<String> lastNames_al = new ArrayList<>();
        
        //Reconocer nombres masculino y femenino
        List<String> masculine_al = new ArrayList<>();
        List<String> feminine_al = new ArrayList<>();
        
        
        //Leer archivo
        File f;
        FileReader fr;
        BufferedReader br;
        String name = "";
        
        //Leer archivo masculino
        try{
            f = new File("data/masculino.txt");
            fr = new FileReader(f);
            br = new BufferedReader(fr); //Lo pone en el area de preparacion
            
            while((name = br.readLine()) != null){
                names_al.add(name);
                masculine_al.add(name);
            }
            System.out.println("Ok. Masculine name read correctly");
            
        }catch(IOException e){
            System.out.println("Error de lectura.");
            JOptionPane.showMessageDialog(null, "Error de lectura.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        //Leer archivo femenino
        try{
            f = new File("data/femenino.txt");
            fr = new FileReader(f);
            br = new BufferedReader(fr); //Lo pone en el area de preparacion
            
            while((name = br.readLine()) != null){
                names_al.add(name);
                feminine_al.add(name);
            }
            System.out.println("Ok. Feminine name read correctly");
            
        }catch(IOException e){
            System.out.println("Error de lectura.");
            JOptionPane.showMessageDialog(null, "Error de lectura.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        //Leer archivo apellido
        String lastName = "";
        try{
            f = new File("data/apellido.txt");
            fr = new FileReader(f);
            br = new BufferedReader(fr); //Lo pone en el area de preparacion
            
            while((lastName = br.readLine()) != null){
                lastNames_al.add(lastName);
            }
            System.out.println("Ok. Last names read correctly");
            
        }catch(IOException e){
            System.out.println("Error de lectura.");
            JOptionPane.showMessageDialog(null, "Error de lectura.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        System.out.println(Arrays.asList(names_al));
        System.out.println(Arrays.asList(lastNames_al));
        
        //Proceso para sacar x numero de personas
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingresar cuantas personas a generar: "); //Maximo 2184
        int number = scan.nextInt(); //10
        Set<String> persons_ts = new TreeSet<>();
        
        System.out.println("tamaño nombre.txt: " + names_al.size());
        System.out.println("tamaño nombre.txt: " + lastNames_al.size());
        
        String sexo = "";
        for(int i=0; true; i++){ //0 - 9 (son 10 numeros)
            int randomName = (int)(Math.random() * names_al.size());
            name = names_al.get(randomName);
            if(masculine_al.contains(name)){
                sexo = "H";
            }else{
                sexo = "M";
            }
                
            int randomLastName = (int)(Math.random() * lastNames_al.size());
            lastName = lastNames_al.get(randomLastName);
            String person = /*(++c) + ";" + */name + " " + lastName + ";" + sexo;
            //System.out.println((i + 1) + " " + person);
            
            persons_ts.add(person);
            if(persons_ts.size() == number){
            break;
            }
            
            if(persons_ts.size() == names_al.size()* lastNames_al.size()){
                System.out.println("Not enough data ");
                JOptionPane.showMessageDialog(null, "Not enough data.", "Information", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            
        }
        
        List<String> persons1_al = new ArrayList<>(persons_ts);
        List<String> persons2_al = new ArrayList<>();
        int k = 1;
        for(int i=0; i<persons1_al.size(); i++){
            String s = persons1_al.get(i);
            String p1 = (k++) + ";" + s + ";" + MetodoArchivo.obtenerFechaNacimientoAleatorio();
            persons2_al.add(i, p1);
        }
        System.out.println("Confirmar cambios.");
        for(String p2: persons2_al){
            System.out.println(p2);
        }
        
       /* 
        System.out.println();
        System.out.println("Unique and in alphabetic order persons: ");
        int c = 1;
        for(String person: persons_ts){
            System.out.println((c++) + " " + person);
        }
        */
        
        
        //Save the collection of persons we create
        //File f; - no hace falta por que la tenemos arriba delcarada
        FileWriter fw;
        BufferedWriter bw;
        
        try{
            f = new File("data/personas.txt");
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
            System.out.println("*************Run*************");
            bw.write("*************Run*************" + "\r\n");
            System.out.println("Written succesfully");
            for(String w: persons2_al){
                bw.write(w  + "\r\n");
            }
            
            bw.flush();
            
        }catch(IOException e){
            System.out.println("Not enough data" + e.getMessage());
                JOptionPane.showMessageDialog(null, "Not enough data.", "Information" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public static void versionTreeSet(){
        Set<String> nombres_ts = new TreeSet<>();
        nombres_ts.add("Mihai");
        nombres_ts.add("Lavinia");
        nombres_ts.add("Lavinia");
        System.out.print(nombres_ts);
    }
    
    public static void versionArrayList(){
     ArrayList<String> nombres_al = new ArrayList<>();
        nombres_al.add("Mihai");
        nombres_al.add("Lavinia");
        
        if(nombres_al.contains("Carla")){
            System.out.println("Si esta.");
            }else{
            System.out.println("No esta.");
        }
        
        String s = nombres_al.get(1);
        
        System.out.println(s);
        ArrayList<String> copianombres_al = (ArrayList<String>) nombres_al.clone();
        
        //nombres_al.clear();
        
        if(nombres_al.isEmpty()){
            System.out.println("List is empty");
            }else {
            System.out.println("List contains: " + s);
                }
        }   
    
}

    