package csv_to_mysql;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

public class MetodoCrud {
    //CRUD = Create Read Update Delete
    
    //Variables de instancia (Atributo)
    private Connection conexion; //Entrada
    
    //Constructores
    public MetodoCrud(Connection conexion){
        this.conexion = conexion;
    }
    
    //Metodos CRUD: 
    //--------------------------------------------
    //Create (Insert)
    public boolean insertStudent(Student student){
        boolean correcto = true;
        String sql = "INSERT INTO Student (idStudent, nombre_apellido,sexo,fecha_nacimiento) VALUES (?, ?, ?, ?)"; //Querry Paramétrica
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, student.getidStudent());
            ps.setString(2, student.getNombre_apellido());
            ps.setString(3, String.valueOf(student.getSexo()));
            ps.setDate(4, student.getFecha_nacimiento());
            ps.executeUpdate();
        }catch(SQLException e){
            correcto = false;
        }
        return correcto;
    }
    
    //Read (Select)    
    
    public List<Student> obtenerTodosLosRegistros(){
        List<Student> student_al = new ArrayList<>();
        String sql = "SELECT * FROM Student";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int idStudent = rs.getInt("idStudent");
                String nombre = rs.getString("nombre_apellido");
                char sexo = rs.getString("sexo").charAt(0);
                String grupo = rs.getString("grupo");
                Date fechaNacimiento = rs.getDate("fecha_nacimiento");
                Student student = new Student(idStudent, nombre, sexo, fechaNacimiento);
                student_al.add(student);
            }
        }catch(SQLException e) {
                    student_al = null;
        }
        return student_al;
    }
    
    //Update
    public boolean actualizarStudent(Student student){
        boolean correcto = true;
        String sql = "UPDATE Student SET nombre_apellido = ?, sexo = ?, fecha_nacimiento = ? WHERE idStudent = ?"; //Query Paramétrica
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, student.getidStudent());
            ps.setString(2, student.getNombre_apellido());
            ps.setString(3, String.valueOf(student.getSexo()));
            ps.setDate(4, student.getFecha_nacimiento());
            ps.executeUpdate();
            
        }catch(SQLException e){
            correcto = false;
        }
        return correcto;
    }
    
    //Delete
    public boolean eliminarStudent(Student student){
        boolean correcto = false;
        String sql = "DELETE FROM Student WHERE idStudent = ?"; //Query Paramétrica
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, student.getidStudent());
            ps.executeUpdate();
            correcto = true;
        }catch(SQLException e){
            correcto = false;
        }
        return correcto;
    }
    
    
    //Verificar si alumno existe
    public boolean existeStudent(Student student){
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
    
    //Del Chat
    public boolean insertarStudent(Student student) {
        String sql = "INSERT INTO Student (idStudent, nombre_apellido, sexo, fecha_nacimiento) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, student.getidStudent());
            ps.setString(2, student.getNombre_apellido());
            ps.setString(3, String.valueOf(student.getSexo()));
            ps.setDate(4, student.getFecha_nacimiento());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error inserting student: " + e.getMessage());
            return false;
        }
    }

    public boolean updateStudent(Student student) {
        String sql = "UPDATE Student SET nombre_apellido = ?, sexo = ?, fecha_nacimiento = ? WHERE idStudent = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, student.getNombre_apellido());
            ps.setString(2, String.valueOf(student.getSexo()));
            ps.setDate(3, student.getFecha_nacimiento());
            ps.setInt(4, student.getidStudent());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("No rows updated. Student ID may not exist: " + student.getidStudent());
                return false;
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteStudent(int idStudent) {
        String sql = "DELETE FROM Student WHERE idStudent = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idStudent);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("No rows deleted. Student ID may not exist: " + idStudent);
                return false;
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
            return false;
        }
    }

    public Student getStudent(int idStudent) {
        String sql = "SELECT * FROM Student WHERE idStudent = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idStudent);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre_apellido");
                char sexo = rs.getString("sexo").charAt(0);
                Date fecha = rs.getDate("fecha_nacimiento");
                return new Student(idStudent, nombre, sexo, fecha);
            } else {
                System.out.println("Student not found with ID: " + idStudent);
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving student: " + e.getMessage());
            return null;
        }
    }

    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        String sql = "SELECT * FROM Student";
        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int idStudent = rs.getInt("idStudent");
                String nombre = rs.getString("nombre_apellido");
                char sexo = rs.getString("sexo").charAt(0);
                Date fecha = rs.getDate("fecha_nacimiento");
                Student student = new Student(idStudent, nombre, sexo, fecha);
                studentList.add(student);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving students: " + e.getMessage());
        }
        return studentList;
    }

    public boolean existsStudent(int idStudent) {
        String sql = "SELECT 1 FROM Student WHERE idStudent = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idStudent);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error checking if student exists: " + e.getMessage());
            return false;
        }
    }
    
    public int obtainLastStudentId(){
        int last = 0;
        String sql = "SELECT MAX(idStudent) AS Last FROM Student"; //Query paramétrica
        //String sql = "SELECT MAX(idStudent) FROM Student"; 
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                //int last = rs.getInt(1);
                last = rs.getInt("Last");
            }
        }catch(SQLException e){
            System.out.println("Error obtaining last student ID: " + e.getMessage());
            last = -1;
        }
        return last + 1;   
    }
    
    
    public static void main(String[] args ){
        ConexionMySQL cm = new ConexionMySQL("COLLEGE");
        Connection conexion = cm.getConexion();
        MetodoCrud mc = new MetodoCrud(conexion);
        
        int n = mc.obtainLastStudentId();
        System.out.println(n);
    }
    
}
