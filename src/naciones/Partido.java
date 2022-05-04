package naciones;

import java.util.ArrayList;
import java.util.Date;

public class Partido {

    private ArrayList<Equipo> equiposVisitante;
    private ArrayList<Equipo> equiposLocal;
    private ArrayList<Arbitro> arbitros;
    private int golesVisitante;
    private int golesLocal;
    private Date fecha;

    public Partido() {
        equiposVisitante = new ArrayList<>();
        equiposLocal = new ArrayList<>();
        arbitros = new ArrayList<>();
        golesVisitante = 0;
        golesLocal = 0;
        fecha = new Date();
    }

    public Partido(Partido partido) {

        equiposVisitante = new ArrayList<>();
        for (Equipo equipo : partido.equiposVisitante) {
            this.equiposVisitante.add(new Equipo(equipo));
        }

        equiposLocal = new ArrayList<>();
        for (Equipo equipo : partido.equiposLocal) {
            this.equiposLocal.add(new Equipo(equipo));
        }

        arbitros = new ArrayList<>();      
        for (int i = 0; i < 30; i++) {
            arbitros.add(new Arbitro(partido.arbitros.get(i)));
        }
        
        golesVisitante = partido.golesVisitante;
        golesLocal = partido.golesLocal;
        fecha = partido.fecha;
    }

    public Partido(ArrayList<Equipo> equiposVisitante, ArrayList<Equipo> equiposLocal, ArrayList<Arbitro> arbitros, int golesVisitante, int golesLocal, Date fecha) {
        this.equiposVisitante = equiposVisitante;
        this.equiposLocal = equiposLocal;
        this.arbitros = arbitros;
        this.golesVisitante = golesVisitante;
        this.golesLocal = golesLocal;
        this.fecha = fecha;
    }

    public ArrayList<Equipo> getEquiposVisitante() {
        return equiposVisitante;
    }

    public void setEquiposVisitante(ArrayList<Equipo> equiposVisitante) {
        this.equiposVisitante = equiposVisitante;
    }

    public ArrayList<Equipo> getEquiposLocal() {
        return equiposLocal;
    }

    public void setEquiposLocal(ArrayList<Equipo> equiposLocal) {
        this.equiposLocal = equiposLocal;
    }

    public ArrayList<Arbitro> getArbitros() {
        return arbitros;
    }

    public void setArbitros(ArrayList<Arbitro> arbitros) {
        this.arbitros = arbitros;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Partido{" + "equiposVisitante=" + equiposVisitante + ", equiposLocal=" + equiposLocal + ", arbitros=" + arbitros + ", golesVisitante=" + golesVisitante + ", golesLocal=" + golesLocal + ", fecha=" + fecha + '}';
    }

    //metodo para calcular el ganador del partido
    public Equipo calcularGanador() {
        if (golesVisitante > golesLocal) {
            return equiposVisitante.get(0);
        } else if (golesVisitante < golesLocal) {
            return equiposLocal.get(0);
        } else {
            return null;
        }
    }
    
    //metodo para jugar recibe un estadio
    public void jugar(Estadio estadio) {
        estadio.setCapacidad(estadio.getCapacidad() - (equiposVisitante.size() + equiposLocal.size()));
    }

    //metodo 


}
