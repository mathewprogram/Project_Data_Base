//Esto es un objeto

package agenda_basedatos;

public class Persona {
    
    //Variables instancia
    private String dni;
    private String nombre;
    private String paterno;
    private String direccion;
    private String telefono;
    private String nacimiento;
    
    //Constructores 
    public Persona() {
        this.dni = "";
        this.nombre = "";
        this.paterno = "";
        this.direccion = "";
        this.telefono = "";
        this.nacimiento = "";
    }

    public Persona(String dni, String nombre, String paterno, String direccion, String telefono, String nacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.paterno = paterno;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nacimiento = nacimiento;
    }
    
    //Get y Set
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }
    
    
    //ToString
    @Override
    public String toString() {
        return "Persona{" + "dni=" + dni + ", nombre=" + nombre + ", paterno=" + paterno + ", direccion=" + direccion + ", telefono=" + telefono + ", nacimiento=" + nacimiento + '}';
    }
  
    
    
    
}
