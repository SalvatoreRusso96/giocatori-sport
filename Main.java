import java.util.Scanner;
import java.util.regex.Pattern;

import Controllers.ControlliNBA;

public class Main {
    public static void main(String[] args) {
        ControlliNBA gestoreNba = new ControlliNBA();

        Scanner scanner = new Scanner(System.in);

        boolean inserimentoAbilitato = true;

        while (inserimentoAbilitato) {

            boolean esciFuori = false;

            System.out.println("Cosa vuoi fare?\n" +
                    "I - Inserisci\n" +
                    "S - Stampa\n" +
                    "E - Elimina\n" +
                    "M - Modifica\n" +
                    "R - Ricerca\n" +
                    "CS- Cerca squdra\n" +
                    "CM- Media età\n" +
                    "TS - Titoli squadra\n" +
                    "Q - Esci\n" +
                    "Scrivi 'exit' per tornare al menu principale");

            String choice = scanner.nextLine();
            choice = choice.toUpperCase();

            if (choice.isEmpty()) {
                System.out.println("Non hai inserito niente. Riprova.");
            } else if (!Pattern.matches("[a-zA-Z\\s]+", choice)) {
                System.out.println("Scelta non valida. Assicurati che non contenga numeri. Riprova.");
            }

            switch (choice) {

                case "I":

                    System.out.println("Inserisci nominativo: ");

                    String inNominativo = scanner.nextLine();

                    if (inNominativo.equals("exit")) {
                        continue;

                    }

                    // VALIDAZIONE
                    while (inNominativo.isEmpty() || !Pattern.matches("[a-zA-Z\\s]+", inNominativo)) {
                        System.out.println("Inserisci il nominativo:");
                        inNominativo = scanner.nextLine();
                        if (inNominativo.equals("exit")) {
                            esciFuori = true;
                            break;

                        }
                        if (inNominativo.isEmpty()) {
                            System.out.println("Non hai inserito il nominativo. Riprova.");
                        } else if (!Pattern.matches("[a-zA-Z\\s]+", inNominativo)) {
                            System.out
                                    .println("Nominativo non valido. Assicurati che non contenga numeri. Riprova.");
                        }
                    }
                    if (esciFuori) {
                        continue;
                    }

                    System.out.println("Inserisci squadra: ");
                    String inSquadra = scanner.nextLine();

                    if (inSquadra.equals("exit")) {
                        continue;
                    }

                    // VALIDAZIONE
                    while (inSquadra.isEmpty() || !Pattern.matches("[a-zA-Z\\s]+", inSquadra)) {
                        System.out.println("Inserisci la squdra : ");
                        inSquadra = scanner.nextLine();
                        if (inSquadra.equals("exit")) {
                            esciFuori = true;
                            break;

                        }
                        if (inSquadra.isEmpty()) {
                            System.out.println("Non hai inserito la squadra. Riprova.");
                        } else if (!Pattern.matches("[a-zA-Z\\s]+", inSquadra)) {
                            System.out.println("Squadra non valida. Assicurati che non contenga numeri. Riprova.");
                        }
                    }
                    if (esciFuori) {
                        continue;
                    }

                    // VALIDAZIONE
                    int inEta = 0;
                    System.out.println("Inserisci l'età:");
                    String input = scanner.nextLine();

                    if (input.equals("exit")) {
                        continue;
                    }
                    try {
                        inEta = Integer.parseInt(input);
                        if (inEta <= 0) {
                            System.out
                                    .println("Età non valida. Assicurati che sia un valore positivo. Riprova.");

                        }
                    } catch (Exception e) {
                        System.out.println("Input non valido. Inserisci un valore numerico. Riprova.");
                    }

                    while (inEta <= 0) {

                        System.out.println("Inserisci l'età:");
                        input = scanner.nextLine();
                        if (input.equals("exit")) {

                            esciFuori = true;
                            break;

                        }

                        try {

                            inEta = Integer.parseInt(input);
                            if (inEta <= 0) {
                                System.out
                                        .println("Età non valida. Assicurati che sia un valore positivo. Riprova.");

                            }

                        } catch (Exception e) {
                            System.out.println("Input non valido. Inserisci un valore numerico. Riprova.");
                        }

                    }
                    if (esciFuori) {
                        continue; // Torna al ciclo esterno
                    }

                    // VALIDAZIONE
                    int inTitoliNba = -1;
                    System.out.println("Inserisci titoliNba:");
                    String inputTitoli = scanner.nextLine();

                    if (inputTitoli.equals("exit")) {
                        continue;
                    }

                    try {
                        inTitoliNba = Integer.parseInt(inputTitoli);
                        if (inTitoliNba < 0) {
                            System.out.println("Non hai inserito un valore valido");
                        }

                    } catch (Exception e) {
                        System.out.println("Non hai inserito un valore numerico");
                    }

                    while (inTitoliNba < 0) {
                        System.out.println("Inserisci titoliNba:");
                        inputTitoli = scanner.next();
                        scanner.nextLine();
                        if (inputTitoli.equals("exit")) {
                            esciFuori = true;
                            break;
                        }

                        try {
                            inTitoliNba = Integer.parseInt(inputTitoli);
                            if (inTitoliNba < 0) {
                                System.out.println(
                                        "Valore non valido. Assicurati che sia un valore pari a '0' o positivo. Riprova.");
                            }
                        } catch (Exception e) {
                            System.out.println("Input non valido. Inserisci un valore numerico. Riprova.");
                        }
                    }

                    if (esciFuori) {
                        continue;
                    }

                    gestoreNba.inserisci(inNominativo, inSquadra, inEta, inTitoliNba);

                    break;

                case "S":

                    if (gestoreNba.draft.isEmpty()) {

                        System.out.println("Elenco vuoto al momento");

                    } else {
                        gestoreNba.stampaDettaglio();
                    }

                    break;

                case "E":

                    // VALIDAZIONE
                    int inId = -1;
                    System.out.println("Inserisci ID:");
                    String inputId = scanner.nextLine();
                    if (inputId.equals("exit")) {
                        continue;

                    }

                    try {
                        inId = Integer.parseInt(inputId);
                        if (inId < 0) {
                            System.out.println(
                                    "Valore non valido. Assicurati che sia un valore pari a '0' o positivo. Riprova.");

                        } else if (inId > gestoreNba.draft.size()) {
                            System.out.println("Valore non valido. Assicurati che sia un Id esistente. Riprova.");

                        } else {
                            System.out.println("Elenco vuoto");
                        }
                    } catch (Exception e) {
                        System.out.println("Input non valido. Inserisci un valore numerico. Riprova.");
                    }

                    while (inId < 0 || inId > gestoreNba.draft.size()) {
                        System.out.println("Inserisci ID:");
                        inputId = scanner.nextLine();
                        if (inputId.equals("exit")) {
                            esciFuori = true;
                            break;

                        }

                        try {
                            inId = Integer.parseInt(inputId);
                            if (inId < 0) {
                                System.out.println(
                                        "Valore non valido. Assicurati che sia un valore pari a '0' o positivo. Riprova.");

                            } else if (inId > gestoreNba.draft.size()) {
                                System.out.println("Valore non valido. Assicurati che sia un Id esistente. Riprova.");

                            } else {
                                System.out.println("Elenco vuoto");
                            }
                        } catch (Exception e) {
                            System.out.println("Input non valido. Inserisci un valore numerico. Riprova.");
                        }

                    }
                    if (esciFuori) {
                        continue;
                    }

                    gestoreNba.eliminaGiocatorePerId(inId);

                    break;

                case "M":
                    int modId = -1;
                    System.out.println("Inserisci ID:");
                    String innId = scanner.nextLine();

                    if (innId.equals("exit")) {
                        continue;
                    }
                   

                    try {
                        modId = Integer.parseInt(innId);
                        if (modId < 0) {
                            System.out.println("Non hai inserito un valore valido");
                        }

                    } catch (Exception e) {
                        System.out.println("Non hai inserito un valore numerico");
                    }

                    while (modId < 0) {
                        System.out.println("Inserisci titoliNba:");
                        innId = scanner.next();
                        scanner.nextLine();
                        if (innId.equals("exit")) {
                            esciFuori = true;
                            break;
                        }

                        try {
                            modId = Integer.parseInt(innId);
                            if (modId < 0) {
                                System.out.println(
                                        "Valore non valido. Assicurati che sia un valore pari a '0' o positivo. Riprova.");
                            }
                        } catch (Exception e) {
                            System.out.println("Input non valido. Inserisci un valore numerico. Riprova.");
                        }
                    }

                    if (esciFuori) {
                        continue;
                    }

                    System.out.println("Inserisci nominativo: ");

                    String modNominativo = scanner.nextLine();

                    if (modNominativo.equals("exit")) {
                        continue;

                    }

                    // VALIDAZIONE
                    while (modNominativo.isEmpty() || !Pattern.matches("[a-zA-Z\\s]+", modNominativo)) {
                        System.out.println("Input non valido. Inserisci il nominativo:");
                        modNominativo = scanner.nextLine();
                        if (modNominativo.equals("exit")) {
                            esciFuori = true;
                            break;

                        }
                        if (modNominativo.isEmpty()) {
                            System.out.println("Non hai inserito il nominativo. Riprova.");
                        } else if (!Pattern.matches("[a-zA-Z\\s]+", modNominativo)) {
                            System.out.println("Nominativo non valido. Assicurati che non contenga numeri. Riprova.");

                        }
                    }
                    if (esciFuori) {
                        continue;
                    }

                    System.out.println("Inserisci squadra");
                    String modSquadra = scanner.nextLine();

                    if (modSquadra.equals("exit")) {
                        continue;

                    }

                    // VALIDAZIONE
                    while (modSquadra.isEmpty() || !Pattern.matches("[a-zA-Z\\s]+", modSquadra)) {
                        System.out.println("Input non valido. Inserisci il nominativo:");
                        modSquadra = scanner.nextLine();
                        if (modSquadra.equals("exit")) {
                            esciFuori = true;
                            break;

                        }
                        if (modSquadra.isEmpty()) {
                            System.out.println("Non hai inserito il nominativo. Riprova.");
                        } else if (!Pattern.matches("[a-zA-Z\\s]+", modSquadra)) {
                            System.out.println("Nominativo non valido. Assicurati che non contenga numeri. Riprova.");

                        }
                    }
                    if (esciFuori) {
                        continue;
                    }
                    int modEta = -1;
                    System.out.println("Inserisci eta");
                    String innEta = scanner.nextLine();

                    if (innEta.equals("exit")) {
                        continue;
                    }

                    try {
                        modEta = Integer.parseInt(innEta);
                        if (modEta < 0) {
                            System.out.println("Non hai inserito un valore valido");
                        }

                    } catch (Exception e) {
                        System.out.println("Non hai inserito un valore numerico");
                    }

                    while (modEta < 0) {
                        System.out.println("Inserisci titoliNba:");
                        innEta = scanner.next();
                        scanner.nextLine();
                        if (innEta.equals("exit")) {
                            esciFuori = true;
                            break;
                        }

                        try {
                            modEta = Integer.parseInt(innEta);
                            if (modEta < 0) {
                                System.out.println(
                                        "Valore non valido. Assicurati che sia un valore pari a '0' o positivo. Riprova.");
                            }
                        } catch (Exception e) {
                            System.out.println("Input non valido. Inserisci un valore numerico. Riprova.");
                        }
                    }

                    if (esciFuori) {
                        continue;
                    }
                    int modTitoliNba = -1;
                    System.out.println("Inserisci titoliNba");
                    String innTitoliNba = scanner.nextLine();

                    if (innTitoliNba.equals("exit")) {
                        continue;
                    }

                    try {
                        modTitoliNba = Integer.parseInt(innTitoliNba);
                        if (modTitoliNba < 0) {
                            System.out.println("Non hai inserito un valore valido");
                        }

                    } catch (Exception e) {
                        System.out.println("Non hai inserito un valore numerico");
                    }

                    while (modTitoliNba < 0) {
                        System.out.println("Inserisci titoliNba:");
                        innTitoliNba = scanner.next();
                        scanner.nextLine();
                        if (innTitoliNba.equals("exit")) {
                            esciFuori = true;
                            break;
                        }

                        try {
                            modTitoliNba = Integer.parseInt(innTitoliNba);
                            if (modTitoliNba < 0) {
                                System.out.println(
                                        "Valore non valido. Assicurati che sia un valore pari a '0' o positivo. Riprova.");
                            }
                        } catch (Exception e) {
                            System.out.println("Input non valido. Inserisci un valore numerico. Riprova.");
                        }
                    }

                    if (esciFuori) {
                        continue;
                    }

                    gestoreNba.modifica(modId, modNominativo, modSquadra, modEta, modTitoliNba);

                    break;

                case "R":

                    System.out.println("Cerca:\n" +
                            "ID - Ricerca per ID\n" +
                            "N - Ricerca per nominativo");
                    String cercaChoice = scanner.nextLine();

                    if (cercaChoice.equals("exit")) {
                        continue;

                    }
                    cercaChoice = cercaChoice.toUpperCase();
                    while (cercaChoice.isEmpty() || !Pattern.matches("[a-zA-Z\\s]+", cercaChoice)
                            || Pattern.matches("[a-zA-Z\\s]+", cercaChoice)
                            || cercaChoice.equals("ID") || cercaChoice.equals("N")) {

                        if (cercaChoice.equals("ID") || cercaChoice.equals("N")) {

                            break;
                        }

                        System.out.println("Errore, cerca:\n" +
                                "ID - Ricerca per ID\n" +
                                "N - Ricerca per nominativo");
                        cercaChoice = scanner.nextLine();

                        if (cercaChoice.equals("exit")) {
                            esciFuori = true;
                            break;

                        }
                        cercaChoice = cercaChoice.toUpperCase();
                        if (cercaChoice.isEmpty()) {
                            System.out.println("Non hai inserito niente. Riprova.");
                        } else if (!Pattern.matches("[a-zA-Z\\s]+", cercaChoice)) {
                            System.out.println("Scelta non valida. Assicurati che non contenga numeri. Riprova.");

                        }

                    }
                    if (esciFuori) {
                        continue;
                    }

                    switch (cercaChoice) {

                        case "ID":

                            int cercId = -1;
                            System.out.println("Inserisci l'ID:");
                            String ID = scanner.nextLine();

                            if (ID.equals("exit")) {
                                esciFuori = true;
                                break;
                            }
                            try {
                                cercId = Integer.parseInt(ID);
                                if (cercId < 0) {
                                    System.out.println("Assicurati che sia un valore pari a '0' o superiore. Riprova.");
                                } else if (cercId > gestoreNba.draft.size()) {
                                    System.out
                                            .println("Valore non valido. Assicurati che sia un Id esistente. Riprova.");

                                } else {
                                    System.out.println("Elenco vuoto");

                                }

                            } catch (Exception e) {
                                System.out.println("Assicurati che contenga solo numeri. Riprova.");
                            }
                            while (cercId < 0) {
                                System.out.println("Inserisci l'ID:");
                                ID = scanner.nextLine();

                                if (ID.equals("exit")) {
                                    esciFuori = true;
                                    break;
                                }
                                try {
                                    cercId = Integer.parseInt(ID);
                                    if (cercId < 0) {
                                        System.out.println(
                                                "Assicurati che sia un valore pari a '0' o superiore. Riprova.");
                                    } else if (cercId > gestoreNba.draft.size()) {
                                        System.out.println(
                                                "Valore non valido. Assicurati che sia un Id esistente. Riprova.");

                                    } else {
                                        System.out.println("Elenco vuoto");

                                    }
                                } catch (Exception e) {
                                    System.out.println("Assicurati che contenga solo numeri. Riprova.");
                                }

                            }
                            if (esciFuori) {
                                continue;
                            }

                            gestoreNba.cercaGiocatorePerId(cercId);

                            break;

                        case "N":

                            System.out.println("Inserisci il nominativo:");
                            String nominativoInput = scanner.nextLine();
                            if (nominativoInput.equals("exit")) {
                                continue;
                            }
                            try {
                                if (nominativoInput.isEmpty() || !Pattern.matches("[a-zA-Z\\s]+", nominativoInput)) {
                                    System.out.println("Assicurati che non sia vuoto e che non contenga numeri.");
                                }

                            } catch (Exception e) {
                                System.out.println("Errore riprova.");
                            }
                            while (nominativoInput.isEmpty() || !Pattern.matches("[a-zA-Z\\s]+", nominativoInput)) {
                                System.out.println("Inserisci il nominativo:");
                                nominativoInput = scanner.nextLine();
                                if (nominativoInput.equals("exit")) {
                                    esciFuori = true;
                                    break;
                                }
                                try {
                                    if (nominativoInput.isEmpty()
                                            || !Pattern.matches("[a-zA-Z\\s]+", nominativoInput)) {
                                        System.out.println("Assicurati che non sia vuoto e che non contenga numeri.");
                                    }

                                } catch (Exception e) {
                                    System.out.println("Errore riprova.");
                                }
                            }
                            if (esciFuori) {
                                continue;
                            }

                            gestoreNba.cercaGiocatorePerNominativo(nominativoInput);

                            break;

                    }

                    break;

                case "CM":

                    System.out.println("L'età media è : " + gestoreNba.calcolaMediaEta());
                    break;

                case "CS":

                    System.out.println("Inserisci la squadra");
                    String inputCs = scanner.nextLine();
                    if (inputCs.equals("exit")) {
                        continue;
                    }

                    // VALIDAZIONE
                    while (inputCs.isEmpty() || !Pattern.matches("[a-zA-Z\\s]+", inputCs)) {
                        System.out.println("Errore, inserisci la squdra: ");
                        inputCs = scanner.nextLine();
                        if (inputCs.equals("exit")) {
                            esciFuori = true;
                            break;
                        }

                        if (inputCs.isEmpty()) {
                            System.out.println("Non hai inserito la squadra. Riprova.");
                        } else if (!Pattern.matches("[a-zA-Z\\s]+", inputCs)) {
                            System.out.println("Squadra non valida. Assicurati che non contenga numeri. Riprova.");

                        }

                    }
                    if (esciFuori) {
                        continue;
                    }

                    gestoreNba.mostraGiocatoriSquadra(inputCs);
                    break;
                
                case "Q":
                    inserimentoAbilitato = false;
                    System.out.println("Arrivederci!");
                    break;

            }

        }

        scanner.close();

    }
}
