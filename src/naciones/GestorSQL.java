package naciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class GestorSQL {
	
	static Scanner sc = new Scanner(System.in);

	static private Connection conexion;

	public static void conectar() {
			String basedatos = "6_naciones";
				String host = "localhost";
				String port = "3306";
				String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
				String user = "root";
				String pwd = "";

				conexion = DriverManager.getConnection(urlConnection, user, pwd);

				conexion.setAutoCommit(true);

	}
	public static void eliminarTablas() {
		try {
			String sql = "DROP TABLE IF EXISTS `equipo`;";
			String sql2 = "DROP TABLE IF EXISTS `jugador`;";
			String sql3 = "DROP TABLE IF EXISTS `partido`;";
			String sql4 = "DROP TABLE IF EXISTS `entrenador`;";
			String sql5 = "DROP TABLE IF EXISTS `arbitro`;";
			String sql6 = "DROP TABLE IF EXISTS `competicion`;";

			Statement st = conexion.createStatement();
			st.executeUpdate(sql);
			st.executeUpdate(sql2);
			st.executeUpdate(sql3);
			st.executeUpdate(sql4);
			st.executeUpdate(sql5);
			st.executeUpdate(sql6);
			st.close();

		} catch (Exception e) {
			System.out.println("Error al eliminar tablas");
		}
	}

	public static void guardarJugadores(ArrayList<Jugador> jugadores) {
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

				conexion.close();

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	public static void guardarEntrenadores(ArrayList<Entrenador> entrenadores) {
		for (int i = 0; i < entrenadores.size(); i++) {
			try {
				int id_equipo = entrenadores.get(i).getEquipo().getId();
				String nombre = entrenadores.get(i).getNombreCompleto();
				double peso = entrenadores.get(i).getPeso();
				int experiencia = entrenadores.get(i).getExperiencia();
				Date fecha_nacimiento = entrenadores.get(i).getFechaNacimiento();

				String sql = "INSERT INTO entrenadores VALUES (NULL,?, ?, ?, ?, ?)";
				String basedatos = "6_naciones";
				String host = "localhost";
				String port = "3306";
				String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
				String user = "root";
				String pwd = "";

				conexion = DriverManager.getConnection(urlConnection, user, pwd);

				conexion.setAutoCommit(true);
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setString(1, nombre);
				pst.setInt(2, id_equipo);
				pst.setInt(3, experiencia);
				pst.setDouble(4, peso);
				pst.setObject(5, fecha_nacimiento);
				pst.executeUpdate();
				pst.close();

				conexion.close();

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	public static void guardarEquipos(ArrayList<Equipo> equipos) {
		for (int i = 0; i < equipos.size(); i++) {
			try {
				String nombre_equipo = equipos.get(i).getNombre().toString();
				int partido_jugado = equipos.get(i).getPartidosJugados();
				int partido_ganado = equipos.get(i).getPartidosGanados();
				int partido_perdido = equipos.get(i).getPartidosPerdidos();
				int partido_empatado = equipos.get(i).getPartidosEmpatados();

				String sql = "INSERT INTO equipos VALUES (NULL,?, ?, ?, ?, ?)";
				String basedatos = "6_naciones";
				String host = "localhost";
				String port = "3306";
				String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
				String user = "root";
				String pwd = "";

				conexion = DriverManager.getConnection(urlConnection, user, pwd);

				conexion.setAutoCommit(true);
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setString(1, nombre_equipo);
				pst.setInt(2, partido_jugado);
				pst.setInt(3, partido_ganado);
				pst.setInt(4, partido_perdido);
				pst.setInt(5, partido_empatado);


				pst.executeUpdate();
				pst.close();

				sql = "Select last_insert_id() as last_id";

				Statement stmt = conexion.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				int lastId = rs.getInt("last_id");

				stmt.close();

				equipos.get(i).setId(lastId);

				guardarJugadores(equipos.get(i).getJugadores());
				guardarEntrenadores(equipos.get(i).getEntrenadores());

				conexion.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	//
	public static int guardarArbitros2(ArrayList<Arbitro> arbitros) {
		int contador=0;
		
		for (int i = 0; i < 5; i++) {
			arbitros.add(new Arbitro());
			 try {
		            Connection conexion;

		            String basedatos = "6_naciones";
		            String host = "localhost";
		            String port = "3306";
		            String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		            String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
		            String user = "root";
		            String pwd = "";

		            conexion = DriverManager.getConnection(urlConnection, user, pwd);

		            conexion.setAutoCommit(true);

		            sc.useDelimiter("\n");
		            sc.useLocale(Locale.US);

          int precicion=arbitros.get(i).getPresicion();
          

          double peso=arbitros.get(i).getPeso();		           

      	 Arbitro dAux;

 	  	 // SQL para crear una equipo
         String SQL = "INSERT INTO arbitros VALUES(null,?,?,?,?);";
         PreparedStatement sentencia = conexion.prepareStatement(SQL);

        
         sentencia.setString(1, nombre);
         sentencia.setInt(2, precicion);
         sentencia.setDate(3, dateSql);
         sentencia.setDouble(4,peso);


         contador += sentencia.executeUpdate();

         // SQL para recuperar el ultimo id insertado
         SQL = "SELECT last_insert_id() as last_id";

         Statement sentenciaID = conexion.createStatement();
         ResultSet rs = sentenciaID.executeQuery(SQL);

         rs.next();
         int iden = rs.getInt("last_id");
         rs.close();
         sentenciaID.close();
         sentencia.close();
         conexion.close();
//       conexion.close();
			 } catch (SQLException ex) {
		            System.out.println(ex.getMessage());
	   }  
		}

		// for (Arbitro arbitro : arbitros) {
			System.out.println("\n Se han creado " + arbitros.size() + " arbitros.\n");
		// 	System.out.println(arbitro);
		// }
		return contador;
	}
	

	public static void guardarArbritos(ArrayList<Arbitro> arbitros) {
		for (int i = 0; i < arbitros.size(); i++) {
			try {
				String nombre = arbitros.get(i).getNombreCompleto();
				int precision = arbitros.get(i).getPrecision();
				Date fecha_nacimiento = arbitros.get(i).getFechaNacimiento();
				double peso = arbitros.get(i).getPeso();

				String sql = "INSERT INTO arbitros VALUES (NULL,?, ?, ?, ?)";

				String basedatos = "6_naciones";
				String host = "localhost";
				String port = "3306";
				String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
				String user = "root";
				String pwd = "";

				conexion = DriverManager.getConnection(urlConnection, user, pwd);

				conexion.setAutoCommit(true);
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setString(1, nombre);
				pst.setInt(2, precision);
				pst.setObject(3, fecha_nacimiento);
				pst.setDouble(4, peso);
				pst.executeUpdate();
				pst.close();

				conexion.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());

			}


		}
	}

	public static void guardarPartidos(ArrayList<Partido> partidos) {
		try {
			for (int i = 0; i < partidos.size(); i++) {

				int id_local = partidos.get(i).getEquipoLocal().getId();
				int id_visitante = partidos.get(i).getEquipoVisitante().getId();

				// for (int x = 0; x < partidos.get(i).getArbitros().size(); x++) {
				// String nombre_arbitro =
				// partidos.get(i).getArbitros().get(x).getNombreCompleto();
				// }

				String sql = "INSERT INTO partidos (id_visitante, id_local) VALUES (?, ?)";

				String basedatos = "6_naciones";
				String host = "localhost";
				String port = "3306";
				String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
				String user = "root";
				String pwd = "";

				conexion = DriverManager.getConnection(urlConnection, user, pwd);

				conexion.setAutoCommit(true);

				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setInt(1, id_visitante);
				pst.setInt(2, id_local);
				// pst.setString(3, nombre_arbitro);

				pst.executeUpdate();
				pst.close();

				conexion.close();
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	// public static void mostrarJugadores() {
	// try {
	// String sql = "SELECT * FROM jugador";
	// Statement stmt = conexion.createStatement();
	// ResultSet rs = stmt.executeQuery(sql);

	// while (rs.next()) {
	// System.out.println(rs.getInt("id") + " " + rs.getString("nombre") + " " +
	// rs.getInt("edad") + " "
	// + rs.getInt("fuerza") + " " + rs.getDouble("peso") + " " +
	// rs.getString("nombre_completo")
	// + " " + rs.getInt("id_equipo"));
	// }

	// stmt.close();

	// } catch (SQLException ex) {
	// System.out.println(ex.getMessage());
	// }
	// }

	// public static void mostrarEntrenadores() {
	// try {
	// String sql = "SELECT * FROM entrenador";
	// Statement stmt = conexion.createStatement();
	// ResultSet rs = stmt.executeQuery(sql);

	// while (rs.next()) {
	// System.out.println(rs.getInt("id") + " " + rs.getString("nombre") + " " +
	// rs.getInt("experiencia")
	// + " " + rs.getDouble("peso"));
	// }

	// stmt.close();

	// } catch (SQLException ex) {
	// System.out.println(ex.getMessage());
	// }
	// }

	// public static void mostrarEquipos() {
	// try {
	// String sql = "SELECT * FROM equipo";
	// Statement stmt = conexion.createStatement();
	// ResultSet rs = stmt.executeQuery(sql);

	// while (rs.next()) {
	// System.out.println(rs.getInt("id") + " " + rs.getString("nombre"));
	// }

	// stmt.close();

	// } catch (SQLException ex) {
	// System.out.println(ex.getMessage());
	// }
	// }

	// public static void mostrarArbitros() {
	// try {
	// String sql = "SELECT * FROM arbitro";
	// Statement stmt = conexion.createStatement();
	// ResultSet rs = stmt.executeQuery(sql);

	// while (rs.next()) {
	// System.out.println(rs.getInt("id") + " " + rs.getString("nombre") + " " +
	// rs.getInt("precision")
	// + " " + rs.getDouble("peso"));
	// }

	// stmt.close();

	// } catch (SQLException ex) {
	// System.out.println(ex.getMessage());
	// }
	// }

	// public static void mostrarPartidos() {
	// try {
	// String sql = "SELECT * FROM partido";
	// Statement stmt = conexion.createStatement();
	// ResultSet rs = stmt.executeQuery(sql);

	// while (rs.next()) {
	// System.out.println(rs.getInt("id") + " " +
	// rs.getString("nombre_equipo_local") + " "
	// + rs.getString("nombre_equipo_visitante") + " " +
	// rs.getString("nombre_estadio") + " "
	// + rs.getString("nombre_entrenador_local") + " " +
	// rs.getString("nombre_entrenador_visitante")
	// + " " + rs.getString("nombre_arbitro"));
	// }

	// stmt.close();

	// } catch (SQLException ex) {
	// System.out.println(ex.getMessage());
	// }
	// }

}