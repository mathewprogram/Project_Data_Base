package csv_to_mysql;

import java.sql.Date;

public class Student {
    //Varialbe de instancia(los atributos)
    private int idStudent;
    private String nombre_apellido;
    private char sexo;
    private Date fecha_nacimiento;

    //Constructores
    public Student() {
        this.idStudent = 0;
        this.nombre_apellido = "";
        this.sexo = ' ';
        this.fecha_nacimiento = null;
    }
    
    public Student(int idStudent, String nombre_apellido, char sexo, Date fecha_nacimiento) {
        this.idStudent = idStudent;
        this.nombre_apellido = nombre_apellido;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    //Set y Get

    public int getidStudent() {
        return idStudent;
    }

    public void setidStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    //To String

    @Override
    public String toString() {
        return "Student{" + "idAlumno=" + idStudent + ", nombre_apellido=" + nombre_apellido + ", sexo=" + sexo + ", fecha_nacimiento=" + fecha_nacimiento + '}';
    }
    
    
}
