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
			System.out.println("1. Crear Jugadores.");
			System.out.println("2. Crear Entrenadores.");
			System.out.println("3. Crear Arbitros.");
			System.out.println("4. Crear Equipos.");
			System.out.println("5. Salir.");
			opcion = sc.nextInt();
			switch (opcion) {

				case 1:
					jugadores = crearJugadores();
					break;

				case 2:
					entrenadores = crearEntrenadores();
					break;

				case 3:
					arbitros = crearArbitros();
					break;

				case 4:
					equipos = crearEquipos(jugadores, entrenadores);
					break;
				case 5:
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("Valor introducido incorrecto.");
					break;
			}
		} while (opcion != 5);
	}

	public static ArrayList<Jugador> crearJugadores() {
		ArrayList<Jugador> jugadores = new ArrayList<>();
		for (int i = 0; i < 180; i++) {
			jugadores.add(new Jugador());
		}
		for (Jugador jugador : jugadores) {
			System.out.println(jugador);
		}
		return jugadores;
	}

	public static ArrayList<Entrenador> crearEntrenadores() {
		ArrayList<Entrenador> entrenadores = new ArrayList<>();
		for (int i = 0; i < 18; i++) {
			entrenadores.add(new Entrenador());
		}
		for (Entrenador entrenador : entrenadores) {
			System.out.println(entrenador);
		}
		return entrenadores;

	}

	public static ArrayList<Equipo> crearEquipos(ArrayList<Jugador> jugadores, ArrayList<Entrenador> entrenadores) {
		ArrayList<Equipo> equipos = new ArrayList<>();
		if (jugadores.size() > 1 && entrenadores.size() > 1) {
			int contadorJugadores = 0;
			int contadorEntrenadores = 0;
			int contadorEquipos = 0;
			for (int i = 0; i < 6; i++) {
				equipos.add(new Equipo());
				contadorEquipos++;
				System.out.println(contadorEquipos++);
				for (int e = 0; e < 30; e++) {
					equipos.get(i).addJugador(jugadores.get(contadorJugadores));
					jugadores.get(contadorJugadores).setEquipo(equipos.get(i));
					contadorJugadores++;
				}
				for (int j = 0; j < 3; j++) {
					equipos.get(i).addEntrenador(entrenadores.get(contadorEntrenadores));
					entrenadores.get(contadorEntrenadores).setEquipo(equipos.get(i));
					contadorEntrenadores++;
				}

			}
		} else {
			System.out.println("No se han creado Jugadores o Entrenadores.");
		}

		for (Equipo equipo : equipos) {
			System.out.println(equipo);
		}
		return equipos;
	}

	private static ArrayList<Arbitro> crearArbitros() {
		for (int i = 0; i < 5; i++) {
			arbitros.add(new Arbitro());
		}

		for (Arbitro arbitro : arbitros) {
			System.out.println(arbitro);
		}
		return arbitros;
	}

	public static int aleatorio() {
		int random = (int) Math.floor(Math.random() * (100 - 0 + 1) + 0);
		return random;
	}

	public static void main(String[] args) {
		mostrarMenu();
	}
}