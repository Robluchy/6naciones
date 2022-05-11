package naciones;

import java.util.ArrayList;
import java.util.Date;

public class Partido {

    private Equipo equipoVisitante;
    private Equipo equipoLocal;
    private ArrayList<Arbitro> arbitros;
    private int golesVisitante;
    private int golesLocal;
    private Date fecha;

    public Partido() {
        equipoVisitante = new Equipo();
        equipoLocal = new Equipo();
        arbitros = new ArrayList<>();
        golesVisitante = 0;
        golesLocal = 0;
        fecha = new Date();
    }

    public Partido(Equipo equipoVisitante, Equipo equipoLocal, ArrayList<Arbitro> arbitros, Estadio estadio, Date fecha) {
        this.equipoVisitante = equipoVisitante;
        this.equipoLocal = equipoLocal;
        this.arbitros = arbitros;

        this.fecha = fecha;
    }

    public Equipo getequipoVisitante() {
        return equipoVisitante;
    }

    public void setequipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
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
        return "Partido{" + "equipoVisitante=" + equipoVisitante + ", equipoLocal=" + equipoLocal + ", arbitros="
                + arbitros + ", golesVisitante=" + golesVisitante + ", golesLocal=" + golesLocal + ", fecha=" + fecha
                + '}';
    }

    public Equipo calcularGanador() {
        if (golesVisitante > golesLocal) {
            return equipoVisitante;
        } else if (golesLocal > golesVisitante) {
            return equipoLocal;
        } else {
            return null;
        }
    }


}
