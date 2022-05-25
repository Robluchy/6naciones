package naciones;

import java.util.ArrayList;
import java.util.Collections;

public class competicion {

    

    public static void competir(ArrayList<Equipo> equipos){
        if (equipos.size() <= 0) {
            System.out.println("No hay equipos para competir");
            return;
        }

        ArrayList<String> partidos = new ArrayList<>();

        Collections.shuffle(equipos);
        

        for (int i = 0; i < equipos.size(); i++) {
            for(int j = i+1; j < equipos.size(); j++){
                partidos.add("(" + equipos.get(i).getNombre().toString() + ", " + equipos.get(j).getNombre() + ")");
            }
        }

        Collections.shuffle(partidos);

        for (String jornada : partidos){
            System.out.println(jornada + "\n");
        }

        return;

    }
    

}




// 1vs2, 1vs3, 1vs4, 1vs5, 1vs6
// 2vs3, 2vs4, 2vs5, 2vs6
// 3vs4, 3vs5, 3vs6
// 4vs5, 4vs6
// 5vs6




//Añadir la clase Competicion al diagrama de clases. 
// Esta clase contendrá la lógica y estructuras de datos necesarias para organizar los partidos que se van a jugar en la competición, 
// así como la lógica de simulación de dicho listado de partidos. Debe implementar una simulación de la competición ejecutada de una vez (simple)
// y otra en la que la simulación se ordena y ejecuta jornada a jornada ( podéis simplemente utilizar shuffle() sobre el conjunto de todos los
// partidos posibles y luego separar por jornadas ) o sino utilizar uno de estos algoritmos adaptándolo a la particularidad del torneo de las seis naciones
// (Algoritmo competición liga de equipos modalidad "todos contra todos": https://es.wikipedia.org/wiki/Sistema_de_todos_contra_todos). 