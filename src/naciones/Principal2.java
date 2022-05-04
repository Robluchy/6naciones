package naciones;

import java.util.ArrayList;

import java.util.Scanner;

public class Principal2 {

	static Scanner sc = new Scanner(System.in);

	static ArrayList<Jugador> jugadores = new ArrayList<>();
	static ArrayList<Equipo> equipos = new ArrayList<>();
	static ArrayList<Entrenador> entrenadores = new ArrayList<>();
	static ArrayList<Arbitro> arbitros = new ArrayList<>();

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

					crearArbitros();
					break;

				case 4:

					crearEquipos();
					break;

				case 5:
					System.out.println("Saliendo...");
					sc.close();
					break;
				default:
					System.out.println("Valor introducido incorrecto.");
					break;
			}
		} while (opcion != 5);
	}

	private  ArrayList<Arbitro>  crearArbitros() {
		ArrayList<Arbitro> arbitros = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			arbitros.add(new Arbitro());
		}
		return arbitros;
	}

	public ArrayList<Jugador> crearJugadores() {
		ArrayList<Jugador> jugadores = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			jugadores.add(new Jugador());
		}
		return jugadores;
	}

	public ArrayList<Entrenador> crearEntrenadores() {
		ArrayList<Entrenador> entrenadores = new ArrayList<>();
		for (int i = 0; i < 18; i++) {
			entrenadores.add(new Entrenador());
		}
		return entrenadores;
	}

	public static ArrayList<Equipo> crearEquipos() {
		for (int i = 0; i < 6; i++) {
			equipos.add(new Equipo(crearJugadores(), crearEntrenadores()));
		}
		return equipos;

	}

	public static int aleatorio() {
		int random = (int) Math.floor(Math.random() * (100 - 0 + 1) + 0);
		return random;
	}

	public static void main(String[] args) {
		mostrarMenu();
	}
}