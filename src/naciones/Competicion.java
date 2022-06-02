package naciones;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class Competicion {

	static Scanner sc = new Scanner(System.in);

	static ArrayList<Jugador> jugadores = new ArrayList<>();
	static ArrayList<Equipo> equipos = new ArrayList<>();
	static ArrayList<Entrenador> entrenadores = new ArrayList<>();
	static ArrayList<Arbitro> arbitros = new ArrayList<>();
	static ArrayList<Partido> partidos = new ArrayList<>();
	Estadio estadio = new Estadio();

	public void mostrarMenu() {
		int opcion;
		do {
			System.out.println(" Torneo 6 Naciones ");
			System.out.println("1. Generar Datos.");
			System.out.println("2. Simular Competicion.");
			System.out.println("3. Guardar en BD.");
			System.out.println("4. Mostrar Datos.");
			System.out.println("5. Mostrar Calificacion.");
			System.out.println("6. Salir.");
			opcion = sc.nextInt();
			switch (opcion) {

				case 1:
					jugadores = crearJugadores();
					entrenadores = crearEntrenadores();
					arbitros = crearArbitros();
					equipos = crearEquipos(jugadores, entrenadores);
					break;

				case 2:
					this.competir();
					System.out.println("\n");
					break;

				case 3:

					//GestorSQL.guardarJugadores(jugadores);
					//GestorSQL.guardarEntrenadores(entrenadores);
					GestorSQL.guardarArbitros2(arbitros);
					//GestorSQL.guardarEquipos(equipos);

					break;

				case 4:


					break;
				case 5:
					competir();
					break;

				case 6:
					System.out.println("\n Saliendo...");
					break;
				default:
					System.out.println("\n Valor introducido incorrecto.");
					break;
			}
		} while (opcion != 6);
		sc.close();
	}

	public static ArrayList<Jugador> crearJugadores() {
		ArrayList<Jugador> jugadores = new ArrayList<>();
		for (int i = 0; i < 180; i++) {
			jugadores.add(new Jugador());
		}
		// for (Jugador jugador : jugadores) {
		System.out.println("\n Se han creado " + jugadores.size() + " jugadores.");
		// System.out.println(jugador);
		// }
		return jugadores;

	}

	public static ArrayList<Entrenador> crearEntrenadores() {
		ArrayList<Entrenador> entrenadores = new ArrayList<>();
		for (int i = 0; i < 18; i++) {
			entrenadores.add(new Entrenador());
		}
		System.out.println("\n Se han creado " + entrenadores.size() + " entrenadores.");

		return entrenadores;

	}

	public ArrayList<Equipo> crearEquipos(ArrayList<Jugador> jugadores, ArrayList<Entrenador> entrenadores) {
		ArrayList<Equipo> equipos = new ArrayList<>();
		if (jugadores.size() > 1 && entrenadores.size() > 1) {
			int contadorJugadores = 0;
			int contadorEntrenadores = 0;
			for (int i = 0; i < 6; i++) {
				equipos.add(new Equipo(Nacion.values()[i]));
				// System.out.println(contadorEquipos++);
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

			System.out.println("\n Se han creado " + equipos.size() + " equipos.");

		} else {
			System.out.println("\n No se han creado Jugadores o Entrenadores.");
		}

		return equipos;
	}

	private ArrayList<Arbitro> crearArbitros() {
		for (int i = 0; i < 5; i++) {
			arbitros.add(new Arbitro());
		}

		System.out.println("\n Se han creado " + arbitros.size() + " arbitro.");

		return arbitros;
	}

	public void competir() {
		if (equipos.size() <= 0) {
			System.out.println("\n No hay equipos para competir");
		} else {
			Collections.shuffle(equipos);

			for (int i = 0; i < equipos.size(); i++) {
				for (int j = i + 1; j < equipos.size(); j++) {
					ArrayList<Arbitro> arbitrosPartido = new ArrayList<>();
					arbitrosPartido.add(arbitros.get(1));
					arbitrosPartido.add(arbitros.get(2));
					arbitrosPartido.add(arbitros.get(3));
					Collections.shuffle(arbitros);
					partidos.add(new Partido(equipos.get(i), equipos.get(j), arbitrosPartido, new Date()));
				}
			}

			Collections.shuffle(partidos);

			for (Partido partido : partidos) {
				partido.jugar(estadio);
			}
		}
	}

	private static void confi() throws IOException {
		File f;
		FileReader lectorarchivo;
		try {
			FileWriter fw = new FileWriter("C:\\3\\naciones.txt");

			fw.write("LISTA DE JUGADORES\n");
			for (int i = 0; i < jugadores.size(); i++) {
				fw.write("" + jugadores.get(i) + "\n");
			}

			fw.write("LISTA DE entrenadores\n");
			for (int i = 0; i < entrenadores.size(); i++) {
				fw.write("" + entrenadores.get(i) + "\n");
			}

			fw.write("LISTA DE arbitros\n");
			for (int i = 0; i < arbitros.size(); i++) {
				fw.write("" + arbitros.get(i) + "\n");
			}

			fw.write("JUGADORES POR EQUIPO\n");

			for (int i = 0; i < 6; i++) {
				fw.write("" + equipos.get(i) + "\n");
				fw.write("" + equipos.get(i).getJugadores() + "\n");

				// fw.write(""+equipos.get(2)+"\n");

				fw.write("\n");
				fw.write("EQUIPO" + i + "\n");
			}

			fw.close();
			f = new File("C:\\perro\\perro.txt");
			lectorarchivo = new FileReader(f);
			BufferedReader br = new BufferedReader(lectorarchivo);
			String l = "";
			String aux = "";
			while (true) {
				aux = br.readLine();
				if (aux != null)
					l = l + aux + "\n";
				else
					break;
			}
			br.close();
			lectorarchivo.close();
			System.out.println(l);

		} catch (Exception e) {

		}

	}

	private static void tablas() throws IOException {
		File f1;
		FileReader lectorarchivo;

		try {
			FileWriter fw1 = new FileWriter("C:\\perro\\tabla_clasificacion.txt");

			fw1.write("Partidos");
			for (int i = 0; i < partidos.size(); i++) {
				fw1.write("\n" + partidos.get(i));
				fw1.write("\n");
			}
			fw1.close();
			f1 = new File("C:\\perro\\tabla_clasificacion.txt");
			lectorarchivo = new FileReader(f1);
			BufferedReader br = new BufferedReader(lectorarchivo);
			String l1 = "";
			String aux1 = "";
			while (true) {
				aux1 = br.readLine();
				if (aux1 != null)
					l1 = l1 + aux1 + "\n";
				else
					break;
			}
			br.close();
			lectorarchivo.close();
			System.out.println(l1);

		} catch (Exception e) {

		}

	}
}
