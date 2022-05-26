package naciones;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class GestorSQL {

	static private Connection conexion;
	
	private void ConectionSql(){

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
		
	private static void cerrarSql(){
		
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
		
					java.util.Date fecha_nacimiento = jugadores.get(i).getFechaNacimiento();

					
					String SQL = "INSERT INTO jugadores VALUES(NULL,?,?,NULL,?,?,?,?)";
					PreparedStatement sentencia = conexion.prepareStatement(SQL);

					sentencia.setDate(1, dateSql);
					sentencia.setString(2, nombre_completo);
					sentencia.setInt(3, fuerza);       
					sentencia.setInt(4, velocidad);
					sentencia.setInt(5, resistencia);
					sentencia.setDouble(6, peso);
					sentencia.executeUpdate();

					// SQL para recuperar el ultimo id insertado
					SQL = "SELECT last_insert_id() as last_id";

					Statement sentenciaID = conexion.createStatement();
					ResultSet rs = sentenciaID.executeQuery(SQL);

					rs.next();
					int idDir = rs.getInt("last_id");
					rs.close();
					sentenciaID.close();									
					sentencia.close();
					conexion.close();
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
		}

		public static void guardarEntrenador(Entrenador entrenador) {
			
		}

		public static void guardarEquipo(Equipo equipo) {
			
		}

		public static void actualizarJugador(Jugador jugador) {
			
		}

		public static void actualizarEntrenador(Entrenador entrenador) {
			
		}

		public static void actualizarEquipo(Equipo equipo) {
			
		}

		public static Jugador buscarJugador(String nombre) {
			
			return null;
		}

		public static Entrenador buscarEntrenador(String nombre) {
			
			return null;
		}

		public static Equipo buscarEquipo(String nombre) {
			
			return null;
		}


}