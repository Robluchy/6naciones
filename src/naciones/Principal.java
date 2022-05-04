package naciones;

import java.util.ArrayList;

import java.util.Scanner;

public class Principal {

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
					do {
						System.out.println("Submenú de jugadores.(Elige una opción 1-3)");
						System.out.println("1. Crear jugadores.");
						System.out.println("2. Mostrar jugadores.");
						System.out.println("3. Borrar jugadores.");
						opcion = sc.nextInt();
						switch (opcion) {
							case 1:
								crearJugadores();
								break;
							case 2:
								mostrarJugadores();
							case 3:
								borrarJugadores();
								break;
							default:
								System.out.println("Número introducido incorrecto.");
						}
					} while (opcion != 3);
					break;

				case 2:
					do {
						System.out.println("Submenú de entrenadores.(Elige una opción 1-3)");
						System.out.println("1. Crear entrenadores.");
						System.out.println("2. Mostrar entrenadores.");
						System.out.println("3. Borrar entrenadores.");
						opcion = sc.nextInt();
						switch (opcion) {
							case 1:
								crearEntrenadores();
								break;
							case 2:
								mostrarEntrenadores();
							case 3:
								borrarEntrenadores();
								break;
							default:
								System.out.println("Número introducido incorrecto.");
						}
					} while (opcion != 3);
					break;

				case 3:
					do {
						System.out.println("Submenú de arbritos.(Elige una opción 1-3)");
						System.out.println("1. Crear arbritos.");
						System.out.println("2. Mostrar arbritos.");
						System.out.println("3. Borrar arbritos.");
						opcion = sc.nextInt();
						switch (opcion) {
							case 1:
								crearArbitros();
								break;
							case 2:
								mostrarArbitros();
								break;
							case 3:
								borrarArbitros();
								break;
							default:
								System.out.println("Número introducido incorrecto.");
						}
					} while (opcion != 3);

				case 4:

					do {
						System.out.println("Submenú de equipos.(Elige una opción 1-3)");
						System.out.println("1. Crear equipos.");
						System.out.println("2. Mostrar equipos.");
						System.out.println("3. Borrar equipos.");
						opcion = sc.nextInt();
						switch (opcion) {
							case 1:
								crearEquipos();
								break;
							case 2:
								mostrarEquipos();
								break;
							case 3:
								borrarEquipos();
								break;
							default:
								System.out.println("Número introducido incorrecto.");
						}
					} while (opcion != 3);
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

	private static void borrarEquipos() {

	}

	private static void mostrarEquipos() {

	}

	private static void borrarArbitros() {
	}

	private static void mostrarArbitros() {
	}

	private static void borrarEntrenadores() {
	}

	private static void mostrarEntrenadores() {
	}

	private static void borrarJugadores() {
	}

	private static void mostrarJugadores() {

		
		
	}

	private static void crearArbitros() {
		for (int i = 0; i < 5; i++) {
			arbitros.add(new Arbitro());
		}
	}

	public static void crearJugadores() {
		for (int i = 0; i < 180; i++) {
			jugadores.add(new Jugador());
		}
	}

	public static void crearEntrenadores() {
		for (int i = 0; i < 18; i++) {
			entrenadores.add(new Entrenador());
		}
	}

	public static ArrayList<Equipo> crearEquipos() {
		for (int i = 0; i < 6; i++) {
			equipos.add(new Equipo( jugadores, crearEntrenadores() ));
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