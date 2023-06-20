package Models;

public class GiocatoriNBA extends Giocatori {

    private int id;
    private int titoliNba;

    public GiocatoriNBA(int id, String nominativo, String squadra, int eta, int titoliNba) {
        super(nominativo, squadra, eta);
        this.id = id;
        this.titoliNba = titoliNba;
    }

    public String toString() {
        String stringa = getId() + " " + getNominativo() + " " + getSquadra() + " " + getEta() + " " + titoliNba;
        return stringa;
    }

    // GETTERS && SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTitoliNba() {
        return titoliNba;
    }

    public void setTitoliNba(int titoliNba) {
        this.titoliNba = titoliNba;
    }


}
