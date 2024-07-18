package csv_to_mysql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class PrincipalCsvToMysql {
    static ConexionMySQL cm = new ConexionMySQL("COLLEGE");
    static Connection conexion = cm.getConexion();
    

    public static void main(String[] args) {
        List<Student> students_al = obtenerListaStudent();
        if(insertStudent(students_al) == true){
            System.out.println("Inserted students.");
        }else{
            System.out.println("Error inserting studends.");
        }
    }
    
    public static List<Student> obtenerListaStudent(){
        List<Student> student_al = new ArrayList<>();
        
        File f;
        FileReader fr;
        BufferedReader br;
        
        String row = "";
        try{
            f = new File("data/personas.txt");
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            
            while((row = br.readLine()) != null){
                String[] p = row.split(";");
                if(p.length >= 4){
                    Date fechaDate = Date.valueOf(LocalDate.parse(p[3]));
                    char sex = p[2].charAt(0); //para recuperar el char y utilizarlo
                    Student student = new Student(Integer.parseInt(p[0]),
                                                                   p[1], 
                                                                   sex,
                                                                   fechaDate); 
                    student_al.add(student);
            }
           }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return student_al;
    }
    
    public static boolean insertStudent(List<Student> student_al){
    boolean correct = true;
    String sql = "INSERT INTO Student (idStudent,nombre_apellido,sexo,fecha_nacimiento) VALUES (?,?,?,?)"; //(?,?,?,?) las posiciones empiezan en 1
    PreparedStatement ps = null;
        for(Student s: student_al){
            if(!existeStudent(s)){
                try{
                    ps = conexion.prepareStatement(sql);
                    ps.setInt(1, s.getidStudent());
                    ps.setString(2, s.getNombre_apellido());
                    ps.setString(3, String.valueOf(s.getSexo()));
                    ps.setDate(4, s.getFecha_nacimiento());
                    ps.executeUpdate();
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                    correct = false;
                }
            }else{
                System.out.println("Error, student exists.");
            }
        }
        return correct;
    }
    
    //Verificar si alumno existe
    public static boolean existeStudent(Student student){
        boolean existe = true;
        String sql = "SELECT * FROM Student WHERE idStudent = ?"; //Query paramétrica
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, student.getidStudent());
            ResultSet rs = ps.executeQuery();
            if(!rs.next()){
                existe = false;
            }
        }catch(SQLException e){
            existe = false;
        }
        return existe;
    }
    
}
