
## Authors

- [@robluchy](https://github.com/Robluchy)
- [@DSAnthony](https://github.com/DSAnthony)
- [@JMA9328](https://github.com/JMA9328)

![Logo](https://static.vecteezy.com/system/resources/thumbnails/005/130/896/small/initial-letter-logo-r-free-vector.jpg)

Semana 1
--

Siguiendo el diagrama de clases adjunto en esta tarea crear una aplicación principal (main) que muestre e implemente la lógica necesaria para realizar las siguiente operaciones:

Crear Jugadores (para seis equipos)
Crear Entrenadores (para seis equipos)
Crear Equipos (seis equipos)
Crear Árbitros. (para 5 partidos)


Semana 2
--

Ampliar la funcionalidad de la clase Entrenador para que pueda crear una alineación diferente con los 15 mejores jugadores para cada partido (utilizad la interfaz Comparable y el método Collections.sort(), explicado en el libro de clase de la página 253 a la 256 en la sección 9.3 ). Tened en cuenta las implicaciones que tiene sobre el método jugar() de la clase Partido.
Añadir la clase Competicion al diagrama de clases. Esta clase contendrá la lógica y estructuras de datos necesarias para organizar los partidos que se van a jugar en la competición, así como la lógica de simulación de dicho listado de partidos. Debe implementar una simulación de la competición ejecutada de una vez (simple) y otra en la que la simulación se ordena y ejecuta jornada a jornada ( podéis simplemente utilizar shuffle() sobre el conjunto de todos los partidos posibles y luego separar por jornadas ) o sino utilizar uno de estos algoritmos adaptándolo a la particularidad del torneo de las seis naciones (Algoritmo competición liga de equipos modalidad "todos contra todos": https://es.wikipedia.org/wiki/Sistema_de_todos_contra_todos). 
Recordad que en el Snipper tenéis ejemplos de código para comparar rectángulos implementando la interfaz Comparable (utilizad la misma técnica para comparar jugadores a la hora de que el entrenador haga la alineación).



Semana 3
--

Diseñar del modelo entidad relación -> modelo relacional -> implementación del modelo físico de la BD (script con las instrucciones DDL). Definición de requisitos para la base de datos emerge del análisis específico del programa realizado y plasmado en el diagrama de clases.
Conectar con la BD de Oracle desde Java mediante JDBC configurando el proyecto en Eclipse*.
Añadidos recursos en esta tarea con ejemplos en Java con operaciones CRUD en una BD SQL. Código Java y script para creación de BD.
* Ver vídeo https://youtu.be/dmc_WvZfxJo // ATENCIÓN: 1) Los .jar se tienen que añadir al proyecto Eclipse igual que lo hicimos para MySQL, en Project Properties. 2) Del código de conexión descargado de GitHub hay que cambiar el usuario y contraseña además de la línea de conexión para indicar que la conexión es local sobre el servicio de base de datos XE final static String DB_URL="jdbc:oracle:thin:@localhost:1521/XE";   )


Semana 4
--
Se añade a la clase Arbitro la responsabilidad de escribir un acta de cada partido al terminar. De los tres árbitros que tiene cada partido, solo el primer árbitro escribe el acta (solo hay un acta por partido). Cada árbitro además debe de mantener un registro de las actas que él ha escrito, para ello utilizará una estructura de datos de tipo Map (mapa o array asociativo de la clase específica que decidáis).
Se añade a la clase Estadio el requisito de almacenar su historial de partidos disputados en una estructura de datos Set (de la clase específica que decidáis). Recordad que el objetivo es que NO puedan existir repeticiones en este conjunto de partidos.


Semana 5
--

Diseñar e implementar tres triggers para la gestión de tu base de datos del proyecto.  La utilidad de los triggers debe estar relacionada con las especificaciones del proyecto de programación que se está llevando a cabo.

Programación de clases y estructuras de datos. Finalizar lógica de negocio de la competición.



Semana 6
--

Lectura de fichero de configuración. Debe indicar: cuantos jugadores por equipo. Cuantos entrenadores por equipo. Cuantos equipos se crean. Cuantos jugadores van en la alineación principal. Si los datos de la base de datos se borran al iniciar la aplicación y se generan nuevos datos aleatorios. 
Escritura de fichero de texto. La clase competición debe de implementar un método para escribir los resultados de su tabla de clasificación en un fichero de texto plano (tabla_clasificacion.txt). Dicha tabla debe tener la información organizada en columnas mostrando partidos jugados, partidos ganados, partidos empatados, partidos perdidos y puntos obtenidos en el torneo para cada equipo.


Opcional
Desarrollo de Interfaz Gráfica de Usuario (UI) para el programa utilizando el framework JavaFX.
Ventana con botones para ejecutar operaciones como mínimo para: 1) Mostrar equipos y 2) lanzar la simulación de la competición ( mostrar el resultado de la tabla clasificatoria final).


![img](https://imgur.com/ezZUJSg)