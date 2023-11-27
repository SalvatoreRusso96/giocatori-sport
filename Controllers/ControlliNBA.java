package Controllers;

import java.util.ArrayList;

import Models.GiocatoriNBA;
import Models.IBallers;

public class ControlliNBA implements IBallers{
    private static int id;
    // CRUD

    // Creazione Lista
    public ArrayList<GiocatoriNBA> draft = new ArrayList<GiocatoriNBA>();

    // Create
    public void inserisci(String nominativo, String squadra, int eta, int titoliNba) {

        int nuovoId = id;

        GiocatoriNBA gioc = new GiocatoriNBA(nuovoId, nominativo, squadra, eta, titoliNba);

        draft.add(gioc);
        System.out.println("Inserimento effettuato con successo!");

        id = nuovoId;

        id++;

    }

    // Read
    public void stampaDettaglio() {

        for (GiocatoriNBA gioc : draft) {
            
            

            System.out.println(gioc.getNominativo() + " " + gioc.getSquadra().toUpperCase() + " " + gioc.getEta() + " " + gioc.getTitoliNba());

        }
    }

    // Delete
    /*
     * public void elimina(GiocatoriNBA gioc) {
     * 
     * draft.remove(gioc);
     * }
     */

    // Update
    public void modifica(int idDiChiModificare, String nuovoNominativo, String nuovaSquadra, int nuovaEta,
            int nuoviTitoliNba) {
        for (GiocatoriNBA gioc : draft) {
            if (gioc.getId() != idDiChiModificare) {
            	System.out.println("Errore: il giocatore specificato non è stato trovato nella lista.");
                

            } else {
            	gioc.setNominativo(nuovoNominativo);
                gioc.setSquadra(nuovaSquadra);
                gioc.setEta(nuovaEta);
                gioc.setTitoliNba(nuoviTitoliNba);
                System.out.println("Giocatore NBA aggiornato con successo.");
            }
        }

    }

    public void cercaGiocatorePerId(int idDiChiStampare) {
        for (GiocatoriNBA gioc : draft) {
            if (gioc.getId() == idDiChiStampare) {
                System.out.println("Il giocatore corrispondente: " + gioc);
            } else {
                System.out.println("Giocatore non trovato");

            }
        }
    }

    public void cercaGiocatorePerNominativo(String nominativoDiChiStampare) {
        for (GiocatoriNBA gioc : draft) {
            if (gioc.getNominativo().equals(nominativoDiChiStampare)) {
                System.out.println(gioc);
            } else {
                System.out.println("Giocatore non trovato");

            }
        }
    }

    // Delete
    public void eliminaGiocatorePerId(int idDiChiEliminare) {
        for (GiocatoriNBA gioc : draft) {
            if (gioc.getId() == idDiChiEliminare) {
                draft.remove(gioc);
                System.out.println("Giocatore eliminato con successo");
                return;
            }

        }
    }

    public double calcolaMediaEta() {
        int numeroGiocatori = draft.size();
        int etaTotale = 0;

        for (GiocatoriNBA gioc : draft) {
            etaTotale += gioc.getEta();
        }
        if (numeroGiocatori != 0) {
            double mediaEta = etaTotale / numeroGiocatori;
            return mediaEta;
        } else {
            return 0.0;
        }

    }

    public ArrayList<GiocatoriNBA> squadra = new ArrayList<GiocatoriNBA>();

    public void mostraGiocatoriSquadra(String inSquadra) {

        for (GiocatoriNBA gioc : draft) {
            if (gioc.getSquadra().equals(inSquadra.toUpperCase()) || gioc.getSquadra().equals(inSquadra.toLowerCase())) {

                squadra.add(gioc);

            } 
        }

        for (GiocatoriNBA giocSqudra : squadra) {

            System.out.println(giocSqudra.getNominativo() + " " + giocSqudra.getSquadra().toUpperCase() + " " + giocSqudra.getEta() + " " + giocSqudra.getTitoliNba());

        }

        if (squadra.isEmpty()) {
            System.out.println("La squadra" + " " + inSquadra + " " + "non esiste");
            squadra.clear();
        } else {
            System.out.println("La squadra" + " " + inSquadra.toUpperCase() + " " + "contiene : " + squadra.size());
            squadra.clear();
        }

    }
    
}
