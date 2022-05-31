package naciones;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorSQL {

	static private Connection conexion;
	
	public static void ConectionSql(){

		try{
			String basedatos = "6_naciones";
			String host = "localhost";
			String port = "3306";
			String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
			String user = "root";
			String pwd = "";

			Connection conexion = DriverManager.getConnection(urlConnection, user, pwd);

			conexion.setAutoCommit(true);
	
		} catch (Exception e) {
			System.out.println("Error al conectar");
		}
	}
		
	public static void cerrarSql(){
		
		try {
			conexion.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar la conexion");
		}
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

	//implementar metodos CRUD para jugadores, entrenadores y equipos

	public static void guardarJugador(ArrayList<Jugador> jugadores) {
		for (int i = 0; i < jugadores.size(); i++) {
			try {
				int resistencia = jugadores.get(i).getResistencia();			         	 
				int velocidad = jugadores.get(i).getVelocidad();			           
				int fuerza = jugadores.get(i).getFuerza();		           
				double peso = jugadores.get(i).getPeso();
				String nombre_completo = jugadores.get(i).getNombreCompleto();
				
				String sql = "INSERT INTO jugador (resistencia, velocidad, fuerza, peso, nombre_completo) VALUES (?, ?, ?, ?, ?)";
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setInt(1, resistencia);
				pst.setInt(2, velocidad);
				pst.setInt(3, fuerza);
				pst.setDouble(4, peso);
				pst.setString(5, nombre_completo);
				pst.executeUpdate();
				pst.close();
				
				

				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
		}

		public static void guardarEntrenador(ArrayList<Entrenador> entrenadores) {
			for (int i = 0; i < entrenadores.size(); i++) {
				try {
					String nombre = entrenadores.get(i).getNombreCompleto();	           
					double peso = entrenadores.get(i).getPeso();
					int experiencia = entrenadores.get(i).getExperiencia();
					
					//java.sql.Date dateSql= new java.sql.Date(dateUtil.getDay(),dateUtil.getMonth(),dateUtil.getYear()+95);

					String sql = "INSERT INTO entrenador (nombre, experiencia) VALUES (?, ?, ?)";
					PreparedStatement pst = conexion.prepareStatement(sql);
					pst.setString(1, nombre);
					pst.setDouble(2, peso);
					pst.setInt(2, experiencia);
					pst.executeUpdate();
					pst.close();
					
					} catch (SQLException ex) {
						System.out.println(ex.getMessage());
					}
				}
			}


		public static void guardarEquipo(Equipo equipo) {
			for (int i = 0; i < equipo.getJugadores().size(); i++) {
				try {
					String nombre_equipo = equipo.getNombre.toString();
					String nombre_entrenador = equipo.getEntrenador().getNombreCompleto();
					String nombre_jugador = equipo.getJugadores().get(i).getNombreCompleto();
					
					String sql = "INSERT INTO equipo (nombre_equipo, nombre_entrenador, nombre_jugador) VALUES (?, ?, ?)";
					PreparedStatement pst = conexion.prepareStatement(sql);
					pst.setString(1, nombre_equipo);
					pst.setString(2, nombre_entrenador);
					pst.setString(3, nombre_jugador);
					pst.executeUpdate();
					pst.close();
					
					} catch (SQLException ex) {
						System.out.println(ex.getMessage());
					}
				}
			}
		
		public static void guardarArbrito(ArrayList<Arbitro> arbitros){
			for (int i = 0; i < arbitros.size(); i++) {
				try {
					String nombre = arbitros.get(i).getNombreCompleto();
					int precicion=arbitros.get(i).getPrecision();	
					double peso=arbitros.get(i).getPeso();

					String sql = "INSERT INTO arbitro (nombre, precicion, peso) VALUES (?, ?, ?)";
					PreparedStatement pst = conexion.prepareStatement(sql);
					pst.setString(1, nombre);
					pst.setInt(2, precicion);
					pst.setDouble(3, peso);
					pst.executeUpdate();
					pst.close();
					
					} catch (SQLException ex) {
						System.out.println(ex.getMessage());
					}

				}
			}
		
		public static void guardarPartido(Partido partido) {
			try {
				String nombre_equipo_local = partido.getEquipoLocal().getNombre.toString();
				String nombre_equipo_visitante = partido.getEquipoVisitante().getNombre.toString();
				String nombre_entrenador_local = partido.getEquipoLocal().getEntrenador().getNombreCompleto();
				String nombre_entrenador_visitante = partido.getEquipoVisitante().getEntrenador().getNombreCompleto();
				String nombre_arbitro = partido.getArbitro().getNombreCompleto();
				
				String sql = "INSERT INTO partido (nombre_equipo_local, nombre_equipo_visitante, nombre_entrenador_local, nombre_entrenador_visitante, nombre_arbitro) VALUES (?, ?, ?, ?, ?)";
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setString(1, nombre_equipo_local);
				pst.setString(2, nombre_equipo_visitante);
				pst.setString(3, nombre_entrenador_local);
				pst.setString(4, nombre_entrenador_visitante);
				pst.setString(5, nombre_arbitro);
				pst.executeUpdate();
				pst.close();
				
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
}

