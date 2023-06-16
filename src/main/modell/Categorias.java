package modell;

public class Categorias {
    private int idC;
    private String nombreC;
    private int idT;
    private String iconos;

    public Categorias() {
    }

    public Categorias(int idC, String nombreC, int idT, String iconos) {
        this.idC = idC;
        this.nombreC = nombreC;
        this.idT = idT;
        this.iconos = iconos;
    }

    public Categorias(String nombreC, int idT, String iconos) {
        this.nombreC = nombreC;
        this.idT = idT;
        this.iconos = iconos;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public int getIdT() {
        return idT;
    }

    public void setIdT(int idT) {
        this.idT = idT;
    }

    public String getIconos() {
        return iconos;
    }

    public void setIconos(String iconos) {
        this.iconos = iconos;
    }

    @Override
    public String toString() {
        return "Categorias{" +
                "idC=" + idC +
                ", nombreC='" + nombreC + '\'' +
                ", idT=" + idT +
                ", iconos='" + iconos + '\'' +
                '}';
    }
}
