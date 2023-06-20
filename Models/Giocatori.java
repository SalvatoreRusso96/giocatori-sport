package Models;

public abstract class Giocatori {

    private String nominativo;
    private String squadra;
    private int eta;

    public Giocatori(String nominativo, String squadra, int eta) {
        this.nominativo = nominativo;
        this.squadra = squadra;
        this.eta = eta;
    }

    public String toString() {
        String stringa = nominativo + " " + squadra + " " + eta;
        return stringa;
    }

    // GETTERS && SETTERS
    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public String getSquadra() {
        return squadra;
    }

    public void setSquadra(String squadra) {
        this.squadra = squadra;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }
}
