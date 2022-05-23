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

    public Partido(Equipo equipoVisitante, Equipo equipoLocal, ArrayList<Arbitro> arbitros,
        int golesVisitante, int golesLocal, Date fecha) {
        this.equipoVisitante = equipoVisitante;
        this.equipoLocal = equipoLocal;
        this.arbitros = arbitros;
        this.golesVisitante = golesVisitante;
        this.golesLocal = golesLocal;
        this.fecha = fecha;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public Equipo getequipoLocal() {
        return equipoLocal;
    }

    public void setequipoLocal(Equipo equipoLocal) {
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

    public void jugar(Estadio estadio) {
        estadio.addPartido(this);
    }

}
