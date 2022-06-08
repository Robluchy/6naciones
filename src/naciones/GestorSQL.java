package naciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class GestorSQL {

	static Scanner sc = new Scanner(System.in);

	static private Connection conexion;

	public static void conectar() {
		try {
			String basedatos = "6_naciones";
			String host = "localhost";
			String port = "3306";
			String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
			String user = "root";
			String pwd = "";

			conexion = DriverManager.getConnection(urlConnection, user, pwd);

			conexion.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println("Error al conectar con la base de datos");
			e.printStackTrace();
		}
	}

	public static void desconectar() {
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error al desconectar con la base de datos");
			e.printStackTrace();
		}
	}

	public static void borrarDatos() {
		try {
			conectar();
			Statement st = conexion.createStatement();
			st.executeUpdate("DELETE FROM jugadores");
			st.executeUpdate("DELETE FROM entrenadores");
			st.executeUpdate("DELETE FROM arbitros");
			st.executeUpdate("DELETE FROM equipos");
			st.executeUpdate("DELETE FROM partidos");
			st.executeUpdate("DELETE FROM estadios");
			desconectar();
		} catch (SQLException e) {
			System.out.println("Error al borrar datos");
			e.printStackTrace();
		}
	}

	public static void guardarJugadores(ArrayList<Jugador> jugadores) {
		conectar();
		for (int i = 0; i < jugadores.size(); i++) {
			try {
				
				Date fecha_nacimiento = new Date(jugadores.get(i).getFechaNacimiento().getTime());
				int id_equipo = jugadores.get(i).getEquipo().getId();
				int resistencia = jugadores.get(i).getResistencia();
				int velocidad = jugadores.get(i).getVelocidad();
				int fuerza = jugadores.get(i).getFuerza();
				double peso = jugadores.get(i).getPeso();
				String nombre = jugadores.get(i).getNombreCompleto();

				String sql = "INSERT INTO jugadores VALUES (NULL,?,?,?,?,?,?,?)";

				PreparedStatement pst = conexion.prepareStatement(sql);

				pst.setObject(1, fecha_nacimiento);
				pst.setString(2, nombre);
				pst.setInt(3, id_equipo);
				pst.setInt(4, fuerza);
				pst.setInt(5, velocidad);
				pst.setInt(6, resistencia);
				pst.setDouble(7, peso);
				pst.executeUpdate();
				pst.close();

				String SQL = "SELECT last_insert_id() as last_id";

				Statement sentenciaID = conexion.createStatement();
				ResultSet rs = sentenciaID.executeQuery(SQL);
				rs.next();
				int id = rs.getInt("id");
				jugadores.get(i).setId(id);
				rs.close();
				sentenciaID.close();

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		desconectar();
	}

	public static void guardarEntrenadores(ArrayList<Entrenador> entrenadores) {
		conectar();
		for (int i = 0; i < entrenadores.size(); i++) {
			try {
		
				int id_equipo = entrenadores.get(i).getEquipo().getId();
				String nombre = entrenadores.get(i).getNombreCompleto();
				double peso = entrenadores.get(i).getPeso();
				int experiencia = entrenadores.get(i).getExperiencia();
				Date fecha_nacimiento = entrenadores.get(i).getFechaNacimiento();

				String sql = "INSERT INTO entrenadores VALUES (NULL,?, ?, ?, ?, ?)";

				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setString(1, nombre);
				pst.setInt(2, id_equipo);
				pst.setInt(3, experiencia);
				pst.setDouble(4, peso);
				pst.setObject(5, fecha_nacimiento);
				pst.executeUpdate();
				pst.close();

				String SQL = "SELECT last_insert_id() as last_id";

				Statement sentenciaID = conexion.createStatement();
				ResultSet rs = sentenciaID.executeQuery(SQL);
				rs.next();
				int id = rs.getInt("id");
				entrenadores.get(i).setId(id);
				rs.close();
				sentenciaID.close();

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		desconectar();
	}

	public static void guardarEquipos(ArrayList<Equipo> equipos) {
		conectar();

		for (int i = 0; i < equipos.size(); i++) {
			try {
				String nombre_equipo = equipos.get(i).getNombre().toString();
				int partido_jugado = equipos.get(i).getPartidosJugados();
				int partido_ganado = equipos.get(i).getPartidosGanados();
				int partido_perdido = equipos.get(i).getPartidosPerdidos();
				int partido_empatado = equipos.get(i).getPartidosEmpatados();

				String sql = "INSERT INTO equipos VALUES (NULL,?, ?, ?, ?, ?)";

				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setString(1, nombre_equipo);
				pst.setInt(2, partido_jugado);
				pst.setInt(3, partido_ganado);
				pst.setInt(4, partido_perdido);
				pst.setInt(5, partido_empatado);

				pst.executeUpdate();
				pst.close();

				String SQL = "SELECT last_insert_id() as last_id";

				Statement sentenciaID = conexion.createStatement();
				ResultSet rs = sentenciaID.executeQuery(SQL);

				rs.next();
				int lastId = rs.getInt("last_id");
				rs.close();
				sentenciaID.close();

				equipos.get(i).setId(lastId);

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		desconectar();

	}

	public static void guardarArbritos(ArrayList<Arbitro> arbitros) {
		for (int i = 0; i < arbitros.size(); i++) {
			try {
				String nombre = arbitros.get(i).getNombreCompleto();
				int precision = arbitros.get(i).getPrecision();
				Date fecha_nacimiento = arbitros.get(i).getFechaNacimiento();
				double peso = arbitros.get(i).getPeso();

				String sql = "INSERT INTO arbitros VALUES (NULL,?, ?, ?, ?)";

				conectar();

				conexion.setAutoCommit(true);
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setString(1, nombre);
				pst.setInt(2, precision);
				pst.setObject(3, fecha_nacimiento);
				pst.setDouble(4, peso);
				pst.executeUpdate();
				pst.close();

				String SQL = "SELECT last_insert_id() as last_id";

				Statement sentenciaID = conexion.createStatement();
				ResultSet rs = sentenciaID.executeQuery(SQL);

				rs.next();
				int lastId = rs.getInt("last_id");
				rs.close();
				sentenciaID.close();

				arbitros.get(i).setId(lastId);
				desconectar();

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());

			}

		}
	}

	public static void guardarPartidos(ArrayList<Partido> partidos) {
		conectar();
		try {
			for (int i = 0; i < partidos.size(); i++) {

				int id_local = partidos.get(i).getEquipoLocal().getId();
				int id_visitante = partidos.get(i).getEquipoVisitante().getId();
				Date fecha_partido = new Date();
				String resultado = "a";


				String sql = "INSERT INTO partidos VALUES (null,?, ? , ?, ?, ?)";

				conectar();

				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setInt(1, id_visitante);
				pst.setInt(2, id_local);
				pst.setObject(3, fecha_partido);
				pst.setString(4, resultado);

				pst.executeUpdate();

				pst.close();

				String SQL = "SELECT last_insert_id() as last_id";

				Statement sentenciaID = conexion.createStatement();
				ResultSet rs = sentenciaID.executeQuery(SQL);

				rs.next();
				int lastId = rs.getInt("last_id");
				rs.close();
				sentenciaID.close();

				partidos.get(i).setId(lastId);

			}
			desconectar();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void asignarArbitros(ArrayList<Partido> partidos) {
		conectar();
		try {
			for (int i = 0; i < partidos.size(); i++) {
				int id_partido = partidos.get(i).getId();
				int id_arbitro = partidos.get(i).getArbitros().get(i).getId();

				String sql = "INSERT INTO arbitros_partidos VALUES (?,?)";

				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setInt(1, id_partido);
				pst.setInt(2, id_arbitro);

				pst.executeUpdate();
				pst.close();

			}
			
			desconectar();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void mostrarJugadores() {
		try {
			String sql = "SELECT * FROM jugador";
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getInt("id") + " " + rs.getString("nombre") + " " +
						rs.getInt("edad") + " "
						+ rs.getInt("fuerza") + " " + rs.getDouble("peso") + " " +
						rs.getString("nombre_completo")
						+ " " + rs.getInt("id_equipo"));
			}

			stmt.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void mostrarEntrenadores() {
		try {
			String sql = "SELECT * FROM entrenador";
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getInt("id") + " " + rs.getString("nombre") + " " +
						rs.getInt("experiencia")
						+ " " + rs.getDouble("peso"));
			}

			stmt.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void mostrarEquipos() {
		try {
			String sql = "SELECT * FROM equipo";
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getInt("id") + " " + rs.getString("nombre"));
			}

			stmt.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void mostrarArbitros() {
		try {
			String sql = "SELECT * FROM arbitro";
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getInt("id") + " " + rs.getString("nombre") + " " +
						rs.getInt("precision")
						+ " " + rs.getDouble("peso"));
			}

			stmt.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void mostrarPartidos() {
		try {
			String sql = "SELECT * FROM partido";
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getInt("id") + " " +
						rs.getString("nombre_equipo_local") + " "
						+ rs.getString("nombre_equipo_visitante") + " " +
						rs.getString("nombre_estadio") + " "
						+ rs.getString("nombre_entrenador_local") + " " +
						rs.getString("nombre_entrenador_visitante")
						+ " " + rs.getString("nombre_arbitro"));
			}

			stmt.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

}