package modell;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Gastos {
    private int idG;
    private LocalDate fechaG;
    private int idC;
    private double importeG;
    private String detallesG;
    private int idU;

    public Gastos(int idC, String fechaG,String detallesG, double importeG, int idU) {
        this.idC = idC;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.fechaG = LocalDate.parse(fechaG, formato);
        this.detallesG = detallesG;
        this.importeG = importeG;
        this.idU = idU;
    }

    public Gastos(int idG, String fechaG, int idC, double importeG, String detallesG, int idU) {
        this.idG = idG;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.fechaG = LocalDate.parse(fechaG, formato);
        this.idC = idC;
        this.importeG = importeG;
        this.detallesG = detallesG;
        this.idU = idU;
    }

    public Gastos(String fechaG, int idC, double importeG, String detallesG, int idU) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.fechaG = LocalDate.parse(fechaG, formato);
        this.idC = idC;
        this.importeG = importeG;
        this.detallesG = detallesG;
        this.idU = idU;
    }

    public int getIdG() {
        return idG;
    }

    public void setIdG(int idG) {
        this.idG = idG;
    }

    public LocalDate getFechaG() {
        return fechaG;
    }

    public void setFechaG(LocalDate fechaG) {
        this.fechaG = fechaG;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public Double getImporteG() {
        return importeG;
    }

    public void setImporteG(double importeG) {
        this.importeG = importeG;
    }

    public String getDetallesG() {
        return detallesG;
    }

    public void setDetallesG(String detallesG) {
        this.detallesG = detallesG;
    }

    public int getIdUsuario() {
        return idU;
    }

    public void setIdUsuario(int idUsuario) {
        this.idU = idU;
    }

    @Override
    public String toString() {
        return "Gastos{" +
                "idG=" + idG +
                ", fechaG=" + fechaG +
                ", idC=" + idC +
                ", ImporteG=" + importeG +
                ", detallesG='" + detallesG + '\'' +
                ", idUsuario=" + idU +
                '}';
    }
}
