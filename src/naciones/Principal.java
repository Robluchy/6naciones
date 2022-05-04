package naciones;

import java.util.ArrayList;

import java.util.Scanner;

public class Principal {

	static Scanner sc = new Scanner(System.in);
 // crear los arrays de jugadores, entrenadores, equipos, arbitros
 
 ArrayList<Jugador> jugadores = new ArrayList<>();
 ArrayList<Equipo> equipos = new ArrayList<>();
 static ArrayList<Entrenador> entrenadores = new ArrayList<>();
 ArrayList<Arbitro> arbitros = new ArrayList<>();

public static void mostrarMenu() {
	    int opcion;

	do {
	   System.out.println("Menú .(Elige una opción 1-5)");
	   System.out.println("1. Submenú Jugadores.");
	   System.out.println("2. Submenú Entrenadores.");
	   System.out.println("3. Submenú Equipo.");
	   System.out.println("4. Crear Arbitros.");
	   System.out.println("5. Salir.");
	   opcion = sc.nextInt();
	   switch (opcion) {
	   case 1:
	        crearJugadores();
	        break;
	   case 2:
	        crearEntrenadores();
	        break;  
	   case 3:
	        crearEquipos();
	        break;
	   case 4:
	        crearArbitros();
	        break;
	   case 5:
			System.out.println("Saliendo...");
			sc.close();
	        break;  
	   default:
	        System.out.println("Valor introducido incorrecto.");
	        break;
	   }
	}
		while( opcion != 5 );
}

private static ArrayList<Arbitro> crearArbitros() {


}

public static ArrayList<Jugador> crearJugadores(){
	   for (int i = 0; i < 30; i++) {
	       jugadores.add(new Jugador("Jugador "+i, aleatorio(), fechaNacimiento, equipo, aleatorio(), aleatorio(), aleatorio());
   }
   return jugadores;
}

public static ArrayList<Entrenador> crearEntrenadores(){
	   for (int i = 0; i <3 ; i++) {
	       entrenadores.add(new Entrenador("Entrenador "+i, aleatorio(), fechaNacimiento, aleatorio(), equipo);
   }
   return entrenadores;
}

public static ArrayList<Equipo> crearEquipos(){
		for (int i = 0; i <3 ; i++) {
	    	equipos.add(new Equipo(i, i, i, i, jugadores, entrenadores, jugadores));     
   }
   return equipos;

}

public static int aleatorio() {
	int random = (int)Math.floor(Math.random()*(100-0+1)+0);
	return random;
}

public static void main(String[] args) {
	    mostrarMenu();
	 }
}