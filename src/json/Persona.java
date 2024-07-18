package json;

public class Persona {
    //Variables de instancia
    private String dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String nacimiento;
    
    //Constructore
    public Persona() {
        this.dni = "";
        this.nombre = "";
        this.apellido = "";
        this.direccion = "";
        this.telefono = "";
        this.nacimiento = "";
    }

    public Persona(String dni, String nombre, String apellido, String direccion, String telefono, String nacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nacimiento = nacimiento;
    }
    
    //Set y Get
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String apellido) {
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
    
    //toString
    @Override
    public String toString() {
        return "Persona{" + "dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", nacimiento=" + nacimiento + '}';
    }
    
    //Esta es una clase que vamos a utilizar
}
