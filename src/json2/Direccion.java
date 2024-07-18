package json2;

public class Direccion {
    //Variable de instancia(Atributos)
    private String calle;
    private int numero;
    private String ciudad;
    
    //Construcores

    public Direccion() {
        this.calle = "";
        this.numero = 0;
        this.ciudad = "";
    }
    
    public Direccion(String calle, int numero, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
    }
    
    //Set y Get
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    //toString
    @Override
    public String toString() {
        return "Direccion{" + "calle=" + calle + ", numero=" + numero + ", ciudad=" + ciudad + '}';
    }
    
    
    
}
