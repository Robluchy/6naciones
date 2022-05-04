package naciones;

import java.util.Date;

abstract class Persona {

    
    private String nombreCompleto;
    private double peso;
    private Date fechaNacimiento;

    //constructor por defecto

    public Persona() {
        nombreCompleto = "";
        peso = 0;
        fechaNacimiento = new Date();
    }

    //constructor de copia
    public Persona(Persona persona) {
        this.nombreCompleto = persona.nombreCompleto;
        this.peso = persona.peso;
        this.fechaNacimiento = persona.fechaNacimiento;
    }

    //constructor con parametros
    public Persona(String nombreCompleto, double peso, Date fechaNacimiento) {
        this.nombreCompleto = nombreCompleto;
        this.peso = peso;
        this.fechaNacimiento = new Date(fechaNacimiento.getTime());
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    //toString
    
    public String toString() {
        return "Persona{" + "nombreCompleto=" + nombreCompleto + ", peso=" + peso + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

    public enum Nombres {
        Pepe,
        Manuel,
        Samuel,
        Jonathan,
        Jose,
        Javier;
    }
}
