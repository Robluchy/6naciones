
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

<!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=5,IE=9" ><![endif]-->
<!DOCTYPE html>
<html>
<head>
<title>seisNaciones.html</title>
<meta charset="utf-8"/>
</head>
<body>
<div class="mxgraph" style="max-width:100%;border:1px solid transparent;" data-mxgraph="{&quot;highlight&quot;:&quot;#0000ff&quot;,&quot;nav&quot;:true,&quot;resize&quot;:true,&quot;xml&quot;:&quot;&lt;mxfile host=\&quot;Electron\&quot; modified=\&quot;2022-05-28T11:40:35.859Z\&quot; agent=\&quot;5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) draw.io/18.0.6 Chrome/100.0.4896.143 Electron/18.2.3 Safari/537.36\&quot; etag=\&quot;3fKtHQbjoWHw5Q2jlW4z\&quot; version=\&quot;18.0.6\&quot; type=\&quot;device\&quot;&gt;&lt;diagram id=\&quot;PvZZYMO9W3wh-XJw-VHZ\&quot; name=\&quot;Page-1\&quot;&gt;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&lt;/diagram&gt;&lt;/mxfile&gt;&quot;,&quot;toolbar&quot;:&quot;pages zoom layers lightbox&quot;,&quot;page&quot;:0}"></div>
<script type="text/javascript" src="https://app.diagrams.net/js/viewer-static.min.js"></script>
</body>
</html>
