package naciones;

import java.util.Date;

abstract class Persona {

    
    private String nombreCompleto;
    private double peso;
    private Date fechaNacimiento;

    //constructor por defecto

    public Persona() {
        nombreCompleto = nombres[(int) (Math.random() * nombres.length)];
        peso = randomInt(0, 100);
        fechaNacimiento = new Date();
    }

    private int randomInt(int min, int max) {
        return (int) Math.floor((Math.random() * (max - min + 1)) + min);
    }

    private static String[] nombres = {"Grégory Alldritt", "Uini Atonio", "Cyril Baille", "Demba Bamba", "Gaëtan Barlot", "Biziwu Daniel Bibi","Dylan Cretin", "François Cros", "Ibrahim Diallo", "Thibaud Flament", "Jean-Baptiste Gros", "Mohamed Haouas", "Anthony Jelonch","Bernard Le Roux", "Sekou Macalou", "Julien Marchand", "Peato Mauvaka", "Yoan Tanga", "Romain Taofifenua", "Florent Vanverberghe", "Florian Verhaeghe", "Paul Willemse", "Cameron Woki", "Yannick Zegers", 
    "Alfred Zwirn", "Baptiste Zwirn", "Clement Zwirn", "David Zwirn", "Emeric Zwirn", "Florent Zwirn", "Guillaume Zwirn", "Hugo Zwirn", "Julien Zwirn", "Kevin Zwirn", "Léo Zwirn", "Louis Zwirn", "Mathieu Zwirn", "Maxime Zwirn", "Nicolas Zwirn", "Olivier Zwirn", "Philippe Zwirn", "Quentin Zwirn", "Romain Zwirn", "Sebastien Zwirn", "Simon Zwirn", "Thomas Zwirn", "Vincent Zwirn", "Yannick Zwirn"};

    //constructor con parametros
    public Persona(String nombreCompleto, double peso, Date fechaNacimiento) {
        this.nombreCompleto = nombreCompleto;
        this.peso = peso;
        this.fechaNacimiento = new Date(fechaNacimiento.getTime());
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(int posicion) {
        this.nombreCompleto = nombres[posicion];
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
        return "Nombre " + nombreCompleto + ", Peso " + peso + ", Fecha de nacimiento" + fechaNacimiento ;
    }

}