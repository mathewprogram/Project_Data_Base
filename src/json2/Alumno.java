package json2;

import java.util.List;

public class Alumno {
    //Variable de instancia(Atributos)
    private int idAlumno;
    private String nombre;
    private String apellido;
    private double estatura;
    private boolean casado;
    private Direccion direccion; //creamos una instancia de la clase Direccion
    private List<String> hobbies; //una lista con los que tenemos, String, puede ser int tambien
    //private List<Object> otros; Object abarca todo
    
    //Constructores
    public Alumno() {
        this.idAlumno = 0;
        this.nombre = "";
        this.apellido = "";
        this.estatura = 0.0;
        this.casado = false;
        this.direccion = null;
        this.hobbies = null;
    }
    public Alumno(int idAlumno, String nombre, String apellido, double estatura, boolean casado, Direccion direccion, List<String> hobbies) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estatura = estatura;
        this.casado = casado;
        this.direccion = direccion;
        this.hobbies = hobbies;
    }
    
    //Set y Get
    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
    
    //toString

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellido=" + apellido + ", estatura=" + estatura + ", casado=" + casado + ", direccion=" + direccion + ", hobbies=" + hobbies + '}';
    }
    
}
